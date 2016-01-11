package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;
import com.amap.api.mapcore.util.ad.a;

public class ap implements aq<ad> {
    private static String a = ai.f;
    private static String b = ai.g;
    private static String c = ai.k;
    private static String d = ai.h;
    private static String e = ai.i;
    private static String f = ai.j;
    private ad g = null;

    public static String a(String str) {
        return a + "='" + au.a(str) + "'";
    }

    private String a(String[] strArr) {
        String str = null;
        if (strArr != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : strArr) {
                    stringBuilder.append(append).append(";");
                }
                str = stringBuilder.toString();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str;
    }

    private String[] b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        return c + "=1";
    }

    public ad a(Cursor cursor) {
        boolean z = true;
        ad adVar = null;
        try {
            String b = au.b(cursor.getString(1));
            String b2 = au.b(cursor.getString(2));
            String b3 = au.b(cursor.getString(3));
            String[] b4 = b(au.b(cursor.getString(4)));
            String b5 = au.b(cursor.getString(5));
            if (cursor.getInt(6) == 0) {
                z = false;
            }
            adVar = new a(b, b2, b3).a(z).a(b5).a(b4).a();
        } catch (v e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return adVar;
    }

    public String a() {
        return ai.a;
    }

    public void a(ad adVar) {
        this.g = adVar;
    }

    public ContentValues b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.g == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(a, au.a(this.g.a()));
                contentValues2.put(b, au.a(this.g.b()));
                contentValues2.put(c, Boolean.valueOf(this.g.e()));
                contentValues2.put(d, au.a(this.g.c()));
                contentValues2.put(f, au.a(this.g.d()));
                contentValues2.put(e, au.a(a(this.g.f())));
                return contentValues2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                contentValues = contentValues2;
                th = th3;
                th.printStackTrace();
                return contentValues;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return contentValues;
        }
    }

    public /* synthetic */ Object b(Cursor cursor) {
        return a(cursor);
    }
}
