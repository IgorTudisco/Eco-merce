package Ecomerce.Ecomerce.controller;

import java.util.List;

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

import Ecomerce.Ecomerce.model.Voucher;
import Ecomerce.Ecomerce.repository.VoucherRepository;

@RestController
@RequestMapping("/voucher")
@CrossOrigin("*")
public class VoucherController {

	@Autowired
	private VoucherRepository repositoryVoucher;

	@GetMapping
	public ResponseEntity<List<Voucher>> getAll() {

		return ResponseEntity.ok(repositoryVoucher.findAll());

	};

	@GetMapping("/id/{id_voucher}")
	public ResponseEntity<Voucher> getById(@PathVariable Long id_voucher) {

		return repositoryVoucher.findById(id_voucher).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	};

	@GetMapping("/descricao/{descricaoVoucher}")
	public ResponseEntity<List<Voucher>> getByDescricao(@PathVariable String descricaoVoucher) {

		return ResponseEntity.ok(repositoryVoucher.findAllByDescricaoVoucherContainingIgnoreCase(descricaoVoucher));

	};

	@PostMapping
	public ResponseEntity<Voucher> postVoucher(@RequestBody Voucher voucher) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryVoucher.save(voucher));

	};

	@PutMapping
	public ResponseEntity<Voucher> putVoucher(@RequestBody Voucher voucher) {

		return ResponseEntity.status(HttpStatus.OK).body(repositoryVoucher.save(voucher));

	};

	@DeleteMapping("/id_delete/{id_voucher}")
	public void deleteById(@PathVariable Long id_voucher) {

		repositoryVoucher.deleteById(id_voucher);

	};

}
