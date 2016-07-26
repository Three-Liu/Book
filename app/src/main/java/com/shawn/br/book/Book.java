package com.shawn.br.book;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Book class (For now)
 * Created by Three on 2016/7/9.
 * remove number on 2016/7/22.
 */
public class Book implements Parcelable {
    private String title;
    private byte[] imageId;

    public Book() {
    }

    protected Book(Parcel in) {
        title = in.readString();
        in.readByteArray(imageId);
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

    public byte[] getImageId() {
        return imageId;
    }

    public void setImageId(byte[] imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeByteArray(this.imageId);
    }
}
