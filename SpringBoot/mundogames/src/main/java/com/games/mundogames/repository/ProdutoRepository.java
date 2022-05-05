package com.games.mundogames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.mundogames.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	public List<ProdutoModel> findAllByTituloIgnoreCase(String titulo); // Buscar todos pelo titulo da entidade 
}
