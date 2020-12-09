package com.eslam.notestakersql_litedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Notes_List.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_list";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "note_title";
    private static final String COLUMN_DESCRIPTION = "note_description";
    private final Context context;

    public MyDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase dp, int i, int i1) {
        dp.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(dp);
    }

    void addNote(String title, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESCRIPTION, description);

        Long result = db.insert(TABLE_NAME, null, cv);
        if (result==-1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(context, "Added Successfully!!", Toast.LENGTH_SHORT).show();
        }
    }
}
