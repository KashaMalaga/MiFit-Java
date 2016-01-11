package cn.com.smartdevices.bracelet.relation.db;

import android.content.ContentValues;
import android.database.Cursor;
import cn.com.smartdevices.bracelet.d.a.d;
import cn.com.smartdevices.bracelet.d.a.e;
import cn.com.smartdevices.bracelet.d.a.f;

@f(a = "friend_detail")
public class a extends d {
    public static final String b = "user_id";
    public static final String c = "step";
    public static final String d = "shallow_sleep";
    public static final String e = "deep_sleep";
    public static final String f = "create_time";
    public static final String g = "distance";
    public static final String h = "calorie";
    public static final String i = "sleep_time";
    public static final String j = "wake_time";
    @e(a = "user_id")
    public long k = 0;
    @e(a = "step")
    public int l;
    @e(a = "deep_sleep")
    public int m;
    @e(a = "shallow_sleep")
    public int n;
    @e(a = "create_time")
    public long o;
    @e(a = "distance")
    public int p;
    @e(a = "calorie")
    public int q;
    @e(a = "sleep_time")
    public long r;
    @e(a = "wake_time")
    public long s;

    public boolean a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        int columnIndex = cursor.getColumnIndex(b);
        if (columnIndex < 0) {
            return false;
        }
        this.k = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(c);
        if (columnIndex < 0) {
            return false;
        }
        this.l = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(e);
        if (columnIndex < 0) {
            return false;
        }
        this.m = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(d);
        if (columnIndex < 0) {
            return false;
        }
        this.n = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(f);
        if (columnIndex < 0) {
            return false;
        }
        this.o = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(g);
        if (columnIndex < 0) {
            return false;
        }
        this.p = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(h);
        if (columnIndex < 0) {
            return false;
        }
        this.q = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(i);
        if (columnIndex < 0) {
            return false;
        }
        this.r = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(j);
        if (columnIndex < 0) {
            return false;
        }
        this.s = cursor.getLong(columnIndex);
        return true;
    }

    public ContentValues b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b, Long.valueOf(this.k));
        contentValues.put(c, Integer.valueOf(this.l));
        contentValues.put(d, Integer.valueOf(this.n));
        contentValues.put(e, Integer.valueOf(this.m));
        contentValues.put(f, Long.valueOf(this.o));
        contentValues.put(g, Integer.valueOf(this.p));
        contentValues.put(h, Integer.valueOf(this.q));
        contentValues.put(i, Long.valueOf(this.r));
        contentValues.put(j, Long.valueOf(this.s));
        return contentValues;
    }
}
