package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@Table(name="turno")
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String prestazione;

	//bi-directional many-to-one association to Prenotazione
	@ManyToOne
	@JoinColumn(name="codice_prenotazione", nullable=false)
	private Prenotazione prenotazione;

	public Turno() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrestazione() {
		return this.prestazione;
	}

	public void setPrestazione(String prestazione) {
		this.prestazione = prestazione;
	}

	public Prenotazione getPrenotazione() {
		return this.prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

}