import presentacion.modelo;

public class Launcher {
    
    private modelo miaplicaccion;

    public Launcher() {
        miaplicaccion = new modelo();
        miaplicaccion.iniciar();
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
