package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the ruolo database table.
 * 
 */
@Entity
@Table(name="ruolo")
@NamedQuery(name="Ruolo.findAll", query="SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String nome;

	//bi-directional many-to-one association to Cittadino
	@OneToMany(mappedBy="ruolo")
	@JsonIgnore
	private List<Cittadino> cittadinos;

	public Ruolo() {
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

	public List<Cittadino> getCittadinos() {
		return this.cittadinos;
	}

	public void setCittadinos(List<Cittadino> cittadinos) {
		this.cittadinos = cittadinos;
	}

	public Cittadino addCittadino(Cittadino cittadino) {
		getCittadinos().add(cittadino);
		cittadino.setRuolo(this);

		return cittadino;
	}

	public Cittadino removeCittadino(Cittadino cittadino) {
		getCittadinos().remove(cittadino);
		cittadino.setRuolo(null);

		return cittadino;
	}

}