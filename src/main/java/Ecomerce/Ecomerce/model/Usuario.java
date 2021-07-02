package Ecomerce.Ecomerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_usuario")
@Component
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@NotEmpty(message = "nome não pode ser nulo e nem vazio")
	@Size(min = 3, max = 100)
	private String nome;

	@NotEmpty(message = "email não pode ser nulo e nem vazio")
	@Size(min = 4, max = 100)
	private String email;

	@NotEmpty(message = "senha não pode ser nulo e nem vazio")
	@Size(min = 8, max = 45)
	private String senha;

	@NotEmpty(message = "endereco não pode ser nulo e nem vazio")
	@Size(min = 10, max = 255)
	private String endereco;

	@NotEmpty(message = "cpf não pode ser nulo e nem vazio (11)")
	@Size(min = 11, max = 11)
	private String cpf;

	@NotEmpty(message = "usuarioTipo não pode ser nulo e nem vazio (1,2,3)")
	@Size(min = 1, max = 1)
	private int usuarioTipo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

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

	public int getUsuarioTipo() {
		return usuarioTipo;
	}

	public void setUsuarioTipo(int usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
