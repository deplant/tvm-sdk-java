package tech.deplant.jacki.binding.gql;

/**
 * Config voting setup;
 */
public record ConfigP11Filter(ConfigProposalSetupFilter critical_params,
    ConfigProposalSetupFilter normal_params, ConfigP11Filter OR) {
}
