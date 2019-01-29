package com.example.enxhikaziu.sample;

import java.io.Serializable;

//"Contacts" class
public class Contacts implements Serializable {
    private String mName,mNumber, mCompany;

    //Parameters
    public Contacts(String name, String number, String company) {
        this.mName = name;
        this.mNumber = number;
        this.mCompany = company;

    }
    //Name getter
    public String getName() {
        return mName;
    }
    //Name setter
    public void setName(String name) {
        this.mName = name;
    }
    //Number getter
    public String getNumber() {
        return mNumber;
    }
    //Number setter
    public void setNumber(String number) {
        this.mNumber = number;
    }
    //Company getter
    public String getCompany() {
        return mCompany;
    }
    //Company setter
    public void setCompany(String company){this.mCompany = company;}


}
