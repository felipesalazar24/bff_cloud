package cl.sanos_y_salvos.ms_base.api.service;

import cl.sanos_y_salvos.ms_base.api.client.KafkaClient;
import cl.sanos_y_salvos.ms_base.api.dto.TopicRequest;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final KafkaClient kafkaClient;

    public KafkaService(KafkaClient kafkaClient) {
        this.kafkaClient = kafkaClient;
    }

    public Object listTopics() {
        return kafkaClient.listTopics();
    }

    public String createTopic(TopicRequest request) {
        return kafkaClient.createTopic(request);
    }

    public void deleteTopic(String name) {
        kafkaClient.deleteTopic(name);
    }

    public Object listConsumerGroups() {
        return kafkaClient.listConsumerGroups();
    }
}