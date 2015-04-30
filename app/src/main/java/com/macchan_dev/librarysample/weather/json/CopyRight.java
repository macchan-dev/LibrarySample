package com.macchan_dev.librarysample.weather.json;

import java.util.List;

/**
 * Created by macchan.dev on 15/04/30.
 *
 */
public class CopyRight {
    public List<Provider> provider;
    public String link;
    public String title;
    public CopyRightImage image;

    public CopyRight(List<Provider> provider, String link, String title, CopyRightImage image) {
        this.provider =  provider;
        this.link = link;
        this.title = title;
        this.image = image;
    }
}
