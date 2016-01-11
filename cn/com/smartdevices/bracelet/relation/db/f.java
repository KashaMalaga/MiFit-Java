package cn.com.smartdevices.bracelet.relation.db;

import android.content.ContentValues;
import android.database.Cursor;
import cn.com.smartdevices.bracelet.d.a.d;
import cn.com.smartdevices.bracelet.d.a.e;

@cn.com.smartdevices.bracelet.d.a.f(a = "relation_message")
public class f extends d {
    public static final String b = "from_user_id";
    public static final String c = "from_user_name";
    public static final String d = "update_time";
    public static final String e = "type";
    public static final String f = "count";
    public static final String g = "status";
    public static final String h = "icon";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    public static final int p = 3;
    @e(a = "from_user_id")
    public long q = 0;
    @e(a = "from_user_name")
    public String r;
    @e(a = "update_time")
    public long s;
    @e(a = "type")
    public int t;
    @e(a = "count")
    public int u;
    @e(a = "status")
    public int v;
    @e(a = "icon")
    public String w;

    public boolean a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        int columnIndex = cursor.getColumnIndex(b);
        if (columnIndex < 0) {
            return false;
        }
        this.q = (long) cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(c);
        if (columnIndex < 0) {
            return false;
        }
        this.r = cursor.getString(columnIndex);
        columnIndex = cursor.getColumnIndex(d);
        if (columnIndex < 0) {
            return false;
        }
        this.s = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(e);
        if (columnIndex < 0) {
            return false;
        }
        this.t = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(f);
        if (columnIndex < 0) {
            return false;
        }
        this.u = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(g);
        if (columnIndex < 0) {
            return false;
        }
        this.v = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(h);
        if (columnIndex < 0) {
            return false;
        }
        this.w = cursor.getString(columnIndex);
        return true;
    }

    public ContentValues b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b, Long.valueOf(this.q));
        contentValues.put(c, this.r);
        contentValues.put(d, Long.valueOf(this.s));
        contentValues.put(e, Integer.valueOf(this.t));
        contentValues.put(f, Integer.valueOf(this.u));
        contentValues.put(g, Integer.valueOf(this.v));
        contentValues.put(h, this.w);
        return contentValues;
    }
}
