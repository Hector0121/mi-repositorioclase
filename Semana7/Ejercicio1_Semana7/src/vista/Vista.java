package vista;

import controlador.Controlador;
import es.usal.progiii.tools.Esdia;

public class Vista {
    private Controlador controlador;

    //metodo para enlazar la vista con el controlador
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }

    //mostrar mensaje bienvenida
    public void mostrarMensajeBienvenida(){
        System.out.println("=== PROGRAMA DE SUMA (MVC) ===");
    }

    //mostrar mensaje bienvenida
    public void mostrarMensajeDespedida(){
        System.out.println("=== GRACIAS POR UTILIZAR EL PROGRAMA ===");
    }

    //mostrar menu principal
    public void mostrarMenuPrincipal() {
        int opcion;
        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Leer los números");
            System.out.println("2. Calcular la suma");
            System.out.println("3. Mostrar el resultado");
            System.out.println("4.- Salir");
            opcion = Esdia.readInt("Seleccione una opcion: ");

            switch(opcion){
                case 1:
                    pedirNumeros();
                    break;
                case 2:
                    calcularSuma();
                    break;
                case 3:
                    mostrarSuma();
                    break;
                case 4: 
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
        
    }


    //pedir numeros al usuario
    public void pedirNumeros(){
        float num1 = Esdia.readFloat("Introduce el primer número entero: ");
        float num2 = Esdia.readFloat("Introduce el segundo número entero: ");

        controlador.pedirNumeros(num1,num2);
    }

    //calcular suma
    public void calcularSuma(){
        controlador.calcularSuma();
    }

    //mostrar suma
    public void mostrarSuma(){
        float suma = controlador.mostrarSuma();

        System.out.println("Tu suma es: "+ suma);
    }

}
