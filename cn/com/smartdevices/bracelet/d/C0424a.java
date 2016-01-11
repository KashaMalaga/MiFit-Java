package cn.com.smartdevices.bracelet.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import cn.com.smartdevices.bracelet.C0596r;

public abstract class C0424a extends SQLiteOpenHelper {
    private static final String a = "origin_db";
    private static final int b = 14;
    private static final int c = 14;

    public C0424a(Context context) {
        super(context, a, null, c);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        D.b(sQLiteDatabase);
        A.b(sQLiteDatabase);
        C0426c.b(sQLiteDatabase);
        if (sQLiteDatabase.getVersion() <= 11) {
            C0433j.b(sQLiteDatabase);
        }
    }

    private void c() {
        try {
            close();
        } catch (IllegalStateException e) {
            C0596r.a("DB", e.getMessage());
        }
    }

    protected SQLiteDatabase a(boolean z) {
        if (!z) {
            return super.getReadableDatabase();
        }
        try {
            return super.getWritableDatabase();
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
            return z ? super.getWritableDatabase() : super.getReadableDatabase();
        }
    }

    protected void a() {
        C0596r.e("DB", "dropAllDataTable");
        SQLiteDatabase a = a(true);
        D.a(a);
        A.a(a);
        C0426c.a(a);
        if (a.getVersion() <= 11) {
            C0433j.a(a);
        }
    }

    protected void b() {
        c();
        try {
            a(false);
        } catch (SQLiteException e) {
            C0596r.a("DB", e.getMessage());
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C0596r.e("DB", "onCreate");
        a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        super.onDowngrade(sQLiteDatabase, i, i2);
        C0596r.e("DB", "onDowngrade  oldVersion = " + i + "  newVersion = " + i2);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0596r.e("DB", "onUpgrade  oldVersion = " + i + "  newVersion = " + i2);
        if (i2 >= 2) {
            a(sQLiteDatabase);
        }
        D.a(sQLiteDatabase, i, i2);
        C0433j.a(sQLiteDatabase, i2, i);
        A.a(sQLiteDatabase, i2, i);
        C0426c.a(sQLiteDatabase, i, i2);
    }
}
