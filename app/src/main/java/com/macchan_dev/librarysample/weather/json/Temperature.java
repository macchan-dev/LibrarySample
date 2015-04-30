package com.macchan_dev.librarysample.weather.json;

/**
 * Created by macchan.dev on 15/04/30.
 *
 */
public class Temperature {
    public TemperatureKind min;
    public TemperatureKind max;

    public Temperature(TemperatureKind min, TemperatureKind max) {
        this.min = min;
        this.max = max;
    }
}
