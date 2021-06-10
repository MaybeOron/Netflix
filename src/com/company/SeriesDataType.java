package com.company;

public class SeriesDataType {

    private String sName;
    private String eName;
    private int epWatchedIndex;

    public SeriesDataType(String eName, String sName){
        this.eName = eName;
        this.sName = sName;
        this.epWatchedIndex = 0;
    }

    public void addEpIndex(){
        epWatchedIndex++;
    }
    public int getEpIndex(){
        return epWatchedIndex;
    }

    public String getEName(){
        return this.eName;
    }

    public String getSName(){
        return this.sName;
    }

}
