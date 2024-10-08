package tech.deplant.jacki.binding.gql;

import java.util.List;

public record AccountStatusEnumFilter(AccountStatusEnum eq, AccountStatusEnum ne,
    AccountStatusEnum gt, AccountStatusEnum lt, AccountStatusEnum ge, AccountStatusEnum le,
    List<AccountStatusEnum> in, List<AccountStatusEnum> notIn) {
}
