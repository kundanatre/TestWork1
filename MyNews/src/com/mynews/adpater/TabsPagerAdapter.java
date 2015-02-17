package com.mynews.adpater;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.mynews.app.AppController;
import com.mynews.fragment.TopNewsFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	private Activity activity;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();
 
    public TabsPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // Top Rated fragment activity
            return new TopNewsFragment(activity);
        case 1:
        	return new TopNewsFragment(activity);
        	// Games fragment activity
//            return new GamesFragment();
        case 2:
        	return new TopNewsFragment(activity);
            // Movies fragment activity
//            return new MoviesFragment();
        default :
        	return new TopNewsFragment(activity);
        }
 
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }
 
}