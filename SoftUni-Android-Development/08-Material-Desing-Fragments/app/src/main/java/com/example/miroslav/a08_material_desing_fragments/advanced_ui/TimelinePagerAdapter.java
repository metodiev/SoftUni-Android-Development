package com.example.miroslav.a08_material_desing_fragments.advanced_ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TimelinePagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public TimelinePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentStories();
            case 1:
                return new FragmentCampaigns();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        switch (position) {
//            case 0:
//                return context.getString(R.string.stories);
//            case 1:
//                return context.getString(R.string.campaigns);
//            default:
//                return null;
//        }
//    }
}
