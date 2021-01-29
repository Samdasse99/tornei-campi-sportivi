package it.itsrizzoli.ifts2021.springsportshub.model;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "idGruppo"
)
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

	public Integer getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(Integer idGruppo) {
		this.idGruppo = idGruppo;
	}

	public String getNomeGruppo() {
		return nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}

	public List<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	public Giocatore getCreatore() {
		return creatore;
	}

	public void setCreatore(Giocatore creatore) {
		this.creatore = creatore;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
}
