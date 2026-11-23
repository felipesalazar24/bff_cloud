package cl.sanos_y_salvos.ms_base.api.controller;

import cl.sanos_y_salvos.ms_base.api.dto.TopicRequest;
import cl.sanos_y_salvos.ms_base.api.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bff/web/kafka")
public class KafkaController {
    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("/topics")
    public ResponseEntity<Object> listTopics() {
        return ResponseEntity.ok(kafkaService.listTopics());
    }

    @PostMapping("/topics")
    public ResponseEntity<String> createTopic(@RequestBody TopicRequest request) {
        return ResponseEntity.ok(kafkaService.createTopic(request));
    }

    @DeleteMapping("/topics/{name}")
    public ResponseEntity<Void> deleteTopic(@PathVariable String name) {
        kafkaService.deleteTopic(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consumer-groups")
    public ResponseEntity<Object> listConsumerGroups() {
        return ResponseEntity.ok(kafkaService.listConsumerGroups());
    }
}
