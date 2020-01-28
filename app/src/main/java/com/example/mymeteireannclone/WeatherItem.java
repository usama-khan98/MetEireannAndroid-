package com.example.mymeteireannclone;


//Model class for Weather Item

//Usama Ali Khan
//17810

public class WeatherItem {

    public String day;
    public int centigrade;

    public WeatherItem(String day, int centigrade) {
        this.day = day;
        this.centigrade = centigrade;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCentigrade() {
        return centigrade;
    }

    public void setCentigrade(int centigrade) {
        this.centigrade = centigrade;
    }
}
