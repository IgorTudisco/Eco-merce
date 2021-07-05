package Ecomerce.Ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.Ecomerce.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {

	public List<Voucher> findAllByDescricaoVoucherContainingIgnoreCase(String descricaoVoucher);

	public List<Voucher> findAllByEmpresaParceiraContainingIgnoreCase(String empresaParceira);
}
