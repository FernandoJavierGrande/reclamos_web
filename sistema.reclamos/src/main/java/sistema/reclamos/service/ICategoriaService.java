package sistema.reclamos.service;

import java.util.List;

import sistema.reclamos.entity.CategoriaReclamo;

public interface ICategoriaService {

	List<CategoriaReclamo> getCategorias();
	
	CategoriaReclamo buscarCategoriaPorId(Long id);
	
	List<CategoriaReclamo> buscarCategoriaPorNombre(String nombre);
	
	Long nuevaCategoria(CategoriaReclamo categoriaReclamo);
	
	void borrarCategoria(Long id);
	
	void actualizarReclamo(CategoriaReclamo categoriaReclamo);
	
	boolean asociaReclamos(Long idCategoria);
}
