package com.example.philoniare.kstar;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by philoniare on 3/1/16.
 */
public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView;
    private ImageView imageView;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    String profileText;
    ArrayList<String> images;
    ArrayList<String> videos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_view);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String imageURL = bundle.getString("imageURL");
        profileText = bundle.getString("profileText");

        images = bundle.getStringArrayList("images");
        videos = bundle.getStringArrayList("videos");

        // titleTextView = (TextView) findViewById(R.id.artistTitle);
        // titleTextView.setText(title);

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


        // Tabs
        final ViewPager viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(R.color.textSecondary, R.color.colorToolbarTitle);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ProfileFragment profileFragment = new ProfileFragment(getResources().getColor(R.color.textPrimary));
        Bundle profileBundle = new Bundle();
        profileBundle.putString("profileText", profileText);
        profileFragment.setArguments(profileBundle);

        ImagesFragment imagesFragment = new ImagesFragment(getResources().getColor(R.color.textPrimary));
        Bundle imagesBundle = new Bundle();
        imagesBundle.putStringArrayList("images", images);
        imagesFragment.setArguments(imagesBundle);

        VideosFragment videosFragment = new VideosFragment(getResources().getColor(R.color.textPrimary));
        Bundle videosBundle = new Bundle();
        videosBundle.putStringArrayList("videos", videos);
        videosFragment.setArguments(videosBundle);

        adapter.addFrag(profileFragment, "Profile");
        adapter.addFrag(imagesFragment, "Images");
        adapter.addFrag(videosFragment, "Videos");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
