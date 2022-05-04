package com.famaco.farmaco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Faz o objeto virar uma table no BD
@Table(name = "tb_produto")
public class ProdutoModel {

	@Id
	// Equivalente ao auto_increment no mysql
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotBlank // que não deixa o espaço ser vazio com espaços p/exemplo
	public String texto;
	
	@NotBlank
	public Double valor;

	@Size(min = 5, max = 100, message = "Min 3 e max de 100")
	public String titulo;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return texto;
	}

	public void setDescricao(String descricao) {
		this.texto = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

}
