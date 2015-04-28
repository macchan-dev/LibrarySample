package com.macchan_dev.librarysample.weather;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macchan.dev on 15/04/28.
 *
 */
public class WeatherListFragment extends ListFragment {

    public WeatherListFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey("list")) {
            // jsonからnameだけ取り出す
            String list = getArguments().getString("list");

            Gson gson = new Gson();
            WeatherDataList weatherDataList = gson.fromJson(list, WeatherDataList.class);

            ArrayList<String> names = new ArrayList<>();
            List<WeatherData> weatherDatas = weatherDataList.getWeatherList();
            for (WeatherData d : weatherDatas) {
                names.add(d.getName());
            }

            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, names);
            setListAdapter(adapter);
        }
    }
}
