package com.macchan_dev.librarysample.weather;

import com.macchan_dev.librarysample.okhttp.OkHttpWrapper;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by macchan.dev on 15/04/28.
 *
 */
public class Weather {

    public interface WeatherListener {
        public void onSuccess(String msg);
    }

    public Weather() {

    }

    public void getTokyo(final WeatherListener listener) {
        getWeather("130010", listener);
    }


    public void getWeather(String city, final WeatherListener listener) {
        OkHttpWrapper okHttpWrapper = new OkHttpWrapper();
        okHttpWrapper.enqueue("http://weather.livedoor.com/forecast/webservice/json/v1?city=" + city,
                new OkHttpWrapper.OkHttpListener() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        listener.onSuccess(response.body().string());
                    }
                });
    }
}
