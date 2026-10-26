import Packages.*;
import java.util.*;

public class Ejercicio1_Semana6
  {
    private  static final int MAX_SIZE=50;
    private static Coche[] concesionario = new Coche[MAX_SIZE];
    public  static  int num_coches=0;
    private static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) throws Exception {
      
      int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar un coche");
            System.out.println("2. Eliminar un coche");
            System.out.println("3. Modificar un coche");
            System.out.println("4. Listado de coches");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción: ");
            opcion =sc.nextInt();
            
            switch (opcion) {
                case 1: 
                  num_coches++;
                  agregarCoche();
                  break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: ; break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void agregarCoche(){
      sc.nextLine();//limpiamos el buffer
      if(num_coches>MAX_SIZE){
        System.out.println("Error: El array esta lleno");
      }
      else{
        System.out.println("Introduce el nombre de la persona del coche: ");
        String nombre= sc.nextLine();
        System.out.println("Introduce el nombre de la marca: ");
        String marca = sc.nextLine();
        System.out.println("Introduce el numero de matricula sin letras");
        int num_matr = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce las letras de tu matricula: ");
        String letr_matrc=sc.nextLine();
        concesionario [num_coches-1]=new Coche(nombre,marca,num_matr,letr_matrc);
        }
    }
    public static void eliminarCoche(){
      System.out.println("Introduce el numero de matricual ");
      int num = sc.nextInt();
      sc.nextLine();
      System.out.println("Introduce letra de matricual ");
      String letr = sc.nextLine();
      for(int i =0; i<num_coches;i++){
        if((concesionario[i].getLetra_matricula().equals(letr)) && (concesionario[i].getNum_matricula() == num)){
          for(int x=i ;x<num_coches;x++){
            concesionario[i]=concesionario[i+1];
          }
          concesionario[num_coches-1]=null;
          num_coches--;
        }
        }
    }
    public static void modificarCoche(){
      System.out.println("Introduce el numero de matricual ");
      int num = sc.nextInt();
      sc.nextLine();
      System.out.println("Introduce letra de matricual ");
      String letr = sc.nextLine();
      int posicion=0;
      for(int i =0; i<num_coches;i++){
        if((concesionario[i].getLetra_matricula().equals(letr)) && (concesionario[i].getNum_matricula() == num)){
          posicion=i;
        }
      }
      int opcion;
      do{
        System.out.println("1)modificar nombre");
        System.out.println("2)modificar marca");
        System.out.println("3)modificar numero de matricula");
        System.out.println("4)modificar letras de matricula");
        System.out.println("Introude la opcion (5 para salir)");
        opcion=sc.nextInt();
        sc.nextLine();

        switch(opcion){
          case 1: System.out.println("Introduce el nuevo nombre");
                  String nombre= sc.nextLine();
                  concesionario[posicion].setNombre(nombre);
                  break;
          case 2: System.out.println("Introducela nueva marca");
                  String marca= sc.nextLine();
                  concesionario[posicion].setMarca(marca);
                  break;
          case 3: System.out.println("Introude los nuevos numeros de matricula");
                  int numer= sc.nextInt();
                  sc.nextLine();
                  concesionario[posicion].setNum_matricula(numer);
                  break;
          case 4: System.out.println("Introduce los nuevas letras de la matricula");
                  String letra =sc.nextLine();
                  concesionario[posicion].setLetra_matricula(letra);
                  break;

        }

      }while(opcion !=5);
    }
    public  static void impimirconcesionario(){
      for(int i=0;i<num_coches;i++){

        System.out.printf("\n Persona : %s, Marca: %s, Matricula %d%s",concesionario[i].getNombre(), concesionario[i].getMarca(), concesionario[i].getNum_matricula(), concesionario[i].getLetra_matricula());
      }
    }
}
