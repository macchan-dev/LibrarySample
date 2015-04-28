package com.macchan_dev.librarysample.weather;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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

            ArrayList<String> names = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(list);
                JSONArray locations = jsonObject.getJSONArray("pinpointLocations");
                int count = locations.length();
                for (int i = 0; i < count; i++) {
                    names.add(locations.getJSONObject(i).getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, names);
            setListAdapter(adapter);
        }
    }
}
