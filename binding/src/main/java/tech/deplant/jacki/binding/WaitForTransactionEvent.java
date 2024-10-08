package tech.deplant.jacki.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WaitForTransactionEvent(String type, String message, Object error,
                                      @JsonProperty("shard_block_id") String shardBlockId,
                                      @JsonProperty("message_id") String messageId) implements ExternalEvent {
}
