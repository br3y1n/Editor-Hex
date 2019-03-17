package Logic;

import Persistence.Data;

public class Logic {

    private Data date;

    public Data getDatos() {
        if (date == null) {
            date = new Data();
        }
        return date;
    }
}
  

