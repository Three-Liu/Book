package com.shawn.br.book;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Book class (For now)
 * Created by Three on 2016/7/9.
 * version
 *      0.1 - 7/9 (Build by Three)
 */
public class Book implements Parcelable {
    private String name;

    private String number = "default";
    //maybe this attr no need

    private int imageId;

    public Book() {
    }

    protected Book(Parcel in) {
        name = in.readString();
        number = in.readString();
        imageId = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        dest.writeString(this.number);
        dest.writeInt(this.imageId);
    }
}
