package com.example.mymeteireannclone;


//Model class for Warning Item


//Usama Ali Khan
//17810
public class WarningItem {
    public String area,level,type;

    public WarningItem(String area, String level, String type) {
        this.area = area;
        this.level = level;
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WarningItem{" +
                "area='" + area + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
