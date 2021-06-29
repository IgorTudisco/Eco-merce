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
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_usuario")
@Component
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;

	@NotEmpty
	@Size(min = 3, max = 100)
	private String nome;

	@NotEmpty
	@Size(min = 4, max = 100)
	private String email;

	@NotEmpty
	@Size(min = 8, max = 45)
	private String senha;

	@NotEmpty
	@Size(min = 10, max = 255)
	private String endereco;

	@NotEmpty
	@Size(min = 11, max = 11)
	private String CPF;

	@NotEmpty
	@Size(min = 3, max = 3)
	private int usuarioTipo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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
