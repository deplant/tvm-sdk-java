package tech.deplant.jacki.framework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import tech.deplant.commons.Hexes;
import tech.deplant.jacki.binding.*;
import tech.deplant.jacki.framework.artifact.JsonFile;
import tech.deplant.jacki.framework.artifact.JsonResource;

import java.math.BigInteger;

/**
 * Credentials is a pair of keys,
 * <p>
 * {@snippet :
 *  var keys = Credentials.ofRandom(sdk);
 * 	String sk = keys.secretKey();
 * 	String pk = keys.publicKey();
 *}*
 *
 * @param publicKey
 * @param secretKey
 */
public record Credentials(@JsonProperty("public") String publicKey, @JsonProperty("secret") String secretKey) {

	/**
	 * The constant NONE.
	 */
	public static final Credentials NONE = new Credentials(
			"0000000000000000000000000000000000000000000000000000000000000000",
			"0000000000000000000000000000000000000000000000000000000000000000");

	/**
	 * Generates new random KeyPair by using crypto.generate_random_sign_keys() method of SDK.
	 *
	 * @param contextId the context id
	 * @return the credentials
	 * @throws TvmSdkException the ever sdk exception
	 */
	public static Credentials ofRandom(int contextId) throws TvmSdkException {
		Crypto.KeyPair fromRandom = TvmSdk.await(Crypto.generateRandomSignKeys(contextId));
		return new Credentials(fromRandom.publicKey(), fromRandom.secretKey());
	}

	/**
	 * Of resource credentials.
	 *
	 * @param resourceName the resource name
	 * @return the credentials
	 */
	public static Credentials ofResource(String resourceName) {
		try {
			return JsonContext.ABI_JSON_MAPPER().readValue(new JsonResource(resourceName).get(), Credentials.class);
		} catch (JsonProcessingException e) {
			return NONE;
		}
	}

	/**
	 * Of file credentials.
	 *
	 * @param filePath the file path
	 * @return the credentials
	 */
	public static Credentials ofFile(String filePath) {
		try {
			return JsonContext.ABI_JSON_MAPPER().readValue(new JsonFile(filePath).get(), Credentials.class);
		} catch (JsonProcessingException e) {
			return NONE;
		}
	}

	/**
	 * Of seed credentials.
	 *
	 * @param contextId  the context id
	 * @param seedString the seed string
	 * @param seedWords  the seed words
	 * @param dictionary the dictionary
	 * @return the credentials
	 * @throws TvmSdkException the ever sdk exception
	 */
	public static Credentials ofSeed(int contextId,
	                                 String seedString,
	                                 int seedWords,
	                                 Crypto.MnemonicDictionary dictionary) throws TvmSdkException {
		return ofSeed(contextId, new Seed(seedString, seedWords, dictionary));
	}

	/**
	 * Of seed credentials.
	 *
	 * @param contextId  the context id
	 * @param seedString the seed string
	 * @param seedWords  the seed words
	 * @return the credentials
	 * @throws TvmSdkException the ever sdk exception
	 */
	public static Credentials ofSeed(int contextId, String seedString, int seedWords) throws TvmSdkException {
		return ofSeed(contextId, new Seed(seedString, seedWords));
	}

	/**
	 * Of seed credentials.
	 *
	 * @param contextId the context id
	 * @param seed      the seed
	 * @return the credentials
	 * @throws TvmSdkException the ever sdk exception
	 */
	public static Credentials ofSeed(int contextId, Seed seed) throws TvmSdkException {
		if (seed.verifySeedPhrase(contextId)) {
			return seed.deriveCredentials(contextId);
		} else {
			throw new RuntimeException("Seed/mnemonic phrase checksum is not valid.");
		}
	}

	/**
	 * Signer abi . signer.
	 *
	 * @return the abi . signer
	 */
	public Abi.Signer signer() {
		if (this.equals(Credentials.NONE)) {
			return new Abi.Signer.None();
		} else {
			return new Abi.Signer.Keys(keyPair());
		}
	}

	/**
	 * Key pair crypto . key pair.
	 *
	 * @return the crypto . key pair
	 */
	public Crypto.KeyPair keyPair() {
		return new Crypto.KeyPair(this.publicKey, this.secretKey);
	}

	/**
	 * Public key ton safe string.
	 *
	 * @param contextId the context id
	 * @return the string
	 * @throws TvmSdkException the ever sdk exception
	 */
	public String publicKeyTonSafe(int contextId) throws TvmSdkException {
		return TvmSdk.await(Crypto.convertPublicKeyToTonSafeFormat(contextId, this.publicKey)).tonPublicKey();
	}

	/**
	 * Public key big int big integer.
	 *
	 * @return the big integer
	 */
	public BigInteger publicKeyBigInt() {
		return Hexes.asBigInt(publicKey());
	}

	/**
	 * Secret key big int big integer.
	 *
	 * @return the big integer
	 */
	public BigInteger secretKeyBigInt() {
		return Hexes.asBigInt(secretKey());
	}
}
