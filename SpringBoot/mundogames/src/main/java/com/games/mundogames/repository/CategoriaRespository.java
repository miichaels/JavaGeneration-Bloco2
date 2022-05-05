package com.games.mundogames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.games.mundogames.model.CategoriaModel;


public interface CategoriaRespository extends JpaRepository<CategoriaModel, Long>{
	public List<CategoriaModel> findAllByDescricaoIgnoreCase (String descricao);
}
