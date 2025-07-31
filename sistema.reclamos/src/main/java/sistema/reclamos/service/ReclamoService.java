package sistema.reclamos.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.reclamos.entity.Reclamo;
import sistema.reclamos.repository.IReclamoRepository;

@Service
@Transactional
public class ReclamoService implements IReclamosService {

	@Autowired
	private IReclamoRepository reclamoRepository; 
	
	@Override
	public List<Reclamo> getReclamosPorUsuario(Long idUsuario) {
		return reclamoRepository.getReclamosPorUsuario(idUsuario);
	}
	@Override
	public Long AltaNuevoReclamo(Reclamo reclamo) {
		reclamo.setFechaAlta(new Date());
		
		reclamoRepository.save(reclamo);
		return reclamo.getId();
	}
	
	@Override
	public List<Reclamo>getReclamos(){
		return reclamoRepository.findAll();
	}
	
	
	@Override
	public Reclamo buscarReclamosPorId(Long id) {
		
		Optional<Reclamo> optionalReclamo = reclamoRepository.findById(id);
		
		if(optionalReclamo.isPresent()) {
			return optionalReclamo.get();
		}
		else {
			return null;
		}
		
	}
	@Override
	public void borrarReclamo(Long id) {
		reclamoRepository.deleteById(id);
	}
	@Override
	public void actualizarReclamo(Reclamo reclamo) {
		reclamoRepository.save(reclamo);
	}
	
}
