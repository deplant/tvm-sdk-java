package tech.deplant.jacki.frtest.unit.datatype;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tech.deplant.jacki.binding.TvmSdkException;
import tech.deplant.jacki.framework.datatype.SolString;
import tech.deplant.jacki.frtest.unit.Env;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Execution(ExecutionMode.CONCURRENT)
public class SolStringTest {

	@BeforeAll
	public static void init_sdk_and_other_vars() throws IOException, TvmSdkException {
		Env.INIT();
	}

	@Test
	public void abi_string_to_string_equals() {
		assertEquals("hello!", new SolString("hello!").toString());
	}

	@Test
	public void string_to_abi_string_equals() {
		assertEquals("hello!", new SolString("hello!").toString());
	}

}
