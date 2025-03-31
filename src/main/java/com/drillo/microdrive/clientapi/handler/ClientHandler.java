package com.drillo.microdrive.clientapi.handler;

import com.drillo.microdrive.clientapi.model.Client;
import com.drillo.microdrive.clientapi.model.Influencer;
import com.drillo.microdrive.clientapi.model.Program;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class ClientHandler {

    UUID testUUID1 = UUID.randomUUID();
    UUID testUUID2 = UUID.randomUUID();

    @QueryMapping
    public List<Client> clients() {
//        return Arrays.asList(new Client(testUUID1, "asdad"));
        return Arrays.asList(
                buildClient(testUUID1, "Walmart"), buildClient(testUUID2, "Denny's"));
    }

    @SchemaMapping
    public List<Program> programs(Client client) {
        return Arrays.asList(
                buildProgram("1", "Walmart Lake St.Louis Sale", false),
                buildProgram("2", "Denny's 5$ breakfast", true));
    }

    @SchemaMapping
    public List<Influencer> influencers(Program program) {
        if (Objects.equals(program.getId(), "1")) {
            return Arrays.asList(
                    buildInfluencer("1", "Theresa Webb", "New York", "18-24", 8.4F),
                    buildInfluencer("2", "Diane Russell", "Chicago", "25-34", 4.6F),
                    buildInfluencer("3", "Devon Lane", "Los Angeles", "45-59", 9.8F),
                    buildInfluencer("4", "Guy Hawkins", "Seattle", "35-44", 2.5F));
        } else return Arrays.asList(
                buildInfluencer("5", "Kathryn Murphy", "Orlando", "18-24", 5.1F),
                buildInfluencer("6", "Leslie Alexander", "San Fransisco", "60+", 6.9F),
                buildInfluencer("7", "Brooklyn Simmons", "New Mexico", "20-28", 7.5F),
                buildInfluencer("8", "Kristin Watson", "Washington DC", "25-34", 3.7F));

    }


    private Client buildClient(UUID clientId, String clientName) {
        return new Client(clientId, clientName);
    }

    private Program buildProgram(String programId, String programName, boolean isActive) {
        return new Program(programId, programName, isActive, null, null, 1000000L, 100000L);
    }

    private Influencer buildInfluencer(String influencerId, String influencerName, String location, String ageRange, Float engagementRate) {
        return new Influencer(influencerId, influencerName, location, ageRange, engagementRate);
    }
}
