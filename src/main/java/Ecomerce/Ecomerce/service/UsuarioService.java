package Ecomerce.Ecomerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.model.Voucher;
import Ecomerce.Ecomerce.repository.UsuarioRepository;
import Ecomerce.Ecomerce.repository.VoucherRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Autowired
	private VoucherRepository repositoryVoucher;

	// Salva um novo produto
	public Usuario novoUsuario(Usuario novoUsuario) {
		return repositoryUsuario.save(novoUsuario);
	}

	// Novo Item Categorisado
	public Optional<Usuario> juncao(Long idUsuario, Long idVoucher) {
		Optional<Voucher> voucher = repositoryVoucher.findById(idVoucher);
		Optional<Usuario> usuario = repositoryUsuario.findById(idUsuario);

		if (voucher.isPresent() && usuario.isPresent()) {
			usuario.get().getMeusVauchers().add(voucher.get());
			return Optional.ofNullable(repositoryUsuario.save(usuario.get()));
		}
		return Optional.empty();
	}
}
