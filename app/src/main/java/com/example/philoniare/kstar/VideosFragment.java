package com.example.philoniare.kstar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by philoniare on 3/10/16.
 */
public class VideosFragment extends Fragment {
    int color;
    SimpleRecyclerAdapter adapter;

    public VideosFragment() {

    }

    @SuppressLint("ValidFragment")
    public VideosFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videos_fragment, container, false);

        ArrayList<String> videos = getArguments().getStringArrayList("videos");

        return view;
    }
}