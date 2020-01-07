package br.com.philippesis.androidjunit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "junit-test.db";
    static final int VERSION = 1;
    private StringBuilder createMessageTable = new StringBuilder();
    private List<String> scripts = new ArrayList<>();

    DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        createMessageTable.append("CREATE TABLE ").append(MessageEnum.TABLE_NAME.getValue())
                .append("( ").append(MessageEnum.ID.getValue()).append(" INTEGER PRIMARY KEY")
                .append(", ").append(MessageEnum.MESSAGE.getValue()).append(" TEXT")
                .append(", ").append(MessageEnum.STATUS.getValue()).append(" TINYINT").append(" )");

        scripts.add(createMessageTable.toString());

        for(String script:scripts) { db.execSQL(script); }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
