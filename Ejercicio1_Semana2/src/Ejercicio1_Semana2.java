import java.util.Scanner;

public class Ejercicio1_Semana2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int anio;
        System.out.println("Introduce el año de nacimiento: ");
        int anioNacimiento = sc.nextInt();

        do{
        System.out.println("Introduce el año actual: ");
        anio = sc.nextInt();
        }while(anio < anioNacimiento);
        
        
        int edad = anio - anioNacimiento; 
        System.out.println("Tu edad es " + edad);
    }
}
 