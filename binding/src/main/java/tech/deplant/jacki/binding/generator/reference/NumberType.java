package tech.deplant.jacki.binding.generator.reference;

public record NumberType(String name,
                         String type,
                         String number_type,
                         Integer number_size,
                         String summary,
                         String description) implements ApiType {
}
