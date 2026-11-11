
import modelo.ModeloQuiniela;
import vista.VistaQuiniela;
import controlador.ControladorQuiniela;


public class App {
    public static void main(String[] args) throws Exception {

        ModeloQuiniela modelo = new ModeloQuiniela();
        VistaQuiniela vista = new VistaQuiniela();
        ControladorQuiniela controlador = new ControladorQuiniela(modelo, vista);

        controlador.init();
    }
}
