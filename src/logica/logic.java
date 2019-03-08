package logica;

import persistencia.datos;

public class logic {

    private datos date;

    public datos getDatos() {
        if (date == null) {
            date = new datos();
        }
        return date;
    }
}
  

