package com.games.mundogames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
;
@Entity //Cria a tabela
@Table(name="tb_usuario") //Da o nome da tabela
public class Usuario {
	

		@Id // Definir a coluna de id como chave primaria
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Equivalente ao auto_increment no mysql
		private Long id;

		@NotBlank 
		/* A anotação @NotBlank indica que o atributo não deve ser nulo e/ou conter
	    espaços em branco */
		private String nome;

		@NotNull // A anotação indica que o atributo não deve ser nulo
		@Email(message = "O usuário deve ser um email valido ex:maria@email.com")
		private String usuario;

		@NotNull 
		private String senha;

		private String foto;

		// Métodos - Getter e Setters
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}

	
		
		
	
	
	}
	
		
