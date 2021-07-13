package Ecomerce.Ecomerce.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Ecomerce.Ecomerce.dto.UsuarioLoginDTO;
import Ecomerce.Ecomerce.model.UsuarioCadastro;
import Ecomerce.Ecomerce.repository.UsuarioCadastroRepository;

@Service
public class UsuarioCadastroService {

	@Autowired
	private UsuarioCadastroRepository cadastroUsuarioRepository;

	public Optional<Object> cadastrarUsuario(UsuarioCadastro novoUsuario) {

		return cadastroUsuarioRepository.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());

			novoUsuario.setSenha(senhaCriptografada);

			return Optional.ofNullable(cadastroUsuarioRepository.save(novoUsuario));

		}); 
	}

	public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioCadastro> cadastro = cadastroUsuarioRepository.findByEmail(user.get().getEmail());

		if (cadastro.isPresent()) {
			if (encoder.matches(user.get().getSenha(), cadastro.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);

				user.get().setToken(authHeader);
				user.get().setNome(cadastro.get().getNome());

				return user;
			}
		}

		return null;
	}
}
