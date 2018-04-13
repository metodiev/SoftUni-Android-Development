package com.example.miroslav.a08_material_desing_fragments.advanced_ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miroslav.a08_material_desing_fragments.R;
import com.example.miroslav.a08_material_desing_fragments.databinding.FragmentTimelineBinding;


public class TimelineFragment extends Fragment{

    FragmentTimelineBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Inflate
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_timeline, container, true);
        setupTabs();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        setupTabs();
    }

    public void setupTabs() {
        TimelinePagerAdapter adapter = new TimelinePagerAdapter(getContext(), getChildFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.grpTabs.setupWithViewPager(binding.viewpager);
    }
}
