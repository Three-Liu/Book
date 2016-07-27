package com.shawn.br.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.shawn.br.data.database.table.BookTable;

/**
 * Created by Three on 2016/7/14.
 */
public class DataBase extends SQLiteOpenHelper {

    public static final String DB_NAME= "appDB.db";

    public DataBase(Context context,int DB_Version) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ BookTable.TABLENAME +"( " +
                                BookTable.TITLE + " TEXT PRIMARY KEY " + " NOT NULL,"+
                                        BookTable.IMAGE + " BLOB NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+BookTable.TABLENAME);
        onCreate(sqLiteDatabase);
    }
    public static SQLiteDatabase getSqliteDatabase(Context context){
        return new DataBase(context,1).getWritableDatabase();
    }
}
