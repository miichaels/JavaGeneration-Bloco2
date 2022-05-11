package com.games.mundogames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Faz o objeto virar uma table no BD
@Table(name = "tb_produto") // Da o nome a tabela
public class ProdutoModel {
	
	@Id
	@GeneratedValue // Equivalente ao auto_increment no mysql
	public Long id;
	
	@NotBlank
	@Size(min = 5, max = 100, message = "Min 3 e max de 100")
	public String titulo;
	
	@NotNull
	public BigDecimal valor;
	
	@NotNull
	public BigDecimal peso;
	
	@NotNull
	public Long codigo;
	
	@ManyToOne
	@JsonIgnoreProperties
	private CategoriaModel categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	
	
	

}
