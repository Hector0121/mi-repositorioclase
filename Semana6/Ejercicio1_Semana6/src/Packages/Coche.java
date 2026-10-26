package Packages;

public class Coche {
    private String nombre;
    private String marca;
    private int num_matricula;
    private String letra_matricula;

    public Coche (String nombre,String marca, int num_matricula, String letra_matricula){
        this.nombre=nombre;
        this.marca=marca;
        this.num_matricula=num_matricula;
        this.letra_matricula=letra_matricula;
    }
    public Coche (){

    }


    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getNum_matricula() {
        return num_matricula;
    }
    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }
    public String getLetra_matricula() {
        return letra_matricula;
    }
    public void setLetra_matricula(String letra_matricula) {
        this.letra_matricula = letra_matricula;
    }


    //Gette
}
