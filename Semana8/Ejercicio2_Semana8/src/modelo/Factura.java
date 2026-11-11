package modelo;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nifCliente;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe, String nifCliente,
            String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nifCliente = nifCliente;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    //factory method
    public static Factura getFacturaFromDelimitedString(String delimitedString, String delimiter){
        String[] chunks = delimitedString.split(delimiter);

        if (chunks.length != 8){
            return null;
        }

        try{
            String concepto = chunks[0];
            double descuento = Double.parseDouble(chunks[1]);
            String fecha = chunks[2];
            double importe = Double.parseDouble(chunks[3]);
            String nifCliente = chunks[4];
            String nombreCliente = chunks[5];
            String direccion = chunks[6];
            double iva = Double.parseDouble(chunks[7]);

            return new Factura(concepto, descuento, fecha, importe, nifCliente, nombreCliente, direccion, iva);
        }
        catch (Exception e){
            return null;
        }

    }

    //calculo importe final
    public double calcularImporteTotal(){
        return importe * (1.0 - descuento) * (1.0 + iva);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getImporte() {
        return importe;
    }

    public String getEstadoComoString() {
        return String.format("Factura: %s | Cliente: %s | Importe Base: %.2f€ | Total con IVA/Dto: %.2f€", 
                concepto, nombreCliente, importe, calcularImporteTotal());
    }

    //para poder poner la factura en tablas (es para OpMat)
    public String[] getInstanceAsArrayOfStrings() {
        String[] campos = new String[8]; 
        
        campos[0] = concepto;
        campos[1] = String.valueOf(descuento);
        campos[2] = fecha;
        campos[3] = String.valueOf(importe);
        campos[4] = nifCliente;
        campos[5] = nombreCliente;
        campos[6] = direccion;
        campos[7] = String.valueOf(iva);
        return campos;
    }

    //lo necesito para poder llamarlo para exportar los datos hacia afuera (lo utilizo en aCsv)
    public String getInstanceAsDelimitedString(String delimitador) {
        return concepto + delimitador + 
            descuento + delimitador + 
            fecha + delimitador + 
            importe + delimitador + 
            nifCliente + delimitador + 
            nombreCliente + delimitador + 
            direccion + delimitador + 
            iva;
    }

}
