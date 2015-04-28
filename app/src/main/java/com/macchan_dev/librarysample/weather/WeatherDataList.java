package com.macchan_dev.librarysample.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macchan.dev on 15/04/28.
 *
 */
public class WeatherDataList {
    public List<WeatherData> pinpointLocations;

    public WeatherDataList() {
        this.pinpointLocations = new ArrayList<>();
    }

    public List<WeatherData> getWeatherList() {
        return pinpointLocations;
    }
}
