package Logic;

import Persistence.Data;
import Presentation.Model;

public class Logic {

    private Data data;
    private Model model;

    public Logic (Model get){
        model = get;
    }
    
    public Data getData() {
        if (data == null) {
            data = new Data(this);
        }
        return data;
    }
}
  

