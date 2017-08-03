package com.example.dipto.expandablerecylerview.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dipto on 8/2/2017.
 */

public class InnerModel implements Parcelable {

    private String name ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InnerModel(String name){
        this.name = name ;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }


    protected InnerModel(Parcel in) {
        name = in.readString();
    }

    public static final Creator<InnerModel> CREATOR = new Creator<InnerModel>() {
        @Override
        public InnerModel createFromParcel(Parcel in) {
            return new InnerModel(in);
        }

        @Override
        public InnerModel[] newArray(int size) {
            return new InnerModel[size];
        }
    };
}
