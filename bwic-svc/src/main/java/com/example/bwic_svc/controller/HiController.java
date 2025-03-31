package com.example.bwic_svc.controller;

import com.example.bwic_svc.Client;
import com.example.bwic_svc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
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

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        Map<String, String> result = new HashMap<>();
        if (username.equals("username") && password.equals("12345678")) {
            result.put("status", "success");
            return result;
        } else {
            result.put("status", "fail");
            return result;
        }
    }
}
