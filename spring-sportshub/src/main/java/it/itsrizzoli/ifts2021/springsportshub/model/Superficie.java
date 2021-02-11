package it.itsrizzoli.ifts2021.springsportshub.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Superficie {

	@Id
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class, 
			property = "idSuperficie"
	)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSuperficie;
	
	@Column(length = 20, nullable = false)
	private String materiale;
	
	@OneToMany(mappedBy = "superficie", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi = new ArrayList<Campo>();

	public Integer getIdSuperficie() {
		return idSuperficie;
	}

	public void setIdSuperficie(Integer idSuperficie) {
		this.idSuperficie = idSuperficie;
	}

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}

	public List<Campo> getCampi() {
		return campi;
	}

	public void setCampi(List<Campo> campi) {
		this.campi = campi;
	}
}
