package com.games.mundogames.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.mundogames.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
/**
 * Método que busca um usuário pelo seu usuario (e-mail). 
 * 
 * select * from tb_usuarios where usuario = "usuario procurado"
 * 
 * Quando não se sabe qual tipo de resposta pode ter ao buscar 
 * na requisição e tem mais de uma possível
 */

public Optional<Usuario> findByUsuario(String usuario);
}
//Método de Busca Específica necessário para a Spring Security