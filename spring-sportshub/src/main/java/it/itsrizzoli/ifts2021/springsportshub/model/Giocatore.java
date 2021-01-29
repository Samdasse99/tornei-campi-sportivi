package it.itsrizzoli.ifts2021.springsportshub.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "email"
)
public class Giocatore {

	@Id
	@Column(length = 100)
	private String email;
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(nullable = false, length = 30)
	private String cognome;
	
	@Column(nullable = false, length = 20)
	private String numeroTelefono;
	
	@Column(length = 100)
	private String indirizzo;
	
	@Column(length = 40)
	private String citta;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Gruppo> gruppi;
	
	@OneToMany(mappedBy = "creatore", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Gruppo> gruppiCreati;
	
	@OneToMany(mappedBy = "referente", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Slot> slots;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
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

	public List<Gruppo> getGruppi() {
		return gruppi;
	}

	public void setGruppi(List<Gruppo> gruppi) {
		this.gruppi = gruppi;
	}

	public List<Gruppo> getGruppiCreati() {
		return gruppiCreati;
	}

	public void setGruppiCreati(List<Gruppo> gruppiCreati) {
		this.gruppiCreati = gruppiCreati;
	}

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
}
