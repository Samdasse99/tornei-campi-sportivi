package model;

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
}
