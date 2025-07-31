package sistema.reclamos.service;

import java.util.List;

import sistema.reclamos.entity.Reclamo;

public interface IReclamosService {

	Long AltaNuevoReclamo(Reclamo reclamo);

	List<Reclamo> getReclamos();

//	List<Reclamo> recuperarTodosLosReclamos(String titulo);
	
	List<Reclamo> getReclamosPorUsuario(Long idUsuario);

	Reclamo buscarReclamosPorId(Long id);

	void borrarReclamo(Long id);

	void actualizarReclamo(Reclamo reclamo);
	
	
	
}