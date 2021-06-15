package de.symeda.sormas.api;

import java.io.Serializable;
import java.util.Objects;

import javax.enterprise.inject.Alternative;

@Alternative
public class SormasToSormasConfig implements Serializable, Cloneable {

	private static final long serialVersionUID = -7981351672462016280L;

	private String id;
	private String path;
	private String keystoreName;
	private String keystorePass;
	private String truststoreName;
	private String truststorePass;
	private boolean retainCaseExternalToken;

	private String redisHost;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getKeystoreName() {
		return keystoreName;
	}

	public void setKeystoreName(String keystoreName) {
		this.keystoreName = keystoreName;
	}

	public String getKeystorePass() {
		return keystorePass;
	}

	public void setKeystorePass(String keystorePass) {
		this.keystorePass = keystorePass;
	}

	public String getTruststoreName() {
		return truststoreName;
	}

	public void setTruststoreName(String truststoreName) {
		this.truststoreName = truststoreName;
	}

	public String getTruststorePass() {
		return truststorePass;
	}

	public void setTruststorePass(String truststorePass) {
		this.truststorePass = truststorePass;
	}

	public boolean getRetainCaseExternalToken() {
		return retainCaseExternalToken;
	}

	public void setRetainCaseExternalToken(boolean retainCaseExternalToken) {
		this.retainCaseExternalToken = retainCaseExternalToken;
	}

	public String getRedisHost() {
		return redisHost;
	}

	public void setRedisHost(String redisHost) {
		this.redisHost = redisHost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SormasToSormasConfig that = (SormasToSormasConfig) o;
		return Objects.equals(path, that.path)
			&& Objects.equals(keystorePass, that.keystorePass)
			&& Objects.equals(truststoreName, that.truststoreName)
			&& Objects.equals(truststorePass, that.truststorePass);
	}

	@Override
	public int hashCode() {
		return Objects.hash(path, keystorePass, truststoreName, truststorePass);
	}

	@Override
	public SormasToSormasConfig clone() {
		try {
			return (SormasToSormasConfig) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Clone failed", e);
		}
	}

}
