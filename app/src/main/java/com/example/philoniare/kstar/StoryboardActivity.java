package com.example.philoniare.kstar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by philoniare on 3/11/16.
 */
public class StoryboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storyboard);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarStory);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView textView = (TextView) this.findViewById(R.id.storyboardTV);
        textView.setText("Korean drama (Hangul: 한국드라마; RR: hanguk deurama) or K-drama refers to televised dramas in the Korean language, made in South Korea, mostly in a miniseries format, with distinctive features that set it apart from regular Western television series or soap operas. Korean dramas can be set in contemporary times or in historical settings, the Korean word for the latter being sageuk (사극). Different genres apply to these two types, from romantic comedies and action series to fusion science fiction dramas.");

    }

}
