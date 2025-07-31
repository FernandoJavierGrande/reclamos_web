package sistema.reclamos.controller;

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
import sistema.reclamos.service.ICategoriaService;
import sistema.reclamos.service.IEstadoService;
import sistema.reclamos.service.IReclamosService;

@Controller
@RequestMapping(value = "/reclamos")
public class ReclamosController {

	@Autowired
	private IReclamosService reclamosService;
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IEstadoService estadoService;
	
	@RequestMapping(value = "/listar")
	public String listarReclamos(Model model) {
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
		
		List<Reclamo> reclamos = ("ADMIN".equals(usuario.getRol())) ? reclamosService.getReclamos(): reclamosService.getReclamosPorUsuario(usuario.getId());
		
		
		model.addAttribute("reclamos",reclamos);
		return "/reclamos/listar";
	}
	
	@RequestMapping(value = "/{id}")
	public String verReclamo(Model model, @PathVariable Long id) {
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
	
	@RequestMapping(value = "/borrar/{id}")
	public String borrarReclamo(Model model, @PathVariable Long id) {
		reclamosService.borrarReclamo(id);
		return "redirect:/reclamos/listar";
	}
	
	@RequestMapping("/nuevo")
	public String nuevo(Model model) {
		ReclamoForm reclamoForm = new ReclamoForm();
		List<CategoriaReclamo> categorias = categoriaService.getCategorias();
		model.addAttribute("categorias",categorias);
		model.addAttribute("reclamoForm", reclamoForm);
		return "/reclamos/nuevo_reclamo";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(Model model, @Valid ReclamoForm ReclamoForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			if(ReclamoForm.getId()== null) {
				return "redirect:/reclamos/nuevo";
			}
			else{
				String res = String.format("redirect:/reclamos/%s/editar", ReclamoForm.getId());
				return res;
			}
		}
		
		Long idForm = ReclamoForm.getId();
		Long idCategoria = Long.parseLong(ReclamoForm.getCategoria());
		
		CategoriaReclamo categoria = new CategoriaReclamo();
		categoria = categoriaService.buscarCategoriaPorId(idCategoria);
		
		Usuario usuario = (session != null) ? (Usuario) session.getAttribute("usuarioLogueado") : null;
		Estado estado = new Estado();
		estado.setId(1L);
		estado.setNombre("");
		
		if(categoria!=null && usuario!=null) {
		
			  if(idForm == null) { 
				  Reclamo reclamo = new Reclamo();
				  reclamo.setTitulo(ReclamoForm.getTitulo());
				  reclamo.setDescripcion(ReclamoForm.getDescripcion());
				  reclamo.setCategoriaReclamo(categoria);
				  reclamo.setUsuario(usuario);
				  reclamo.setCalle(ReclamoForm.getCalle());
				  reclamo.setBarrio(ReclamoForm.getBarrio());
				  reclamo.setEstado(estado);
				  reclamosService.AltaNuevoReclamo(reclamo);
			  } else { 
				  Reclamo reclamo = reclamosService.buscarReclamosPorId(idForm);
				  reclamo.setTitulo(ReclamoForm.getTitulo());
				  reclamo.setDescripcion(ReclamoForm.getDescripcion());
				  reclamo.setCategoriaReclamo(categoria);
				  reclamo.setUsuario(usuario);
				  reclamo.setCalle(ReclamoForm.getCalle());
				  reclamo.setBarrio(ReclamoForm.getBarrio());
				  reclamo.setEstado(estado);
				  reclamosService.actualizarReclamo(reclamo);
			  }
		}
		return  "redirect:/reclamos/listar";
	}
	
}
