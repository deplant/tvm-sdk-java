package tech.deplant.jacki.binding.gql;

import java.util.List;

/**
 * This type is unstable;
 */
public record BlockchainTransactionsConnection(List<BlockchainTransactionEdge> edges,
    PageInfo pageInfo) {
}
