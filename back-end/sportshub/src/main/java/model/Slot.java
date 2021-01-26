package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSlot;
	
	@Column(nullable = false)
	private Date dataOraInizio;
	
	@Column(nullable = false)
	private Date dataOraFine;
	
	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal prezzo;
	
	private Integer scontoPercent;
	
	@Column(nullable = false)
	private Boolean scontoRiscattato;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Campo campo;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Giocatore referente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Gruppo gruppo;
}
