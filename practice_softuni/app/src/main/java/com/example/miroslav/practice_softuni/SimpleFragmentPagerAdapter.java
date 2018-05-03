package com.example.miroslav.practice_softuni;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new UsefulInfoFragment();
        } else if (position == 1){
            return new UsefulInfoFragment();
        } else if (position == 2){
            return new UsefulInfoFragment();
        } else {
            return new UsefulInfoFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.app_name);
            case 1:
                return mContext.getString(R.string.app_name);
            case 2:
                return mContext.getString(R.string.app_name);
            case 3:
                return mContext.getString(R.string.app_name);
            default:
                return null;
        }
    }

}
