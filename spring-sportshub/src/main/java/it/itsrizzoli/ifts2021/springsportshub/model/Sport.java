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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSport;
	
	@Column(length = 30, nullable = false)
	private String nomeSport;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "sports", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi = new ArrayList<Campo>();

	public void addCampo(Campo c) {
		this.campi.add(c);
		c.getSports().add(this);
	}
	
	public void removeCampo(Campo c) {
		this.campi.remove(c);
		c.getSports().remove(this);
	}
	
	public Integer getIdSport() {
		return idSport;
	}

	public void setIdSport(Integer idSport) {
		this.idSport = idSport;
	}

	public String getNomeSport() {
		return nomeSport;
	}

	public void setNomeSport(String nomeSport) {
		this.nomeSport = nomeSport;
	}

	public List<Campo> getCampi() {
		return campi;
	}

	public void setCampi(List<Campo> campi) {
		this.campi = campi;
	}
}
