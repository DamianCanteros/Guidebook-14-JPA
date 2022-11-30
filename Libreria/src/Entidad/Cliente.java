
package Entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Damian
 */
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long Documento;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente() {
    }

    public Cliente(Long Documento, String nombre, String apellido, String telefono) {
        this.Documento = Documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public Long getDocumento() {
        return Documento;
    }

    public void setDocumento(Long Documento) {
        if (Documento != null) {
            this.Documento = Documento;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {        
            this.nombre = nombre;
        }   
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido != null) {                
            this.apellido = apellido;
        }    
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null) {           
            this.telefono = telefono;
        }    
    }  
    
}
