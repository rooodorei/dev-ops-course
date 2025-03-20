package com.example.client_svc.controller;

import com.example.client_svc.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ClientController {
        static Map<Integer, Client> clients = new HashMap<>();
        static {
            clients.put(1, new Client(1, "Alice"));
            clients.put(2, new Client(2, "Bob"));
        }

    @GetMapping("/getClient/{id}")
    public Client getClient(@PathVariable Integer id) {
        return clients.get(id);
    }
}
