package it.itsrizzoli.ifts2021.springsportshub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "idSport"
)
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSport;
	
	@Column(length = 30, nullable = false)
	private String nomeSport;
	
	@ManyToMany(mappedBy = "sports", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi;

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
