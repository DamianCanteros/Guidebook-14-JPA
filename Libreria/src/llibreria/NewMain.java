
package llibreria;

import Servicio.AutorServicio;
import Servicio.ClienteServicio;
import Servicio.EditorialServicio;
import Servicio.LibroServicio;
import Servicio.PrestamoServicio;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class NewMain {

    public static void main(String[] args) throws Exception {
       
        AutorServicio as = new AutorServicio();
        ClienteServicio cs = new ClienteServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        PrestamoServicio ps = new PrestamoServicio();
        Scanner read = new Scanner(System.in);
        
        int answer;  
        do {
            System.out.println("\n============= LIBRERIA =============\n");
            System.out.println("Show option about");
            System.out.println("1) AUTOR\n2) CLIENTE\n3) EDITORIAL\n4) LIBRO\n"
            + "5) PRESTAMO\n6) SALIR\n");
            answer = read.nextInt(); 
            switch (answer){
                case 1:
                    do {
                        System.out.println("\n============= AUTOR =============\n");
                        System.out.println("What would you like to do?");
                        System.out.println("1) Crear autor\n2) Modificar autor\n"
                        + "3) Borrar autor\n4) Buscar autor por nombre\n5) Volver");
                        answer = read.nextInt();
                        switch (answer){
                            case 1: as.crearAutor();
                            break;
                            case 2: as.modificarAutor();
                            break;
                            case 3: as.borrarAutor();
                            break;
                            case 4: System.out.println("ingrese el nombre del autor a buscar");
                                    String nombre = read.next();
                                    as.showquery(as.buscarNombre(nombre));
                            break;
                            case 5: break;
                            default: System.out.println("respuesta invalida, intetelo nuevamente");                            
                        }                                   
                    } while (answer!=5);
                break;
                case 2:
                    do {
                        System.out.println("\n============= CLIENTE =============\n");
                        System.out.println("What would you like to do?");
                        System.out.println("1) Crear cliente\n2) Modificar cliente\n"
                        + "3) Borrar cliente\n4) Buscar cliente por nombre\n5) Volver");
                        answer = read.nextInt();
                        switch (answer){
                            case 1: cs.crearCliente();
                            break;
                            case 2: cs.modificarCliente();
                            break;
                            case 3: cs.borrarCliente();
                            break;
                            case 4: System.out.println("ingrese el nombre del cliente a buscar");
                                    String nombre = read.next();      
                                    cs.showquery(cs.buscarNombre(nombre));
                            break;
                            case 5: break;
                            default: System.out.println("respuesta invalida, intetelo nuevamente");
                        }                                   
                    } while (answer!=5);  
                break;                            
                case 3:
                    do {
                        System.out.println("\n============= EDITORIAL =============\n");
                        System.out.println("What would you like to do?");
                        System.out.println("1) Crear editorial\n2) Modificar editorial\n"
                        + "3) Borrar editorial\n4) Buscar editorial por nombre\n5) Volver");
                        answer = read.nextInt();
                        switch (answer){
                            case 1: es.crearEditorial();
                            break;
                            case 2: es.modificarEditorial();
                            break;
                            case 3: es.borrarEditorial();
                            break;
                            case 4: System.out.println("ingrese el nombre de la editorial a buscar");
                                    String nombre = read.next();      
                                    es.showquery(es.buscarNombre(nombre));
                            break;
                            case 5: break;
                            default: System.out.println("respuesta invalida, intetelo nuevamente");
                        }        
                    } while (answer!=5);  
                break;     
                case 4:
                    do {
                        System.out.println("\n============= LIBRO =============\n");
                        System.out.println("What would you like to do?");
                        System.out.println("1) Crear libro\n2) Borrar libro\n3) Buscar libro por titulo\n"
                        + "4) Buscar libro por autor\n5) Buscar libro por titulo\n6) Volver");
                        answer = read.nextInt();
                        switch (answer){
                            case 1: ls.crearLibro();
                            break;
                            case 2: ls.borrarLibro();
                            break;
                            case 3: System.out.println("ingrese el titulo del libro a buscar");
                                    String titulo = read.next();
                                    ls.showquery(ls.buscarTitulo(titulo));
                            break;
                            case 4: System.out.println("ingrese el autor del libro a buscar");
                                    String autor = read.next();
                                    ls.showquery(ls.buscarAutor(autor));
                            break;
                            case 5: System.out.println("ingrese la editorial del libro a buscar");
                                    String editorial = read.next();   
                                    ls.showquery(ls.buscarEditorial(editorial));
                            break;                            
                            case 6: break;
                            default: System.out.println("respuesta invalida, intetelo nuevamente");
                        }                                      
                    } while (answer!=6);  
                break;
                case 5:
                    do {
                        System.out.println("\n============= PRESTAMO =============\n");
                        System.out.println("What would you like to do?");
                        System.out.println("1) Crear prestamo\n2) Modificar prestamo\n"
                        + "3) Borrar prestamo\n4) Buscar prestamo por cliente\n5) Volver");
                        answer = read.nextInt();
                        switch (answer){
                            case 1: ps.crearPrestamo();
                            break;
                            case 2: ps.modificarPrestamo();
                            break;
                            case 3: ps.borrarPrestamo();
                            break;
                            case 4: System.out.println("ingrese el nombre del cliente a buscar");
                                    String nombre = read.next();      
                                    ps.showquery(ps.buscarCliente(nombre));
                            break;
                            case 5: break;
                            default: System.out.println("respuesta invalida, intetelo nuevamente");
                        }        
                    } while (answer!=5);  
                break; 
                case 6: break;
                default: System.out.println("respuesta invalida, intetelo nuevamente");
            }        
        } while (answer!=6); 
    }
    
}
