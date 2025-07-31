package sistema.reclamos.controller.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import sistema.reclamos.entity.Reclamo;

public class ReclamoDTO {

	private Long Id;
	@NotEmpty(message="Titulo es obligatorio")
	@Length(min =15, max =100)
	private String titulo;
	@NotEmpty(message="Descripcion es obligatorio")
	private String descripcion;
	
	public ReclamoDTO() {}
	
	public ReclamoDTO(Reclamo reclamo) {
		this.Id = reclamo.getId();
		this.descripcion = reclamo.getDescripcion();
		this.titulo = reclamo.getTitulo();
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
