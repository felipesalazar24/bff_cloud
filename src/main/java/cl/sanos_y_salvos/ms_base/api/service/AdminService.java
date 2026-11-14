package cl.sanos_y_salvos.ms_base.api.service;

import cl.sanos_y_salvos.ms_base.api.client.AdminClient;
import cl.sanos_y_salvos.ms_base.api.dto.BindingRequest;
import cl.sanos_y_salvos.ms_base.api.dto.ExchangeRequest;
import cl.sanos_y_salvos.ms_base.api.dto.QueueRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminClient adminClient;

    public AdminService(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    public String createQueue(QueueRequest request) {
        return adminClient.createQueue(request);
    }

    public void deleteQueue(String name) {
        adminClient.deleteQueue(name);
    }

    public String createExchange(ExchangeRequest request) {
        return adminClient.createExchange(request);
    }

    public void deleteExchange(String name) {
        adminClient.deleteExchange(name);
    }

    public String createBinding(BindingRequest request) {
        return adminClient.createBinding(request);
    }
}