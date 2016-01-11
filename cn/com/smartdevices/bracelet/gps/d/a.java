package cn.com.smartdevices.bracelet.gps.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a extends SQLiteOpenHelper {
    private static final String a = "gpsdebug.db";
    private static final int b = 1;
    private static final String c = "CREATE TABLE gpsdebug (_id INTEGER PRIMARY KEY, track_id INTEGER, latitude REAL, longtitude REAL)";
    private static final String d = "DROP TABLE IF EXISTS gpsdebug";

    public a(Context context) {
        super(context.getApplicationContext(), a, null, b);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(c);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(d);
        onCreate(sQLiteDatabase);
    }
}
