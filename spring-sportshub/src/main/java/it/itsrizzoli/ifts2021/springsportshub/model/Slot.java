package it.itsrizzoli.ifts2021.springsportshub.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@JoinColumn(nullable = false)
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Campo campo;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Giocatore referente;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Gruppo gruppo;

	public Integer getIdSlot() {
		return idSlot;
	}

	public void setIdSlot(Integer idSlot) {
		this.idSlot = idSlot;
	}

	public Date getDataOraInizio() {
		return dataOraInizio;
	}

	public void setDataOraInizio(Date dataOraInizio) {
		this.dataOraInizio = dataOraInizio;
	}

	public Date getDataOraFine() {
		return dataOraFine;
	}

	public void setDataOraFine(Date dataOraFine) {
		this.dataOraFine = dataOraFine;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getScontoPercent() {
		return scontoPercent;
	}

	public void setScontoPercent(Integer scontoPercent) {
		this.scontoPercent = scontoPercent;
	}

	public Boolean getScontoRiscattato() {
		return scontoRiscattato;
	}

	public void setScontoRiscattato(Boolean scontoRiscattato) {
		this.scontoRiscattato = scontoRiscattato;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Giocatore getReferente() {
		return referente;
	}

	public void setReferente(Giocatore referente) {
		this.referente = referente;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}
}
