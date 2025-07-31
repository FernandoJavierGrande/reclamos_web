package sistema.reclamos.controller.forms;

import javax.validation.constraints.NotEmpty;

public class CategoriaForm {

	@NotEmpty(message="Ingrese el nombre de la categoría")
	private String Nombre;

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
}
