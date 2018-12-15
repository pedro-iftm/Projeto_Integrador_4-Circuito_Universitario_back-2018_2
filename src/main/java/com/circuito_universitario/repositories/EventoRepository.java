package com.circuito_universitario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.circuito_universitario.domain.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
