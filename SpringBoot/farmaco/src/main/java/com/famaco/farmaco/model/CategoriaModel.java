package com.famaco.farmaco.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_categoria")
	public class CategoriaModel {

	@Id
	// Equivalente ao auto_increment no mysql
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotBlank // que o espaço nao pode ser null
	public String descricao;

	// Um para muitos
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ProdutoModel> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<ProdutoModel> categoria) {
		this.categoria = categoria;
	}

}
