package Ecomerce.Ecomerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Ecomerce.Ecomerce.dto.UsuarioCadastroDTO;
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
			usuario.get().getMeusVouchers().add(voucher.get());
			return Optional.ofNullable(repositoryUsuario.save(usuario.get()));
		}
		return Optional.empty();
	}

	/**
	 * Metodo que dá uma cortesia ao cliente.
	 * 
	 * @param pontos
	 * @since 1.0
	 * @author Grupo
	 */
	public void pontosCortesia(Usuario pontos) {

		long pontosValor = 10;
		pontos.setMeusPontos(pontosValor);

	};

	/**
	 * Metodo utilizado para Criar um Voucher
	 * 
	 * @param idEmpresa
	 * @param novoVoucher
	 * @return Optional com Voucher
	 * @since 1.0
	 * @author Grupo
	 */
	public Optional<Voucher> criarVoucher(Long idEmpresa, Voucher novoVoucher) {
		Optional<Usuario> empresa = repositoryUsuario.findById(idEmpresa);
		if (empresa.isPresent()) {
			novoVoucher.setEmpresaCriadora(empresa.get());
			return Optional.ofNullable(repositoryVoucher.save(novoVoucher));
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Metodo para Adcionar pontos ao Usuario Cliente
	 * 
	 * @param idCliente
	 * @param idCooperativa
	 * @param pontuacaoDada
	 * @return Optional com Usuario Cliente
	 * @since 1.0
	 * @author Grupo
	 */
	public Optional<Usuario> adicionarPontos(Long idCliente, Long idCooperativa, Long pontuacaoDada) {
		Optional<Usuario> cliente = repositoryUsuario.findById(idCliente);
		Optional<Usuario> cooperativa = repositoryUsuario.findById(idCooperativa);
		if (cliente.isPresent() && cooperativa.isPresent()) {
			Long valor = cliente.get().getMeusPontos() + pontuacaoDada;
			cliente.get().setMeusPontos(valor);
			return Optional.ofNullable(repositoryUsuario.save(cliente.get()));
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Metodo para adquirir Voucher
	 * 
	 * @param idCliente
	 * @param idVoucher
	 * @return Response Entity 200 com Vouchers
	 * @since 1.0
	 * @author Grupo
	 */
	public ResponseEntity<Object> adquirirVoucher(Long idCliente, Long idVoucher) {
		Optional<Usuario> cliente = repositoryUsuario.findById(idCliente);
		Optional<Voucher> voucher = repositoryVoucher.findById(idVoucher);

		if (cliente.isPresent() && voucher.isPresent()) {
			if (cliente.get().getMeusPontos() >= voucher.get().getPontosNecessario()) {
				Long valor = cliente.get().getMeusPontos() - voucher.get().getPontosNecessario();
				cliente.get().setMeusPontos(valor);
				Usuario novoCliente = repositoryUsuario.save(cliente.get());
				voucher.get().getUsuariosComVoucher().add(novoCliente);
				return ResponseEntity.ok(repositoryVoucher.save(voucher.get()));
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	public Optional<?> mudarUsuario(Usuario mudarUsuario) {

		return repositoryUsuario.findById(mudarUsuario.getId_usuario()).map(usuarioExistente -> {
			Optional<Usuario> usuarioExistente2 = repositoryUsuario.findByEmail(mudarUsuario.getEmail());

			if (usuarioExistente2.isPresent()) {
				return Optional.empty();
			} else {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String senhaCriptografada = encoder.encode(mudarUsuario.getSenha());

				usuarioExistente.setEmail(mudarUsuario.getEmail());
				usuarioExistente.setNome(mudarUsuario.getNome());
				usuarioExistente.setEndereco(mudarUsuario.getEndereco());
				usuarioExistente.setTipo(mudarUsuario.getTipo());
				usuarioExistente.setSenha(senhaCriptografada);

				return Optional.ofNullable(repositoryUsuario.save(usuarioExistente));
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	public void removerVoucherUsuario(Long idUsuario) {
		Optional<Usuario> cliente = repositoryUsuario.findById(idUsuario);

		List<Voucher> vouchers = cliente.get().getMeusVouchers();
		List<Voucher> result = vouchers.stream()
				.filter(voucher -> voucher.getUsuariosComVoucher().remove(cliente.get())).collect(Collectors.toList());
		repositoryVoucher.saveAll(result);

	}
}
