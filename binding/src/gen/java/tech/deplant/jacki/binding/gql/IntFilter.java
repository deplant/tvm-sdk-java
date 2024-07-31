package tech.deplant.jacki.binding.gql;

import java.util.List;

public record IntFilter(Integer eq, Integer ne, Integer gt, Integer lt, Integer ge, Integer le,
    List<Integer> in, List<Integer> notIn) {
}
