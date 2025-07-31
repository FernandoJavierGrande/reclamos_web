package sistema.reclamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.reclamos.entity.Reclamo;

import java.util.*;

@Repository
public interface IReclamoRepository extends JpaRepository<Reclamo, Long>{


	@Query(value="select r from Reclamo r where r.usuario.id = :idUsuario order by r.fechaAlta")
	public List<Reclamo> getReclamosPorUsuario(@Param("idUsuario") Long idUsuario);
	
} 
