import java.util.Scanner;

public class Ejercicio3_Semana3 {
   
    public  static class Person{
        //Atributos
        private String nomb;
        private float pesoKg;
        private float alturaCm; 

        //Contructor
        public Person(String nomb, float pesoKg, float alturaCm){
            this.nomb=nomb;
            this.pesoKg=pesoKg;
            this.alturaCm=alturaCm;
            
        }
        public  Person (){

        }
        //Metodo

        public float calcularIMC (float pesoKg, float alturaCm){
            float IMC;
            IMC=pesoKg/(alturaCm*alturaCm);
            return IMC;
        }

        //Getter y Setter
        public String getNombre(){
            return nomb;
        }
        public float getPeso(){
            return pesoKg;
        }
        public float getAltura(){
            return alturaCm;
        }
        public void setNombre(String nomb){
            this.nomb=nomb;
        }
        public void setPeso(float pesoKg){
            this.pesoKg=pesoKg;
        }
        public void setAltura(float alturaCm){
            this.alturaCm=alturaCm;
        }
        
    }
    public static void main (String[] args) {
        String Nombre;
        float altura;
        float peso;
        Scanner sc =new Scanner(System.in);
        Person p1= new Person();
        Person p2= new Person();
        Person p3= new Person();

        System.out.println("Ingrese el nombre de la persona 1: ");
        Nombre = sc.nextLine();
        p1.setNombre(Nombre);
        System.out.println("Ingrese el nombre de la persona 2: ");
        Nombre = sc.nextLine();
        p2.setNombre(Nombre);
        System.out.println("Ingrese el nombre de la persona 3: ");
        Nombre = sc.nextLine();
        p3.setNombre(Nombre);
        System.out.println("Introduce la altura de la persona 1. ");
        altura = sc.nextFloat();
        p1.setAltura(altura);
        System.out.println("Introduce la altura de la persona 2. ");
        altura = sc.nextFloat();
        p2.setAltura(altura);
        System.out.println("Introduce la altura de la persona 3. ");
        altura = sc.nextFloat();
        p3.setAltura(altura);
        System.out.println("Introduce el peso de la persona 1. ");
        peso = sc.nextFloat();
        p1.setPeso(peso);
        System.out.println("Introduce el peso de la persona 2. ");
        peso = sc.nextFloat();
        p2.setPeso(peso);
        System.out.println("Introduce el peso de la persona 3. ");
        peso = sc.nextFloat();
        p3.setPeso(peso);
    
    //Altura
    if(p1.getAltura()>p2.getAltura() && p1.getAltura()>p3.getAltura()){
        System.out.println("La mas alta es " + p1.getNombre());
    }else if(p2.getAltura()>p1.getAltura() && p2.getAltura()>p3.getAltura()){
        System.out.println("La mas alta es " + p2.getNombre());  
    }else{
        System.out.println("La mas alta es " + p3.getNombre());
    }

    //Peso
    if(p1.getPeso()>p2.getPeso() && p1.getPeso()>p3.getPeso()){
        System.out.println("La mas pesada es " + p1.getNombre());   
    }else if(p2.getPeso()>p1.getPeso() && p2.getPeso()>p3.getPeso()){
        System.out.println("La mas pesada es " + p2.getNombre());
    }else{
        System.out.println("La mas pesada es " + p3.getNombre());
    }

    //IMC
    System.out.println("----IMC de cada perosna------");
    System.out.printf("%s tiene un ICM %.2f",p1.getNombre(),p1.calcularIMC(p1.getPeso(),p1.getAltura()));
    System.out.printf("%s tiene un ICM %.2f",p2.getNombre(),p2.calcularIMC(p2.getPeso(),p2.getAltura()));
    System.out.printf("%s tiene un ICM %.2f",p3.getNombre(),p3.calcularIMC(p3.getPeso(),p3.getAltura()));
}
}
