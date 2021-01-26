package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Gruppo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGruppo;
	
	@Column(length = 50, nullable = false)
	private String nomeGruppo;
	
	@ManyToMany(mappedBy = "gruppi", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Giocatore> giocatori;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Giocatore creatore;
	
	@OneToMany(mappedBy = "gruppo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Slot> slots;
}
