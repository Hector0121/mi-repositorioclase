package modelo;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String resultado;

    public Partido(String equipoLocal, String equipoVisitante, String resultado) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;   
    }

    //factory method
    public static Partido getPartidoFromDelimitedString(String delimitedString, String delimiter){
        String[] chunks = delimitedString.split(delimiter);
        if(chunks.length != 2)
            return null;

        try{
            String equipoLocal = chunks[0];
            String equipoVisitante = chunks[1];
            String resultado = "-";
            Partido p = new Partido(equipoLocal, equipoVisitante, resultado);
            return p;
        }
        catch(Exception e){
            return null;
        }
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }


    @Override
    public String toString() {
        return equipoLocal + " vs " + equipoVisitante + " ---> [ " + resultado + " ]";
    }


}
