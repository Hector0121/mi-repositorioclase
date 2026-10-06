import java.util.Scanner;

public class Ejercicio2_Semana4 {
    public static class Persona{

        //Atributos
        private String nomb;
        private float peso;
        private float altura;
        
        //Constructor 
        public Persona(String nomb, float altura, float  peso){
            this.nomb=nomb;
            this.altura=altura;
            this.peso=peso;
        }
        public Persona(){
        }

        //Metodos
        public float calcularIMC(float peso, float altura){
            return peso / (altura * altura);
        }

        //Getter y Setter

        public String getNombre(){
            return this.nomb;
        }
        public float getAltura(){
            return this.altura;
        }
        public float getPeso(){
            return this.peso;
        }

        public void setNombre ( String nombre){
            this.nomb= nombre;
        }
        public void setAltura(float alt){
            this.altura=alt;
        }
        public void setPeso(float pes){
            this.peso=pes;
        }

    }
    public static void main (String args[]){
        Scanner sc =new Scanner(System.in);
        Persona person =new Persona();
        float IMC;
        person = new Persona(args[0],Float.parseFloat(args[1]),Float.parseFloat(args[2]));
        IMC=person.calcularIMC(Float.parseFloat(args[2]),Float.parseFloat(args[1]));

        System.out.println("------------------------------------");
        System.out.printf("Nombre %10s\nAltura %-10.2f\nPeso %-10.2f\nIMC %-10.2f /n", person.getNombre(),person.getAltura(),person.getPeso(),IMC);
        System.out.println("------------------------------------");
    }
}
