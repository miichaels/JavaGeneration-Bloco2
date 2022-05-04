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

import com.famaco.farmaco.model.ProdutoModel;
import com.famaco.farmaco.repository.ProdutoRepository;

@RestController //Aqui é a class controller
@RequestMapping ("/produto") // tudo que tiver o (/...) é um endpoint
@CrossOrigin("*") // Para reconhecer o contato com o front-end 
public class ProdutoController {
	
	@Autowired 
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
		
		@GetMapping("/{id}")
		public ResponseEntity<ProdutoModel> GetById(@PathVariable long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
			
			@GetMapping("/titulo/{titulo}")
			public ResponseEntity<List<ProdutoModel>> GetByTitulo(@PathVariable String titulo){
				return ResponseEntity.ok(repository.findAllByTituloIgnoreCase(titulo));
				
			}
			
			@PostMapping
			public ResponseEntity<ProdutoModel> post (@Valid @RequestBody ProdutoModel produto){
				return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
				
			}
			
			@PutMapping
			public ResponseEntity<ProdutoModel> put (@Valid @RequestBody ProdutoModel produto){
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
				
			}
	
			@DeleteMapping("/{id}")
			public void delete(@PathVariable long id) {
				repository.deleteById(id);
			}
	

}
