package sistema.reclamos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.reclamos.entity.CategoriaReclamo;
import sistema.reclamos.repository.ICategoriaReclamoRepository;

@Service
@Transactional
public class CategoriaService implements ICategoriaService {

	@Autowired
	private ICategoriaReclamoRepository categoriaReclamoRepo;
	
	@Override
	public List<CategoriaReclamo> getCategorias() {
		return (List<CategoriaReclamo>) categoriaReclamoRepo.findAll();
	}

	@Override
	public CategoriaReclamo buscarCategoriaPorId(Long id) {
		Optional<CategoriaReclamo> optCategoria = categoriaReclamoRepo.findById(id);
		
		if(optCategoria.isPresent()) {
			return optCategoria.get();
		}
		else {
			return null;
		}
	}
	@Override
	public Long nuevaCategoria(CategoriaReclamo categoriaReclamo) {
		categoriaReclamoRepo.save(categoriaReclamo);
		return categoriaReclamo.getId();
	}
	
	@Override
	public List<CategoriaReclamo> buscarCategoriaPorNombre(String nombre) {
		List<CategoriaReclamo> categorias = categoriaReclamoRepo.recuperarCategoriaPorNombre(nombre);
		
		if(categorias.size() > 0) {
			return categorias;
		}
		else {
			return null;
		}
	}
	
	@Override
	public void actualizarReclamo(CategoriaReclamo categoria) {
		categoriaReclamoRepo.save(categoria);
	}
	
	@Override
	public void borrarCategoria(Long id) {
		categoriaReclamoRepo.deleteById(id);
		
	}

	@Override
	public boolean asociaReclamos(Long idCategoria) {
		CategoriaReclamo categoria = categoriaReclamoRepo.findById(idCategoria).orElse(null);
	    if (categoria == null) return false;
	    
	    return !categoria.getReclamos().isEmpty();
	}
}
