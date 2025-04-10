package com.drillo.microdrive.clientapi.repository;

import com.drillo.microdrive.clientapi.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    List<Program> findAllByClients_Id(UUID clientId);
}
