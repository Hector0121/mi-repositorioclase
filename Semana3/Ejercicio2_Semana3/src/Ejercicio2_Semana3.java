import java.util.Scanner;

public class Ejercicio2_Semana3 {
   
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
            this.nomb = "Juan";
            this.pesoKg=70;
            this.alturaCm=185;
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
        Scanner sc =new Scanner(System.in);
        Person p1= new Person("Andres",89,184);
        Person p2= new Person("Carmen",65,159);
        Person p3= new Person();
        //para q haga las comparaciones
       
    
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
}
}