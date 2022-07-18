package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the possesso database table.
 * 
 */
@Entity
@Table(name="possesso")
@NamedQuery(name="Possesso.findAll", query="SELECT p FROM Possesso p")
public class Possesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Cittadino
	@ManyToOne
	@JoinColumn(name="ref_cittadino", nullable=false)
	private Cittadino cittadino;

	//bi-directional many-to-one association to Patologia
	@ManyToOne
	@JoinColumn(name="ref_patologia", nullable=false)
	private Patologia patologia;

	public Possesso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cittadino getCittadino() {
		return this.cittadino;
	}

	public void setCittadino(Cittadino cittadino) {
		this.cittadino = cittadino;
	}

	public Patologia getPatologia() {
		return this.patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

}