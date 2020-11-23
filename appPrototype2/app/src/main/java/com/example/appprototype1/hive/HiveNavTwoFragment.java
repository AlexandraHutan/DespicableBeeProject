package com.example.appprototype1.hive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appprototype1.R;


public class HiveNavTwoFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Spinner spin2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hive_nav_two, container, false);
        spin2 = view.findViewById(R.id.newHiveSpinner3);
        String[] string = {""};
        if(getArguments() != null){
            if(getArguments().getString("string").toString().equals("4 frames"))
                string = new String[]{"Nucleus", "Mating Nuc"};
            if(getArguments().getString("string").toString().equals("5 frames"))
                string = new String[]{"Mating Nuc","Nucleus", "Starter",};
            if(getArguments().getString("string").toString().equals("8 frames"))
                string = new String[]{"Builder","Honey Production","Mother Hive","Starter"};
            if(getArguments().getString("string").toString().equals("10 frames"))
                string = new String[]{"Builder","Honey Production","Mother Hive","Starter"};
        }
        ArrayAdapter<String> dataAdapter2;
        dataAdapter2 = new ArrayAdapter(this.getActivity(), R.layout.list_dropdown,string);

        dataAdapter2.setDropDownViewResource(R.layout.list_dropdown);
        spin2.setAdapter(dataAdapter2);
        return view;
    }
}