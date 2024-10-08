package tech.deplant.jacki.binding.generator.reference;

public record BigIntType(String name,
                         String type,
                         String number_type,
                         Integer number_size,
                         String summary,
                         String description) implements ApiType {
}
