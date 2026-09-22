import java.io.Console;

public class Ejercicio2_Semana2 {
    public static void main(String[] args){
        Console console = System.console();
        int anio;
        if(console == null) {
            System.out.printf("No hay consola disponible");
            return;
        }
        System.out.printf("Introduce tu año de nacimiento: ");
        int aniNac=Integer.parseInt(console.readLine());

        do{
            System.out.printf("Introduce el año actual: ");
            anio=Integer.parseInt(console.readLine());
        }while(anio < aniNac);

        int edad = anio - aniNac;
        System.out.printf("Tu edad es " + edad);
    }
}

 