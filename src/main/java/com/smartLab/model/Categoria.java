package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@Table(name = "categoria")
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 255)
	private String nome;

	@Column(nullable = false)
	private int priorita;

	// bi-directional many-to-one association to CategoriaPatologia
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<CategoriaPatologia> categoriaPatologias;

	// bi-directional many-to-one association to Cittadino
	@OneToMany(mappedBy = "categoria")
	@JsonIgnore
	private List<Cittadino> cittadinos;

	public Categoria() {
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

	public int getPriorita() {
		return this.priorita;
	}

	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}

	public List<CategoriaPatologia> getCategoriaPatologias() {
		return this.categoriaPatologias;
	}

	public void setCategoriaPatologias(List<CategoriaPatologia> categoriaPatologias) {
		this.categoriaPatologias = categoriaPatologias;
	}

	public CategoriaPatologia addCategoriaPatologia(CategoriaPatologia categoriaPatologia) {
		getCategoriaPatologias().add(categoriaPatologia);
		categoriaPatologia.setCategoria(this);

		return categoriaPatologia;
	}

	public CategoriaPatologia removeCategoriaPatologia(CategoriaPatologia categoriaPatologia) {
		getCategoriaPatologias().remove(categoriaPatologia);
		categoriaPatologia.setCategoria(null);

		return categoriaPatologia;
	}

	public List<Cittadino> getCittadinos() {
		return this.cittadinos;
	}

	public void setCittadinos(List<Cittadino> cittadinos) {
		this.cittadinos = cittadinos;
	}

	public Cittadino addCittadino(Cittadino cittadino) {
		getCittadinos().add(cittadino);
		cittadino.setCategoria(this);

		return cittadino;
	}

	public Cittadino removeCittadino(Cittadino cittadino) {
		getCittadinos().remove(cittadino);
		cittadino.setCategoria(null);

		return cittadino;
	}

}