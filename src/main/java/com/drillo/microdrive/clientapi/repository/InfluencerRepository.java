package com.drillo.microdrive.clientapi.repository;

import com.drillo.microdrive.clientapi.domain.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
     List<Influencer> findAllByClients_Id(UUID clientId);
     List<Influencer> findAllByPrograms_Id(Long programId);
     List<Influencer> findAllByClients_IdAndPrograms_Id(UUID clientId, Integer programId);
}

