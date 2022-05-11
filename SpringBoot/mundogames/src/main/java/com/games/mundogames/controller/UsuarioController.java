package com.games.mundogames.controller;

import java.util.List;
import java.util.Optional;

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

import com.games.mundogames.model.Usuario;
import com.games.mundogames.model.UsuarioLogin;
import com.games.mundogames.repository.UsuarioRepository;
import com.games.mundogames.service.UsuarioService;

	@RestController
	@RequestMapping("/usuarios") //Ponto de acesso
	@CrossOrigin("*") //Entrar independente do lugar (web,db)
	public class UsuarioController {

		//Transfere a responsabilidade de construir as consultas
		@Autowired
		private UsuarioService usuarioService;

		@Autowired
		private UsuarioRepository usuarioRepository;

		//Metodo para pegar tudo,pela mesma rota principal (/usuarios/all)
		@GetMapping("/all")
		public ResponseEntity<List<Usuario>> getAll() {

			return ResponseEntity.ok(usuarioRepository.findAll());

		}

		@PostMapping("/logar") //Logar 
		public ResponseEntity<UsuarioLogin> login(@RequestBody Optional<UsuarioLogin> user) {
			return usuarioService.autenticarUsuario(user).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		}

		@PostMapping("/cadastrar") //Cadastrar Usuarios
		public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {

			return usuarioService.cadastrarUsuario(usuario)
					.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
					.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
		}
		
		@PutMapping() //Atualizar Usuarios
		public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
			return usuarioService.atualizarUsuario(usuario)
					.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}

				
		@DeleteMapping("/{id}") //Deleta através do id
		public void delete (@PathVariable Long id) {
			usuarioRepository.deleteById(id);
		
		}
	
	
}
