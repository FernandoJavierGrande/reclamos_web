package sistema.reclamos.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import sistema.reclamos.entity.Usuario;
import sistema.reclamos.service.IUsuarioService;
import sistema.reclamos.util.PasswordUtils;

@Controller
public class LoginController {


    @Autowired
    private IUsuarioService usuarioService;
	
    @GetMapping("/denegado")
	public String accesoDenegado() {
    	return "login/denegado";
	}
    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                 @RequestParam String password,
                                 HttpSession session, Model model) {

        Usuario usuario = usuarioService.BuscarUsuario(email, password);
        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/reclamos/listar";
        } else {
            model.addAttribute("error", "Email o contraseña inválidos");
            return "login/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/registro")
    public String mostrarFormRegistro() {
        return "/login/registro";
    }
    
    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombre,
                                    @RequestParam String email,
                                    @RequestParam String password,
                                    Model model) {

        if (usuarioService.findByEmail(email)) {
            model.addAttribute("error", "Ya existe un usuario con ese email");
            return "/login/registro";
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setPassword(PasswordUtils.encriptar(password));
        nuevoUsuario.setRol("CIUDADANO");

        usuarioService.grabar(nuevoUsuario);

        model.addAttribute("mensaje", "Usuario registrado correctamente. Inicie sesión."); //METER EN INICIAR SESION
        return "/login/login";
    }
}
