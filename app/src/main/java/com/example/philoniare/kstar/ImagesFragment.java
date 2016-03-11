package com.example.philoniare.kstar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by philoniare on 3/10/16.
 */
public class ImagesFragment extends Fragment {
    int color;
    SimpleRecyclerAdapter adapter;
    ListView listView;

    public ImagesFragment() {
    }

    @SuppressLint("ValidFragment")
    public ImagesFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.images_fragment, container, false);
        ArrayList<String> images = getArguments().getStringArrayList("images");
        String[] imagesArr = new String[images.size()];
        imagesArr = images.toArray(imagesArr);
        listView = (ListView) view.findViewById(R.id.artistImagesLV);
        listView.setAdapter(new ImageListAdapter(getActivity(), imagesArr));
        return view;
    }
}