package cl.sanos_y_salvos.ms_base.api.client;

import cl.sanos_y_salvos.ms_base.api.dto.TopicRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KafkaClient {

    private final RestTemplate restTemplate;
    private final String topicsUrl;
    private final String consumerGroupsUrl;

    public KafkaClient(RestTemplate restTemplate, @Value("${endpoints.ms-kafka}") String msKafkaAdminUrl) {
        this.restTemplate = restTemplate;
        this.topicsUrl = msKafkaAdminUrl + "/api/kafka/topics";
        this.consumerGroupsUrl = msKafkaAdminUrl + "/api/kafka/consumer-groups";
    }

    public Object listTopics() {
        return restTemplate.getForObject(topicsUrl, Object.class);
    }

    public String createTopic(TopicRequest request) {
        return restTemplate.postForObject(topicsUrl, request, String.class);
    }

    public void deleteTopic(String name) {
        restTemplate.delete(topicsUrl + "/" + name);
    }

    // --- Consumer Groups ---
    public Object listConsumerGroups() {
        return restTemplate.getForObject(consumerGroupsUrl, Object.class);
    }
}
