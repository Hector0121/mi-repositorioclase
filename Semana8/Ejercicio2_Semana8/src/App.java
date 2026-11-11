
import modelo.ModeloFacturas;
import vista.VistaFacturas;
import controlador.ControladorFacturas;

public class App {
    public static void main(String[] args) throws Exception {

        ModeloFacturas modelo = new ModeloFacturas();
        VistaFacturas vista = new VistaFacturas();
        ControladorFacturas controlador = new ControladorFacturas(modelo, vista);

        controlador.init();

    }
}
