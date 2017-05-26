package com.insertco.insert;

import android.app.Application;

import java.util.ArrayList;

public class globalClass extends Application{
    private String username;
    private ArrayList<String> historyDocumentName = new ArrayList<String>();
    private ArrayList<String> historyDate = new ArrayList<String>();
    private ArrayList<String> storageName = new ArrayList<String>();
    private String documentName;
    public String getUsernameGlobal(){
        return username;
    }
    public void setUsernameGlobal(String x){
        this.username = x;
    }
    public String getDocumentName(){
        return documentName;
    }
    public void setDocumentName(String x){
        this.documentName = x;
    }
    public ArrayList<String> getHistoryDocumentName(){
        return historyDocumentName;
    }
    public ArrayList<String> getHistoryDate(){
        return historyDate;
    }
    public ArrayList<String> getStorageName(){
        return storageName;
    }

    public void addHistoryDocumentName(String x){
        this.historyDocumentName.add(x);
    }
    public void addHistoryDate(String x){
        this.historyDate.add(x);
    }
    public void addStorageName(String x){
        this.storageName.add(x);
    }




}
