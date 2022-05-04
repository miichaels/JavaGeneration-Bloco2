package com.famaco.farmaco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.famaco.farmaco.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	public List<ProdutoModel> findAllByTituloIgnoreCase (String titulo); // Buscar todos pelo titulo da entidade


	
}
