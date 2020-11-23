package com.example.appprototype1.hive;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appprototype1.R;

import java.util.ArrayList;
import java.util.List;


public class HiveNavOneFragment extends Fragment {
public HiveNavOneFragment(){};
    Spinner dropdown;
    Spinner dropdown2;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_hive_nav_one, container, false);

            dropdown = v.findViewById(R.id.newHiveSpinner);
            dropdown2 = v.findViewById(R.id.newHiveSpinner2);

        String[] hives = new String[]{"Choose...","4 frames", "5 frames", "8 frames", "10 frames"};

        String[] items2 = new String[]{"Extract", "From", "Database"};

        adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.list_dropdown, hives);
        adapter.setDropDownViewResource(R.layout.list_dropdown);

        adapter2 = new ArrayAdapter<String>(this.getActivity(),R.layout.list_dropdown, items2);
        adapter2.setDropDownViewResource(R.layout.list_dropdown);

        dropdown.setAdapter(adapter);
        dropdown2.setAdapter(adapter2);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(item.equals("Choose...")){

                }
                else{
                    Bundle bundle = new Bundle();
                    bundle.putString("string", item);
                    Navigation.findNavController(view).navigate(R.id.action_hiveNavOneFragment_to_hiveNavTwoFragment,bundle);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

}