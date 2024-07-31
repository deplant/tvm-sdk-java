package tech.deplant.jacki.binding.generator.reference;

public record RefType(String name,
                      String type,
                      String ref_name,
                      String summary,
                      String description) implements ApiType {
}
