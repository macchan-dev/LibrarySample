package com.macchan_dev.librarysample.weather;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.macchan_dev.librarysample.R;


public class WeatherActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // Fragmentのnewはメインスレッド上じゃないとダメだった
        final WeatherListFragment weatherListFragment = new WeatherListFragment();

        // 天気情報の取得
        Weather weather = new Weather();
        weather.getTokyo(new Weather.WeatherListener() {
            @Override
            public void onSuccess(String msg) {
                // 受け取ったjsonをListFragmentに渡す
                Bundle bundle = new Bundle();
                bundle.putString("list", msg);
                weatherListFragment.setArguments(bundle);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.container, weatherListFragment, "fragment");
                transaction.commit();
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
