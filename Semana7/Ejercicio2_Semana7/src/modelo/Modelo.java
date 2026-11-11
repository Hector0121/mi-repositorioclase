package modelo;

public class Modelo {
    private int[][] ventas;     //5 almacenes (filas) y 2 productos (columnas)
    private float[] precios;    //precios de los dos productos
    private float[] ingresosPorAlmacen;
    private float ingresosTotalesCompania;

    public Modelo(){
        ventas = new int[5][2];
        precios = new float[2];
        ingresosPorAlmacen = new float[5];
        ingresosTotalesCompania = 0;
    }

    public void setVentas(int[][] nuevasVentas){
        this.ventas = nuevasVentas;
    }

    public void setPrecios(float[] nuevosPrecios){
        this.precios = nuevosPrecios;
    }

    //lógica de negocio
    public void calcularIngresos(){
        ingresosTotalesCompania = 0;
        for (int i = 0; i < 5; i++){
            ingresosPorAlmacen[i] = 0;
            for (int j = 0; j < 2; j++){
                ingresosPorAlmacen[i] += ventas[i][j] * precios[j];
            }
            ingresosTotalesCompania += ingresosPorAlmacen[i];
        }
    }

    //getters
    public int[][] getVentas(){
        return ventas;
    }
    public float[] getPrecios(){
        return precios;
    }
    public float[] getIngresosPorAlmacen(){
        return ingresosPorAlmacen;
    }
    public float getIngresosTotalesCompania(){
        return ingresosTotalesCompania;
    }



}
