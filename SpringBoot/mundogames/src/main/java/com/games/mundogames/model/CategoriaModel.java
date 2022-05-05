package com.games.mundogames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity // Faz o objeto virar uma table no BD
	@Table(name = "tb_categoria") // Da o nome a tabela
	public class CategoriaModel {
	
	@Id 
	@GeneratedValue // Equivalente ao auto_increment no mysql
	public Long id;
	
	@NotBlank // que o espaço nao pode ser null
	public String descricao;
	
	// Um para muitos
	@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria") // Usado para nao mostrar a propriedade categoria
	private List<ProdutoModel> produto;

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

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	
	
	

}
