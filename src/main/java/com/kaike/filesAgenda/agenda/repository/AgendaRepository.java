package com.kaike.filesAgenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaike.filesAgenda.agenda.domain.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    
}
