package com.xiaomi.mistatistic.sdk.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.d.C0430g;
import cn.com.smartdevices.bracelet.d.C0432i;
import cn.com.smartdevices.bracelet.gps.services.ay;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.xiaomi.e.a;
import com.xiaomi.mistatistic.sdk.c.i;

public class t {
    private static B a;

    public static i a(Cursor cursor) {
        i iVar = new i();
        long j = cursor.getLong(2);
        String string = cursor.getString(4);
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(1);
        String string4 = cursor.getString(3);
        String string5 = cursor.getString(6);
        i iVar2 = new i();
        iVar2.a = string3;
        iVar2.c = string4;
        iVar2.e = string;
        iVar2.b = j;
        iVar2.d = string2;
        iVar2.f = string5;
        return iVar2;
    }

    public static void a() {
        a = new B(C1125b.a());
    }

    public i a(String str, String str2) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        try {
            i a;
            Cursor query = a.getReadableDatabase().query("mistat_event", null, "category=? AND key=?", new String[]{str, str2}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a = a(query);
                        if (query != null) {
                            return a;
                        }
                        query.close();
                        return a;
                    }
                } catch (SQLiteException e) {
                    cursor = query;
                    if (cursor != null) {
                        return null;
                    }
                    cursor.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            a = null;
            if (query != null) {
                return a;
            }
            query.close();
            return a;
        } catch (SQLiteException e2) {
            cursor = null;
            if (cursor != null) {
                return null;
            }
            cursor.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void a(long j) {
        try {
            a.getWritableDatabase().delete("mistat_event", "ts<=?", new String[]{String.valueOf(j)});
        } catch (Throwable e) {
            new A().a("Error while deleting event by ts from DB", e);
        }
    }

    public void a(i iVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(WidgetRequestParam.REQ_PARAM_COMMENT_CATEGORY, iVar.a);
        contentValues.put(C0430g.b, TextUtils.isEmpty(iVar.c) ? a.f : iVar.c);
        contentValues.put(ay.H, Long.valueOf(iVar.b));
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, TextUtils.isEmpty(iVar.d) ? a.f : iVar.d);
        contentValues.put(C0432i.b, TextUtils.isEmpty(iVar.e) ? a.f : iVar.e);
        contentValues.put(com.xiaomi.channel.relationservice.data.a.G, TextUtils.isEmpty(iVar.f) ? a.f : iVar.f);
        try {
            a.getWritableDatabase().insert("mistat_event", a.f, contentValues);
        } catch (Throwable e) {
            new A().a("Error to insert data into DB, key=" + iVar.c, e);
        }
    }

    public void a(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(C0432i.b, str3);
        try {
            a.getWritableDatabase().update("mistat_event", contentValues, "category=? AND key=?", new String[]{str2, str});
        } catch (Throwable e) {
            new A().a("Error to update data from DB, key=" + str, e);
        }
    }

    public Cursor b() {
        try {
            return a.getReadableDatabase().query("mistat_event", null, null, null, null, null, "ts DESC");
        } catch (Throwable e) {
            new A().a("Error while reading data from DB", e);
            return null;
        }
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        try {
            a.getWritableDatabase().delete("mistat_event", "ts<=? and category <> ?", new String[]{String.valueOf(currentTimeMillis), "mistat_basic"});
        } catch (Throwable e) {
            new A().a("Error while deleting old data from DB", e);
        }
    }

    public int d() {
        Throwable e;
        Cursor cursor = null;
        Cursor query;
        try {
            query = a.getReadableDatabase().query("mistat_event", new String[]{"count(*)"}, null, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (query == null) {
                            return i;
                        }
                        query.close();
                        return i;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        new A().a("Error while getting count from DB", e);
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    } catch (Throwable th) {
                        e = th;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            new A().a("Error while getting count from DB", e);
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw e;
        }
        return 0;
    }
}
