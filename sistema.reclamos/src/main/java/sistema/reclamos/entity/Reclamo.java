package sistema.reclamos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import java.util.Date;

@Entity
public class Reclamo {
	
	@Id
	@GeneratedValue
	Long Id;
	
	private String titulo;
	private String descripcion;
	private Date fechaAlta;
	private Date fechaModificacion;
	private String calle;
	private String barrio;
	private String resolucion;
	
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	@ManyToOne
	private CategoriaReclamo categoriaReclamo;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Estado estado;

	public CategoriaReclamo getCategoriaReclamo() {
		return categoriaReclamo;
	}
	public void setCategoriaReclamo(CategoriaReclamo categoriaReclamo) {
		this.categoriaReclamo = categoriaReclamo;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Long getId() {
		return Id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public Estado getEstado() {
	    return estado;
	}
	public void setEstado(Estado estado) {
	    this.estado = estado;
	}

}
