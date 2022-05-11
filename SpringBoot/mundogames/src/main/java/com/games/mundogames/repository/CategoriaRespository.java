package com.games.mundogames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.games.mundogames.model.CategoriaModel;

@Repository // informando para o spring que o CategoriaRepository é um repositorio
public interface CategoriaRespository extends JpaRepository<CategoriaModel, Long>{
	public List<CategoriaModel> findAllByDescricaoIgnoreCase (String descricao);
	// Select * tb_categoria where descricao like "%descricao%"
}
