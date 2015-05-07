package com.macchan_dev.librarysample.weather.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macchan.dev on 15/04/28.
 *
 * 取得したJSONの構造
 */
public class WeatherJson implements Serializable {
    public List<PinpointLocation> pinpointLocations;
    public String link;
    public List<Forecast> forecasts;
    public Location location;
    public String publicTime;
    public CopyRight copyright;
    public String title;
    public Description description;


    public WeatherJson() {
        this.pinpointLocations = new ArrayList<>();
        this.forecasts = new ArrayList<>();
    }

    public List<PinpointLocation> getPinpointLocations() {
        return pinpointLocations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("{\n");
        builder.append("pinpointLocations:[");
        builder.append(pinpointLocations.toString());
        builder.append("],\n");

        builder.append("link:");
        builder.append(link);
        builder.append(",\n");

        builder.append("forecasts:[");
        builder.append(forecasts.toString());
        builder.append("],\n");

        builder.append("location:{");
        builder.append(location.toString());
        builder.append("},\n");

        builder.append("publicTime:");
        builder.append(publicTime);
        builder.append(",\n");

        builder.append("copyright:{");
        builder.append(copyright.toString());
        builder.append("},\n");

        builder.append("title:");
        builder.append(title);
        builder.append(",\n");

        builder.append("description:{");
        builder.append(description.toString());
        builder.append("},\n");

        builder.append("}");

        return builder.toString();
    }
}
