package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.database.Cursor;

public class as implements aq<at> {
    private static final String b = ai.o;
    private static final String c = ai.p;
    private static final String d = ai.q;
    private at a = null;

    public at a(Cursor cursor) {
        at atVar;
        Throwable th;
        boolean z = true;
        try {
            int i = cursor.getInt(1);
            int i2 = cursor.getInt(2);
            int i3 = cursor.getInt(3);
            boolean z2 = i != 0;
            boolean z3 = i2 != 0;
            if (i3 == 0) {
                z = false;
            }
            atVar = new at();
            try {
                atVar.a(z2);
                atVar.c(z);
                atVar.b(z3);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return atVar;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            atVar = null;
            th = th4;
            th.printStackTrace();
            return atVar;
        }
        return atVar;
    }

    public String a() {
        return ai.e;
    }

    public void a(at atVar) {
        this.a = atVar;
    }

    public ContentValues b() {
        Throwable th;
        ContentValues contentValues = null;
        try {
            if (this.a == null) {
                return null;
            }
            ContentValues contentValues2 = new ContentValues();
            try {
                contentValues2.put(b, Boolean.valueOf(this.a.a()));
                contentValues2.put(c, Boolean.valueOf(this.a.b()));
                contentValues2.put(d, Boolean.valueOf(this.a.c()));
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
