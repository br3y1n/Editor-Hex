import presentacion.Model;

public class Launcher {
    
    private Model MyApp;

    public Launcher() {
        MyApp = new Model();
        MyApp.start();
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
