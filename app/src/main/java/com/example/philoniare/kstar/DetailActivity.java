package com.example.philoniare.kstar;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by philoniare on 3/1/16.
 */
public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String imageURL = bundle.getString("imageURL");

        titleTextView = (TextView) findViewById(R.id.artistTitle);
        titleTextView.setText(title);

        imageView = (ImageView) findViewById(R.id.grid_item_image);
        Picasso.with(this).load(imageURL).into(imageView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(title);



        // Toolbar color based on image palette
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
//                R.drawable.header);
//        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                mutedColor = palette.getMutedColor(R.attr.colorPrimary);
//                collapsingToolbar.setContentScrimColor(mutedColor);
//            }
//        });
    }


}
