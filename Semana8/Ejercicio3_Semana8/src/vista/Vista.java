package vista;

import static es.usal.progiii.tools.Esdia.*;
import java.util.ArrayList;
import controlador.Controlador;
import modelo.Persona;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ GESTIÓN DE PERSONAS ---");
            System.out.println("1. Importar datos desde un fichero TSV");
            System.out.println("2. Mostrar listado en forma tabular");
            System.out.println("3. Salir del programa");
            opcion = readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    pedirFicheroEImportar();
                    break;
                case 2:
                    controlador.mostrarTablaPersonas();
                    break;
                case 3:
                    confirmarYSalir();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTabla(ArrayList<Persona> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay personas registradas en el sistema.");
            return;
        }

        //hay que hacerla con una tabla
        System.out.println("\n--- LISTADO DE PERSONAS ---");
        
        String[] cabecera = Persona.getCabeceraTabla();
        System.out.printf("%-20s | %-15s | %-10s%n", cabecera[0], cabecera[1], cabecera[2]);
        System.out.println("--------------------------------------------------");

        //mostarmas cada persona como fila
        for (Persona p : lista) {
            String[] fila = p.getInstanceAsArrayOfStrings();
            System.out.printf("%-20s | %-15s | %-10s%n", fila[0], fila[1], fila[2]);
        }
    }

    private void pedirFicheroEImportar() {
        String nombreArchivo = readString("Introduce el nombre del fichero TSV (situado en el escritorio): ");
        controlador.importarFichero(nombreArchivo);
    }

    //hay que confirmar con el usuario que de verdad quiere salir
    private void confirmarYSalir() {
        String respuesta = readString("¿Está seguro de que quiere salir del programa? (s/n): ");
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Salida cancelada.");
        }
    }




}
