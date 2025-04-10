package com.drillo.microdrive.clientapi.service;

import com.drillo.microdrive.clientapi.domain.Influencer;
import com.drillo.microdrive.clientapi.repository.InfluencerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Service
public class InfluencerService {

    private final InfluencerRepository influencerRepository;

    public InfluencerService(InfluencerRepository influencerRepository) {
        this.influencerRepository = influencerRepository;
    }

    public List<Influencer> getInfluencers() {
        return influencerRepository.findAll();
    }

    public List<Influencer> getInfluencersByClient(UUID clientId) {
        return influencerRepository.findAllByClients_Id(clientId);
    }

    public List<Influencer> getInfluencersByProgram(Long programId) {
        return influencerRepository.findAllByPrograms_Id(programId);
    }

    public Influencer getInfluencer(Long influencerId) {
        return influencerRepository.findById(influencerId)
                .orElseThrow(() -> HttpClientErrorException.NotFound.create("Influencer not found", HttpStatus.NOT_FOUND,  null, null, null, null));
    }

    public Influencer saveInfluencer(Influencer influencer) {
        return influencerRepository.save(influencer);
    }

}
