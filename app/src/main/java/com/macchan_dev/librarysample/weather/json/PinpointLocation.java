package com.macchan_dev.librarysample.weather.json;

/**
 * Created by macchan.dev on 15/04/28.
 *
 */
public class PinpointLocation {
    public String name;
    public String link;

    public PinpointLocation(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
