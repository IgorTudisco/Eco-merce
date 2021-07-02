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
@Table(name = "tb_voucher")
@Component
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_voucher;

	@NotEmpty(message = "empresaParceira não pode ser nulo e nem vazio")
	@Size(min = 3, max = 100)
	private String empresaParceira;

	@NotEmpty(message = "desconto não pode ser nulo e nem vazio")
	private Long desconto;

	@NotEmpty(message = "descricaoVoucher não pode ser nulo e nem vazio")
	@Size(min = 8, max = 255)
	private String descricaoVoucher;

	@NotEmpty(message = "produto não pode ser nulo e nem vazio")
	@Size(min = 3, max = 255)
	private String produto;

	@NotEmpty(message = "id_usuario não pode ser nulo e nem vazio")
	private Long id_usuario;

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

	public Long getDesconto() {
		return desconto;
	}

	public void setDesconto(Long desconto) {
		this.desconto = desconto;
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

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
