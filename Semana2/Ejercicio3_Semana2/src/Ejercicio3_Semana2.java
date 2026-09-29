import es.usal.progiii.tools.Esdia;


public class Ejercicio3_Semana2 {
    public static void main(String[] args){
        float num;
        do{
            num=Esdia.readFloat("Introduce un número: ");
            if(num<=0){
                System.err.println("El número debe ser mayor que 0");
            }
        }while(num <=0);
        float suma=0;
        for(int i=0;i<num;i++){
            suma+=Esdia.readFloat("Introduce un número para hacer la media: ");
        }
        float media;
        media=suma/num;
        System.out.println("La media es "+ media);
    }
}
