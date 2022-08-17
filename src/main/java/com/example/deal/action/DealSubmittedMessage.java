package com.example.deal.action;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DealSubmittedMessage {
    public final String dealIdx;
    public final String modifiedTimestamp;
    public final String status;

    @JsonCreator
    public DealSubmittedMessage(
            @JsonProperty("dealIdx") String dealIdx,
            @JsonProperty("modifiedTimestamp") String modifiedTimestamp,
            @JsonProperty("status") String status) {
        this.dealIdx = dealIdx;
        this.modifiedTimestamp = modifiedTimestamp;
        this.status = status;
    }

    @Override
    public String toString() {
        return "DealKeyValueMessage{" +
                "dealIdx=" + dealIdx +
                "modifiedTimestamp=" + modifiedTimestamp +
                "status=" + status +
                '}';
    }
}