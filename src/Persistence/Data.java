package Persistence;

import Logic.Logic;

public class Data {

    private String URL;
    private Logic logic;
    
    public Data (Logic get){
        logic = get;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
