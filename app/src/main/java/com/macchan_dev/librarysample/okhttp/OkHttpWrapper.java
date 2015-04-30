package com.macchan_dev.librarysample.okhttp;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by macchan-dev on 15/04/28.
 *
 */
public class OkHttpWrapper {

    /**
     * 呼び出し元に返すリスナー
     */
    public interface OkHttpListener {
        /**
         * 失敗
         * @param request 返すものそのまま
         * @param e 返すものそのまま
         */
        public void onFailure(Request request, IOException e);

        /**
         * 成功
         * @param response 返すものそのまま
         */
        public void onResponse(Response response) throws IOException;
    }

    public OkHttpWrapper() {

    }

    /**
     * enqueueする
     * @param url URL
     * @param listener 返すリスナー
     */
    public void enqueue(final String url, final OkHttpListener listener) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                listener.onFailure(request, e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                listener.onResponse(response);
            }
        });
    }
}
