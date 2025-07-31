package sistema.reclamos.service;

import java.util.List;

import sistema.reclamos.entity.Estado;

public interface IEstadoService  {
	
	List<Estado> findAll(); 
	
	Estado findById(Long Id);
}
