package Ecomerce.Ecomerce.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.Ecomerce.dto.UsuarioCadastroDTO;
import Ecomerce.Ecomerce.dto.UsuarioLoginDTO;
import Ecomerce.Ecomerce.service.UsuarioCadastroService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioCadastroDTOController {

	@Autowired
	private UsuarioCadastroService cadastroUsuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLoginDTO> autentication(@Valid @RequestBody Optional<UsuarioLoginDTO> login) {
		return cadastroUsuarioService.logar(login).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> autentication(@Valid @RequestBody UsuarioCadastroDTO usuarioCadastro) {
		return cadastroUsuarioService.cadastrarUsuario(usuarioCadastro)
				.map(usuarioCadastrado -> ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado))
				.orElse(ResponseEntity.status(HttpStatus.OK).body("Usuario Existente!"));
	}

}
