package com.example.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DealKeyValueMessage {
    public final String dealIdx;
    public final String createdTimestamp;
    public final String modifiedTimestamp;
    public final String lifecycleStatus;
    public final String brand;
    public final String channel;

    @JsonCreator
    public DealKeyValueMessage(
            @JsonProperty("dealIdx") String dealIdx,
            @JsonProperty("createdTimestamp") String createdTimestamp,
            @JsonProperty("modifiedTimestamp") String modifiedTimestamp,
            @JsonProperty("lifecycleStatus") String lifecycleStatus,
            @JsonProperty("brand") String brand,
            @JsonProperty("channel") String channel) {
        this.dealIdx = dealIdx;
        this.createdTimestamp = createdTimestamp;
        this.modifiedTimestamp = modifiedTimestamp;
        this.lifecycleStatus = lifecycleStatus;
        this.brand = brand;
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "DealKeyValueMessage{" +
                "dealIdx=" + dealIdx +
                "createdTimestamp=" + createdTimestamp +
                "modifiedTimestamp=" + modifiedTimestamp +
                "lifecycleStatus=" + lifecycleStatus +
                "brand=" + brand +
                "channel=" + channel +
                '}';
    }
}