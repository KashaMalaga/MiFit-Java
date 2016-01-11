package com.xiaomi.market.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class w extends SQLiteOpenHelper {
    static final String a = "xiaomi_market_sdk_update.db";
    static final int b = 1;
    private static w c = null;
    private static final String d = "MarketSDKDatabaseHelper";

    private w(Context context) {
        super(context, a, null, b);
    }

    public static w a(Context context) {
        if (c == null) {
            c = new w(context);
        }
        return c;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(q.k);
    }

    public long a(ContentValues contentValues) {
        SQLiteStatement compileStatement = getWritableDatabase().compileStatement("INSERT OR REPLACE INTO update_download(package_name,download_id,version_code,apk_url,apk_hash,diff_url,diff_hash,apk_path) VALUES(?,?,?,?,?,?,?,?)");
        compileStatement.bindString(b, contentValues.getAsString(q.c));
        compileStatement.bindLong(2, contentValues.getAsLong(q.d).longValue());
        compileStatement.bindLong(3, (long) contentValues.getAsInteger(q.e).intValue());
        compileStatement.bindString(4, contentValues.getAsString(q.f));
        compileStatement.bindString(5, contentValues.getAsString(q.g));
        compileStatement.bindString(6, contentValues.getAsString(q.h));
        compileStatement.bindString(7, contentValues.getAsString(q.i));
        compileStatement.bindString(8, contentValues.getAsString(q.j));
        compileStatement.execute();
        return 1;
    }

    public synchronized long a(String str, ContentValues contentValues) {
        return getWritableDatabase().insert(str, null, contentValues);
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return getReadableDatabase().query(str, strArr, str2, strArr2, str3, str4, str5);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.d(d, "create database");
        a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
