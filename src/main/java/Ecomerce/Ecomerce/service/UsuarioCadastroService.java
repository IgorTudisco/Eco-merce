package Ecomerce.Ecomerce.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Ecomerce.Ecomerce.dto.UsuarioLoginDTO;
import Ecomerce.Ecomerce.dto.UsuarioCadastroDTO;
import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.repository.UsuarioRepository;

@Service
public class UsuarioCadastroService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Object> cadastrarUsuario(UsuarioCadastroDTO novoUsuarioCadastro) {

		return usuarioRepository.findByEmail(novoUsuarioCadastro.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Usuario novoUsuario = new Usuario(novoUsuarioCadastro);			
			String senhaCriptografada = encoder.encode(novoUsuarioCadastro.getSenha());
			novoUsuario.setSenha(senhaCriptografada);
			
			return Optional.ofNullable(usuarioRepository.save(novoUsuario));
		});

		/*
		 * return usuarioRepository.findByEmail(usuario.getEmail()).map(usuarioExistente
		 * -> { return Optional.empty(); }).orElseGet(() -> {
		 * 
		 * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		 * 
		 * String senhaCriptografada = encoder.encode(usuario.getSenha());
		 * 
		 * usuario.setSenha(senhaCriptografada);
		 * 
		 * return Optional.ofNullable(usuarioRepository.save(usuario));
		 * 
		 * });
		 */
	}

	public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> cadastro = usuarioRepository.findByEmail(user.get().getEmail());

		if (cadastro.isPresent()) {
			if (encoder.matches(user.get().getSenha(), cadastro.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				user.get().setToken(authHeader);
				user.get().setNome(cadastro.get().getNome());
				user.get().setTipo(cadastro.get().getTipo());

				return user;
			}
		}
		
		return Optional.empty(); // login errado. seViraFront().
	}
}
