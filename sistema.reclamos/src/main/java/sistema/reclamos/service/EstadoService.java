package sistema.reclamos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.reclamos.entity.Estado;
import sistema.reclamos.repository.IEstadoRepository;

@Service
public class EstadoService implements IEstadoService{
	
	@Autowired
	private IEstadoRepository estadoRepo;
	
	@Override
	public List<Estado> findAll() {
	
		return estadoRepo.findAll();
	}
	@Override
	public Estado findById(Long id) {
		return estadoRepo.findById(id).orElse(null);
	}
}
