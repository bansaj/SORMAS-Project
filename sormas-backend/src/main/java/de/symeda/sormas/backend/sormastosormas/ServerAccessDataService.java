/*
 * SORMAS® - Surveillance Outbreak Response Management & Analysis System
 * Copyright © 2016-2020 Helmholtz-Zentrum für Infektionsforschung GmbH (HZI)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package de.symeda.sormas.backend.sormastosormas;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import de.symeda.sormas.backend.crypt.KeyStoreUtils;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.SslOptions;
import io.lettuce.core.SslVerifyMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.symeda.sormas.api.SormasToSormasConfig;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

@Stateless
@LocalBean
public class ServerAccessDataService {

	// todo move this and reject at runtime if setup was wrong
	private static final String S2S_REALM_PREFIX = "s2s:%s";

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerAccessDataService.class);

	@Inject
	private SormasToSormasConfig sormasToSormasConfig;

	private RedisCommands<String, String> createRedisConnection() {
		String[] redis = sormasToSormasConfig.getRedisHost().split(":");

		RedisURI uri = RedisURI.Builder.redis(redis[0], Integer.parseInt(redis[1]))
			.withAuthentication("s2s-client", "password")
			.withSsl(true)
			.withVerifyPeer(SslVerifyMode.FULL)
			.build();
		RedisClient redisClient = RedisClient.create(uri);

		SslOptions sslOptions = null;
		try {
			sslOptions = SslOptions.builder()
				.jdkSslProvider()
				.truststore(Paths.get("/tmp/s2s/redis/redis.truststore.p12").toUri().toURL(), "password")
				.build();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		ClientOptions clientOptions = ClientOptions.builder().sslOptions(sslOptions).build();

		redisClient.setOptions(clientOptions);

		StatefulRedisConnection<String, String> connection = redisClient.connect();
		return connection.sync();
	}

	public Optional<OrganizationServerAccessData> getServerAccessData() {
		try {
			RedisCommands<String, String> redis = createRedisConnection();
			Map<String, String> serverAccess = redis.hgetall(String.format(S2S_REALM_PREFIX, sormasToSormasConfig.getId()));
			return Optional.of(buildServerAccessData(sormasToSormasConfig.getId(), serverAccess));

		} catch (Exception e) {
			LOGGER.warn("Unexpected error while reading sormas to sormas server access data", e);
			return Optional.empty();
		}
	}

	public List<OrganizationServerAccessData> getOrganizationList() {
		try {
			RedisCommands<String, String> redis = createRedisConnection();
			// todo pin to the same prefix as the scopes s2s:
			List<String> keys = redis.keys(String.format(S2S_REALM_PREFIX, "*"));

			// remove own Id from the set
			keys.remove(String.format(S2S_REALM_PREFIX, sormasToSormasConfig.getId()));

			List<OrganizationServerAccessData> list = new ArrayList<>();
			for (String key : keys) {
				Map<String, String> hgetAll = redis.hgetall(key);
				OrganizationServerAccessData organizationServerAccessData = buildServerAccessData(key.split(":")[1], hgetAll);
				list.add(organizationServerAccessData);
			}
			return list;
		} catch (Exception e) {
			LOGGER.warn("Unexpected error while reading sormas to sormas server list", e);
			return Collections.emptyList();
		}
	}

	public Optional<OrganizationServerAccessData> getServerListItemById(String id) {
		return getOrganizationList().stream().filter(i -> i.getId().equals(id)).findFirst();
	}

	private OrganizationServerAccessData buildServerAccessData(String id, Map<String, String> entry) {
		return new OrganizationServerAccessData(id, entry.get("name"), entry.get("hostname"), entry.get("restUserPassword"));

	}
}
