package tech.deplant.jacki.binding.gql;

/**
 * Validators count;
 */
public record ConfigP16Filter(IntFilter max_main_validators, IntFilter max_validators,
    IntFilter min_validators, ConfigP16Filter OR) {
}
