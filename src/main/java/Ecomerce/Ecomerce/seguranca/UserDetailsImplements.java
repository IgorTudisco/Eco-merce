package Ecomerce.Ecomerce.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Ecomerce.Ecomerce.model.Usuario;

public class UserDetailsImplements implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	
	private String password;
	
	private List<GrantedAuthority> autoridades;

	public UserDetailsImplements(Usuario usuarioCadastro) {
		super();
		this.userEmail = usuarioCadastro.getNome();
		this.password = usuarioCadastro.getSenha();
		this.password = usuarioCadastro.getSenha();
		this.password = usuarioCadastro.getSenha();
		this.password = usuarioCadastro.getSenha();
	}
	
	public UserDetailsImplements() {
		super();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autoridades;
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
