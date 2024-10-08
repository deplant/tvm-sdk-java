package tech.deplant.jacki.framework;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The interface Currency unit.
 */
public interface CurrencyUnit {

	/**
	 * The type Custom token.
	 */
	class CustomToken implements CurrencyUnit {

		private final BigDecimal factor;
		private final int decimals;

		/**
		 * Instantiates a new Custom token.
		 *
		 * @param decimals the decimals
		 */
		public CustomToken(int decimals) {
			this.decimals = decimals;
			this.factor = BigDecimal.TEN.pow(decimals);
		}

		@Override
		public BigDecimal factor() {
			return this.factor;
		}

		@Override
		public int decimals() {
			return this.decimals;
		}
	}

	/**
	 * Factor big decimal.
	 *
	 * @return the big decimal
	 */
	BigDecimal factor();

	/**
	 * Decimals int.
	 *
	 * @return the int
	 */
	int decimals();

	/**
	 * Value big integer.
	 *
	 * @param unit   the unit
	 * @param amount the amount
	 * @return the big integer
	 */
	static BigInteger VALUE(CurrencyUnit unit, String amount) {
		return VALUE(unit, new BigDecimal(amount));
	}

	/**
	 * Value big integer.
	 *
	 * @param unit   the unit
	 * @param amount the amount
	 * @return the big integer
	 */
	static BigInteger VALUE(CurrencyUnit unit, BigDecimal amount) {
		return amount.multiply(unit.factor()).toBigInteger();
	}

	/**
	 * Nanos big integer.
	 *
	 * @param decimalAmount the decimal amount
	 * @return the big integer
	 */
	default BigInteger nanos(BigDecimal decimalAmount) {
		return decimalAmount.multiply(factor()).toBigInteger();
	}

	/**
	 * Nanos big integer.
	 *
	 * @param stringAmount the string amount
	 * @return the big integer
	 */
	default BigInteger nanos(String stringAmount) {
		return nanos(new BigDecimal(stringAmount));
	}

	/**
	 * The enum Ever.
	 */
	enum Coin implements CurrencyUnit {
		/**
		 * Nanoever ever.
		 */
		NANOCOIN(0),
		/**
		 * Microever ever.
		 */
		MICROCOIN(3),
		/**
		 * Milliever ever.
		 */
		MILLICOIN(6),
		/**
		 * Ever ever.
		 */
		COIN(9),
		/**
		 * Kiloever ever.
		 */
		KILOCOIN(12),
		/**
		 * Megaever ever.
		 */
		MEGACOIN(15),
		/**
		 * Gigaever ever.
		 */
		GIGACOIN(18);

		private final BigDecimal factor;

		private final int decimals;

		Coin(int decimals) {
			this.decimals = decimals;
			this.factor = BigDecimal.TEN.pow(decimals);
		}


		@Override
		public int decimals() {
			return this.decimals;
		}

		@Override
		public BigDecimal factor() {
			return this.factor;
		}
	}

	/**
	 * The enum Tokens.
	 */
	enum Tokens implements CurrencyUnit {
		/**
		 * Qube tokens.
		 */
		QUBE(9),
		/**
		 * Bridge tokens.
		 */
		BRIDGE(9),
		/**
		 * Lend tokens.
		 */
		LEND(9),
		/**
		 * Weth tokens.
		 */
		WETH(18);

		private final BigDecimal factor;
		private final int decimals;

		Tokens(int decimals) {
			this.decimals = decimals;
			this.factor = BigDecimal.TEN.pow(decimals);
		}

		@Override
		public int decimals() {
			return this.decimals;
		}

		@Override
		public BigDecimal factor() {
			return this.factor;
		}
	}

}
