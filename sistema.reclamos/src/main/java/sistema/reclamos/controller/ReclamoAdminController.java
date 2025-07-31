package sistema.reclamos.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sistema.reclamos.controller.forms.ReclamoForm;
import sistema.reclamos.controller.forms.ReclamoFormExt;
import sistema.reclamos.entity.CategoriaReclamo;
import sistema.reclamos.entity.Estado;
import sistema.reclamos.entity.Reclamo;
import sistema.reclamos.entity.Usuario;
import sistema.reclamos.service.EmailService;
import sistema.reclamos.service.EstadoService;
import sistema.reclamos.service.ICategoriaService;
import sistema.reclamos.service.IEstadoService;
import sistema.reclamos.service.IReclamosService;

@Controller
@RequestMapping(value = "admin/reclamos")
public class ReclamoAdminController {
	
	@Autowired
	IReclamosService reclamosService;
	
	@Autowired
	ICategoriaService categoriaService;
	
	@Autowired
	IEstadoService estadoService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/{id}/editar") 
	public String editarReclamo(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamosService.buscarReclamosPorId(id);
		
		List<CategoriaReclamo> categorias = categoriaService.getCategorias();
		List<Estado> 		   estados    = estadoService.findAll(); 
		
		
		ReclamoFormExt reclamoForm = new ReclamoFormExt();
		reclamoForm.setId(reclamo.getId());
		reclamoForm.setDescripcion(reclamo.getDescripcion());
		reclamoForm.setTitulo(reclamo.getTitulo());
		reclamoForm.setCalle(reclamo.getCalle());
		reclamoForm.setBarrio(reclamo.getBarrio());
		reclamoForm.setResolucion(reclamo.getResolucion());
		reclamoForm.setEstado(reclamo.getEstado());
		
		model.addAttribute("reclamoForm", reclamoForm);
		model.addAttribute("categorias",categorias);
		model.addAttribute("estados", estados);
		
		return "/reclamos/ver_reclamo"; 
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(Model model, @Valid ReclamoFormExt reclamoForm, BindingResult bindingResult) {
		
		
		Long idForm = reclamoForm.getId();
		Long idCategoria = Long.parseLong(reclamoForm.getCategoria());
		
		CategoriaReclamo categoria = new CategoriaReclamo();
		categoria = categoriaService.buscarCategoriaPorId(idCategoria);
		
		Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogueado") : null;
		Estado estado = estadoService.findById(reclamoForm.getEstado().getId());
		
		if (categoria!=null && usuario!=null && estado != null) {
		
		Reclamo reclamo = reclamosService.buscarReclamosPorId(idForm);
		reclamo.setTitulo(reclamoForm.getTitulo());
		reclamo.setDescripcion(reclamoForm.getDescripcion());
		reclamo.setCalle(reclamoForm.getCalle());
		reclamo.setBarrio(reclamoForm.getBarrio());
		reclamo.setCategoriaReclamo(categoria);
		reclamo.setEstado(estado);
		reclamo.setFechaModificacion(new Date());
		reclamo.setResolucion(reclamoForm.getResolucion());
		reclamosService.actualizarReclamo(reclamo);	
			  
		String destinatario = reclamo.getUsuario().getEmail();	
		String asunto = "El reclamo " + reclamo.getId() + " cambió de estado ";
		  
		emailService.enviarMail(destinatario, asunto, genCuerpoEmail(reclamo));
			  
		}
		return  "redirect:/reclamos/listar";
	}
	
	private String genCuerpoEmail(Reclamo reclamo) {
			
			return  "Hola "+ reclamo.getUsuario().getNombre()+ " \n"+
					"El reclamo "+reclamo.getTitulo()+". Número: " + reclamo.getId() + "\n" +
					"cambió al estado: '" + reclamo.getEstado().getNombre() + "'. En la fecha: "+reclamo.getFechaModificacion()+ "\n" +
					"Mensaje: " + reclamo.getResolucion() + "\n"+
					"Saludos."
			 ;
		}
}
