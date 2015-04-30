package com.macchan_dev.librarysample.weather.json;

/**
 * Created by macchan.dev on 15/04/30.
 *
 */
public class Forecast {
    public String dateLabel;
    public String telop;
    public String date;
    public Temperature temperature;
    public Image image;

    public Forecast(String dateLabel, String telop, String date, Temperature temperature, Image image) {
        this.dateLabel = dateLabel;
        this.telop = telop;
        this.temperature = temperature;
        this.image = image;
    }
}
