package Ecomerce.Ecomerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.Ecomerce.model.UsuarioCadastro;

@Repository
public interface UsuarioCadastroRepository extends JpaRepository<UsuarioCadastro, Long> {
	public Optional<UsuarioCadastro> findByEmail(String email);
}
