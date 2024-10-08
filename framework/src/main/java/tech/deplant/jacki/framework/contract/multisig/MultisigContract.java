package tech.deplant.jacki.framework.contract.multisig;

import com.fasterxml.jackson.annotation.JsonCreator;
import tech.deplant.jacki.framework.ContractAbi;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.FunctionHandle;
import tech.deplant.jacki.framework.MessageFlag;
import tech.deplant.jacki.framework.contract.GiverContract;
import tech.deplant.jacki.framework.datatype.Address;
import tech.deplant.jacki.framework.datatype.TvmCell;

import java.math.BigInteger;

/**
 * The type Multisig contract.
 */
public abstract class MultisigContract extends GiverContract {

	/**
	 * Instantiates a new Multisig contract.
	 *
	 * @param sdk         the sdk
	 * @param address     the address
	 * @param abi         the abi
	 * @param credentials the credentials
	 */
	@JsonCreator
	public MultisigContract(int sdk, String address, ContractAbi abi, Credentials credentials) {
		super(sdk, address, abi, credentials);
	}

	/**
	 * Send transaction function handle.
	 *
	 * @param dest    the dest
	 * @param value   the value
	 * @param bounce  the bounce
	 * @param flags   the flags
	 * @param payload the payload
	 * @return the function handle
	 */
	public abstract FunctionHandle<Void> sendTransaction(Address dest, BigInteger value, Boolean bounce,
	                                                     Integer flags, TvmCell payload);

	@Override
	public FunctionHandle<Void> sendTransaction(Address dest, BigInteger value, Boolean bounce) {
		return sendTransaction(dest, value, bounce, MessageFlag.FEE_EXTRA.flag(), TvmCell.EMPTY);
	}

	@Override
	public FunctionHandle<Void> give(Address to, BigInteger value) {
		return sendTransaction(to, value, false,
		                       1, TvmCell.EMPTY);
	}

	/**
	 * Confirm transaction function handle.
	 *
	 * @param transactionId the transaction id
	 * @return the function handle
	 */
	public abstract FunctionHandle<Void> confirmTransaction(BigInteger transactionId);

	/**
	 * Is confirmed function handle.
	 *
	 * @param mask  the mask
	 * @param index the index
	 * @return the function handle
	 */
	public abstract FunctionHandle<ResultOfIsConfirmed> isConfirmed(Long mask, Integer index);

	/**
	 * Gets parameters.
	 *
	 * @return the parameters
	 */
	public abstract FunctionHandle<ResultOfGetParameters> getParameters();

	/**
	 * Gets custodians.
	 *
	 * @return the custodians
	 */
	public abstract FunctionHandle<ResultOfGetCustodians> getCustodians();

	/**
	 * Accept transfer function handle.
	 *
	 * @param payload the payload
	 * @return the function handle
	 */
	public abstract FunctionHandle<Void> acceptTransfer(Byte[] payload);

	/**
	 * Submit transaction function handle.
	 *
	 * @param dest       the dest
	 * @param value      the value
	 * @param bounce     the bounce
	 * @param allBalance the all balance
	 * @param payload    the payload
	 * @return the function handle
	 */
	public abstract FunctionHandle<ResultOfSubmitTransaction> submitTransaction(Address dest,
	                                                                            BigInteger value,
	                                                                            Boolean bounce,
	                                                                            Boolean allBalance,
	                                                                            TvmCell payload);

	/**
	 * Gets transaction.
	 *
	 * @param transactionId the transaction id
	 * @return the transaction
	 */
	public abstract FunctionHandle<ResultOfGetTransaction> getTransaction(BigInteger transactionId);

	/**
	 * Gets transactions.
	 *
	 * @return the transactions
	 */
	public abstract FunctionHandle<ResultOfGetTransactions> getTransactions();

	/**
	 * Gets transaction ids.
	 *
	 * @return the transaction ids
	 */
	public abstract FunctionHandle<ResultOfGetTransactionIds> getTransactionIds();

	/**
	 * The enum Type.
	 */
	public enum Type {
		/**
		 * Surf type.
		 */
		SURF,
		/**
		 * Safe type.
		 */
		SAFE,
		/**
		 * Setcode type.
		 */
		SETCODE;
	}

}
