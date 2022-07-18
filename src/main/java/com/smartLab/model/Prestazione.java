package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the prestazione database table.
 * 
 */
@Entity
@Table(name="prestazione")
@NamedQuery(name="Prestazione.findAll", query="SELECT p FROM Prestazione p")
public class Prestazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private int costo;

	@Column(nullable=false)
	private int giacenza;

	@Column(nullable=false, length=255)
	private String nome;

	//bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy="prestazione")
	@JsonIgnore
	@JsonBackReference("booking_medical_service")
	private List<Prenotazione> prenotaziones;
	
	//bi-directional many-to-one association to Report
	@OneToMany(mappedBy="prestazione")
	@JsonIgnore
	@JsonBackReference("report")
	private List<Report> reports;
	
	public Prestazione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCosto() {
		return this.costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getGiacenza() {
		return this.giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setPrestazione(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setPrestazione(null);

		return prenotazione;
	}
	
	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

}