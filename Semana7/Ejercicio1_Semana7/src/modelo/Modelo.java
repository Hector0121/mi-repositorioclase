package modelo;

public class Modelo {
    private float num1;
    private float num2;
    private float suma;

    //constructor por defecto
    public Modelo(){
        this.num1= 0;
        this.num2= 0;
        this.suma = 0;
    }

    //para guardar los numeros (lógica de negocio)
    public void setNumeros(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    
    //realizar la suma (lógica de negocio)
    public void calcularSuma(){
        this.suma = this.num1 + this.num2;
    }

    //getters y setters
    public float getNum1(){
        return num1;
    }
    public float getNum2(){
        return num2;
    }
    public float getSuma(){
        return suma;
    }

}
