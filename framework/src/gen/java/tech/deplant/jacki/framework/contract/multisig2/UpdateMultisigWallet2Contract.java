package tech.deplant.jacki.framework.contract.multisig2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.Void;
import java.math.BigInteger;
import java.util.Map;
import java.util.Optional;
import tech.deplant.jacki.framework.ContractAbi;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.FunctionHandle;
import tech.deplant.jacki.framework.datatype.Address;
import tech.deplant.jacki.framework.datatype.TvmCell;

/**
 * Java wrapper class for usage of <strong>UpdateMultisigWallet2Contract</strong> contract for Everscale blockchain.
 */
public class UpdateMultisigWallet2Contract extends MultisigContract2 {
  public UpdateMultisigWallet2Contract(int contextId, String address) throws
      JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),Credentials.NONE);
  }

  public UpdateMultisigWallet2Contract(int contextId, String address, ContractAbi abi) {
    super(contextId,address,abi,Credentials.NONE);
  }

  public UpdateMultisigWallet2Contract(int contextId, String address, Credentials credentials)
      throws JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),credentials);
  }

  @JsonCreator
  public UpdateMultisigWallet2Contract(int contextId, String address, ContractAbi abi,
      Credentials credentials) {
    super(contextId,address,abi,credentials);
  }

  public static ContractAbi DEFAULT_ABI() throws JsonProcessingException {
    return ContractAbi.ofString("{\"version\":\"2.3\",\"header\":[\"pubkey\",\"time\",\"expire\"],\"functions\":[{\"name\":\"constructor\",\"inputs\":[{\"name\":\"owners\",\"type\":\"uint256[]\"},{\"name\":\"reqConfirms\",\"type\":\"uint8\"},{\"name\":\"lifetime\",\"type\":\"uint32\"}],\"outputs\":[]},{\"name\":\"sendTransaction\",\"inputs\":[{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"flags\",\"type\":\"uint8\"},{\"name\":\"payload\",\"type\":\"cell\"}],\"outputs\":[]},{\"name\":\"submitTransaction\",\"inputs\":[{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"allBalance\",\"type\":\"bool\"},{\"name\":\"payload\",\"type\":\"cell\"},{\"name\":\"stateInit\",\"type\":\"optional(cell)\"}],\"outputs\":[{\"name\":\"transId\",\"type\":\"uint64\"}]},{\"name\":\"confirmTransaction\",\"inputs\":[{\"name\":\"transactionId\",\"type\":\"uint64\"}],\"outputs\":[]},{\"name\":\"isConfirmed\",\"inputs\":[{\"name\":\"mask\",\"type\":\"uint32\"},{\"name\":\"index\",\"type\":\"uint8\"}],\"outputs\":[{\"name\":\"confirmed\",\"type\":\"bool\"}]},{\"name\":\"getParameters\",\"inputs\":[],\"outputs\":[{\"name\":\"maxQueuedTransactions\",\"type\":\"uint8\"},{\"name\":\"maxCustodianCount\",\"type\":\"uint8\"},{\"name\":\"expirationTime\",\"type\":\"uint64\"},{\"name\":\"minValue\",\"type\":\"uint128\"},{\"name\":\"requiredTxnConfirms\",\"type\":\"uint8\"},{\"name\":\"requiredUpdConfirms\",\"type\":\"uint8\"}]},{\"name\":\"getTransaction\",\"inputs\":[{\"name\":\"transactionId\",\"type\":\"uint64\"}],\"outputs\":[{\"name\":\"trans\",\"type\":\"tuple\",\"components\":[{\"name\":\"id\",\"type\":\"uint64\"},{\"name\":\"confirmationsMask\",\"type\":\"uint32\"},{\"name\":\"signsRequired\",\"type\":\"uint8\"},{\"name\":\"signsReceived\",\"type\":\"uint8\"},{\"name\":\"creator\",\"type\":\"uint256\"},{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"sendFlags\",\"type\":\"uint16\"},{\"name\":\"payload\",\"type\":\"cell\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"stateInit\",\"type\":\"optional(cell)\"}]}]},{\"name\":\"getTransactions\",\"inputs\":[],\"outputs\":[{\"name\":\"transactions\",\"type\":\"tuple[]\",\"components\":[{\"name\":\"id\",\"type\":\"uint64\"},{\"name\":\"confirmationsMask\",\"type\":\"uint32\"},{\"name\":\"signsRequired\",\"type\":\"uint8\"},{\"name\":\"signsReceived\",\"type\":\"uint8\"},{\"name\":\"creator\",\"type\":\"uint256\"},{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"sendFlags\",\"type\":\"uint16\"},{\"name\":\"payload\",\"type\":\"cell\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"stateInit\",\"type\":\"optional(cell)\"}]}]},{\"name\":\"getCustodians\",\"inputs\":[],\"outputs\":[{\"name\":\"custodians\",\"type\":\"tuple[]\",\"components\":[{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"pubkey\",\"type\":\"uint256\"}]}]},{\"name\":\"submitUpdate\",\"inputs\":[{\"name\":\"codeHash\",\"type\":\"optional(uint256)\"},{\"name\":\"owners\",\"type\":\"optional(uint256[])\"},{\"name\":\"reqConfirms\",\"type\":\"optional(uint8)\"},{\"name\":\"lifetime\",\"type\":\"optional(uint32)\"}],\"outputs\":[{\"name\":\"updateId\",\"type\":\"uint64\"}]},{\"name\":\"confirmUpdate\",\"inputs\":[{\"name\":\"updateId\",\"type\":\"uint64\"}],\"outputs\":[]},{\"name\":\"executeUpdate\",\"inputs\":[{\"name\":\"updateId\",\"type\":\"uint64\"},{\"name\":\"code\",\"type\":\"optional(cell)\"}],\"outputs\":[]},{\"name\":\"getUpdateRequests\",\"inputs\":[],\"outputs\":[{\"name\":\"updates\",\"type\":\"tuple[]\",\"components\":[{\"name\":\"id\",\"type\":\"uint64\"},{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"signs\",\"type\":\"uint8\"},{\"name\":\"confirmationsMask\",\"type\":\"uint32\"},{\"name\":\"creator\",\"type\":\"uint256\"},{\"name\":\"codeHash\",\"type\":\"optional(uint256)\"},{\"name\":\"custodians\",\"type\":\"optional(uint256[])\"},{\"name\":\"reqConfirms\",\"type\":\"optional(uint8)\"},{\"name\":\"lifetime\",\"type\":\"optional(uint32)\"}]}]}],\"events\":[],\"data\":[],\"fields\":[{\"name\":\"_pubkey\",\"type\":\"uint256\"},{\"name\":\"_timestamp\",\"type\":\"uint64\"},{\"name\":\"_constructorFlag\",\"type\":\"bool\"},{\"name\":\"m_ownerKey\",\"type\":\"uint256\"},{\"name\":\"m_requestsMask\",\"type\":\"uint256\"},{\"name\":\"m_transactions\",\"type\":\"map(uint64,tuple)\",\"components\":[{\"name\":\"id\",\"type\":\"uint64\"},{\"name\":\"confirmationsMask\",\"type\":\"uint32\"},{\"name\":\"signsRequired\",\"type\":\"uint8\"},{\"name\":\"signsReceived\",\"type\":\"uint8\"},{\"name\":\"creator\",\"type\":\"uint256\"},{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"sendFlags\",\"type\":\"uint16\"},{\"name\":\"payload\",\"type\":\"cell\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"stateInit\",\"type\":\"optional(cell)\"}]},{\"name\":\"m_custodians\",\"type\":\"map(uint256,uint8)\"},{\"name\":\"m_custodianCount\",\"type\":\"uint8\"},{\"name\":\"m_updateRequests\",\"type\":\"map(uint64,tuple)\",\"components\":[{\"name\":\"id\",\"type\":\"uint64\"},{\"name\":\"index\",\"type\":\"uint8\"},{\"name\":\"signs\",\"type\":\"uint8\"},{\"name\":\"confirmationsMask\",\"type\":\"uint32\"},{\"name\":\"creator\",\"type\":\"uint256\"},{\"name\":\"codeHash\",\"type\":\"optional(uint256)\"},{\"name\":\"custodians\",\"type\":\"optional(uint256[])\"},{\"name\":\"reqConfirms\",\"type\":\"optional(uint8)\"},{\"name\":\"lifetime\",\"type\":\"optional(uint32)\"}]},{\"name\":\"m_updateRequestsMask\",\"type\":\"uint32\"},{\"name\":\"m_requiredVotes\",\"type\":\"uint8\"},{\"name\":\"m_defaultRequiredConfirmations\",\"type\":\"uint8\"},{\"name\":\"m_lifetime\",\"type\":\"uint32\"}],\"ABI version\":2}");
  }

  public FunctionHandle<Void> sendTransaction(Address dest, BigInteger value, Boolean bounce,
      Integer flags, TvmCell payload) {
    Map<String, Object> params = Map.of("dest", dest, 
        "value", value, 
        "bounce", bounce, 
        "flags", flags, 
        "payload", payload);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "sendTransaction", params, null);
  }

  public FunctionHandle<ResultOfSubmitTransaction> submitTransaction(Address dest, BigInteger value,
      Boolean bounce, Boolean allBalance, TvmCell payload, Optional<TvmCell> stateInit) {
    Map<String, Object> params = Map.of("dest", dest, 
        "value", value, 
        "bounce", bounce, 
        "allBalance", allBalance, 
        "payload", payload, 
        "stateInit", stateInit);
    return new FunctionHandle<ResultOfSubmitTransaction>(ResultOfSubmitTransaction.class, contextId(), address(), abi(), credentials(), "submitTransaction", params, null);
  }

  public FunctionHandle<Void> confirmTransaction(BigInteger transactionId) {
    Map<String, Object> params = Map.of("transactionId", transactionId);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "confirmTransaction", params, null);
  }

  public FunctionHandle<ResultOfIsConfirmed> isConfirmed(Long mask, Integer index) {
    Map<String, Object> params = Map.of("mask", mask, 
        "index", index);
    return new FunctionHandle<ResultOfIsConfirmed>(ResultOfIsConfirmed.class, contextId(), address(), abi(), credentials(), "isConfirmed", params, null);
  }

  public FunctionHandle<ResultOfGetParameters> getParameters() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOfGetParameters>(ResultOfGetParameters.class, contextId(), address(), abi(), credentials(), "getParameters", params, null);
  }

  public FunctionHandle<ResultOfGetTransaction> getTransaction(BigInteger transactionId) {
    Map<String, Object> params = Map.of("transactionId", transactionId);
    return new FunctionHandle<ResultOfGetTransaction>(ResultOfGetTransaction.class, contextId(), address(), abi(), credentials(), "getTransaction", params, null);
  }

  public FunctionHandle<ResultOfGetTransactions> getTransactions() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOfGetTransactions>(ResultOfGetTransactions.class, contextId(), address(), abi(), credentials(), "getTransactions", params, null);
  }

  public FunctionHandle<ResultOfGetCustodians> getCustodians() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOfGetCustodians>(ResultOfGetCustodians.class, contextId(), address(), abi(), credentials(), "getCustodians", params, null);
  }

  public FunctionHandle<ResultOfSubmitUpdate> submitUpdate(Optional<BigInteger> codeHash,
      Optional<BigInteger[]> owners, Optional<Integer> reqConfirms, Optional<Long> lifetime) {
    Map<String, Object> params = Map.of("codeHash", codeHash, 
        "owners", owners, 
        "reqConfirms", reqConfirms, 
        "lifetime", lifetime);
    return new FunctionHandle<ResultOfSubmitUpdate>(ResultOfSubmitUpdate.class, contextId(), address(), abi(), credentials(), "submitUpdate", params, null);
  }

  public FunctionHandle<Void> confirmUpdate(BigInteger updateId) {
    Map<String, Object> params = Map.of("updateId", updateId);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "confirmUpdate", params, null);
  }

  public FunctionHandle<Void> executeUpdate(BigInteger updateId, Optional<TvmCell> code) {
    Map<String, Object> params = Map.of("updateId", updateId, 
        "code", code);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "executeUpdate", params, null);
  }

  public FunctionHandle<ResultOfGetUpdateRequests> getUpdateRequests() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOfGetUpdateRequests>(ResultOfGetUpdateRequests.class, contextId(), address(), abi(), credentials(), "getUpdateRequests", params, null);
  }
}
