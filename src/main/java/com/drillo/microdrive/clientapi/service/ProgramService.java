package com.drillo.microdrive.clientapi.service;

import com.drillo.microdrive.clientapi.domain.Program;
import com.drillo.microdrive.clientapi.repository.ProgramRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getPrograms() {
        return programRepository.findAll();
    }

    public List<Program> getProgramsByClient(UUID clientId) {
        return programRepository.findAllByClients_Id(clientId);
    }

    public Program getProgram(Long programId) {
        return programRepository.findById(programId)
                .orElseThrow(() -> HttpClientErrorException.NotFound.create("Program not found", HttpStatus.NOT_FOUND,  null, null, null, null));
    }

    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

}
