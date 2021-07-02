package Ecomerce.Ecomerce.controller;

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

import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {

		return ResponseEntity.ok(repositoryUsuario.findAll());

	};

	@GetMapping("/id/{id_usuario}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id_usuario) {

		return repositoryUsuario.findById(id_usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	};

	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Usuario>> getByEndereco(@PathVariable String endereco) {

		return ResponseEntity.ok(repositoryUsuario.findAllByEnderecoContainingIgnoreCase(endereco));

	};

	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));

	};

	@PutMapping
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) {

		return ResponseEntity.status(HttpStatus.OK).body(repositoryUsuario.save(usuario));

	};

	@DeleteMapping("/id_delete/{id_usuario}")
	public void deleteById(@PathVariable Long id_usuario) {

		repositoryUsuario.deleteById(id_usuario);

	};

}
