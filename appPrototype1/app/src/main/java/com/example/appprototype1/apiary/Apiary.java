package com.example.appprototype1.apiary;

import com.google.android.gms.common.api.Api;

public class Apiary {
    private String apiaryName;
    private String location;
    private String notes;

    public Apiary(String apiaryName, String location, String notes){
        this.apiaryName = apiaryName;
        this.location = location;
        this.notes = notes;
    }

    public String getApiaryName(){
        return apiaryName;
    }

    public String getNotesName(){
        return notes;
    }

    public String getLocationName(){
        return location;
    }
    public void setApiaryName(String apiaryName,String location, String notes){
        this.apiaryName = apiaryName;
        this.location = location;
        this.notes = notes;
    }
}
