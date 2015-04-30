package com.macchan_dev.librarysample.weather;

import java.io.Serializable;

/**
 * Created by macchan.dev on 15/04/30.
 *
 * 天気情報を取得する為のインターフェース
 */
public abstract class WeatherConnect implements Serializable {
    /**
     * 成功、失敗を返すリスナー
     */
    public interface WeatherListener {
        public void onSuccess(String msg);
        public void onFailed(String error);
    }

    /**
     * ネットワークの実装を行う。
     *
     * @param url リクエストするURL
     * @param listener 返すリスナー
     */
    public abstract void request(final String url, final WeatherListener listener);
}
