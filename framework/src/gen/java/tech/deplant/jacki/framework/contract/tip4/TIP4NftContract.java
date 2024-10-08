package tech.deplant.jacki.framework.contract.tip4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.Void;
import java.math.BigInteger;
import java.util.Map;
import tech.deplant.jacki.framework.ContractAbi;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.FunctionHandle;
import tech.deplant.jacki.framework.contract.AbstractContract;
import tech.deplant.jacki.framework.datatype.Address;
import tech.deplant.jacki.framework.datatype.TvmCell;

/**
 * Java wrapper class for usage of <strong>TIP4NftContract</strong> contract for Everscale blockchain.
 */
public class TIP4NftContract extends AbstractContract {
  public TIP4NftContract(int contextId, String address) throws JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),Credentials.NONE);
  }

  public TIP4NftContract(int contextId, String address, ContractAbi abi) {
    super(contextId,address,abi,Credentials.NONE);
  }

  public TIP4NftContract(int contextId, String address, Credentials credentials) throws
      JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),credentials);
  }

  @JsonCreator
  public TIP4NftContract(int contextId, String address, ContractAbi abi, Credentials credentials) {
    super(contextId,address,abi,credentials);
  }

  public static ContractAbi DEFAULT_ABI() throws JsonProcessingException {
    return ContractAbi.ofString("{\"version\":\"2.2\",\"header\":[\"pubkey\",\"time\",\"expire\"],\"functions\":[{\"name\":\"constructor\",\"inputs\":[{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"sendGasTo\",\"type\":\"address\"},{\"name\":\"remainOnNft\",\"type\":\"uint128\"},{\"name\":\"json\",\"type\":\"string\"},{\"name\":\"indexDeployValue\",\"type\":\"uint128\"},{\"name\":\"indexDestroyValue\",\"type\":\"uint128\"},{\"name\":\"codeIndex\",\"type\":\"cell\"}],\"outputs\":[]},{\"name\":\"burn\",\"inputs\":[{\"name\":\"dest\",\"type\":\"address\"}],\"outputs\":[]},{\"name\":\"indexCode\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"code\",\"type\":\"cell\"}]},{\"name\":\"indexCodeHash\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"hash\",\"type\":\"uint256\"}]},{\"name\":\"resolveIndex\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"},{\"name\":\"collection\",\"type\":\"address\"},{\"name\":\"owner\",\"type\":\"address\"}],\"outputs\":[{\"name\":\"index\",\"type\":\"address\"}]},{\"name\":\"getJson\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"json\",\"type\":\"string\"}]},{\"name\":\"transfer\",\"inputs\":[{\"name\":\"to\",\"type\":\"address\"},{\"name\":\"sendGasTo\",\"type\":\"address\"},{\"name\":\"callbacks\",\"type\":\"map(address,tuple)\",\"components\":[{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"payload\",\"type\":\"cell\"}]}],\"outputs\":[]},{\"name\":\"changeOwner\",\"inputs\":[{\"name\":\"newOwner\",\"type\":\"address\"},{\"name\":\"sendGasTo\",\"type\":\"address\"},{\"name\":\"callbacks\",\"type\":\"map(address,tuple)\",\"components\":[{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"payload\",\"type\":\"cell\"}]}],\"outputs\":[]},{\"name\":\"changeManager\",\"inputs\":[{\"name\":\"newManager\",\"type\":\"address\"},{\"name\":\"sendGasTo\",\"type\":\"address\"},{\"name\":\"callbacks\",\"type\":\"map(address,tuple)\",\"components\":[{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"payload\",\"type\":\"cell\"}]}],\"outputs\":[]},{\"name\":\"getInfo\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"},{\"name\":\"collection\",\"type\":\"address\"}]},{\"name\":\"supportsInterface\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"},{\"name\":\"interfaceID\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"value0\",\"type\":\"bool\"}]}],\"events\":[{\"name\":\"NftCreated\",\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"},{\"name\":\"collection\",\"type\":\"address\"}]},{\"name\":\"OwnerChanged\",\"inputs\":[{\"name\":\"oldOwner\",\"type\":\"address\"},{\"name\":\"newOwner\",\"type\":\"address\"}]},{\"name\":\"ManagerChanged\",\"inputs\":[{\"name\":\"oldManager\",\"type\":\"address\"},{\"name\":\"newManager\",\"type\":\"address\"}]},{\"name\":\"NftBurned\",\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"},{\"name\":\"collection\",\"type\":\"address\"}]}],\"data\":[{\"key\":1,\"name\":\"_id\",\"type\":\"uint256\"}],\"fields\":[{\"name\":\"_pubkey\",\"type\":\"uint256\"},{\"name\":\"_timestamp\",\"type\":\"uint64\"},{\"name\":\"_constructorFlag\",\"type\":\"bool\"},{\"name\":\"_supportedInterfaces\",\"type\":\"optional(cell)\"},{\"name\":\"_id\",\"type\":\"uint256\"},{\"name\":\"_collection\",\"type\":\"address\"},{\"name\":\"_owner\",\"type\":\"address\"},{\"name\":\"_manager\",\"type\":\"address\"},{\"name\":\"_json\",\"type\":\"string\"},{\"name\":\"_indexDeployValue\",\"type\":\"uint128\"},{\"name\":\"_indexDestroyValue\",\"type\":\"uint128\"},{\"name\":\"_codeIndex\",\"type\":\"cell\"}],\"ABI version\":2}");
  }

  public FunctionHandle<Void> burn(Address dest) {
    Map<String, Object> params = Map.of("dest", dest);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "burn", params, null);
  }

  public FunctionHandle<ResultOfIndexCode> indexCode() {
    Map<String, Object> params = Map.of("answerId", 0);
    return new FunctionHandle<ResultOfIndexCode>(ResultOfIndexCode.class, contextId(), address(), abi(), credentials(), "indexCode", params, null);
  }

  public FunctionHandle<ResultOfIndexCodeHash> indexCodeHash() {
    Map<String, Object> params = Map.of("answerId", 0);
    return new FunctionHandle<ResultOfIndexCodeHash>(ResultOfIndexCodeHash.class, contextId(), address(), abi(), credentials(), "indexCodeHash", params, null);
  }

  public FunctionHandle<ResultOfResolveIndex> resolveIndex(Address collection, Address owner) {
    Map<String, Object> params = Map.of("answerId", 0, 
        "collection", collection, 
        "owner", owner);
    return new FunctionHandle<ResultOfResolveIndex>(ResultOfResolveIndex.class, contextId(), address(), abi(), credentials(), "resolveIndex", params, null);
  }

  public FunctionHandle<ResultOfGetJson> getJson() {
    Map<String, Object> params = Map.of("answerId", 0);
    return new FunctionHandle<ResultOfGetJson>(ResultOfGetJson.class, contextId(), address(), abi(), credentials(), "getJson", params, null);
  }

  public FunctionHandle<Void> transfer(Address to, Address sendGasTo,
      Map<Address, Map<String, Object>> callbacks) {
    Map<String, Object> params = Map.of("to", to, 
        "sendGasTo", sendGasTo, 
        "callbacks", callbacks);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "transfer", params, null);
  }

  public FunctionHandle<Void> changeOwner(Address newOwner, Address sendGasTo,
      Map<Address, Map<String, Object>> callbacks) {
    Map<String, Object> params = Map.of("newOwner", newOwner, 
        "sendGasTo", sendGasTo, 
        "callbacks", callbacks);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "changeOwner", params, null);
  }

  public FunctionHandle<Void> changeManager(Address newManager, Address sendGasTo,
      Map<Address, Map<String, Object>> callbacks) {
    Map<String, Object> params = Map.of("newManager", newManager, 
        "sendGasTo", sendGasTo, 
        "callbacks", callbacks);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "changeManager", params, null);
  }

  public FunctionHandle<ResultOfGetInfo> getInfo() {
    Map<String, Object> params = Map.of("answerId", 0);
    return new FunctionHandle<ResultOfGetInfo>(ResultOfGetInfo.class, contextId(), address(), abi(), credentials(), "getInfo", params, null);
  }

  public FunctionHandle<ResultOfSupportsInterface> supportsInterface(Long interfaceID) {
    Map<String, Object> params = Map.of("answerId", 0, 
        "interfaceID", interfaceID);
    return new FunctionHandle<ResultOfSupportsInterface>(ResultOfSupportsInterface.class, contextId(), address(), abi(), credentials(), "supportsInterface", params, null);
  }

  public record ResultOfIndexCode(TvmCell code) {
  }

  public record ResultOfIndexCodeHash(BigInteger hash) {
  }

  public record ResultOfResolveIndex(Address index) {
  }

  public record ResultOfGetJson(String json) {
  }

  public record ResultOfGetInfo(BigInteger id, Address owner, Address manager, Address collection) {
  }

  public record ResultOfSupportsInterface(Boolean value0) {
  }
}
