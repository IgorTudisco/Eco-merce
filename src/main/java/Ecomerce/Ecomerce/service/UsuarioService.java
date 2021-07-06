package Ecomerce.Ecomerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	 * Metodo para Adcionar pontos ao Usuario Normal
	 * 
	 * @param idNormal
	 * @param idCooperativa
	 * @param pontuacaoDada
	 * @return Optional com Usuario Normal
	 * @since 1.0
	 * @author Grupo
	 */
	public Optional<Usuario> adicionarPontos(Long idNormal, Long idCooperativa, Float pontuacaoDada) {
		Optional<Usuario> normal = repositoryUsuario.findById(idNormal);
		Optional<Usuario> cooperativa = repositoryUsuario.findById(idCooperativa);
		if (normal.isPresent() && cooperativa.isPresent()) {
			Float valor = normal.get().getMeusPontos() + pontuacaoDada;
			normal.get().setMeusPontos(valor);
			return Optional.ofNullable(repositoryUsuario.save(normal.get()));
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Metodo para adquirir Voucher
	 * 
	 * @param idNormal
	 * @param idVoucher
	 * @return Response Entity 200 com Vouchers
	 * @since 1.0
	 * @author Grupo
	 */
	public ResponseEntity<Object> adquirirVoucher(Long idNormal, Long idVoucher) {
		Optional<Usuario> normal = repositoryUsuario.findById(idNormal);
		Optional<Voucher> voucher = repositoryVoucher.findById(idVoucher);

		if (normal.isPresent() && voucher.isPresent()) {
			if (normal.get().getMeusPontos() >= voucher.get().getPontosNecessario()) {
				Float valor = normal.get().getMeusPontos() - voucher.get().getPontosNecessario();
				normal.get().setMeusPontos(valor);
				Usuario novoNormal = repositoryUsuario.save(normal.get());
				voucher.get().getUsuariosComVoucher().add(novoNormal);
				return ResponseEntity.ok(repositoryVoucher.save(voucher.get()));
			} else {
				return ResponseEntity.ok("Pontuação insuficiente");
			}
		} else {
			return ResponseEntity.ok("Usuario ou Vaucher não existe");
		}
	}
}
