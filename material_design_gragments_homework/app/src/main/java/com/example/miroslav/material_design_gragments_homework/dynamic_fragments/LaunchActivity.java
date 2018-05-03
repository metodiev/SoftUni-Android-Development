package com.example.miroslav.material_design_gragments_homework.dynamic_fragments;




import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.example.miroslav.material_design_gragments_homework.R;
import com.example.miroslav.material_design_gragments_homework.databinding.ActivityLunchBinding;

public class LaunchActivity extends AppCompatActivity implements ContactListFragment.OnFragmentDataReceived{

    ActivityLunchBinding activityLunchBinding;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);


    }

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_lunch);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ContactListFragment fragment = new ContactListFragment();
        fragmentTransaction.add(R.id.grp_container, fragment);



        //fragmentTransaction.addToBackStack("asd");
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();

        ContactDetailsFragment fragment1 = new ContactDetailsFragment();
       fragmentManager.beginTransaction().replace(R.id.grp_container, fragment1).commit();

    }


    @Override
    public void onDataReceived(String text) {

    }
}
