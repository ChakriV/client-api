package com.drillo.microdrive.clientapi.config;

import com.drillo.microdrive.clientapi.domain.Client;
import com.drillo.microdrive.clientapi.domain.Influencer;
import com.drillo.microdrive.clientapi.domain.Program;
import com.drillo.microdrive.clientapi.service.ClientService;
import com.drillo.microdrive.clientapi.service.InfluencerService;
import com.drillo.microdrive.clientapi.service.ProgramService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
@Profile("local")
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    private final ClientService clientService;
    private final ProgramService programService;
    private final InfluencerService influencerService;
    
    public Initializer(ClientService clientService, ProgramService programService, InfluencerService influencerService) {
        this.clientService = clientService;
        this.programService = programService;
        this.influencerService = influencerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Client client1 = clientService.getClientByName("Walmart").orElseGet( () -> clientService.saveClient(new Client("Walmart")));
        Client client2 = clientService.getClientByName("Denny's").orElseGet(() -> clientService.saveClient(new Client("Denny's")));

        Program program1 = programService.saveProgram(buildProgram(1L, "Walmart Lake St.Louis Sale", Collections.singletonList(client1)));
        Program program2 = programService.saveProgram(buildProgram(2L, "Denny's 5$ breakfast", Collections.singletonList(client2)));
        Program program3 = programService.saveProgram(buildProgram(3L, "Denny's BOGO pancakes", Collections.singletonList(client1)));

        influencerService.saveInfluencer(buildInfluencer(1L, "Theresa Webb", "New York", 1000000L, "18-24", 8.4F, 
                Collections.singletonList(program1), Collections.singletonList(client1)));
        influencerService.saveInfluencer(buildInfluencer(2L, "Diane Russell", "Chicago", 2000000L, "25-34", 4.6F,
                Collections.singletonList(program1), Collections.singletonList(client1)));
        influencerService.saveInfluencer(buildInfluencer(3L, "Devon Lane", "Los Angeles", 3000000L, "45-59", 9.8F,
                Collections.singletonList(program1), Collections.singletonList(client1)));
        influencerService.saveInfluencer(buildInfluencer(4L, "Guy Hawkins", "Seattle", 4000000L, "35-44", 2.5F,
                Collections.singletonList(program3), Collections.singletonList(client1)));
        influencerService.saveInfluencer(buildInfluencer(5L, "Kathryn Murphy", "Orlando", 5000000L, "18-24", 5.1F,
                Collections.singletonList(program3), Collections.singletonList(client1)));

        influencerService.saveInfluencer(buildInfluencer(6L, "Leslie Alexander", "San Fransisco", 6000000L, "60+", 6.9F,
                Collections.singletonList(program2), Collections.singletonList(client2)));
        influencerService.saveInfluencer(buildInfluencer(7L, "Brooklyn Simmons", "New Mexico", 7000000L, "20-28", 7.5F,
                Collections.singletonList(program2), Collections.singletonList(client2)));
        influencerService.saveInfluencer(buildInfluencer(8L, "Darlene Robertson", "Miami", 8000000L, "30-40", 3.2F,
                Collections.singletonList(program2), Collections.singletonList(client2)));
    }

    private Program buildProgram(Long programId, String programName, List<Client> clients) {
        return new Program(programId, programName,  null, null, 1000000L, 100000L, clients);
    }

    private Influencer buildInfluencer(Long influencerId, String influencerName, String location, Long followerCount, String ageRange, Float engagementRate, List<Program> programs, List<Client> clients) {
        return new Influencer(influencerId, influencerName, location, null, null, followerCount, ageRange, engagementRate, clients, programs);
    }
}