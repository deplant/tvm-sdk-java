package tech.deplant.jacki.frtest.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tech.deplant.jacki.binding.TvmSdkException;
import tech.deplant.jacki.framework.Credentials;
import tech.deplant.jacki.framework.CurrencyUnit;
import tech.deplant.jacki.framework.contract.GiverContract;
import tech.deplant.jacki.framework.template.SafeMultisigWalletTemplate;
import tech.deplant.jacki.framework.template.SetcodeMultisigWalletTemplate;
import tech.deplant.jacki.framework.template.SurfMultisigWalletTemplate;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.deplant.jacki.framework.CurrencyUnit.Coin.COIN;
import static tech.deplant.jacki.frtest.unit.Env.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Execution(ExecutionMode.CONCURRENT)
public class TemplateTests {
	@BeforeAll
	public static void init_sdk_and_other_vars() throws IOException, TvmSdkException {
		INIT();
	}

	@Test
	public void multisig_code_hashes_should_be_equal_to_known() throws TvmSdkException {
		assertEquals("80d6c47c4a25543c9b397b71716f3fae1e2c5d247174c52e2c19bd896442b105",
		             SafeMultisigWalletTemplate.DEFAULT_TVC().codeHash(SDK_EMPTY));
		assertEquals("e2b60b6b602c10ced7ea8ede4bdf96342c97570a3798066f3fb50a4b2b27a208",
		             SetcodeMultisigWalletTemplate.DEFAULT_TVC().codeHash(SDK_EMPTY));
		assertEquals("207dc560c5956de1a2c1479356f8f3ee70a59767db2bf4788b1d61ad42cdad82",
		             SurfMultisigWalletTemplate.DEFAULT_TVC().codeHash(SDK_EMPTY));
	}

	@Test
	public void template_updated_and_hashed_address_equal_to_deployset_message_address() throws TvmSdkException, JsonProcessingException {
//TODO Return tests
		var keys = new Credentials("a828a9533949a4eba661d54674fb5d5aaa1e968ac0cdab88d1d71f91996bed48", "");
		assertEquals("0:856f54b9126755ce6ecb7c62b7ad8c94353f7797c03ab82eda63d11120ed3ab7",
		             new SurfMultisigWalletTemplate()
				             .prepareDeploy(SDK_EMPTY, 0, keys, new BigInteger[]{keys.publicKeyBigInt()}, 1)
				             .toAddress().makeAddrStd());
	}

	@Test
	public void template_updated_with_pubkey_should_calculate_to_correct_address() {
		//TODO add template updating?
	}


	@Test
	@Disabled
	public void giver_switch_networks() throws Throwable {
		var safeTemplate = new SafeMultisigWalletTemplate();
		GiverContract giver = null;
		Integer sdk = null;
		if (false) {
			giver = GIVER_LOCAL;
			sdk = SDK_LOCAL;
		} else {
			giver = GIVER_DEV;
			sdk = SDK_DEV;
		}
		var keys = RNG_KEYS();
		safeTemplate.prepareDeploy(
				sdk, 0,
				RNG_KEYS(), new BigInteger[]{keys.publicKeyBigInt()}, 1
		).deployWithGiver(giver,
		                  CurrencyUnit.VALUE(COIN, "1"));
	}

}
