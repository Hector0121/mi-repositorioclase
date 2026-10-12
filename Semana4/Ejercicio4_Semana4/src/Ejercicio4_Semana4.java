import java.util.*;

public class Ejercicio4_Semana4 {

    public  static class Alumno{
        //Atributos
        private String nombre;
        private float nota1;
        private float nota2;
        private float nota_final;
        private float valor1=0.1f;
        private float valor2=0.8f;
        //Contructor

        public Alumno(String nombre, float nota1, float nota2,  float nota_final){
            this.nombre=nombre;
            this.nota1=nota1;
            this.nota2=nota2;
            this.nota_final=nota_final;
        }
        public Alumno(){

        }
        //Metodos
        public float nota_1_2parcial_porc(float nota){
            float nota_1_2parcial;
            nota_1_2parcial=nota*this.valor1;
            return nota_1_2parcial;
        }
        public float nota_final_porc(float nota_final){
            float nota_del_final;
            nota_del_final =nota_final*this.valor2;
            return nota_del_final;
        }

        //Getter y Setter

        public String getNombre(){
            return this.nombre;
        }
        public float getNota1(){
            return this.nota1;
        }
        public float getNota2(){
            return this.nota2;
        }
        public float getNota_final(){
            return this.nota_final;
        }
        public void setNombre(String nombre){
            this.nombre=nombre;
        }
        public void setNota1(float nota1){
            this.nota1=nota1;
        }
        public void setNota2(float nota2){
            this.nota2=nota2;
        }
        public void setNota_final(float nota_final){
            this.nota_final=nota_final;
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Alumno[] alumno = new Alumno [20];

        //Variables
        int num;
        float nota1_porc, nota2_porc, nota_final_porc;
        float media_nota1=0;
        float media_nota2=0;
        float media_notaFin=0;
        float nota_final;


        do{
        System.out.println("Introduce el numero de alumnos: ");
        num=sc.nextInt();
        }while(num>20);
        for(int i=0;i<num;i++){
            System.out.println("------ FICHA DEL ALUMNO------");
            alumno[i]=new Alumno ();
            System.out.println("Introduce el nombre del alumno: ");
            alumno[i].setNombre(sc.nextLine());
            sc.nextLine();
            System.out.println("Introduce la nota del primer parcial: ");
            alumno[i].setNota1(sc.nextFloat());
            System.out.println("Introduce la nota del segundo parcial: ");
            alumno[i].setNota2(sc.nextFloat());
            System.out.println("Introduce la nota del global: ");
            alumno[i].setNota_final(sc.nextFloat());
            
        }
        for(int i=0; i<num;i++){
            media_nota1+=alumno[i].getNota1();
            media_nota2+=alumno[i].getNota2();
            media_notaFin+=alumno[i].getNota_final();
        }
        media_nota1=media_nota1/num;
        media_nota2=media_nota2/num;
        media_notaFin=media_notaFin/num;

        for(int i=0;i<num;i++){
            System.out.println("-----NOTAS-----");
            System.out.printf("Alumno: %s",alumno[i].getNombre());
            nota1_porc=alumno[i].nota_1_2parcial_porc(alumno[i].getNota1());
            System.out.printf("\nNota del primer parcial con porcentaje: %.2f",nota1_porc);
            nota2_porc=alumno[i].nota_1_2parcial_porc(alumno[i].getNota2());
            System.out.printf("\nNota del segundo parcial con porcentaje: %.2f",nota2_porc);
            nota_final_porc=alumno[i].nota_final_porc(alumno[i].getNota_final());
            System.out.printf("\nNota del global con porcentaje: %.2f",nota2_porc);
            nota_final=nota1_porc+nota2_porc+nota_final_porc;
            System.out.printf("\nLa nota de la asignatura es : %.2f",nota_final);
            System.out.println("\n|----------------------------------------------------|");
            System.out.println("|----------------------------------------------------|");
        }
        System.out.println("\n\n-----MEDIAS DE CLASE----");
        System.out.printf("\nLa nota media del primer parcial es  %.2f",media_nota1);
        System.out.printf("\nLa nota media del segundo  parcial es %.2f",media_nota2);
        System.out.printf("\nLa nota media del global  es %.2f",media_notaFin);


        sc.close();
    }
}
