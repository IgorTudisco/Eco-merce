package Ecomerce.Ecomerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Ecomerce.Ecomerce.dto.UsuarioCadastroDTO;
import Ecomerce.Ecomerce.model.util.TipoUsuario;

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
	@Size(min = 8)
	private String senha;

	@NotEmpty(message = "endereco não pode ser nulo e nem vazio")
	@Size(min = 10, max = 255)
	private String endereco;

	private Long meusPontos;

	@NotNull(message = "Necessario COOPERATIVA, CLIENTE ou EMPRESA")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	@OneToMany(mappedBy = "empresaCriadora")
	@JsonIgnoreProperties({ "id_voucher", "empresaCriadora" })
	private List<Voucher> vouchersEmpresa = new ArrayList<>();

	@ManyToMany(mappedBy = "usuariosComVoucher")
	@JsonIgnoreProperties({ "usuariosComVoucher" })
	private List<Voucher> meusVouchers = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Usuario() {
		super();
	}

	public Usuario(UsuarioCadastroDTO novoUsuario) {

		this.nome = novoUsuario.getNome();
		this.email = novoUsuario.getEmail();
		this.senha = novoUsuario.getSenha();
		this.endereco = novoUsuario.getEndereco();
		this.tipo = novoUsuario.getTipo();
	}

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

	public Long getMeusPontos() {
		return meusPontos;
	}

	public void setMeusPontos(Long meusPontos) {

		this.meusPontos = meusPontos;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public List<Voucher> getVouchersEmpresa() {
		return vouchersEmpresa;
	}

	public void setVouchersEmpresa(List<Voucher> vouchersEmpresa) {
		this.vouchersEmpresa = vouchersEmpresa;
	}

	public List<Voucher> getMeusVouchers() {
		return meusVouchers;
	}

	public void setMeusVouchers(List<Voucher> meusVouchers) {
		this.meusVouchers = meusVouchers;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
