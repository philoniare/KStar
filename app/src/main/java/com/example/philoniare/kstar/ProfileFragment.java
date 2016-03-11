package com.example.philoniare.kstar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by philoniare on 3/10/16.
 */
public class ProfileFragment extends Fragment {
    int color;
    SimpleRecyclerAdapter adapter;

    public ProfileFragment() {
    }

    @SuppressLint("ValidFragment")
    public ProfileFragment(int color) {
        this.color = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);


        String profileText = getArguments().getString("profileText");
        TextView textView = (TextView) view.findViewById(R.id.profileTV);

        textView.setText(profileText);


        return view;
    }
}