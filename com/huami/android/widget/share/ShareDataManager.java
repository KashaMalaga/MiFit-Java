package com.huami.android.widget.share;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import cn.com.smartdevices.bracelet.d.a.d;
import cn.com.smartdevices.bracelet.d.a.e;
import cn.com.smartdevices.bracelet.d.a.f;
import com.c.a.C0993k;
import com.c.a.r;
import java.util.ArrayList;
import java.util.List;

public class ShareDataManager {
    public static final boolean a = false;
    private static final String b = "ShareDataManager";
    private static final String c = "share_data";
    private static final String d = "total_share_cache";
    private SharedPreferences e;
    private f f;
    private boolean g;
    private boolean h;
    private C0993k i;

    @f(a = "shared_data")
    public class SharedData extends d implements Parcelable {
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        public static final String k = "shared_id";
        public static final String l = "shared_type";
        @e(a = "shared_id", b = true)
        public Long m;
        @e(a = "shared_type")
        public int n;

        public SharedData(int i) {
            this.n = i;
        }

        public SharedData(Parcel parcel) {
            this.m = Long.valueOf(parcel.readLong());
            this.n = parcel.readInt();
        }

        public boolean a(Cursor cursor) {
            if (cursor == null) {
                return ShareDataManager.a;
            }
            int columnIndex = cursor.getColumnIndex(k);
            if (columnIndex < 0) {
                return ShareDataManager.a;
            }
            this.m = Long.valueOf(cursor.getLong(columnIndex));
            columnIndex = cursor.getColumnIndex(l);
            if (columnIndex < 0) {
                return ShareDataManager.a;
            }
            this.n = cursor.getInt(columnIndex);
            return true;
        }

        public ContentValues b() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(k, this.m);
            contentValues.put(l, Integer.valueOf(this.n));
            return contentValues;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.m.longValue());
            parcel.writeInt(this.n);
        }
    }

    private ShareDataManager() {
        this.f = null;
        this.g = a;
        this.h = a;
        this.i = null;
    }

    public static ShareDataManager a() {
        return d.a;
    }

    private void b(Context context) {
        if (!this.h) {
            a(context);
        }
    }

    private boolean c(Context context) {
        return this.e.edit().putInt(d, this.e.getInt(d, 0) + 1).commit();
    }

    private Integer d(Context context) {
        return Integer.valueOf(this.e.getInt(d, 0));
    }

    private void e(Context context) {
        if (this.e.contains(d)) {
            this.g = true;
        } else {
            v.a(context, true, new a(this));
        }
    }

    private void f(Context context) {
        List<SharedData> d = this.f.d();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (SharedData sharedData : d) {
            g gVar = new g(sharedData.n);
            int indexOf = arrayList.indexOf(gVar);
            if (indexOf != -1) {
                gVar = (g) arrayList.get(indexOf);
                gVar.b++;
            } else {
                gVar.b++;
                arrayList.add(gVar);
            }
            arrayList2.add(sharedData);
        }
        if (this.i == null) {
            this.i = new r().i();
        }
        v.a(context, this.i.b(arrayList, new b(this).getType()), true, new c(this, arrayList2));
    }

    public void a(Context context) {
    }

    public void a(Context context, int i) {
    }
}
