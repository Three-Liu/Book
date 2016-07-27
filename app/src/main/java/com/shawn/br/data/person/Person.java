package com.shawn.br.data.person;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Person class (For now)
 * Created by Three on 2016/7/9.
 * version
 * 0.1 - 7/9 (Build by Three)
 * version
 * 0.2 - 7/21 (Build by Three)
 * remove major,grade attr
 */
public class Person implements Parcelable {
    private String name;
    private String gender;
    private String storageOfBook = new String();
    private byte[] imageId;

    //constructor
    public Person() {
        super();
    }

    public Person(Parcel source) {
        this.name = source.readString();
        this.gender = source.readString();
        this.storageOfBook = source.readString();
        source.readByteArray(this.imageId);
    }

    public Person(String name, String gender, String storageOfBook, byte[] imageId) {
        this.name = name;
        this.gender = gender;
        this.storageOfBook = storageOfBook;
        this.imageId = imageId;
    }

    //getter and setter

    public String getStorageOfBook() {
        return storageOfBook;
    }

    public void setStorageOfBook(String storageOfBook) {
        this.storageOfBook = storageOfBook;
    }

    public byte[] getImageId() {
        return imageId;
    }

    public void setImageId(byte[] imageId) {
        this.imageId = imageId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        dest.writeString(this.gender);
        dest.writeString(this.storageOfBook);
        dest.writeByteArray(this.imageId);
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
