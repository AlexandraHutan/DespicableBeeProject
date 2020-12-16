package com.example.appprototype1.apiary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appprototype1.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ApiaryAdapter extends RecyclerView.Adapter<ApiaryViewHolder>{
    FirebaseAuth firebaseAuth;
    DatabaseReference database;
    final ArrayList<String> apiariesList = new ArrayList<>();
    ArrayList<String> apiaryList;
    public ApiaryAdapter(ArrayList<String> apiaryList){
        this.apiaryList = apiaryList;
    }

    @NonNull
    @Override
    public ApiaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_apiary_view_holder, parent, false);
        return new ApiaryViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ApiaryViewHolder holder, int position) {

        String apiary = apiaryList.get(position);
        toast(apiary);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference("Users").child("Apiaries").child(apiary);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                apiariesList.clear();
                for(DataSnapshot snapshot1: datasnapshot.getChildren()){
                    apiariesList.add(snapshot1.getValue().toString());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        holder.apiaryNameTV.setText(apiariesList.get(0));
        holder.locationNameTV.setText(apiariesList.get(1));
        holder.notesTV.setText(apiariesList.get(2));

    }

    @Override
    public int getItemCount() {
        return apiaryList.size();
    }

    public void toast(String str){
        Log.e(str,"This is bind function");
    }
}
