package com.smartLab.model;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the categoria_patologia database table.
 * 
 */
@Entity
@Table(name="categoria_patologia")
@NamedQuery(name="CategoriaPatologia.findAll", query="SELECT c FROM CategoriaPatologia c")
public class CategoriaPatologia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="ref_categoria", nullable=false)
	private Categoria categoria;

	//bi-directional many-to-one association to Patologia
	@ManyToOne
	@JoinColumn(name="ref_patologia", nullable=false)
	private Patologia patologia;

	public CategoriaPatologia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Patologia getPatologia() {
		return this.patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

}