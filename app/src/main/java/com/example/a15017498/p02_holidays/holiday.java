package com.example.a15017498.p02_holidays;

/**
 * Created by 15017498 on 25/4/2017.
 */

public class holiday {

    String name;
    String date;
    String img;
    String desc;


    public holiday(String name, String date, String img, String desc) {
        this.name = name;
        this.date = date;
        this.img = img;
        this.desc = desc;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
