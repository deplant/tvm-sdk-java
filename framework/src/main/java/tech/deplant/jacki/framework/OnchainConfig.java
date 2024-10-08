package tech.deplant.jacki.framework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import tech.deplant.jacki.binding.JsonContext;
import tech.deplant.jacki.framework.artifact.Artifact;
import tech.deplant.jacki.framework.artifact.JsonFile;
import tech.deplant.jacki.framework.artifact.JsonResource;
import tech.deplant.jacki.framework.contract.AbstractContract;
import tech.deplant.jacki.framework.contract.Contract;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static tech.deplant.jacki.framework.LogUtils.warn;

/**
 * The type Onchain config.
 */
public record OnchainConfig(Artifact<String, String> artifact, OnchainInfo info) {

	private static System.Logger logger = System.getLogger(OnchainConfig.class.getName());

	/**
	 * Load if exists onchain config.
	 *
	 * @param serializationPath the serialization path
	 * @return the onchain config
	 * @throws IOException the io exception
	 */
	public static OnchainConfig LOAD_IF_EXISTS(String serializationPath) throws IOException {
		OnchainConfig conf = null;
		try {
			conf = OnchainConfig.LOAD(serializationPath);
		} catch (Exception e) {
			conf = OnchainConfig.EMPTY(serializationPath);
			warn(logger, e.getMessage());
		}
		return conf;
	}

	/**
	 * Empty onchain config.
	 *
	 * @param serializationPath the serialization path
	 * @return the onchain config
	 * @throws IOException the io exception
	 */
	public static OnchainConfig EMPTY(String serializationPath) throws IOException {
		var path = Paths.get(serializationPath);
		Artifact<String, String> jsonArtifact = null;
		switch (Artifact.pathType(serializationPath)) {
			case ABSOLUTE, RELATIONAL -> jsonArtifact = new JsonFile(serializationPath);
			case RESOURCE -> jsonArtifact = new JsonResource(serializationPath);
		}
		var config = new OnchainConfig(jsonArtifact,
		                               new OnchainInfo(new ConcurrentHashMap<>(), new ConcurrentHashMap<>()));
		config.sync();
		return config;
	}

	/**
	 * Load onchain config.
	 *
	 * @param serializationPath the serialization path
	 * @return the onchain config
	 * @throws JsonProcessingException the json processing exception
	 */
	public static OnchainConfig LOAD(String serializationPath) throws JsonProcessingException {
		var mapper = JsonContext.ABI_JSON_MAPPER();
		//.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		Artifact<String, String> jsonArtifact = null;
		switch (Artifact.pathType(serializationPath)) {
			case ABSOLUTE, RELATIONAL -> jsonArtifact = new JsonFile(serializationPath);
			case RESOURCE -> jsonArtifact = new JsonResource(serializationPath);
		}
		return new OnchainConfig(jsonArtifact, mapper.readValue(jsonArtifact.get(), OnchainInfo.class));
	}

	/**
	 * Keys credentials.
	 *
	 * @param keysName the keys name
	 * @return the credentials
	 */
	public Credentials keys(String keysName) {
		return info().credentials().get(keysName);
	}

	private <T extends AbstractContract> T instatiateContract(Class<T> clazz,
	                                                          int contextId,
	                                                          String contractName,
	                                                          Credentials credentials) throws JsonProcessingException {
		var contr = info().contracts().get(contractName);
		if (Optional.ofNullable(contr).isEmpty()) {
			return null;
		}
		return Contract.instantiate(clazz, contextId, contr.address(), ContractAbi.ofString(contr.abiJson()), credentials);
	}

	/**
	 * Contract t.
	 *
	 * @param <T>          the type parameter
	 * @param clazz        the clazz
	 * @param contextId    the context id
	 * @param contractName the contract name
	 * @param keysName     the keys name
	 * @return the t
	 * @throws JsonProcessingException the json processing exception
	 */
	public <T extends AbstractContract> T contract(Class<T> clazz,
	                      int contextId,
	                      String contractName,
	                      String keysName) throws JsonProcessingException {
		return instatiateContract(clazz, contextId, contractName, keys(keysName));
	}

	/**
	 * Contract t.
	 *
	 * @param <T>          the type parameter
	 * @param clazz        the clazz
	 * @param contextId    the context id
	 * @param contractName the contract name
	 * @return the t
	 * @throws JsonProcessingException the json processing exception
	 */
	public <T extends AbstractContract> T contract(Class<T> clazz,
	                      int contextId,
	                      String contractName) throws JsonProcessingException {
		return instatiateContract(clazz, contextId, contractName, Credentials.NONE);
	}

	/**
	 * Adds OwnedContract object to config with a given name as a key.
	 *
	 * @param name     key for finding contract in config later
	 * @param contract contract object
	 * @return OwnedContract that we successfully putted to config
	 * @throws IOException can be thrown by the call of sync() method
	 */
	public Contract addContract(String name, Contract contract) throws IOException {
		info().contracts().put(name,
		                       new OnchainConfig.SavedContract(contract.abi().json(), contract.address().makeAddrStd()));
		sync();
		logger.log(System.Logger.Level.INFO, "Saved contract: %s, name: %s".formatted(contract.address(), name));
		return contract;
	}

	/**
	 * Add keys credentials.
	 *
	 * @param name the name
	 * @param keys the keys
	 * @return the credentials
	 * @throws IOException the io exception
	 */
	public Credentials addKeys(String name, Credentials keys) throws IOException {
		info().credentials().put(name, keys);
		sync();
		logger.log(System.Logger.Level.INFO, "Saved keys: %s, name: %s".formatted(keys, name));
		return keys;
	}

	/**
	 * Flushes this config to file on serializationPath()
	 *
	 * @throws IOException can be thrown by work with File
	 */
	public void sync() throws IOException {
		var mapper = JsonContext.ABI_JSON_MAPPER();
		//.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
		//.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		artifact().accept(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(info()));
	}

	/**
	 * The type Onchain info.
	 */
	public record OnchainInfo(Map<String, SavedContract> contracts, Map<String, Credentials> credentials) {
	}

	/**
	 * The type Saved contract.
	 */
	public record SavedContract(@JsonProperty("abi_json") String abiJson, String address) {
	}
}
