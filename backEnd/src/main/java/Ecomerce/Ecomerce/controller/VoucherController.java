package Ecomerce.Ecomerce.controller;

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

import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.model.Voucher;
import Ecomerce.Ecomerce.repository.UsuarioRepository;
import Ecomerce.Ecomerce.repository.VoucherRepository;
import Ecomerce.Ecomerce.service.UsuarioService;

@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VoucherController {

	@Autowired
	private VoucherRepository repositoryVoucher;

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Autowired
	private UsuarioService serviceUsuario;

	@GetMapping
	public ResponseEntity<List<Voucher>> getAll() {

		return ResponseEntity.ok(repositoryVoucher.findAll());

	};

	@GetMapping("/id/{id_voucher}")
	public ResponseEntity<Voucher> getById(@Valid @PathVariable Long id_voucher) {

		return repositoryVoucher.findById(id_voucher).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	};

	@GetMapping("/descricao/{descricaoVoucher}")
	public ResponseEntity<List<Voucher>> getByDescricao(@Valid @PathVariable String descricaoVoucher) {

		List<Voucher> lista = repositoryVoucher.findAllByDescricaoVoucherContainingIgnoreCase(descricaoVoucher);

		if (lista.isEmpty()) {

			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.ok(lista);

		}

	};

	@GetMapping("/empresaParceira/{empresaParceira}")
	public ResponseEntity<List<Voucher>> getByEmpresaParceira(@Valid @PathVariable String empresaParceira) {

		List<Voucher> lista = repositoryVoucher.findAllByEmpresaParceiraContainingIgnoreCase(empresaParceira);

		if (lista.isEmpty()) {

			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.ok(lista);

		}
	};

	@PostMapping
	public ResponseEntity<Voucher> postVoucher(@RequestBody Voucher voucher) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryVoucher.save(voucher));

	};

	@PutMapping
	public ResponseEntity<Voucher> putVoucher(@Valid @RequestBody Voucher voucher) {

		Optional<Usuario> objetoUsuario = repositoryUsuario.findById(voucher.getEmpresaCriadora().getId_usuario());
		Optional<Voucher> objetoVoucher = repositoryVoucher.findById(voucher.getId_voucher());
		if (objetoUsuario.isPresent() && objetoVoucher.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(repositoryVoucher.save(voucher));
		} else {
			return ResponseEntity.status(400).build();
		}
	};

	@DeleteMapping("/id_delete/{id_voucher}")
	public void deleteById(@Valid @PathVariable Long id_voucher) {

		repositoryVoucher.deleteById(id_voucher);

	};

	@PutMapping("/cliente/{id_cliente}/voucher/{id_voucher}")
	public ResponseEntity<Object> adquirirVoucher(@Valid @PathVariable(value = "id_cliente") Long idCliente,
			@Valid @PathVariable(value = "id_voucher") Long idVoucher) {
		return serviceUsuario.adquirirVoucher(idCliente, idVoucher);
	}

}
