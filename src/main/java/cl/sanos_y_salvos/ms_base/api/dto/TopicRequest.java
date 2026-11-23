package cl.sanos_y_salvos.ms_base.api.dto;

public record TopicRequest(
    String name,
    int partitions,
    short replicationFactor
) {}