package com.android.demos.jason.myandroiddemos.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by xude1 on 16/7/2.
 */
class ParcelableDeveloper implements Parcelable {
    String name;
    int yearsOfExperience;
    List<Skill> skillSet;
    float favoriteFloat;

    public ParcelableDeveloper(String name, int yearsOfExperience, List<Skill> skillSet, float favoriteFloat) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.skillSet = skillSet;
        this.favoriteFloat = favoriteFloat;
    }

    protected ParcelableDeveloper(Parcel in) {
        name = in.readString();
        yearsOfExperience = in.readInt();
        skillSet = in.createTypedArrayList(Skill.CREATOR);
        favoriteFloat = in.readFloat();
    }

    public static final Creator<ParcelableDeveloper> CREATOR = new Creator<ParcelableDeveloper>() {
        @Override
        public ParcelableDeveloper createFromParcel(Parcel in) {
            return new ParcelableDeveloper(in);
        }

        @Override
        public ParcelableDeveloper[] newArray(int size) {
            return new ParcelableDeveloper[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(yearsOfExperience);
        dest.writeTypedList(skillSet);
        dest.writeFloat(favoriteFloat);
    }
}
