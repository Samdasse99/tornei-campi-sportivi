package it.itsrizzoli.ifts2021.springsportshub.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CentroSportivo {

	@Id
	@Column(length = 100)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String nomeCentro;
	
	@Column(length = 20, nullable = false)
	private String pIva;
	
	@Column(length = 20, nullable = false)
	private String numTelefono;
	
	@Column(length = 100, nullable = false)
	private String indirizzo;
	
	@Column(length = 40, nullable = false)
	private String citta;
	
	@Column(precision = 8, scale = 2)
	private BigDecimal soglia_coupon;
	
	@OneToMany(mappedBy = "centroSportivo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Campo> campi;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public String getpIva() {
		return pIva;
	}

	public void setpIva(String pIva) {
		this.pIva = pIva;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public BigDecimal getSoglia_coupon() {
		return soglia_coupon;
	}

	public void setSoglia_coupon(BigDecimal soglia_coupon) {
		this.soglia_coupon = soglia_coupon;
	}

	public List<Campo> getCampi() {
		return campi;
	}

	public void setCampi(List<Campo> campi) {
		this.campi = campi;
	}
}
