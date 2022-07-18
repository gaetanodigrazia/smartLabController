package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the report database table.
 * 
 */
@Entity
@Table(name="report")
@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String sintesi;


	//bi-directional many-to-one association to Prestazione
	@ManyToOne
	@JoinColumn(name="prestazione")
	@JsonManagedReference("report")
	private Prestazione prestazione;
	
	//bi-directional many-to-one association to Cittadino
	@ManyToOne
	@JoinColumn(name="SSN", referencedColumnName="ssn", nullable=false)
	private Cittadino cittadino;

	//bi-directional many-to-one association to Cittadino
	@ManyToOne
	@JoinColumn(name="SSN_Medico", referencedColumnName="ssn", nullable=false)
	private Cittadino medico;

	//bi-directional many-to-one association to Prenotazione
	@ManyToOne
	@JoinColumn(name="codice_prenotazione", referencedColumnName="codice_prenotazione", nullable=false)
	private Prenotazione prenotazione;


	
	public Report() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSintesi() {
		return this.sintesi;
	}

	public void setSintesi(String sintesi) {
		this.sintesi = sintesi;
	}

	public Cittadino getCittadino() {
		return this.cittadino;
	}

	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}

	public Cittadino getMedico() {
		return this.medico;
	}

	public void setMedico(Cittadino medico) {
		this.medico = medico;
	}

	public Prenotazione getPrenotazione() {
		return this.prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
	

	public Prestazione getPrestazione() {
		return this.prestazione;
	}

	public void setPrestazione(Prestazione prestazione) {
		this.prestazione = prestazione;
	}


}