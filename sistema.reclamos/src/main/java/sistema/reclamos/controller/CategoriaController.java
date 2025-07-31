package sistema.reclamos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sistema.reclamos.controller.forms.CategoriaForm;
import sistema.reclamos.entity.CategoriaReclamo;
import sistema.reclamos.service.ICategoriaService;

@Controller
@RequestMapping(value="admin/categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
	@RequestMapping(value="/nueva")
	public String NuevaCategoria(Model model) {
		CategoriaForm categoriaForm = new CategoriaForm();
		model.addAttribute("categoriaForm",categoriaForm);
		return "categoria/nueva_categoriaForm";
	}
	
	@RequestMapping(value="/guardar" , method=RequestMethod.POST)
	public String guardar(Model model,@Valid CategoriaForm categoriaForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/reclamos/nueva_categoriaForm";
		}
		String nombreCategoria= categoriaForm.getNombre().trim().toLowerCase();
		List<CategoriaReclamo> Listcategoria;
		Listcategoria = categoriaService.buscarCategoriaPorNombre(nombreCategoria);
		
		if(Listcategoria == null) {
			CategoriaReclamo categoria = new CategoriaReclamo();
			categoria.setNombre(nombreCategoria);
			categoriaService.nuevaCategoria(categoria);
		}
		
		return  "redirect:/reclamos/nuevo";
	}
	
	@RequestMapping("/listar")
	public String listarCategorias(Model model) {
	    List<CategoriaReclamo> categorias = categoriaService.getCategorias();
	    model.addAttribute("categorias", categorias);
	    return "categoria/listarCategorias";
	}
	
	@RequestMapping(value = "/borrar/{id}")
	public String borrarCategoria(Model model, @PathVariable Long id,RedirectAttributes redirectAttributes) {
		
		if (categoriaService.asociaReclamos(id)) {
	        redirectAttributes.addFlashAttribute("error", "No se puede eliminar la categoría porque tiene reclamos asociados.");
	        return "redirect:/admin/categoria/listar";
	    }
		
		categoriaService.borrarCategoria(id);
		redirectAttributes.addFlashAttribute("mensaje", "Categoría eliminada correctamente.");
		return "redirect:/admin/categoria/listar";
	}
	
	
}
