package it.itsrizzoli.ifts2021.springsportshub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts2021.springsportshub.model.Gruppo;

public interface GruppoRepository extends JpaRepository<Gruppo, Integer> {

	List<Gruppo> findByGiocatoriEmail(String email);
	
	List<Gruppo> findByCreatoreEmail(String email);
}
