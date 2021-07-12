package Ecomerce.Ecomerce.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Ecomerce.Ecomerce.model.UsuarioCadastro;
import Ecomerce.Ecomerce.repository.UsuarioCadastroRepository;

public class UserDetailsServiceImplement implements UserDetailsService{

	@Autowired
	private UsuarioCadastroRepository cadastroUsuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<UsuarioCadastro> cadastro = cadastroUsuarioRepository.findByEmail(userEmail);
		cadastro.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found."));
		return cadastro.map(UserDetailsImplements::new).get();
	}

}
