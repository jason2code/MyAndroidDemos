package com.android.demos.jason.myandroiddemos.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xude1 on 16/7/2.
 */
public class Skill implements Parcelable {
    public String skillname;

    public Skill(String skillname) {
        this.skillname = skillname;
    }

    protected Skill(Parcel in) {
        skillname = in.readString();
    }

    public static final Creator<Skill> CREATOR = new Creator<Skill>() {
        @Override
        public Skill createFromParcel(Parcel in) {
            return new Skill(in);
        }

        @Override
        public Skill[] newArray(int size) {
            return new Skill[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(skillname);
    }
}
