package it.itsrizzoli.ifts2021.springsportshub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts2021.springsportshub.model.Campo;

public interface CampoRepository extends JpaRepository<Campo, Integer> {

	List<Campo> findByCentroSportivoId(String email);
}
