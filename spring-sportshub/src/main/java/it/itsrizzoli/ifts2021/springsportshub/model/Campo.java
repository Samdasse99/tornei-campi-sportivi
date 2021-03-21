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
public class Campo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCampo;
	
	@Column(nullable = false)
	private Boolean coperto;
	
	@Column(nullable = false)
	private Boolean spogliatoi;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private CentroSportivo centroSportivo;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Superficie superficie;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Sport> sports = new ArrayList<Sport>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "campo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Slot> slots = new ArrayList<Slot>();

	public void addSport(Sport s) {
		this.sports.add(s);
		s.getCampi().add(this);
	}
	
	public void removeSport(Sport s) {
		this.sports.remove(s);
		s.getCampi().remove(this);
	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public Boolean getCoperto() {
		return coperto;
	}

	public void setCoperto(Boolean coperto) {
		this.coperto = coperto;
	}

	public Boolean getSpogliatoi() {
		return spogliatoi;
	}

	public void setSpogliatoi(Boolean spogliatoi) {
		this.spogliatoi = spogliatoi;
	}

	public CentroSportivo getCentroSportivo() {
		return centroSportivo;
	}

	public void setCentroSportivo(CentroSportivo centroSportivo) {
		this.centroSportivo = centroSportivo;
	}

	public Superficie getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Superficie superficie) {
		this.superficie = superficie;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
}
