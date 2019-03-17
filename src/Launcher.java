
import Presentation.Model;

public class Launcher {

    private Model myApp;

    public Launcher() {
        myApp = new Model();
        myApp.start();
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
