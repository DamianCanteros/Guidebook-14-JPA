
package Entidad;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Damian
 */
@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaPrestamo;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaDevolucion;
    @OneToOne
    private Libro libro;
    @OneToOne
    private Cliente cliente;

    public Prestamo() {
    }

    public Prestamo(Date fechaPrestamo, Libro libro, Cliente cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        if (fechaPrestamo != null) {    
            this.fechaPrestamo = fechaPrestamo;
        }
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        if (fechaDevolucion != null) {  
            this.fechaDevolucion = fechaDevolucion;
        }
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        if (libro != null) {  
            this.libro = libro;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {  
            this.cliente = cliente;
        }    
    }
    
}
