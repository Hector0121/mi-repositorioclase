package vista;

import static es.usal.progiii.tools.Esdia.*;
import controlador.ControladorQuiniela;

//para poder listar
import java.util.ArrayList;
import modelo.Partido;

public class VistaQuiniela {
    private ControladorQuiniela controlador;

    public void setControlador(ControladorQuiniela controlador){
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENU QUINIELA ---");
            System.out.println("1. Mostrar partidos");
            System.out.println("2. Introducir / Modificar resultado");
            System.out.println("3. Recargar partidos desde fichero");
            System.out.println("4. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: controlador.listarPartidos(); break;
                case 2: introducirResultado(); break;
                case 3: controlador.cargarFichero(); break;
                case 4: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    //listar 
    public void mostrarListadoArrayList(ArrayList<Partido> partidos){
        if (partidos.isEmpty()){
            System.out.println("No hay partidos que mostrar.");
            return;
        }
        System.out.println("\\n--- LISTADO DE PARTIDOS ---");
        for (int i = 0; i < partidos.size(); i++){
            System.out.println((i+1)+". "+ partidos.get(i).toString());
        }
    }

    //para introducir el resultado
    public void introducirResultado(){
        int indice = readInt("Ingrese el numero del partido: ") - 1;
        String resultado = readString_ne("Ingrese el resultado (1, X, 2): ");

        controlador.actualizarResultado(indice, resultado);
    }


}
