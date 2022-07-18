package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the cittadino database table.
 * 
 */

@Entity
@Table(name = "cittadino")
@NamedQuery(name = "Cittadino.findAll", query = "SELECT c FROM Cittadino c")
public class Cittadino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private int cap;

	@Column(nullable = false)
	private int civico;

	@Column(nullable = false, length = 255)
	private String cognome;

	@Column(nullable = false, length = 255)
	private String comune;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date data_nascita;

	@Column(nullable = false, length = 255)
	private String email;

	@Column(nullable = false, length = 255)
	private String nome;

	@Column(length = 255)
	private String password;

	@Column(nullable = false, length = 255)
	private String provincia;

	@Column(unique = true, nullable = false, length = 255)
	private String ssn;

	@Column(nullable = false, length = 255)
	private String telefono;

	@Column(nullable = false, length = 255)
	private String via;

	// bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name = "ref_categoria", nullable = false)
	@JsonBackReference("category_reference")
	private Categoria categoria;

	// bi-directional many-to-one association to Ruolo
	@ManyToOne
	@JoinColumn(name = "ref_ruolo")
	@JsonBackReference("role_reference")
	private Ruolo ruolo;

	// bi-directional many-to-one association to Log
	@OneToMany(mappedBy = "cittadino")
	@JsonIgnore
	private List<Log> logs;

	// bi-directional many-to-one association to Possesso
	@OneToMany(mappedBy = "cittadino")
	@JsonIgnore
	private List<Possesso> possessos;

	// bi-directional many-to-one association to Prenotazione
	@OneToMany(mappedBy = "cittadino")
	@JsonIgnore
	@JsonBackReference("booking_medical_service")
	private List<Prenotazione> prenotaziones;

	// bi-directional many-to-one association to Report
	@OneToMany(mappedBy = "cittadino")
	@JsonIgnore
	private List<Report> reports1;

	// bi-directional many-to-one association to Report
	@OneToMany(mappedBy = "cittadino")
	@JsonIgnore
	private List<Report> reports2;

	/*
	 * Default blank constructor
	 */
	public Cittadino() {
	}

	/*
	 * Method that retrieve the id
	 * 
	 */
	public int getId() {
		return this.id;
	}

	/*
	 * Method that set the id
	 * 
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public int getCap() {
		return this.cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getCivico() {
		return this.civico;
	}

	public void setCivico(int civico) {
		this.civico = civico;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getComune() {
		return this.comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public Date getData_nascita() {
		return this.data_nascita;
	}

	public void setData_nascita(Date data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Ruolo getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public List<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public Log addLog(Log log) {
		getLogs().add(log);
		log.setCittadino(this);

		return log;
	}

	public Log removeLog(Log log) {
		getLogs().remove(log);
		log.setCittadino(null);

		return log;
	}

	public List<Possesso> getPossessos() {
		return this.possessos;
	}

	public void setPossessos(List<Possesso> possessos) {
		this.possessos = possessos;
	}

	public Possesso addPossesso(Possesso possesso) {
		getPossessos().add(possesso);
		possesso.setCittadino(this);

		return possesso;
	}

	public Possesso removePossesso(Possesso possesso) {
		getPossessos().remove(possesso);
		possesso.setCittadino(null);

		return possesso;
	}

	public List<Prenotazione> getPrenotaziones() {
		return this.prenotaziones;
	}

	public void setPrenotaziones(List<Prenotazione> prenotaziones) {
		this.prenotaziones = prenotaziones;
	}

	public Prenotazione addPrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().add(prenotazione);
		prenotazione.setCittadino(this);

		return prenotazione;
	}

	public Prenotazione removePrenotazione(Prenotazione prenotazione) {
		getPrenotaziones().remove(prenotazione);
		prenotazione.setCittadino(null);

		return prenotazione;
	}

	public List<Report> getReports1() {
		return this.reports1;
	}

	public void setReports1(List<Report> reports1) {
		this.reports1 = reports1;
	}

	public Report addReports1(Report reports1) {
		getReports1().add(reports1);
		reports1.setCittadino(this);

		return reports1;
	}

	public Report removeReports1(Report reports1) {
		getReports1().remove(reports1);
		reports1.setCittadino(null);

		return reports1;
	}

	public List<Report> getReports2() {
		return this.reports2;
	}

	public void setReports2(List<Report> reports2) {
		this.reports2 = reports2;
	}

	public Report addReports2(Report reports2) {
		getReports2().add(reports2);
		reports2.setMedico(this);
		return reports2;
	}

	public Report removeReports2(Report reports2) {
		getReports2().remove(reports2);
		reports2.setMedico(null);

		return reports2;
	}

}