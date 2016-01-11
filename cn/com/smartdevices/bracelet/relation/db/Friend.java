package cn.com.smartdevices.bracelet.relation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import cn.com.smartdevices.bracelet.d.a.d;
import cn.com.smartdevices.bracelet.d.a.e;
import cn.com.smartdevices.bracelet.d.a.f;
import com.xiaomi.e.a;

@f(a = "friend")
public class Friend extends d implements Parcelable {
    public static final Creator<Friend> CREATOR = new c();
    public static final String b = "user_id";
    public static final String c = "username";
    public static final String d = "weight";
    public static final String e = "step";
    public static final String f = "sleep";
    public static final String g = "updateTime";
    public static final String h = "icon";
    public static final String i = "careByHim";
    public static final String j = "careByMe";
    public static final String k = "detail_update_time";
    public static final String l = "remark_name";
    public static final String m = "create_time";
    @e(a = "user_id", b = true)
    public long n;
    @e(a = "username")
    public String o;
    @e(a = "icon")
    public String p;
    @e(a = "weight")
    public int q = 0;
    @e(a = "step")
    public int r = 0;
    @e(a = "sleep")
    public int s = 0;
    @e(a = "careByHim")
    public int t = 0;
    @e(a = "careByMe")
    public int u = 0;
    @e(a = "updateTime")
    public long v = 0;
    @e(a = "detail_update_time")
    public long w = 0;
    @e(a = "remark_name")
    public String x = null;
    @e(a = "create_time")
    public long y = 0;

    public Friend(long j) {
        this.n = j;
    }

    public Friend(Parcel parcel) {
        this.n = parcel.readLong();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.t = parcel.readInt();
        this.u = parcel.readInt();
        this.v = parcel.readLong();
        this.w = parcel.readLong();
        this.x = parcel.readString();
        this.y = parcel.readLong();
    }

    public boolean a(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        int columnIndex = cursor.getColumnIndex(b);
        if (columnIndex < 0) {
            return false;
        }
        this.n = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(c);
        if (columnIndex < 0) {
            return false;
        }
        this.o = cursor.getString(columnIndex);
        columnIndex = cursor.getColumnIndex(h);
        if (columnIndex < 0) {
            return false;
        }
        this.p = cursor.getString(columnIndex);
        columnIndex = cursor.getColumnIndex(d);
        if (columnIndex < 0) {
            return false;
        }
        this.q = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(e);
        if (columnIndex < 0) {
            return false;
        }
        this.r = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(f);
        if (columnIndex < 0) {
            return false;
        }
        this.s = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(i);
        if (columnIndex < 0) {
            return false;
        }
        this.t = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(j);
        if (columnIndex < 0) {
            return false;
        }
        this.u = cursor.getInt(columnIndex);
        columnIndex = cursor.getColumnIndex(g);
        if (columnIndex < 0) {
            return false;
        }
        this.v = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(k);
        if (columnIndex < 0) {
            return false;
        }
        this.w = cursor.getLong(columnIndex);
        columnIndex = cursor.getColumnIndex(l);
        if (columnIndex < 0) {
            return false;
        }
        this.x = cursor.getString(columnIndex);
        columnIndex = cursor.getColumnIndex(m);
        if (columnIndex < 0) {
            return false;
        }
        this.y = cursor.getLong(columnIndex);
        return true;
    }

    public ContentValues b() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(b, Long.valueOf(this.n));
        contentValues.put(c, this.o);
        contentValues.put(h, this.p);
        contentValues.put(d, Integer.valueOf(this.q));
        contentValues.put(e, Integer.valueOf(this.r));
        contentValues.put(f, Integer.valueOf(this.s));
        contentValues.put(i, Integer.valueOf(this.t));
        contentValues.put(j, Integer.valueOf(this.u));
        contentValues.put(g, Long.valueOf(this.v));
        contentValues.put(k, Long.valueOf(this.w));
        contentValues.put(l, this.x);
        contentValues.put(m, Long.valueOf(this.y));
        return contentValues;
    }

    public String c() {
        return (this.x == null || a.f.equals(this.x)) ? this.o : this.x;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.n == ((Friend) obj).n;
    }

    public int hashCode() {
        return ((int) (this.n ^ (this.n >>> 32))) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
        parcel.writeString(this.x);
        parcel.writeLong(this.y);
    }
}
