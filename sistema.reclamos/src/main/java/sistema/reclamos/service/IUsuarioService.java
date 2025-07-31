package sistema.reclamos.service;
import sistema.reclamos.entity.Usuario;

public interface IUsuarioService {
	
	Usuario BuscarUsuario(String email, String password);	
	
	Boolean findByEmail(String Email);
	
	void grabar (Usuario usuario);
	
	String findEmailById(Long id);
}
