package tech.deplant.jacki.framework.contract;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.deplant.jacki.framework.Credentials;

/**
 * The interface Ever os giver.
 */
public interface EverOSGiver {

	/**
	 * V 2 giver v 2 contract.
	 *
	 * @param contextId the context id
	 * @return the giver v 2 contract
	 * @throws JsonProcessingException the json processing exception
	 */
	static GiverV2Contract V2(int contextId) throws JsonProcessingException {
		return new GiverV2Contract(contextId,
		                           "0:ece57bcc6c530283becbbd8a3b24d3c5987cdddc3c8b7b33be6e4a6312490415",
		                           new Credentials("2ada2e65ab8eeab09490e3521415f45b6e42df9c760a639bcf53957550b25a16",
		                                           "172af540e43a524763dd53b26a066d472a97c4de37d5498170564510608250c3"));
	}

}
