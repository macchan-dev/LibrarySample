package com.macchan_dev.librarysample.weather;

import com.macchan_dev.librarysample.weather.json.WeatherJson;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by macchan.dev on 15/05/07.
 *
 */
public class WeatherRetrofit extends WeatherConnect {

    public interface WeatherApiService {
        @GET(REQUEST_PATH)
        public void request(@Query(REQUEST_QUERY) String city, Callback<WeatherJson> rb);
    }

    @Override
    public void request(final String city, final WeatherListener listener) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(REQUEST_DOMAIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        WeatherApiService service = restAdapter.create(WeatherApiService.class);

        service.request(city, new Callback<WeatherJson>() {
            @Override
            public void success(WeatherJson weatherJson, Response response) {
                listener.onSuccess(weatherJson);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }
}
