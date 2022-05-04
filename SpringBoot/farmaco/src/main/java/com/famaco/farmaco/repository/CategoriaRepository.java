package com.famaco.farmaco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.famaco.farmaco.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{
	public List<CategoriaModel> findAllByDescricaoIgnoreCase (String descricao);

}
