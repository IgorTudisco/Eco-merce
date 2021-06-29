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
public class Voucher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_voucher;

	@NotEmpty
	@Size(min = 3, max = 100)
	private String empresaParceira;

	@NotEmpty
	private Long desconto;

	@NotEmpty
	@Size(min = 8, max = 255)
	private String descricaoVoucher;

	@NotEmpty
	@Size(min = 10, max = 255)
	private String produto;

	@NotEmpty
	private int id_usuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public int getId_voucher() {
		return id_voucher;
	}

	public void setId_voucher(int id_voucher) {
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

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
