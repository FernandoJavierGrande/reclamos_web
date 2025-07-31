package sistema.reclamos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistema.reclamos.entity.Usuario;
import sistema.reclamos.repository.IUsuarioRepository;
import sistema.reclamos.util.PasswordUtils;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
    private IUsuarioRepository usuarioRepository;
	
	@Override
	public Usuario BuscarUsuario(String email, String password) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		
		if(usuario.isPresent()) {
			Usuario user = usuario.get();
			
			if (PasswordUtils.verificar(password, user.getPassword())) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public Boolean findByEmail(String Email) {
		return usuarioRepository.findByEmail(Email).isPresent();
	}
	
	@Override
	public void grabar(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}


}
