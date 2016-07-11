package com.shawn.br;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Person class (For now)
 * Created by Three on 2016/7/9.
 * version
 *      0.1 - 7/9 (Build by Three)
 */
public class Person implements Parcelable {
    private String name = "Default";
    private String major;
    private String gender;
    private String grade;
    private int imageId;

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Person() {
        super();
    }

    @Override
    public String toString() {
        return name + '\n' + '\n' + major + '\n' + grade + '\n';
    }

    public Person(String name, String number, String major, String grade) {
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    public Person(Parcel source) {
        this.name = source.readString();
        this.major = source.readString();
        this.grade = source.readString();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.major);
        dest.writeString(this.grade);
    }


    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {

        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[0];
        }
    };
}
