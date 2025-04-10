package com.drillo.microdrive.clientapi.handler;

import com.drillo.microdrive.clientapi.domain.Client;
import com.drillo.microdrive.clientapi.domain.Influencer;
import com.drillo.microdrive.clientapi.domain.Program;
import com.drillo.microdrive.clientapi.service.ClientService;
import com.drillo.microdrive.clientapi.service.InfluencerService;
import com.drillo.microdrive.clientapi.service.ProgramService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class ClientHandler {

    private final ClientService clientService;
    private final ProgramService programService;
    private final InfluencerService influencerService;

    public ClientHandler(ClientService clientService, ProgramService programService, InfluencerService influencerService) {
        this.clientService = clientService;
        this.programService = programService;
        this.influencerService = influencerService;
    }

    @QueryMapping
    public List<Client> clients() {
        return clientService.getClients();
    }

    @QueryMapping
    public Client client(@Argument(name = "id") UUID clientId) {
        return clientService.getClient(clientId);
    }

    @SchemaMapping
    public List<Program> programs(Client client) {
        return programService.getProgramsByClient(client.getId());
    }

    @SchemaMapping
    public List<Influencer> influencers(Program program) {
        return influencerService.getInfluencersByProgram(program.getId());
    }

    @SchemaMapping
    public List<Influencer> influencers(Client client) {
        return influencerService.getInfluencersByClient(client.getId());
    }

}
