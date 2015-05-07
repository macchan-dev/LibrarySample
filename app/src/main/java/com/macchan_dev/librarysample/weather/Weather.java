package com.macchan_dev.librarysample.weather;


/**
 * Created by macchan.dev on 15/04/28.
 *
 * 天気情報を取得する
 */
public class Weather {

    public Weather() {

    }

    /**
     * 東京の情報を取得する
     * @param connect コネクタ
     * @param listener リスナ
     */
    public void getTokyo(WeatherConnect connect, WeatherConnect.WeatherListener listener) {
        getWeather(connect, "130010", listener);
    }


    /**
     * 天気情報を取得する
     * @param connect コネクタ
     * @param city 都市番号
     * @param listener リスナ
     */
    public void getWeather(WeatherConnect connect, String city, final WeatherConnect.WeatherListener listener) {
        connect.request(city, listener);
    }
}
