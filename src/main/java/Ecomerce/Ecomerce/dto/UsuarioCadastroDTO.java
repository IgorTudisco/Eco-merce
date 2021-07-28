package Ecomerce.Ecomerce.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import Ecomerce.Ecomerce.model.util.TipoUsuario;

public class UsuarioCadastroDTO {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String senha;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String cpf;


	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
