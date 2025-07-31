package sistema.reclamos.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaReclamo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "categoriaReclamo", cascade = CascadeType.ALL)
	private List<Reclamo> reclamos = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public List<Reclamo> getReclamos() {
	    return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
	    this.reclamos = reclamos;
	}
	
}
