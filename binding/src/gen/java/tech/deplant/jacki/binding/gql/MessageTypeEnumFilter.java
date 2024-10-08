package tech.deplant.jacki.binding.gql;

import java.util.List;

public record MessageTypeEnumFilter(MessageTypeEnum eq, MessageTypeEnum ne, MessageTypeEnum gt,
    MessageTypeEnum lt, MessageTypeEnum ge, MessageTypeEnum le, List<MessageTypeEnum> in,
    List<MessageTypeEnum> notIn) {
}
