package Ecomerce.Ecomerce.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Ecomerce.Ecomerce.model.Usuario;
import Ecomerce.Ecomerce.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplement implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		Optional<Usuario> cadastro = usuarioRepository.findByEmail(userEmail);
		cadastro.orElseThrow(() -> new UsernameNotFoundException(userEmail + " not found."));
		return cadastro.map(UserDetailsImplements::new).get();
	}

}
