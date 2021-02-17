package it.itsrizzoli.ifts2021.springsportshub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itsrizzoli.ifts2021.springsportshub.model.Slot;

public interface SlotRepository extends JpaRepository<Slot, Integer> {

	List<Slot> findByCampoIdCampo(Integer idCampo);
	
	List<Slot> findByGruppoIdGruppo(Integer idGruppo);
	
	List<Slot> findByReferenteEmail(String email);
}
