package com.shawn.br.data;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Three on 2016/7/14.
 */
public class BitmapByte {
    public static byte[] picToarray(Bitmap bitmap) throws IOException {
        int size = bitmap.getHeight()*bitmap.getWidth()*4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
        bitmap.compress(Bitmap.CompressFormat.PNG,100,byteArrayOutputStream);
        byte[] array = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return array;
    }

    public static Bitmap arrayTopic(byte[] array){
        return BitmapFactory.decodeByteArray(array,0,array.length);
    }
}
