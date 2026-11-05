package cl.sanos_y_salvos.ms_base.api.controller;

import cl.sanos_y_salvos.ms_base.api.dto.BindingRequest;
import cl.sanos_y_salvos.ms_base.api.dto.ExchangeRequest;
import cl.sanos_y_salvos.ms_base.api.dto.QueueRequest;
import cl.sanos_y_salvos.ms_base.api.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bff/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/queues")
    public ResponseEntity<String> createQueue(@RequestBody QueueRequest request) {
        String response = adminService.createQueue(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/queues/{name}")
    public ResponseEntity<String> deleteQueue(@PathVariable String name) {
        adminService.deleteQueue(name);
        return ResponseEntity.ok("Cola eliminada desde el BFF: " + name);
    }

    @PostMapping("/exchanges")
    public ResponseEntity<String> createExchange(@RequestBody ExchangeRequest request) {
        String response = adminService.createExchange(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/exchanges/{name}")
    public ResponseEntity<String> deleteExchange(@PathVariable String name) {
        adminService.deleteExchange(name);
        return ResponseEntity.ok("Exchange eliminado desde el BFF: " + name);
    }

    @PostMapping("/bindings")
    public ResponseEntity<String> createBinding(@RequestBody BindingRequest request) {
        String response = adminService.createBinding(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}