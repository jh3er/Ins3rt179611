package com.insertco.insert;

import android.app.Application;

public class globalClass extends Application{
    private String username;

    public String getUsernameGlobal(){
        return username;
    }
    public void setUsernameGlobal(String x){
        this.username = x;
    }
}
