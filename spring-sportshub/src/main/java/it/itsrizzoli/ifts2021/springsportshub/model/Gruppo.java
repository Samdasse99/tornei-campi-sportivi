package it.itsrizzoli.ifts2021.springsportshub.model;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToMany(mappedBy = "gruppo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Slot> slots = new ArrayList<Slot>();

	public void addGiocatore(Giocatore g) {
		this.giocatori.add(g);
		g.getGruppi().add(this);
	}
	
	public void removeGiocatore(Giocatore g) {
		this.giocatori.remove(g);
		g.getGruppi().remove(this);
	}
	
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
