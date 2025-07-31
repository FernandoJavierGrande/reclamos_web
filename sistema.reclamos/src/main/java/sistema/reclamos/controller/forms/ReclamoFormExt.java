package sistema.reclamos.controller.forms;

import javax.validation.constraints.NotEmpty;
import sistema.reclamos.entity.Estado;

public class ReclamoFormExt {

	 	private Long Id;
		@NotEmpty(message ="Titulo es obligatorio")
		private String titulo;
		@NotEmpty(message ="Descripcion es obligatorio")
		private String descripcion;
		@NotEmpty(message="Seleccione una categoria")
		private String categoria;	
		@NotEmpty(message ="Calle es obligatorio")
		private String calle;
		@NotEmpty(message ="Barrio es obligatorio")
		private String barrio;
		
		//campos llenados por admin
		
		private Estado Estado;
		private String Detalle;
		private String resolucion;
		
		public String getResolucion() {
			return resolucion;
		}
		public void setResolucion(String resolucion) {
			this.resolucion = resolucion;
		}
		public Estado getEstado() {
			return Estado;
		}
		public void setEstado(Estado estado) {
			Estado = estado;
		}
		public String getDetalle() {
			return Detalle;
		}
		public void setDetalle(String detalle) {
			Detalle = detalle;
		}
		public String getCalle() {
			return calle;
		}
		public void setCalle(String calle) {
			this.calle = calle;
		}
		public String getBarrio() {
			return barrio;
		}
		public void setBarrio(String barrio) {
			this.barrio = barrio;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public Long getId() {
			return Id;
		}
		public void setId(Long Id) {
			this.Id = Id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
}

