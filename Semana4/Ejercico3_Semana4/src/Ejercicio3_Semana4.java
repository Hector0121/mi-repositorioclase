import java.util.*;
public class Ejercicio3_Semana4 {

    public static class Frutas{
        private String frutas;
        private float IVA=0.16f;
        private float prec_Kg;
        private int cantidad;
    

        //constructores
        public Frutas(String frutas, float IVA, float prec_Kg, int cantidad){
            this.frutas=frutas;
            this.IVA=IVA;
            this.prec_Kg=prec_Kg;
            this.cantidad=cantidad;
        }
        public Frutas (String frutas){
            this.frutas=frutas;

        }
        public Frutas(){

    
        }

        //Metodos
        public float Precio_IVA(float prec_Kg){
            float IVA_calculo=prec_Kg*this.IVA;
            IVA_calculo=prec_Kg+IVA_calculo;
            return IVA_calculo;
        }

        public float PrecioTotal_x_Fruta(int cantidad,float prec_Kg){
            float precio_x_Fruta;
            float IVA_calculo=prec_Kg*this.IVA;
            precio_x_Fruta=(prec_Kg+IVA_calculo)*cantidad;
            return precio_x_Fruta;
        }
        

        //Getter y Setter
        public String getFrutas(){
            return this.frutas;
        }
        
        public float getIVA(){
            return this.IVA;
        }
        public float getPrec_Kg(){
            return this.prec_Kg;
        }
        public int getCantidad(){
            return this.cantidad;
        }
        public void setFrutas(String frutas){
            this.frutas=frutas;
        }
        public void setIVA(float IVA){
            this.IVA=IVA;
        }
        public void setPrec_Kg(float prec_Kg){
            this.prec_Kg=prec_Kg;
        }
        public void setCantidad(int cantidad){
            this.cantidad=cantidad;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Frutas Manzana=new Frutas("Manzana");
        Frutas Pera=new Frutas("Peras");
        //Variables
        int clientes=0;
        int opcion;
        float precio_x_Manzana, precio_x_Pera, precio_total;
        float manzana_precio_IVA, pera_precio_IVA;

        System.out.println("Introduce el precio de las manzanas sin IVA:");
        Manzana.setPrec_Kg(sc.nextFloat());
        System.out.println("Introduce el precio de las Peras sin IVA:");
        Pera.setPrec_Kg(sc.nextFloat());

        do{
            
            System.out.println("---MENU---");
            System.out.println("1.)Comprar manzanas y/o peras");
            System.out.println("2.)Tiket de compra");
            System.out.println("3.)Salir");
            System.out.println("Seleccione una opcion: ");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Introduce la cantidad de manzanas(Kg):");
                    Manzana.setCantidad(sc.nextInt());
                    System.out.println("Introduce la cantidad de peras(Kg):");
                    Pera.setCantidad(sc.nextInt());
                    clientes++;
                    break;
                case 2:
                    precio_x_Manzana=Manzana.PrecioTotal_x_Fruta(Manzana.getCantidad(),Manzana.getPrec_Kg());
                    precio_x_Pera=Pera.PrecioTotal_x_Fruta(Pera.getCantidad(),Pera.getPrec_Kg());
                    manzana_precio_IVA=Manzana.Precio_IVA(Manzana.getPrec_Kg());
                    pera_precio_IVA=Pera.Precio_IVA(Pera.getPrec_Kg());
                    precio_total=precio_x_Manzana+precio_x_Pera;
                    System.out.println("---Imprimiendo tiket de compra---");
                    for(int i=0;i<4;i++){
                        System.out.println("\t\t.");
                    }
                    System.out.println("|--------------------------------------------------|");
                    System.out.printf("|Cliente                                       | %s |",clientes);
                    System.out.println("\n|--------------------------------------------------|");
                    System.out.printf("| %s | %-2d Kg| Precio Kg con IVA %-1.2f$ | %.2f$ |",Manzana.getFrutas(),Manzana.getCantidad(),manzana_precio_IVA,precio_x_Manzana);
                    System.out.printf("\n| %-7s | %-2d Kg| Precio Kg con IVA %-1.2f$ | %.2f$ |",Pera.getFrutas(),Pera.getCantidad(),pera_precio_IVA,precio_x_Pera);
                    System.out.println("\n|--------------------------------------------------|");
                    System.out.printf("| Total con IVA %33.2f$ |",precio_total);
                    System.out.println("\n|--------------------------------------------------|\n");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        }while (opcion !=3);
        sc.close();
    }
    
}
    
