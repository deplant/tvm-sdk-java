package tech.deplant.jacki.framework.template;

import com.fasterxml.jackson.core.JsonProcessingException;
import tech.deplant.jacki.binding.*;
import tech.deplant.jacki.framework.ContractAbi;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.contract.EverWalletContract;
import tech.deplant.jacki.framework.datatype.Address;
import tech.deplant.jacki.framework.datatype.TvmBuilder;
import tech.deplant.jacki.framework.datatype.TvmCell;
import tech.deplant.jacki.framework.datatype.Uint;

import java.math.BigInteger;

public record EverWalletTemplate(TvmCell code, ContractAbi abi) {

	public EverWalletTemplate() throws JsonProcessingException {
		this(CODE(),DEFAULT_ABI());
	}

	public static TvmCell CODE() {
		return new TvmCell(
				"te6cckEBBgEA/AABFP8A9KQT9LzyyAsBAgEgAgMABNIwAubycdcBAcAA8nqDCNcY7UTQgwfXAdcLP8j4KM8WI88WyfkAA3HXAQHDAJqDB9cBURO68uBk3oBA1wGAINcBgCDXAVQWdfkQ8qj4I7vyeWa++COBBwiggQPoqFIgvLHydAIgghBM7mRsuuMPAcjL/8s/ye1UBAUAmDAC10zQ+kCDBtcBcdcBeNcB10z4AHCAEASqAhSxyMsFUAXPFlAD+gLLaSLQIc8xIddJoIQJuZgzcAHLAFjPFpcwcQHLABLM4skB+wAAPoIQFp4+EbqOEfgAApMg10qXeNcB1AL7AOjRkzLyPOI+zYS/");
	}

	public static ContractAbi DEFAULT_ABI() throws JsonProcessingException {
		return ContractAbi.ofString(
				"{\n" + "  \"ABI version\": 2,\n" + "  \"version\": \"2.3\",\n" + "  \"header\": [\n" +
				"    \"pubkey\",\n" + "    \"time\",\n" + "    \"expire\"\n" + "  ],\n" + "  \"functions\": [\n" +
				"    {\n" + "      \"name\": \"sendTransaction\",\n" + "      \"inputs\": [\n" + "        {\n" +
				"          \"name\": \"dest\",\n" + "          \"type\": \"address\"\n" + "        },\n" +
				"        {\n" + "          \"name\": \"value\",\n" + "          \"type\": \"uint128\"\n" +
				"        },\n" + "        {\n" + "          \"name\": \"bounce\",\n" +
				"          \"type\": \"bool\"\n" + "        },\n" + "        {\n" + "          \"name\": \"flags\",\n" +
				"          \"type\": \"uint8\"\n" + "        },\n" + "        {\n" +
				"          \"name\": \"payload\",\n" + "          \"type\": \"cell\"\n" + "        }\n" + "      ],\n" +
				"      \"outputs\": []\n" + "    },\n" + "    {\n" + "      \"name\": \"sendTransactionRaw\",\n" +
				"      \"inputs\": [\n" + "        {\n" + "          \"name\": \"flags\",\n" +
				"          \"type\": \"uint8\"\n" + "        },\n" + "        {\n" +
				"          \"name\": \"message\",\n" + "          \"type\": \"cell\"\n" + "        }\n" + "      ],\n" +
				"      \"outputs\": []\n" + "    }\n" + "  ],\n" + "  \"data\": [],\n" + "  \"events\": [],\n" +
				"  \"fields\": [\n" + "    {\n" + "      \"name\": \"_pubkey\",\n" + "      \"type\": \"uint256\"\n" +
				"    },\n" + "    {\n" + "      \"name\": \"_timestamp\",\n" + "      \"type\": \"uint64\"\n" +
				"    }\n" + "  ]\n" + "}");
	}

	public TvmCell getInitialData(int contextId, String publicKey, BigInteger timestamp) throws TvmSdkException {
		return new TvmBuilder().store(Uint.of(256, publicKey), Uint.of(64, timestamp)).toCell(contextId);
	}

	public TvmCell getStateInit(int contextId, String publicKey, BigInteger timestamp) throws TvmSdkException {
		return new TvmCell(TvmSdk.await(Boc.encodeStateInit(contextId, CODE().cellBoc(), getInitialData(contextId, publicKey, timestamp).cellBoc(), null, null, null, null, null))
		                          .stateInit());
	}

	public Address getAddress(int contextId, int wid, TvmCell stateInit) throws TvmSdkException {
		return new Address(wid,stateInit.bocHash(contextId));
	}

	public Address getAddress(int contextId, int wid, String publicKey, BigInteger timestamp) throws TvmSdkException {
		return new Address(wid,getStateInit(contextId, publicKey, timestamp).bocHash(contextId));
	}

	public String getMessageBody(int contextId, int wid, Credentials keys, BigInteger timestamp, Address to, BigInteger value) throws TvmSdkException, JsonProcessingException {
		var stateInit = getStateInit(contextId, keys.publicKey(), timestamp);
		var targetAddress = getAddress(contextId, wid, stateInit);
		var body =  new EverWalletContract(contextId, targetAddress, keys).sendTransaction(to, value, true).toPayload();
		return TvmSdk.await(Boc.encodeExternalInMessage(contextId,
		                                                        null,
		                                                        targetAddress.makeAddrStd(),
		                                                        stateInit.cellBoc(),
		                                                        body.cellBoc(),
		                                                        null)).message();
	}

//	public EverWalletContract deployAndSend(int contextId, int wid, Credentials keys, BigInteger timestamp, Address to, BigInteger value) throws EverSdkException, JsonProcessingException {
//		EverSdk.await(Boc.encodeExternalInMessage(contextId,
//		                                          null,
//		                                          targetAddress.makeAddrStd(),
//		                                          stateInit.cellBoc(),
//		                                          body.cellBoc(),
//		                                          null)).message();
//		var body =  getMessageBody(contextId, wid, keys, timestamp, to, value);
//
//		var request = EverSdk.await(Processing.sendMessage(contextId, message, abi().ABI(), false, null));
//
//		var transaction = EverSdk.await(Processing.waitForTransaction(contextId,
//		                                                              abi().ABI(),
//		                                                              message,
//		                                                              request.shardBlockId(),
//		                                                              false,
//		                                                              request.sendingEndpoints(),
//		                                                              null)).transaction();
//		return futureContract;
//	}
}
