package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@JsonIgnoreProperties
@Table(name = "prenotazione")
@NamedQuery(name = "Prenotazione.findAll", query = "SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id")
	private int id;

	@Column(name = "codice_prenotazione", unique = true, nullable = false, length = 255)
	private String codicePrenotazione;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_esecuzione")
	private Date dataEsecuzione;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Berlin")
	@Column(name = "data_prenotazione", nullable = false)
	private Date dataPrenotazione;

	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Berlin")
	@Column(name = "data_richiesta")
	private Date dataRichiesta;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm:ss", timezone = "Europe/Berlin")
	@Column(name = "ora_prenotazione")
	private Date oraPrenotazione;

	@Column(nullable = false)
	private int status;

	// bi-directional many-to-one association to Cittadino
	@ManyToOne
	@JoinColumn(name = "ref_cittadino", nullable = false)
	private Cittadino cittadino;

	// bi-directional many-to-one association to Prestazione
	@ManyToOne
	@JoinColumn(name = "ref_prestazione", nullable = false)
	@JsonManagedReference("booking_medical_service")
	private Prestazione prestazione;

	// bi-directional many-to-one association to Report
	@OneToMany(mappedBy = "prenotazione")
	@JsonIgnore
	private List<Report> reports;

	// bi-directional many-to-one association to Turno
	@OneToMany(mappedBy = "prenotazione")
	@JsonIgnore
	private List<Turno> turnos;

	public Prenotazione() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodicePrenotazione() {
		return this.codicePrenotazione;
	}

	public void setCodicePrenotazione(String codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}

	public Date getDataEsecuzione() {
		return this.dataEsecuzione;
	}

	public void setDataEsecuzione(Date dataEsecuzione) {
		this.dataEsecuzione = dataEsecuzione;
	}

	public Date getDataPrenotazione() {
		return this.dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Date getDataRichiesta() {
		return this.dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Date getOraPrenotazione() {
		return this.oraPrenotazione;
	}

	public void setOraPrenotazione(Date oraPrenotazione) {
		this.oraPrenotazione = oraPrenotazione;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cittadino getCittadino() {
		return this.cittadino;
	}

	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}

	public Prestazione getPrestazione() {
		return this.prestazione;
	}

	public void setPrestazione(Prestazione prestazione) {
		this.prestazione = prestazione;
	}

	public List<Report> getReports() {
		return this.reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Report addReport(Report report) {
		getReports().add(report);
		report.setPrenotazione(this);

		return report;
	}

	public Report removeReport(Report report) {
		getReports().remove(report);
		report.setPrenotazione(null);

		return report;
	}

	public List<Turno> getTurnos() {
		return this.turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Turno addTurno(Turno turno) {
		getTurnos().add(turno);
		turno.setPrenotazione(this);

		return turno;
	}

	public Turno removeTurno(Turno turno) {
		getTurnos().remove(turno);
		turno.setPrenotazione(null);

		return turno;
	}

}