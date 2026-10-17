import Paquetes.Array; //Paquetes.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int num=5;
        Scanner sc = new Scanner(System.in);
        Array[] nombre = new Array[num];

        for(int i=0;i< num;i++){
            nombre[i] = new Array();
            System.out.println("Introduce un nombre: ");
            nombre[i].setNombre(sc.nextLine());
        }

        Arrays.sort(nombre);

        System.out.println("\nNúmero de nombres: " + nombre.length);
        for(Array nombres : nombre){
            System.out.printf("\n%s",nombres.getNombre());

        }

        sc.close();
    }
}
