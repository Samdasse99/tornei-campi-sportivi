package it.itsrizzoli.ifts2021.springsportshub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts2021.springsportshub.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Integer> {

	List<Sport> findByCampiCentroSportivoEmail(String email);
}
