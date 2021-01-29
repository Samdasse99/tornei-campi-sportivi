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
		property = "idCampo"
)
public class Campo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCampo;
	
	@Column(nullable = false)
	private Boolean coperto;
	
	@Column(nullable = false)
	private Boolean spogliatoi;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private CentroSportivo centroSportivo;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Superficie superficie;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Sport> sports;
	
	@OneToMany(mappedBy = "campo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Slot> slots;

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
