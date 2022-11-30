
package Servicio;

import Entidad.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Damian
 */
public class ClienteServicio {
    
    Scanner read = new Scanner(System.in);
    List<Cliente> clientes = new ArrayList();    
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    public void crearCliente(){
        System.out.println("ingrese el nombre del cliente a buscar");
        String nombre = read.next();      
        try{
            if (buscarNombre(nombre).isEmpty()) {
                System.out.println("ingrese el DNI");
                System.out.println("ingrese el apellido");
                System.out.println("ingrese el telefono");
                Cliente c = new Cliente(read.nextLong(), nombre, read.next(), read.next());
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
                System.out.println("Carga exitosa");
            }else
                System.out.println("El cliente ingresado ya existe");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void modificarCliente(){
            
        System.out.println("ingrese el Id del Cliente a modificar");
        Cliente c = buscarId(read.nextInt());
        try{
            if (c != null) {
                System.out.println("ingrese el nuevo telefono");
                c.setTelefono(read.next());
                em.getTransaction().begin();
                em.merge(c);
                em.getTransaction().commit();
                System.out.println("Modificacion exitosa");
            }else
                System.out.println("No se encontro el cliente");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void borrarCliente(){
            
        System.out.println("ingrese el Id del Cliente a borrar");
        Cliente c = buscarId(read.nextInt());
        try{
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
                System.out.println("Cliente borrado con exito");
            }else
                System.out.println("No se encontro el cliente");
        }catch(Exception e){
            throw e;
        }
    }
    
        public Cliente buscarId(int id){
            
        try{
            Cliente c = new Cliente();
            return c = em.find(Cliente.class, id);       
        }catch(Exception e){
            throw e;
        }
    }

    public List buscarNombre(String nombre){
      
        try{
            return clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre")
                    .setParameter("nombre",nombre).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void showquery(List<Cliente> clientes) throws Exception{
        System.out.println("\nCLIENTES");
        System.out.println("____________________________________________________________");
        System.out.printf("|%-3s|%-13s|%-13s|%-13s|%-13s|\n", "ID", "DNI", "NOMBRE", "APELLIDO", "TELEFONO", "");
        for (Cliente aux : clientes) {
            System.out.printf("|%-3s|%-13s|%-13s|%-13s|%-13s|\n",
                             aux.getId(), aux.getDocumento(), aux.getNombre(), aux.getApellido(), aux.getTelefono(), "");
        }
        System.out.println("____________________________________________________________");
    }  
}
