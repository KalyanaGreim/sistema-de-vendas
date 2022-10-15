package com.github.KalyanaGreim.service;

import com.github.KalyanaGreim.model.Client;
import com.github.KalyanaGreim.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    //classe com todas as regras de negócio
    private ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    public void saveClient(Client client) {
        validClient(client);
        this.repository.persist(client);
    }

    public void validClient(Client client){
        // aplica validações
    }
}
