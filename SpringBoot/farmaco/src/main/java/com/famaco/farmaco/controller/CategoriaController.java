package com.famaco.farmaco.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.famaco.farmaco.model.CategoriaModel;
import com.famaco.farmaco.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria") // ponto de acesso
@CrossOrigin("*") // Entrar independente do lugar (web,db)
public class CategoriaController {

	// Transfere a responsabilidade de construir as consultas
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<CategoriaModel>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByDescricaoIgnoreCase(nome));
	}
	
	@PostMapping
	/* @Valid: valida todas as regras definidas na model*/
	/*RequestBody: put e post*/
	public ResponseEntity<CategoriaModel> postCategoriaModel(@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	/* @Valid: valida todas as regras definidas na model*/
	/*RequestBody: put e post*/
	public ResponseEntity<CategoriaModel> put(@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}


