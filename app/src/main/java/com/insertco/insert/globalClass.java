package com.insertco.insert;

import android.app.Application;

import java.util.ArrayList;

public class globalClass extends Application{
    private String username;


    public String getUsernameGlobal(){
        return username;
    }
    public void setUsernameGlobal(String x){
        this.username = x;
    }


//    public ArrayList<String> getHistoryDocumentName(){
//        return historyDocumentName;
//    }
//    public ArrayList<String> getHistoryDate(){
//        return historyDate;
//    }
//
//    public void addHistoryDocumentName(String x){
//        this.historyDocumentName.add(x);
//    }
//    public void addHistoryDate(String x){
//        this.historyDate.add(x);
//    }
}
