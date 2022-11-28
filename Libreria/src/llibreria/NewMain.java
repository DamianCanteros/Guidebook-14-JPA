
package llibreria;

import Servicio.AutorServicio;
import Servicio.EditorialServicio;
import Servicio.LibroServicio;
import java.util.Scanner;

/**
 *
 * @author Damian
 */
public class NewMain {

    public static void main(String[] args) {
       
                AutorServicio as = new AutorServicio();
                EditorialServicio es = new EditorialServicio();
                LibroServicio ls = new LibroServicio();
                Scanner read = new Scanner(System.in);
        
        int answer;
        
        do {
            System.out.println("\n============= LIBRERIA =============\n");
            System.out.println("What would you like to do?");
            System.out.println("");
            System.out.println("1) Crear autor");
            System.out.println("2) ");
            System.out.println("3) ");
            System.out.println("4) ");
            System.out.println("5) Crear editorial");
            System.out.println("6) ");
            System.out.println("7) ");
            System.out.println("8) Crear libro");
            System.out.println("9) ");
            System.out.println("10) ");
            System.out.println("11) ");
            System.out.println("12) ");
            System.out.println("13) ");
            System.out.println("14) ");
            System.out.println("15) Salir");
            answer = read.nextInt();

            switch (answer){

                case 1: as.crearAutor();
                break;
                case 2: as.modificarAutor();
                break;
                case 3: as.borrarAutor();
                break;
                case 4: as.buscarNombre(nombre);
                break;
                case 5: es.crearEditorial();
                break;
                case 6: es.modificarEditorial();
                break;
                case 7: es.borrarEditorial();
                break;
                case 8: ls.crearLibro();
                break;
                case 9: ls.modificarLibro();
                break;
                case 10: ls.borrarLibro();
                break;
                case 11: ls.buscarIsbn(isbn);
                break;
                case 12: ls.buscarTitulo(titulo);
                break;
                case 13: ls.buscarAutor(autor);
                break;
                case 14: ls.buscarEditorial(editorial);
                break;
                case 15: break;
            } 
        } while (answer!=15); 
    }
    
}
