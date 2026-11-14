package cl.sanos_y_salvos.ms_base.api.client;

import cl.sanos_y_salvos.ms_base.api.dto.BindingRequest;
import cl.sanos_y_salvos.ms_base.api.dto.ExchangeRequest;
import cl.sanos_y_salvos.ms_base.api.dto.QueueRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AdminClient {
    
    private final RestTemplate restTemplate;
    
    private final String queuesUrl;
    private final String exchangesUrl;
    private final String bindingsUrl;

    public AdminClient(RestTemplate restTemplate, @Value("${endpoints.ms-admin}") String msAdminUrl) {
        this.restTemplate = restTemplate;
        this.queuesUrl = msAdminUrl + "/api/rabbit/queues";
        this.exchangesUrl = msAdminUrl + "/api/rabbit/exchanges";
        this.bindingsUrl = msAdminUrl + "/api/rabbit/bindings";
    }

    // --- Métodos de Colas (Queues) ---
    public String createQueue(QueueRequest request) {
        return restTemplate.postForObject(queuesUrl, request, String.class);
    }

    public void deleteQueue(String name) {
        restTemplate.delete(queuesUrl + "/" + name);
    }

    // --- Métodos de Exchanges ---
    public String createExchange(ExchangeRequest request) {
        return restTemplate.postForObject(exchangesUrl, request, String.class);
    }

    public void deleteExchange(String name) {
        restTemplate.delete(exchangesUrl + "/" + name);
    }

    // --- Métodos de Bindings ---
    public String createBinding(BindingRequest request) {
        return restTemplate.postForObject(bindingsUrl, request, String.class);
    }
}