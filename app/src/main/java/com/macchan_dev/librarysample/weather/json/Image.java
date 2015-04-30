package com.macchan_dev.librarysample.weather.json;

/**
 * Created by macchan.dev on 15/04/30.
 *
 */
public class Image {
    public int width;
    public String url;
    public String title;
    public int height;

    public Image(int width, String url, String title, int height) {
        this.width = width;
        this.url = url;
        this.title = title;
        this.height = height;
    }
}
