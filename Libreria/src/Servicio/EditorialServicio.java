
package Servicio;

import Entidad.Editorial;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Damian
 */
public class EditorialServicio {
    
    
    Scanner read = new Scanner(System.in);
    List<Editorial> editoriales = new ArrayList();    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
       
    public void crearEditorial(){
        
        System.out.println("ingrese el nombre");
        String nombre = read.next();
        try{
            if (buscarNombre(nombre).isEmpty()) {
                Editorial e = new Editorial(nombre,true);
                em.getTransaction().begin();
                em.persist(e);
                em.getTransaction().commit();
                System.out.println("Carga exitosa");
            }else
                System.out.println("La editorial ingresada ya existe");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void modificarEditorial(){
            
        System.out.println("ingrese el Id de la Editorial a modificar");
        Editorial e = buscarId(read.nextInt());
        try{
            if (e != null) {
                System.out.println("ingrese el nuevo nombre");
                e.setNombre(read.next());
                em.getTransaction().begin();
                em.merge(e);
                em.getTransaction().commit();
                System.out.println("Modificacion exitosa");
            }else
                System.out.println("No se encontro la editorial");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void borrarEditorial(){
            
        System.out.println("ingrese el Id del Editorial a borrar");
        Editorial e = buscarId(read.nextInt());
        try{
            if (e != null) {
                em.getTransaction().begin();
                em.remove(e);
                em.getTransaction().commit();
                System.out.println("Libro borrado con exito");
            }else
                System.out.println("No se encontro la editorial");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Editorial buscarId(int id){
            
        try{
            Editorial e = new Editorial();
            return e = em.find(Editorial.class, id);       
        }catch(Exception e){
            throw e;
        }
    }

    public List buscarNombre(String nombre){
            
        try{
            return editoriales = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre")
                    .setParameter("nombre",nombre).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void showquery(List<Editorial> editoriales) throws Exception{
        System.out.println("\nEDITORIALES");
        System.out.println("__________________________");
        System.out.printf("|%-3s|%-13s|%-7s|\n", "ID", "NOMBRE", "ALTA", "");
        for (Editorial aux : editoriales) {
            System.out.printf("|%-3s|%-13s|%-7s|\n", aux.getId(), aux.getNombre(), "");
        }
        System.out.println("__________________________");
    } 
}
