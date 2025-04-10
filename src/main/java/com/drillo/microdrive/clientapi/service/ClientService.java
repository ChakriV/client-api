package com.drillo.microdrive.clientapi.service;

import com.drillo.microdrive.clientapi.domain.Client;
import com.drillo.microdrive.clientapi.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(UUID clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> HttpClientErrorException.NotFound.create("Client not found", HttpStatus.NOT_FOUND,  null, null, null, null));
    }

    public Optional<Client> getClientByName(String clientName) {
        return clientRepository.findByName(clientName);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

}
