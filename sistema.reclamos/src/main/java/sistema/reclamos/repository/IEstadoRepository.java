package sistema.reclamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.reclamos.entity.Estado;

public interface IEstadoRepository extends JpaRepository<Estado, Long>{

}
