package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the patologia database table.
 * 
 */
@Entity
@Table(name="patologia")
@NamedQuery(name="Patologia.findAll", query="SELECT p FROM Patologia p")
public class Patologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String nome;

	//bi-directional many-to-one association to CategoriaPatologia
	@OneToMany(mappedBy="patologia")
	@JsonIgnore
	private List<CategoriaPatologia> categoriaPatologias;

	//bi-directional many-to-one association to Possesso
	@OneToMany(mappedBy="patologia")
	@JsonIgnore
	private List<Possesso> possessos;

	public Patologia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CategoriaPatologia> getCategoriaPatologias() {
		return this.categoriaPatologias;
	}

	public void setCategoriaPatologias(List<CategoriaPatologia> categoriaPatologias) {
		this.categoriaPatologias = categoriaPatologias;
	}

	public CategoriaPatologia addCategoriaPatologia(CategoriaPatologia categoriaPatologia) {
		getCategoriaPatologias().add(categoriaPatologia);
		categoriaPatologia.setPatologia(this);

		return categoriaPatologia;
	}

	public CategoriaPatologia removeCategoriaPatologia(CategoriaPatologia categoriaPatologia) {
		getCategoriaPatologias().remove(categoriaPatologia);
		categoriaPatologia.setPatologia(null);

		return categoriaPatologia;
	}

	public List<Possesso> getPossessos() {
		return this.possessos;
	}

	public void setPossessos(List<Possesso> possessos) {
		this.possessos = possessos;
	}

	public Possesso addPossesso(Possesso possesso) {
		getPossessos().add(possesso);
		possesso.setPatologia(this);

		return possesso;
	}

	public Possesso removePossesso(Possesso possesso) {
		getPossessos().remove(possesso);
		possesso.setPatologia(null);

		return possesso;
	}

}