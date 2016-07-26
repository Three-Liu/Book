package com.shawn.br.person;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shawn.br.R;

/**
 * Person class (For now)
 * Created by Three on 2016/7/9.
 * version
 *      0.1 - 7/9 (Build by Three)
 * version
 *      0.2 - 7/21 (Build by Three)
 *      remove major,grade attr
 */
public class Person implements Parcelable {
    private String name = "Default";
    private String gender;
    private int imageId;

    public String getStorageOfBook() {
        return storageOfBook;
    }

    public void setStorageOfBook(String storageOfBook) {
        this.storageOfBook = storageOfBook;
    }

    private String storageOfBook = new String();
    //    private String major;
    //    private String grade;

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

//    @Override
//    public String toString() {
//        return name + '\n' + '\n' + major + '\n' + grade + '\n';
//    }

//    public Person(String name, String number, String major, String grade) {
//        this.name = name;
//        this.major = major;
//        this.grade = grade;
//    }

    public Person(Parcel source) {
        this.name = source.readString();
        this.gender = source.readString();
        this.imageId = source.readInt();
        this.storageOfBook = source.readString();
//        this.major = source.readString();
//        this.grade = source.readString();
    }

//    public String getMajor() {
//        return major;
//    }

//    public void setMajor(String major) {
//        this.major = major;
//    }

//    public String getGrade() {
//        return grade;
//    }

//    public void setGrade(String grade) {
//        this.grade = grade;
//    }

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
        dest.writeString(this.gender);
        dest.writeInt(this.imageId);
        dest.writeString(this.storageOfBook);
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
