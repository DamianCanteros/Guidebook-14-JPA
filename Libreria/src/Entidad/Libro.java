
package Entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Damian
 */
@Entity
public class Libro {
    @Id
    private Long isbn;
    private String titulo;
    private Integer anio;
    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    @OneToOne
    private Autor autor;
    @OneToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAnio(anio);
        setEjemplares(ejemplares);
        setEjemplaresPrestados(ejemplaresPrestados);
        setEjemplaresRestantes(ejemplaresRestantes);
        setAlta(alta);
        setAutor(autor);
        setEditorial(editorial);
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        if (isbn != null) {
            this.isbn = isbn;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null) {
            this.titulo = titulo;
        }
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        if (anio != null) {
            this.anio = anio;
        }
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        if (ejemplares != null) {
            this.ejemplares = ejemplares;
        }
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        if (ejemplaresPrestados != null) {
            this.ejemplaresPrestados = ejemplaresPrestados;
        }
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        if (ejemplaresRestantes != null) {
            this.ejemplaresRestantes = ejemplaresRestantes;
        }
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        if (alta != null) {
            this.alta = alta;
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        if (autor != null) {
            this.autor = autor;
        }
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        if (editorial != null) {
            this.editorial = editorial;
        }
    }
              
    
}
