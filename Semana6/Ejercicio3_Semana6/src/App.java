
import modelo.Libro;
import java.util.HashMap;

import static es.usal.progiii.tools.Esdia.*;

public class App {

    private static HashMap<String, Libro> libros = new HashMap<>();
    public static void main(String[] args) throws Exception {
        int opcion;
        do{
            System.out.println("\n--- GESTIÓN DE BIBLIOTECA ---");
            System.out.println("1. Dar de alta un libro (Create)");
            System.out.println("2. Listar libros (Read)");
            System.out.println("3. Buscar libro por ISBN (Read)");
            System.out.println("4. Actualizar libro (Update)");
            System.out.println("5. Eliminar libro (Delete)");
            System.out.println("6. Salir");
            
            opcion = readInt("Elige una opción: ");
            switch (opcion) {
                case 1:
                    darDeAlta();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    actualizarLibro();
                    break;
                case 5:
                    eliminarLibro();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 6.");
            }
        }while(opcion != 6);
    }

    private static void darDeAlta(){
        String isbn = readString("Introduce el isbn: ");
        if (libros.containsKey(isbn)){
            System.out.println("Ya existe un libro con ese isbn.");
        }
        else{
            String titulo = readString("Introduce el título: ");
            String autor = readString("Introduce el autor: ");
            int anio = readInt("Introduce el año de publicación: ");

            Libro nuevoLibro = new Libro(isbn,titulo,autor,anio);

            libros.put(isbn, nuevoLibro);
            System.out.println("Libro añadido correctamente.");
        }
    }

    private static void listarLibros(){
        if (libros.isEmpty()){
            System.out.println("Aún no hay libros.");
        }
        else{
            System.out.println("\\n--- LISTADO DE LIBROS ---");
            for (String isbn : libros.keySet()){
                System.out.printf("%s -> %s\n", isbn, libros.get(isbn).getTitulo());
            }
        }
    }

    private static void buscarLibro(){
        String isbn = readString("Introduce el ISBN del libro a buscar: ");
        Libro libro = libros.get(isbn);

        if (libro != null){
            System.out.println("Libro encontrado: " + libro);
        }
        else
            System.out.println("No se ha encontrado el libro.");
    }

    private static void actualizarLibro(){
        String isbn = readString("Introduce el ISBN del libro a actualizar: ");
        Libro libro = libros.get(isbn);

        if (libro != null){
            System.out.println("Libro actual: " + libro);

            String nuevoTitulo = readString("Introduce el nuevo titulo: ");
            String nuevoAutor = readString("Introduce el nuevo autor: ");
            int nuevoAnio = readInt("Introduce el nuevo año de publicación: ");

            libro.setTitulo(nuevoTitulo);
            libro.setAutor(nuevoAutor);
            libro.setAnioPublicacion(nuevoAnio);

            System.out.println("Libro actualizado correctamente.");

        }
        else
            System.out.println("No se ha encontrado el libro.");
    }

    private static void eliminarLibro(){
        String isbn = readString("Introduce el ISBN del libro a eliminar: ");

        if (libros.containsKey(isbn)){
            libros.remove(isbn);
            System.out.println("Libro eliminado correctamente.");
        }
        else{
            System.out.println("No se ha encontrado el libro.");
        }
    }

}
