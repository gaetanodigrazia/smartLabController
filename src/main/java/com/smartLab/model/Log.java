package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log database table.
 * 
 */
@Entity
@Table(name="log")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;

	@Column(nullable=false, length=255)
	private String status;

	//bi-directional many-to-one association to Cittadino
	@ManyToOne
	@JoinColumn(name="ref_cittadino", nullable=false)
	private Cittadino cittadino;

	public Log() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cittadino getCittadino() {
		return this.cittadino;
	}

	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}

}