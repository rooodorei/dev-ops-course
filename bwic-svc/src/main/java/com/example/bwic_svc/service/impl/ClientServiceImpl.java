package com.example.bwic_svc.service.impl;

import com.example.bwic_svc.Client;
import com.example.bwic_svc.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    /*static Map<Integer, Client> clients = new HashMap<>();
    static {
        clients.put(1, new Client(1, "Alice"));
    }*/
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Client getClient(Integer id) {
        ResponseEntity<Client> client = restTemplate.getForEntity("http://CLIENT-SVC/getClient/" + id, Client.class);
        return client.getBody();
    }
}
