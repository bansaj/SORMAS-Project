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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.symeda.sormas.api.SormasToSormasConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

@Stateless
@LocalBean
public class ServerAccessDataService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServerAccessDataService.class);

	@Inject
	private SormasToSormasConfig sormasToSormasConfig;

	public Optional<OrganizationServerAccessData> getServerAccessData() {
		try {
			Jedis jedis = getJedis();
			Map<String, String> serverAccess = jedis.hgetAll(sormasToSormasConfig.getId());

			return Optional.of(buildServerAccessData(sormasToSormasConfig.getId(), serverAccess));

		} catch (Exception e) {
			LOGGER.warn("Unexpected error while reading sormas to sormas server access data", e);
			return Optional.empty();
		}
	}

	private Jedis getJedis() {
		String[] redis = sormasToSormasConfig.getRedisHost().split(":");
		return new Jedis(new HostAndPort(redis[0], Integer.parseInt(redis[1])));
	}

	public List<OrganizationServerAccessData> getOrganizationList() {
		Jedis jedis = getJedis();
		Set<String> keys = jedis.keys("s2s:*");

		// remove own Id from the set
		keys.remove("s2s:" + sormasToSormasConfig.getId());
		try {
			List<OrganizationServerAccessData> list = new ArrayList<>();
			for (String key : keys) {
				Map<String, String> hgetAll = jedis.hgetAll(key);
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
