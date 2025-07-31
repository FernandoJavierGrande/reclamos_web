package sistema.reclamos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistema.reclamos.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
	Usuario findByEmailAndPassword(String email, String password);
    
	Optional<Usuario> findByEmail(String email);
}