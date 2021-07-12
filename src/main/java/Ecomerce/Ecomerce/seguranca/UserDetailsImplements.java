package Ecomerce.Ecomerce.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Ecomerce.Ecomerce.model.UsuarioCadastro;

public class UserDetailsImplements implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	
	private String password;

	public UserDetailsImplements(UsuarioCadastro usuarioCadastro) {
		super();
		this.userEmail = usuarioCadastro.getEmail();
		this.password = usuarioCadastro.getSenha();
	}
	
	public UserDetailsImplements() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
