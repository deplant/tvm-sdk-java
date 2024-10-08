package tech.deplant.jacki.framework.contract.tip4;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.Boolean;
import java.lang.Integer;
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
 * Java wrapper class for usage of <strong>TIP4WalletContract</strong> contract for Everscale blockchain.
 */
public class TIP4WalletContract extends AbstractContract {
  public TIP4WalletContract(int contextId, String address) throws JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),Credentials.NONE);
  }

  public TIP4WalletContract(int contextId, String address, ContractAbi abi) {
    super(contextId,address,abi,Credentials.NONE);
  }

  public TIP4WalletContract(int contextId, String address, Credentials credentials) throws
      JsonProcessingException {
    super(contextId,address,DEFAULT_ABI(),credentials);
  }

  @JsonCreator
  public TIP4WalletContract(int contextId, String address, ContractAbi abi,
      Credentials credentials) {
    super(contextId,address,abi,credentials);
  }

  public static ContractAbi DEFAULT_ABI() throws JsonProcessingException {
    return ContractAbi.ofString("{\"version\":\"2.2\",\"header\":[\"pubkey\",\"time\",\"expire\"],\"functions\":[{\"name\":\"sendTransaction\",\"inputs\":[{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"},{\"name\":\"bounce\",\"type\":\"bool\"},{\"name\":\"flags\",\"type\":\"uint8\"},{\"name\":\"payload\",\"type\":\"cell\"}],\"outputs\":[]},{\"name\":\"transferOwnership\",\"inputs\":[{\"name\":\"newOwner\",\"type\":\"uint256\"}],\"outputs\":[]},{\"name\":\"constructor\",\"inputs\":[],\"outputs\":[]},{\"name\":\"owner\",\"inputs\":[],\"outputs\":[{\"name\":\"owner\",\"type\":\"uint256\"}]},{\"name\":\"_randomNonce\",\"inputs\":[],\"outputs\":[{\"name\":\"_randomNonce\",\"type\":\"uint256\"}]}],\"events\":[{\"name\":\"OwnershipTransferred\",\"inputs\":[{\"name\":\"previousOwner\",\"type\":\"uint256\"},{\"name\":\"newOwner\",\"type\":\"uint256\"}]}],\"data\":[{\"key\":1,\"name\":\"_randomNonce\",\"type\":\"uint256\"}],\"fields\":[{\"name\":\"_pubkey\",\"type\":\"uint256\"},{\"name\":\"_timestamp\",\"type\":\"uint64\"},{\"name\":\"_constructorFlag\",\"type\":\"bool\"},{\"name\":\"owner\",\"type\":\"uint256\"},{\"name\":\"_randomNonce\",\"type\":\"uint256\"}],\"ABI version\":2}");
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

  public FunctionHandle<Void> transferOwnership(BigInteger newOwner) {
    Map<String, Object> params = Map.of("newOwner", newOwner);
    return new FunctionHandle<Void>(Void.class, contextId(), address(), abi(), credentials(), "transferOwnership", params, null);
  }

  public FunctionHandle<ResultOfOwner> owner() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOfOwner>(ResultOfOwner.class, contextId(), address(), abi(), credentials(), "owner", params, null);
  }

  public FunctionHandle<ResultOf_randomNonce> _randomNonce() {
    Map<String, Object> params = Map.of();
    return new FunctionHandle<ResultOf_randomNonce>(ResultOf_randomNonce.class, contextId(), address(), abi(), credentials(), "_randomNonce", params, null);
  }

  public record ResultOfOwner(BigInteger owner) {
  }

  public record ResultOf_randomNonce(BigInteger _randomNonce) {
  }
}
