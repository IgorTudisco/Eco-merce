package Ecomerce.Ecomerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecomerce.Ecomerce.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findAllByEnderecoContainingIgnoreCase(String endereco);

}
