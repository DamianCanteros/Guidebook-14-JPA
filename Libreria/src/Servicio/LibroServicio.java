
package Servicio;

import Entidad.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Damian
 */

public class LibroServicio {
    
    AutorServicio as = new AutorServicio();
    EditorialServicio es = new EditorialServicio();
    Scanner read = new Scanner(System.in);
    List<Libro> libros = new ArrayList();
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU")
            .createEntityManager();
            
    public void crearLibro(){
        
        System.out.println("ingrese el ISBN");
        Long isbn = read.nextLong();
        try{
            if (buscarIsbn(isbn) == null) {
                System.out.println("ingrese el titulo");
                System.out.println("ingrese el año");
                System.out.println("ingrese el total ejemplares");
                System.out.println("ingrese la cantidad ejemplares prestados");
                System.out.println("ingrese la cantidad ejemplares restantes");
                System.out.println("ingrese el id del autor");
                System.out.println("ingrese el id de la editorial");
                Libro l = new Libro(isbn, read.next(), read.nextInt(), read.nextInt(), read.nextInt(), 
                read.nextInt(), true, as.buscarId(read.nextInt()), es.buscarId(read.nextInt()));
                em.getTransaction().begin();
                em.persist(l);
                em.getTransaction().commit();
                System.out.println("Libro cargado con exito");
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public void modificarLibro(){
            
        System.out.println("ingrese el ISBN del libro a modificar");
        Libro l = buscarIsbn(read.nextLong());
        try{
            if (l != null) {
                System.out.println("ingrese la cantidad ejemplares prestados");
                l.setEjemplaresPrestados(read.nextInt());
                l.setEjemplaresRestantes(l.getEjemplares() - l.getEjemplaresPrestados());
                em.getTransaction().begin();
                em.merge(l);
                em.getTransaction().commit();
                System.out.println("Modificacion exitosa");
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public void borrarLibro(){
            
        System.out.println("ingrese el ISBN del libro a borrar");
        Libro l = buscarIsbn(read.nextLong());
        try{
            if (l != null) {
                em.getTransaction().begin();
                em.remove(l);
                em.getTransaction().commit();
                System.out.println("Libro borrado con exito");
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public Libro buscarIsbn(Long isbn){
            
        try{
            Libro l = new Libro();
            return l = em.find(Libro.class, isbn);       
        }catch(Exception e){
            throw e;
        }
    }

    public List buscarTitulo(String titulo){
            
        try{
            return libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo")
                    .setParameter("titulo",titulo).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public List buscarAutor(String autor){
            
        try{
            return libros = em.createQuery("SELECT l FROM Libro l JOIN Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre",autor).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public List buscarEditorial(String editorial){
            
        try{
            return libros = em.createQuery("SELECT l FROM Libro l JOIN Editorial e WHERE e.nombre LIKE :nombre")
                    .setParameter("nombre",editorial).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
}
