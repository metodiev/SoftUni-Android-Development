package com.example.miroslav.material_design_gragments_homework.dynamic_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miroslav.material_design_gragments_homework.R;

public class ContactListFragment extends Fragment {

    private OnFragmentDataReceived listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        return view;//super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //some of our code
        FragmentActivity activityCompat = getActivity();
        if (activityCompat instanceof OnFragmentDataReceived){
            listener = (OnFragmentDataReceived)activityCompat;
        }else {
           throw new RuntimeException("You must implement my inteface");

        }

        listener.onDataReceived("yess");
    }

    public interface OnFragmentDataReceived {
        void onDataReceived(String text);
    }
}
