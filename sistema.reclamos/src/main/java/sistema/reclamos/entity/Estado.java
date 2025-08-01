package sistema.reclamos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	
    @Id
    private Long id; // No autogenerado es manual

    private String nombre;

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
}
