package vista;

import controlador.Controlador;
import es.usal.progiii.tools.Esdia;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }

    public void mostrarMenu(){
        int opcion;
        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1.- Leer tabla de ventas");
            System.out.println("2.- Leer tabla de precios");
            System.out.println("3.- Calcular ingresos totales");
            System.out.println("4.- Mostrar resultados");
            System.out.println("5.- Salir");
            
            opcion = Esdia.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    pedirVentas();
                    break;
                case 2:
                    pedirPrecios();
                    break;
                case 3:
                    controlador.calcularIngresos();
                    break;
                case 4:
                    controlador.mostrarResultados();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while(opcion != 5);
    }

    public void pedirVentas() {
        System.out.println("\n--- Introducir Ventas (Unidades) ---");
        int[][] nuevasVentas = new int[5][2];
        for (int i = 0; i < 5; i++) {
            System.out.println("Almacén " + (i + 1) + ":");
            for (int j = 0; j < 2; j++) {
                nuevasVentas[i][j] = Esdia.readInt("  - Producto " + (j + 1) + ": ");
            }
        }
        controlador.guardarVentas(nuevasVentas);
    }

    public void pedirPrecios() {
        System.out.println("\n--- Introducir Precios Unitarios ---");
        float[] nuevosPrecios = new float[2];
        for (int j = 0; j < 2; j++) {
            nuevosPrecios[j] = Esdia.readFloat("Precio unitario del Producto " + (j + 1) + ": ");
        }
        controlador.guardarPrecios(nuevosPrecios);
    }

    public void mostrarResultadosFinales(float[] ingresosAlmacen, float ingresosTotales, int[][] ventas, float[] precios) {        
        System.out.println("\n========================================");
        System.out.println("          RESULTADOS FINALES");
        System.out.println("========================================");
        System.out.println("Precios de referencia:");
        System.out.println("  - Producto 1: " + precios[0] + " €");
        System.out.println("  - Producto 2: " + precios[1] + " €");
        System.out.println("----------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println("Almacén " + (i + 1) + " [Prod 1: " + ventas[i][0] + " u., Prod 2: " + ventas[i][1] + " u.] -> Ingresos: " + ingresosAlmacen[i] + " €");
        }
        System.out.println("----------------------------------------");
        System.out.println("Ingresos Totales de la Compañía: " + ingresosTotales + " €");
        System.out.println("========================================");
    }
}
