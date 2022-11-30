
package Servicio;

import Entidad.Autor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Damian
 */
public class AutorServicio {
    
    Scanner read = new Scanner(System.in);
    List<Autor> autores = new ArrayList();    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    public void crearAutor(){
        
        System.out.println("ingrese el nombre");
        String nombre = read.next();
        try{
            if (buscarNombre(nombre).isEmpty()) {
                Autor a = new Autor(nombre,true);
                em.getTransaction().begin();
                em.persist(a);
                em.getTransaction().commit();
                System.out.println("Carga exitosa");
            }else
                System.out.println("El autor ingresado ya existe");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void modificarAutor(){
            
        System.out.println("ingrese el Id del Autor a modificar");
        Autor a = buscarId(read.nextInt());
        try{
            if (a != null) {
                System.out.println("ingrese el nuevo nombre");
                a.setNombre(read.next());
                em.getTransaction().begin();
                em.merge(a);
                em.getTransaction().commit();
                System.out.println("Modificacion exitosa");
            }else
                System.out.println("No se encontro el autor");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void borrarAutor(){
            
        System.out.println("ingrese el Id del Autor a borrar");
        Autor a = buscarId(read.nextInt());
        try{
            if (a != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
                System.out.println("Libro borrado con exito");
            }else
                System.out.println("No se encontro el autor");
        }catch(Exception e){
            throw e;
        }
    }
    
        public Autor buscarId(int id){
            
        try{
            Autor a = new Autor();
            return a = em.find(Autor.class, id);       
        }catch(Exception e){
            throw e;
        }
    }

    public List buscarNombre(String nombre){
        
        try{
            return autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre",nombre).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void showquery(List<Autor> autores) throws Exception{
        System.out.println("\nAUTORES");
        System.out.println("__________________________");
        System.out.printf("|%-3s|%-13s|%-7s|\n", "ID", "NOMBRE", "ALTA", "");
        for (Autor aux : autores) {
            System.out.printf("|%-3s|%-13s|%-7s|\n", aux.getId(), aux.getNombre(), "");
        }
        System.out.println("__________________________");
    } 
}
