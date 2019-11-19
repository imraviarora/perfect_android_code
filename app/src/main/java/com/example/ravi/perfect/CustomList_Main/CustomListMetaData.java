package com.example.ravi.perfect.CustomList_Main;

/**
 * Created by root on 11/16/18.
 */

public class CustomListMetaData {
    private String numbr;
    private String resn;
    private String dte;

    public CustomListMetaData(String numbr,String resn ,String dte){
        this.dte=dte;
        this.numbr=numbr;
        this.resn=resn;
    }

    //-------------------   GET ----------------------------------

    public String getNumbr(){
        return numbr;
    }

    public String getResn(){
        return resn;
    }

    public String getDte(){
        return dte;
    }

    //-------------------   GET ----------------------------------



    //-------------------   SET ----------------------------------

    public void setNumbr(String numbr){
        this.numbr=numbr;
    }

    public void setResn(String resn){
        this.resn=resn;
    }

    public void setDte(String dte){
        this.dte=dte;
    }
    //-------------------   SET ----------------------------------

}