package com.shawn.br.data;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shawn.br.book.Book;

import java.io.IOException;

/**
 * This class only provide necessary methods for this app
 * <p>
 * Created by Three on 2016/7/22.
 */
public class DBOperate {
    private static DataBase myDataBase;
    private static SQLiteDatabase sqLiteDatabase;

    public static void getContext(Context context) {
        myDataBase = new DataBase(context, 1);
        sqLiteDatabase = myDataBase.getWritableDatabase();
    }

    /**
     * The insertData method of DataBaseOperate (BOOKTABLE)
     * this method is use to insert new Data
     * @param book Book OBJECT
     * @throws IOException if an error occurred
     *                     Log.e("insert DB","Transform error from image to picture");
     */
    public static void insertData(Book book) throws IOException {
        sqLiteDatabase.execSQL("insert into " + BookTable.NAME + " values (?,?)",
                new Object[]{book.getTitle(), book.getImageId()});
    }
    /**
     * The insertData method of DataBaseOperate (BOOKTABLE)
     * this method is use to search a line or lines
     * @param bookTitle bookTitle bookname
     * @return Cursor use Cursor to get column data
     */
    public static Cursor searchData(String bookTitle) {
        return sqLiteDatabase.rawQuery("select * from " + BookTable.NAME
                + " where " + BookTable.TITLE + " = ?", new String[]{bookTitle});
    }

//    public static void insertData()
}
