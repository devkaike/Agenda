package com.kaike.filesAgenda.agenda.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kaike.filesAgenda.agenda.domain.Agenda;
import com.kaike.filesAgenda.agenda.repository.AgendaRepository;
import com.kaike.filesAgenda.email.domain.Email;
import com.kaike.filesAgenda.email.service.EmailService;
import com.kaike.filesAgenda.user.domain.User;
import com.kaike.filesAgenda.user.repository.UserRepository;
import com.kaike.filesAgenda.utils.dtos.ServiceResponseDTO;

@Service
public class AgendaService {

    private static final Logger logger = LoggerFactory.getLogger(AgendaService.class);

    private AgendaRepository agendaRepository;

    private final EmailService emailService;

    private UserRepository userRepository;

    public AgendaService(AgendaRepository agendaRepository, EmailService emailService, UserRepository userRepository) {
        this.agendaRepository = agendaRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    public ServiceResponseDTO createAgenda(Agenda agenda) {

        Optional<User> user = userRepository.findById(agenda.getUser().getId());
        try {
            agenda.setCreatedAt(LocalDateTime.now());
            agendaRepository.save(agenda);
            
            Email email = new Email(user.get().getEmail(), "Novo compromisso marcado", "Olá, " + user.get().getName() + " você tem um novo compromisso marcado para o dia " + agenda.getDate() + " às " + agenda.getHour() + "\n com o título " + agenda.getTitle());
            emailService.sendEmail(email);
            
            return new ServiceResponseDTO(201, "Agenda criada com sucesso");
        } catch (Exception e) {
            logger.error("Erro ao criar a agenda", e);
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
