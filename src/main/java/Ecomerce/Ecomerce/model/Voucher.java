package Ecomerce.Ecomerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_voucher")
@Component
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_voucher;

	@NotEmpty(message = "empresaParceira não pode ser nulo e nem vazio")
	@Size(min = 3, max = 100)
	private String empresaParceira;

	@NotNull(message = "Pontos não pode ser nulo")
	private Long pontosNecessario;

	@NotEmpty(message = "descricaoVoucher não pode ser nulo e nem vazio")
	@Size(min = 8, max = 255)
	private String descricaoVoucher;

	@NotEmpty(message = "produto não pode ser nulo e nem vazio")
	@Size(min = 3, max = 255)
	private String produto;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "id_usuario", "senha", "vouchersEmpresa", "meusVouchers", "cpf", "meusPontos", "tipo",
			"data" })
	private Usuario empresaCriadora;

	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(name = "juncaoVU", joinColumns = @JoinColumn(name = "fk_voucher"), inverseJoinColumns = @JoinColumn(name = "fk_usuario"))
	@JsonIgnoreProperties({ "meusVouchers", "vouchersEmpresa", "id_usuario", "senha", "cpf", "tipo" })
	private List<Usuario> usuariosComVoucher = new ArrayList<>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Long getId_voucher() {
		return id_voucher;
	}

	public void setId_voucher(Long id_voucher) {
		this.id_voucher = id_voucher;
	}

	public String getEmpresaParceira() {
		return empresaParceira;
	}

	public void setEmpresaParceira(String empresaParceira) {
		this.empresaParceira = empresaParceira;
	}

	public Long getPontosNecessario() {
		return pontosNecessario;
	}

	public void setPontosNecessario(Long pontosNecessario) {
		this.pontosNecessario = pontosNecessario;
	}

	public String getDescricaoVoucher() {
		return descricaoVoucher;
	}

	public void setDescricaoVoucher(String descricaoVoucher) {
		this.descricaoVoucher = descricaoVoucher;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Usuario getEmpresaCriadora() {
		return empresaCriadora;
	}

	public void setEmpresaCriadora(Usuario empresaCriadora) {
		this.empresaCriadora = empresaCriadora;
	}

	public List<Usuario> getUsuariosComVoucher() {
		return usuariosComVoucher;
	}

	public void setUsuariosComVoucher(List<Usuario> usuariosComVoucher) {
		this.usuariosComVoucher = usuariosComVoucher;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
