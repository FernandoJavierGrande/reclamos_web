package sistema.reclamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sistema.reclamos.entity.CategoriaReclamo;

@Repository
public interface ICategoriaReclamoRepository extends JpaRepository<CategoriaReclamo, Long> {
	
	@Query(value="select c from CategoriaReclamo c where c.nombre= :nombreCat")
	public List<CategoriaReclamo> recuperarCategoriaPorNombre(@Param("nombreCat")String nombre);
	
	@Query(value="select c from CategoriaReclamo c order by c.nombre ")
	public List<CategoriaReclamo> recuperarCategoriaAsc();
}
