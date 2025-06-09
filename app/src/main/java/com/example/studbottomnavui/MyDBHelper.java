package com.example.studbottomnavui;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="SCHOOL.db";
    private static final int DATABASE_VERSION=2;
    public MyDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlStatement = "CREATE TABLE STUDENT ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "SNO CHAR(10), "
                + "SNAME CHAR(10), "
                + "YEAR INTEGER, "
                + "DEPT CHAR(20))";

        sqLiteDatabase.execSQL(sqlStatement);
        //초기 데이터 적재
        String SQLStatement = "INSERT INTO STUDENT VALUES(null, '2022219001', '손흥민', 3, '스마트')";
        sqLiteDatabase.execSQL(SQLStatement);
        sqLiteDatabase.execSQL("INSERT INTO STUDENT VALUES(null, '2022219002', '김민재', 2, '스마트')");
        sqLiteDatabase.execSQL("INSERT INTO STUDENT VALUES(null, '2022219003', '황인범', 1, '컴퓨터')");
        sqLiteDatabase.execSQL("INSERT INTO STUDENT VALUES(null, '2022219004', '박지성', 2, '스마트')");
        sqLiteDatabase.execSQL("INSERT INTO STUDENT VALUES(null, '2022219005', '박주영', 2, '컴퓨터')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS STUDENT");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}