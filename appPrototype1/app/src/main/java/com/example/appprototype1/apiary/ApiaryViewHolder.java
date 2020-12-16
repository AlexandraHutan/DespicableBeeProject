package com.example.appprototype1.apiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appprototype1.R;

import org.w3c.dom.Text;

public class ApiaryViewHolder extends RecyclerView.ViewHolder {
    TextView apiaryNameTV;
    TextView locationNameTV;
    TextView notesTV;


    public ApiaryViewHolder(View view){
        super(view);
        apiaryNameTV = (TextView) view.findViewById(R.id.apairyNameTV);
        locationNameTV = (TextView) view.findViewById(R.id.locationNameTV);
        notesTV = (TextView) view.findViewById(R.id.notesTV);

    }

}