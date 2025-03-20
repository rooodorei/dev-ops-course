package com.example.bwic_svc.controller;

import com.example.bwic_svc.Client;
import com.example.bwic_svc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable Integer id) {
        return clientService.getClient(id);
    }
}
