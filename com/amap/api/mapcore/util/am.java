package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class am implements aq<an> {
    private static final String a = ai.l;
    private static final String b = ai.m;
    private static final String c = ai.n;
    private static final String d = ai.f;
    private an e = null;

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(b).append("=").append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(a).append("='").append(str).append("'");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public an a(Cursor cursor) {
        Throwable th;
        an anVar = null;
        if (cursor == null) {
            return null;
        }
        try {
            String string = cursor.getString(1);
            int i = cursor.getInt(2);
            String string2 = cursor.getString(4);
            int i2 = cursor.getInt(3);
            an anVar2 = new an();
            try {
                anVar2.a(string);
                anVar2.a(i);
                anVar2.b(au.b(string2));
                anVar2.b(i2);
                return anVar2;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                anVar = anVar2;
                th = th3;
                th.printStackTrace();
                return anVar;
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            return anVar;
        }
    }

    public void a(an anVar) {
        this.e = anVar;
    }

    public ContentValues b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.e == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(a, this.e.b());
                contentValues2.put(b, Integer.valueOf(this.e.a()));
                contentValues2.put(d, au.a(this.e.c()));
                contentValues2.put(c, Integer.valueOf(this.e.d()));
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
