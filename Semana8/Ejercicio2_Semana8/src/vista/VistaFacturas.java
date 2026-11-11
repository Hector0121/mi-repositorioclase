package vista;

import static es.usal.progiii.tools.Esdia.*;
import java.util.ArrayList;
import controlador.ControladorFacturas;
import modelo.Factura;

public class VistaFacturas {
    private ControladorFacturas controlador;

    public void setControlador(ControladorFacturas controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENU GESTIÓN DE FACTURAS ===");
            System.out.println("1. Cargar facturas desde fichero TSV");
            System.out.println("2. Mostrar listado total de facturas");
            System.out.println("3. Buscar clientes por valor mínimo de factura");
            System.out.println("4. Exportar facturas a HTML");
            System.out.println("5. Exportar facturas a CSV");
            System.out.println("6. Salir");
            opcion = readInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: controlador.cargarFichero(); break;
                case 2: controlador.listarFacturas(); break;
                case 3: pedirValorMinimoYFiltrar(); break;
                case 4: controlador.exportarHtml(); break;
                case 5: controlador.exportarCsv(); break;
                case 6: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    //metodos
    public void mostrarListado(ArrayList<Factura> facturas) {
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas cargadas en el sistema.");
            return;
        }
        System.out.println("\n--- LISTADO DE FACTURAS ---");
        for (Factura f : facturas) {
            System.out.println(f.getEstadoComoString());
        }
    }

    public void mostrarClientesFiltrados(ArrayList<String> clientes, double minimo) {
        System.out.println("\n--- CLIENTES CON FACTURAS SUPERIORES A " + minimo + "€ ---");
        if (clientes.isEmpty()) {
            System.out.println("Ningún cliente supera ese importe mínimo.");
            return;
        }
        for (String cliente : clientes) {
            System.out.println("- " + cliente);
        }
    }

    private void pedirValorMinimoYFiltrar() {
        double minimo = readDouble("Ingrese el valor mínimo de factura a evaluar: ");
        controlador.filtrarClientesPorImporte(minimo);
    }
}
