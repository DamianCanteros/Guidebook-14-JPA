
package Servicio;

import Entidad.Prestamo;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Damian
 */
public class PrestamoServicio {
    
    LibroServicio ls = new LibroServicio();
    ClienteServicio cs = new ClienteServicio();
    Scanner read = new Scanner(System.in);
    Prestamo p = new Prestamo();
    List<Prestamo> prestamos = new ArrayList();    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
    
    public void crearPrestamo() throws Exception{
        Date hoy = new Date();
        System.out.println("ingrese la fecha");
        String fechaP = read.next();
        System.out.println("ingrese el ISBN del libro");
        Long libro = read.nextLong();
        System.out.println("ingrese el id del cliente");
        int cliente = read.nextInt();
        boolean equals = true;
        Iterator<Prestamo> it = buscarPrestamo().iterator();
            while(it.hasNext() && equals){
                Prestamo aux = it.next();
                if (aux.getCliente().getId() == cliente && aux.getLibro().getIsbn().equals(libro)  && aux.getFechaPrestamo().equals(sdf.parse(fechaP))) {
                    equals = false;
                }
            }
        try{
            if (ls.buscarIsbn(libro).getEjemplaresRestantes()>0 && sdf.parse(fechaP).compareTo(hoy)>0 && equals) {
                ls.modificarLibro(libro, 1);
                p = new Prestamo(sdf.parse(fechaP), ls.buscarIsbn(libro), cs.buscarId(cliente));
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                System.out.println("Carga exitosa");
            }else if (equals == false) {
                System.out.println("Este prestamo ya fue realizado");
            }else
                System.out.println("No hay libros disponibles");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void modificarPrestamo() throws Exception{
            
        System.out.println("ingrese el nombre del cliente");
        String cliente = read.next();
        System.out.println("ingrese el titulo del libro");
        String libro = read.next();
        int id;
        boolean equals = true;
        Iterator<Prestamo> it = prestamos.iterator();
            while(it.hasNext() && equals){
                Prestamo aux = it.next();
                if (aux.getCliente().getNombre().equals(cliente ) && aux.getLibro().getTitulo().equals(libro)) {
                    p = aux;
                    equals = false;
                }
            }
        try{
            if (p != null && p.getLibro().getEjemplaresPrestados()>0) {
                ls.modificarLibro(p.getLibro().getIsbn(), -1);
                System.out.println("ingrese la fecha de devolucion");
                String fechaD = read.next();
                p.setFechaDevolucion(sdf.parse(fechaD));
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
                System.out.println("Modificacion exitosa");
            }else
                System.out.println("No se encontro el prestamo");
        }catch(Exception e){
            throw e;
        }
    }
    
    public void borrarPrestamo(){
            
        System.out.println("ingrese el Id del Prestamo a borrar");
        Prestamo p = buscarId(read.nextInt());
        try{
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
                System.out.println("Prestamo borrado con exito");
            }else
                System.out.println("No se encontro el prestamo");
        }catch(Exception e){
            throw e;
        }
    }
    
        public Prestamo buscarId(int id){
            
        try{
            Prestamo p = new Prestamo();
            return p = em.find(Prestamo.class, id);       
        }catch(Exception e){
            throw e;
        }
    }

    public List buscarCliente(String cliente){
            
        try{
            return prestamos = em.createQuery("SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.nombre LIKE :nombre")
                    .setParameter("nombre",cliente).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public List buscarLibro(String libro){
            
        try{
            return prestamos = em.createQuery("SELECT p FROM Prestamo p JOIN p.libro l WHERE l.titulo LIKE :titulo")
                    .setParameter("titulo",libro).getResultList();
        }catch(Exception e){
            throw e;
        }
    }    
    
    public List buscarFechaP(String fechaP){
            
        try{
            return prestamos = em.createQuery("SELECT p FROM Prestamo p WHERE p.fechaPrestamo LIKE :fechaPrestamo")
                    .setParameter("fechaPrestamo",fechaP).getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public List buscarPrestamo(){
            
        try{
            return prestamos = em.createQuery("SELECT p FROM Prestamo p ").getResultList();
        }catch(Exception e){
            throw e;
        }
    }
    
    public void showquery(List<Prestamo> prestamos) throws Exception{
        System.out.println("\nPRESTAMO");
        System.out.println("________________________________________________________");
        System.out.printf("|%-3s|%-13s|%-13s|%-13s|%-13s|\n", "ID", "PRESTAMO", "DEVOLUCION", "LIBRO", "CLIENTE", "");
        for (Prestamo aux : prestamos) {
            System.out.printf("|%-13s|%-7s|%-26s|%-13s|%-13s|%-13s|%-13s|\n",
                             aux.getId(), aux.getFechaPrestamo(), aux.getFechaDevolucion(), aux.getLibro().getTitulo(), aux.getCliente().getNombre(), "");
        }
        System.out.println("________________________________________________________");
    } 
}
