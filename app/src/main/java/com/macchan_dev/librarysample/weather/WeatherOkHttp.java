package com.macchan_dev.librarysample.weather;

import com.macchan_dev.librarysample.okhttp.OkHttpWrapper;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by macchan.dev on 15/04/30.
 *
 * OkHttpを使ってリクエストを行う。
 *
 */
public class WeatherOkHttp extends WeatherConnect {
    @Override
    public void request(final String city, final WeatherListener listener) {
        String requestUrl = REQUEST_DOMAIN + REQUEST_PATH + "?" + REQUEST_QUERY + "=" + city;

        OkHttpWrapper okHttpWrapper = new OkHttpWrapper();
        okHttpWrapper.enqueue(requestUrl,
                new OkHttpWrapper.OkHttpListener() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();
                        listener.onFailed(request.toString());
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        listener.onSuccess(response.body().string());
                    }
                });
    }
}
