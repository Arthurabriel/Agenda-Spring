package com.example.agendaspring.domain.repository;

import com.example.agendaspring.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Long, Paciente> {
}
