package tech.deplant.jacki.framework.template;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.Map;
import tech.deplant.jacki.framework.ContractAbi;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.DeployHandle;
import tech.deplant.jacki.framework.Tvc;
import tech.deplant.jacki.framework.contract.tip4.TIP4CollectionContract;
import tech.deplant.jacki.framework.datatype.TvmCell;

/**
 * Java template class for deploy of <strong>TIP4CollectionContract</strong> contract for Everscale blockchain.
 */
public record TIP4CollectionTemplate(ContractAbi abi, Tvc tvc) implements Template {
  public TIP4CollectionTemplate(Tvc tvc) throws JsonProcessingException {
    this(DEFAULT_ABI(), tvc);
  }

  public TIP4CollectionTemplate() throws JsonProcessingException {
    this(DEFAULT_ABI(),DEFAULT_TVC());
  }

  public static ContractAbi DEFAULT_ABI() throws JsonProcessingException {
    return ContractAbi.ofString("{\"version\":\"2.2\",\"header\":[\"pubkey\",\"time\",\"expire\"],\"functions\":[{\"name\":\"constructor\",\"inputs\":[{\"name\":\"codeNft\",\"type\":\"cell\"},{\"name\":\"codeIndex\",\"type\":\"cell\"},{\"name\":\"codeIndexBasis\",\"type\":\"cell\"},{\"name\":\"ownerPubkey\",\"type\":\"uint256\"},{\"name\":\"json\",\"type\":\"string\"},{\"name\":\"mintingFee\",\"type\":\"uint128\"}],\"outputs\":[]},{\"name\":\"mintNft\",\"inputs\":[{\"name\":\"json\",\"type\":\"string\"}],\"outputs\":[]},{\"name\":\"withdraw\",\"inputs\":[{\"name\":\"dest\",\"type\":\"address\"},{\"name\":\"value\",\"type\":\"uint128\"}],\"outputs\":[]},{\"name\":\"onTokenBurned\",\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"}],\"outputs\":[]},{\"name\":\"setRemainOnNft\",\"inputs\":[{\"name\":\"remainOnNft\",\"type\":\"uint128\"}],\"outputs\":[]},{\"name\":\"setMintingFee\",\"inputs\":[{\"name\":\"mintingFee\",\"type\":\"uint128\"}],\"outputs\":[]},{\"name\":\"mintingFee\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"value0\",\"type\":\"uint128\"}]},{\"name\":\"owner\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"pubkey\",\"type\":\"uint256\"}]},{\"name\":\"transferOwnership\",\"inputs\":[{\"name\":\"newOwner\",\"type\":\"uint256\"}],\"outputs\":[]},{\"name\":\"indexBasisCode\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"code\",\"type\":\"cell\"}]},{\"name\":\"indexBasisCodeHash\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"hash\",\"type\":\"uint256\"}]},{\"name\":\"resolveIndexBasis\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"indexBasis\",\"type\":\"address\"}]},{\"name\":\"indexCode\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"code\",\"type\":\"cell\"}]},{\"name\":\"indexCodeHash\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"hash\",\"type\":\"uint256\"}]},{\"name\":\"getJson\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"json\",\"type\":\"string\"}]},{\"name\":\"totalSupply\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"count\",\"type\":\"uint128\"}]},{\"name\":\"nftCode\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"code\",\"type\":\"cell\"}]},{\"name\":\"nftCodeHash\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"codeHash\",\"type\":\"uint256\"}]},{\"name\":\"nftAddress\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"},{\"name\":\"id\",\"type\":\"uint256\"}],\"outputs\":[{\"name\":\"nft\",\"type\":\"address\"}]},{\"name\":\"supportsInterface\",\"inputs\":[{\"name\":\"answerId\",\"type\":\"uint32\"},{\"name\":\"interfaceID\",\"type\":\"uint32\"}],\"outputs\":[{\"name\":\"value0\",\"type\":\"bool\"}]}],\"events\":[{\"name\":\"OwnershipTransferred\",\"inputs\":[{\"name\":\"oldOwner\",\"type\":\"uint256\"},{\"name\":\"newOwner\",\"type\":\"uint256\"}]},{\"name\":\"NftCreated\",\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"nft\",\"type\":\"address\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"},{\"name\":\"creator\",\"type\":\"address\"}]},{\"name\":\"NftBurned\",\"inputs\":[{\"name\":\"id\",\"type\":\"uint256\"},{\"name\":\"nft\",\"type\":\"address\"},{\"name\":\"owner\",\"type\":\"address\"},{\"name\":\"manager\",\"type\":\"address\"}]}],\"data\":[],\"fields\":[{\"name\":\"_pubkey\",\"type\":\"uint256\"},{\"name\":\"_timestamp\",\"type\":\"uint64\"},{\"name\":\"_constructorFlag\",\"type\":\"bool\"},{\"name\":\"_supportedInterfaces\",\"type\":\"optional(cell)\"},{\"name\":\"_codeNft\",\"type\":\"cell\"},{\"name\":\"_totalSupply\",\"type\":\"uint128\"},{\"name\":\"_json\",\"type\":\"string\"},{\"name\":\"_codeIndex\",\"type\":\"cell\"},{\"name\":\"_codeIndexBasis\",\"type\":\"cell\"},{\"name\":\"_indexDeployValue\",\"type\":\"uint128\"},{\"name\":\"_indexDestroyValue\",\"type\":\"uint128\"},{\"name\":\"_deployIndexBasisValue\",\"type\":\"uint128\"},{\"name\":\"_owner\",\"type\":\"uint256\"},{\"name\":\"_remainOnNft\",\"type\":\"uint128\"},{\"name\":\"_lastTokenId\",\"type\":\"uint128\"},{\"name\":\"_mintingFee\",\"type\":\"uint128\"}],\"ABI version\":2}");
  }

  public static Tvc DEFAULT_TVC() {
    return Tvc.ofBase64String("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");
  }

  public DeployHandle<TIP4CollectionContract> prepareDeploy(int contextId, int workchainId,
      Credentials credentials, TvmCell codeNft, TvmCell codeIndex, TvmCell codeIndexBasis,
      BigInteger ownerPubkey, String json, BigInteger mintingFee) {
    Map<String, Object> initialDataFields = Map.of();
    Map<String, Object> params = Map.of("codeNft", codeNft, 
        "codeIndex", codeIndex, 
        "codeIndexBasis", codeIndexBasis, 
        "ownerPubkey", ownerPubkey, 
        "json", json, 
        "mintingFee", mintingFee);
    return new DeployHandle<TIP4CollectionContract>(TIP4CollectionContract.class, contextId, abi(), tvc(), workchainId, credentials, initialDataFields, params, null);
  }
}
