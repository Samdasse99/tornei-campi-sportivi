package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
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
}
