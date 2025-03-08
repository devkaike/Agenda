package com.kaike.filesAgenda.agenda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaike.filesAgenda.agenda.domain.Agenda;
import com.kaike.filesAgenda.agenda.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    
    private AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAgenda(@RequestBody Agenda agenda) {
        var response = agendaService.createAgenda(agenda);
        return ResponseEntity.status(response.status()).body(response.message());
    }

    @GetMapping("/list")
    public ResponseEntity<?> listAgendas() {
        var response = agendaService.listAgendas();
        return ResponseEntity.status(response.status()).body(response.message());
    }
}
