package com.example.kiemtra;

import java.io.Serializable;

public class ThoiTiet implements Serializable {
    String nameCountry;
    int temp;

    public ThoiTiet(String nameCountry, int temp) {
        this.nameCountry = nameCountry;
        this.temp = temp;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
