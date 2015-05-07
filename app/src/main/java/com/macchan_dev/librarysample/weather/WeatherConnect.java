package com.macchan_dev.librarysample.weather;

import com.macchan_dev.librarysample.weather.json.WeatherJson;

import java.io.Serializable;

/**
 * Created by macchan.dev on 15/04/30.
 * <p/>
 * 天気情報を取得する為のインターフェース
 */
public abstract class WeatherConnect implements Serializable {
    public static final String REQUEST_DOMAIN = "http://weather.livedoor.com";
    public static final String REQUEST_PATH = "/forecast/webservice/json/v1";
    public static final String REQUEST_QUERY = "city";

    /**
     * 成功、失敗を返すリスナー
     */
    public interface WeatherListener {
        /**
         * JSONの文字列を返す場合
         *
         * @param msg JSONの文字列
         */
        public void onSuccess(String msg);

        /**
         * JSONのインスタンスを返す場合
         *
         * @param json JSONのインスタンス
         */
        public void onSuccess(WeatherJson json);

        /**
         * 失敗
         *
         * @param error 失敗メッセージ
         */
        public void onFailed(String error);
    }

    /**
     * ネットワークの実装を行う。
     *
     * @param city     リクエストする都市の番号
     * @param listener 返すリスナー
     */
    public abstract void request(final String city, final WeatherListener listener);
}
