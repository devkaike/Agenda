package com.kaike.filesAgenda.agenda.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kaike.filesAgenda.agenda.domain.Agenda;
import com.kaike.filesAgenda.agenda.repository.AgendaRepository;
import com.kaike.filesAgenda.utils.dtos.ServiceResponseDTO;

@Service
public class AgendaService {

    private AgendaRepository agendaRepository;

    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public ServiceResponseDTO createAgenda(Agenda agenda) {
        try {
            agenda.setCreatedAt(LocalDateTime.now());
            agendaRepository.save(agenda);
            return new ServiceResponseDTO(201, "Agenda criada com sucesso");
        } catch (Exception e) {
            return new ServiceResponseDTO(500, "Ocorreu um erro ao criar a agenda");
        }
    }

    public ServiceResponseDTO listAgendas() {
        try {
            List<Agenda> agendas = agendaRepository.findAll();
            return new ServiceResponseDTO(200, agendas);
        } catch (Exception e) {
            return new ServiceResponseDTO(500, "Ocorreu um erro ao listar as agendas");
        }
    }
}
