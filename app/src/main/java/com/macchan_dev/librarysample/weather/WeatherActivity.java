package com.macchan_dev.librarysample.weather;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.macchan_dev.librarysample.R;
import com.macchan_dev.librarysample.weather.json.WeatherJson;


public class WeatherActivity extends ActionBarActivity {
    private static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // コネクタを取得する
        WeatherConnect connect = (WeatherConnect) getIntent().getSerializableExtra("connect");

        // Fragmentのnewはメインスレッド上じゃないとダメだった
        final WeatherListFragment weatherListFragment = new WeatherListFragment();

        // 天気情報の取得
        Weather weather = new Weather();
        weather.getTokyo(connect, new WeatherConnect.WeatherListener() {
            @Override
            public void onSuccess(String msg) {
                // 受け取ったjsonをListFragmentに渡す
                Gson gson = new Gson();
                WeatherJson weatherJson = gson.fromJson(msg, WeatherJson.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("list", weatherJson);
                weatherListFragment.setArguments(bundle);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, weatherListFragment, "fragment");
                transaction.commit();
            }

            @Override
            public void onSuccess(WeatherJson json) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", json);
                weatherListFragment.setArguments(bundle);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, weatherListFragment, "fragment");
                transaction.commit();
            }

            @Override
            public void onFailed(String error) {
                Log.d(TAG, error);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
