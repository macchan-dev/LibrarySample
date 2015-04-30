package com.macchan_dev.librarysample.weather.json;

/**
 * Created by macchan.dev on 15/04/30.
 *
 */
public class Location {
    public String city;
    public String area;
    public String prefecture;

    public Location(String city, String area, String prefecture) {
        this.city = city;
        this.area = area;
        this.prefecture = prefecture;
    }
}
