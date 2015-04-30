package com.macchan_dev.librarysample.weather;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.macchan_dev.librarysample.weather.json.PinpointLocation;
import com.macchan_dev.librarysample.weather.json.WeatherJson;

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
            String list = getArguments().getString("list");
            Gson gson = new Gson();
            WeatherJson weatherJson = gson.fromJson(list, WeatherJson.class);

            // jsonからnameだけ取り出す
            ArrayList<String> names = new ArrayList<>();
            List<PinpointLocation> pinpointLocations = weatherJson.getPinpointLocations();
            for (PinpointLocation d : pinpointLocations) {
                names.add(d.getName());
            }

            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, names);
            setListAdapter(adapter);
        }
    }
}
