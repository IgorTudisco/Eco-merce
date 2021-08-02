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

import Ecomerce.Ecomerce.dto.UsuarioCadastroDTO;
import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.model.Voucher;
import Ecomerce.Ecomerce.repository.UsuarioRepository;
import Ecomerce.Ecomerce.service.UsuarioCadastroService;
import Ecomerce.Ecomerce.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Autowired
	private UsuarioService serviceUsuario;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {

		return ResponseEntity.ok(repositoryUsuario.findAll());

	};

	@GetMapping("/id/{id_usuario}")
	public ResponseEntity<Usuario> getById(@Valid @PathVariable Long id_usuario) {

		return repositoryUsuario.findById(id_usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	};

	@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<Usuario>> getByEndereco(@Valid @PathVariable String endereco) {

		return ResponseEntity.ok(repositoryUsuario.findAllByEnderecoContainingIgnoreCase(endereco));

	};

	@GetMapping("/email/{email}")
	public ResponseEntity<List<Usuario>> getByEmail(@Valid @PathVariable String email) {
		return ResponseEntity.ok(repositoryUsuario.findAllByEmail(email));
	};

//	@PostMapping
//	public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {
//
//		serviceUsuario.pontosCortesia(usuario);
//		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
//
//	};

//	/**
//	 * Rota de atualização de usuário
//	 * @param usuario
//	 * @return usuário atualizado.
//	 */
//	@PutMapping
//	public ResponseEntity<Usuario> putUsuario(@Valid @RequestBody Usuario usuario) {
//		return ResponseEntity.status(HttpStatus.OK).body(repositoryUsuario.save(usuario));
//
//	};
	
	
	
	/**
	 * Rota de atualização de usuário e cripto de senha
	 * @param usuario
	 * @return usuário atualizado.
	 */
	@PutMapping("/mudar")
	public ResponseEntity<Object> autentication(@Valid @RequestBody Usuario usuarioCadastro) {
		return ResponseEntity.status(HttpStatus.OK).body(serviceUsuario.mudarUsuario(usuarioCadastro));
	}
	
	
	

	@DeleteMapping("/id_delete/{id_usuario}")
	public void deleteById(@Valid @PathVariable Long id_usuario) {

		repositoryUsuario.deleteById(id_usuario);

	};

	@PostMapping("/empresa/{id_empresa}/criar")
	public ResponseEntity<Voucher> criarVoucher(@Valid @PathVariable(value = "id_empresa") Long idEmpresa,
			@Valid @RequestBody Voucher novoVoucher) {
		return serviceUsuario.criarVoucher(idEmpresa, novoVoucher)
				.map(voucherCriado -> ResponseEntity.status(201).body(voucherCriado))
				.orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping("/cliente/{id_cliente}/cooperativa/{id_cooperativa}/valor/{long_valor}")
	public ResponseEntity<Usuario> adcionarPontuacao(@Valid @PathVariable(value = "id_cliente") Long idCliente,
			@Valid @PathVariable(value = "id_cooperativa") Long idCooperativa,
			@Valid @PathVariable(value = "long_valor") Long valor) {
		return serviceUsuario.adicionarPontos(idCliente, idCooperativa, valor)
				.map(usuarioPontuado -> ResponseEntity.ok(usuarioPontuado)).orElse(ResponseEntity.badRequest().build());
	}

	/*
	 * @PutMapping("/usuario/{id_usuario}/voucher/{id_voucher}") public
	 * ResponseEntity<Usuario> batatinhas(@PathVariable Long
	 * id_usuario, @PathVariable Long id_voucher) {
	 * 
	 * Optional<Usuario> voucherCriado = serviceUsuario.juncao(id_usuario,
	 * id_voucher);
	 * 
	 * if (voucherCriado.isEmpty()) {
	 * 
	 * return ResponseEntity.badRequest().build();
	 * 
	 * } else {
	 * 
	 * return ResponseEntity.ok(voucherCriado.get());
	 * 
	 * }
	 * 
	 * };
	 */

}
