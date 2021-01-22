package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Gruppo {

	private Integer idGruppo;
	
	private String nomeGruppo;
	
	@ManyToMany(mappedBy = "gruppi", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Giocatore> membri;
}
