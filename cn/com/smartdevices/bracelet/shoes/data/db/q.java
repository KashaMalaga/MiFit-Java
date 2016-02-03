package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.model.a;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.model.k;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.open.SocialConstants;
import com.xiaomi.account.openauth.h;
import java.util.ArrayList;
import java.util.List;

final class q {
    private static final String a = "SDB";

    private q() {
    }

    private static ContentValues a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(g.a, Long.valueOf(aVar.q()));
        contentValues.put(g.q, k.a(aVar.j()));
        if (!TextUtils.isEmpty(aVar.n())) {
            contentValues.put(g.p, k.a(aVar.n()));
        }
        if (!TextUtils.isEmpty(aVar.f())) {
            contentValues.put(g.t, k.a(aVar.f()));
        }
        contentValues.put(b.e, k.a(aVar.m()));
        contentValues.put(h.k, Integer.valueOf(aVar.p()));
        contentValues.put(h.N, Integer.valueOf(aVar.b()));
        contentValues.put(SocialConstants.PARAM_SUMMARY, aVar.h().toString());
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(aVar.o()));
        contentValues.put(CaptureActivity.n, aVar.c());
        return contentValues;
    }

    private static Uri a(Uri uri, String str, String str2, String str3, String str4) {
        return uri.buildUpon().appendQueryParameter(g.q, str).appendQueryParameter(g.p, str2).appendQueryParameter(b.e, str3).appendQueryParameter(g.t, str4).build();
    }

    public static a a(Context context) {
        return a(context, k.SYNC_STATE_DEFAULT);
    }

    public static a a(Context context, c cVar, k kVar) {
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null || cVar == null || cVar.e() || kVar == null) {
            throw new IllegalArgumentException();
        }
        try {
            String[] strArr;
            SQLiteDatabase a = s.a(context).a(false);
            String str = "(mac=? AND sn=? OR mac=? AND sn='')";
            if (k.SYNC_STATE_DEFAULT.equals(kVar)) {
                strArr = new String[]{cVar.b(), cVar.d(), cVar.b()};
            } else {
                str = str + " AND synced=?";
                strArr = new String[]{cVar.b(), cVar.d(), cVar.b(), String.valueOf(kVar.a())};
            }
            query = a.query(c.a, null, str, strArr, null, null, "date DESC ");
            try {
                List a2 = a(query);
                if (a2.size() == 0) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                a aVar = (a) a2.get(0);
                if (query == null) {
                    return aVar;
                }
                query.close();
                return aVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.d(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.d(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static a a(Context context, k kVar) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null || kVar == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        List arrayList = new ArrayList(2);
        if (k.SYNC_STATE_DEFAULT.equals(kVar)) {
            stringBuilder.append("state=?");
            arrayList.add(String.valueOf(1));
        } else {
            stringBuilder.append("synced=? AND state=?");
            arrayList.add(String.valueOf(kVar.a()));
            arrayList.add(String.valueOf(1));
        }
        Cursor query;
        try {
            query = s.a(context).a(false).query(c.a, null, stringBuilder.length() > 0 ? stringBuilder.toString() : null, arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[arrayList.size()]) : null, null, null, "date DESC ");
            try {
                List a = a(query);
                if (a.size() == 0) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                a aVar = (a) a.get(0);
                if (query == null) {
                    return aVar;
                }
                query.close();
                return aVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.d(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.d(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static List<a> a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return new ArrayList(0);
        }
        String str = com.xiaomi.e.a.f;
        str = com.xiaomi.e.a.f;
        str = com.xiaomi.e.a.f;
        str = com.xiaomi.e.a.f;
        str = com.xiaomi.e.a.f;
        List<a> arrayList = new ArrayList(cursor.getCount());
        while (cursor.moveToNext()) {
            Object string = cursor.getString(cursor.getColumnIndex(g.q));
            if (!TextUtils.isEmpty(string)) {
                String string2 = cursor.getString(cursor.getColumnIndex(g.p));
                String string3 = cursor.getString(cursor.getColumnIndex(g.t));
                String string4 = cursor.getString(cursor.getColumnIndex(b.e));
                int i = cursor.getInt(cursor.getColumnIndex(h.N));
                int i2 = cursor.getInt(cursor.getColumnIndex(h.k));
                String string5 = cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                long j = cursor.getLong(cursor.getColumnIndex(g.a));
                a a = cn.com.smartdevices.bracelet.shoes.data.c.a(cursor.getString(cursor.getColumnIndex(CaptureActivity.n)), cursor.getInt(cursor.getColumnIndex(com.xiaomi.channel.relationservice.data.a.h)), new c(string, string2, string3, string4));
                a.c(i);
                a.f(i2);
                a.b(string5);
                a.a(j);
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static boolean a(Context context, a aVar) {
        if (aVar == null || context == null) {
            throw new IllegalArgumentException();
        }
        try {
            ContentValues a = a(aVar);
            boolean z = context.getContentResolver().update(a(n.d, aVar.j(), aVar.n(), aVar.m(), aVar.f()), a, null, null) > 0;
            if (z) {
                return z;
            }
            return context.getContentResolver().insert(a(n.e, aVar.j(), aVar.n(), aVar.m(), aVar.f()), a) != null;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, c cVar) {
        if (context == null || cVar == null || cVar.e()) {
            throw new IllegalArgumentException();
        }
        a a = a(context, cVar, k.SYNC_STATE_DEFAULT);
        if (a == null) {
            return true;
        }
        a.w();
        a.f(k.STATE_UNSYNCED.a());
        return a(context, a);
    }

    public static boolean a(Context context, c cVar, String str) {
        if (cVar == null || cVar.e() || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        a a = a(context, cVar, k.SYNC_STATE_DEFAULT);
        if (a == null) {
            return false;
        }
        a.f(str);
        a.x();
        a.f(k.STATE_UNSYNCED.a());
        return a(context, a);
    }

    public static boolean a(Context context, e eVar) {
        c e = eVar.e();
        if (e == null || e.e()) {
            return false;
        }
        a a = a(context, e, k.SYNC_STATE_DEFAULT);
        if (a == null) {
            a = cn.com.smartdevices.bracelet.shoes.data.c.a(eVar.e, eVar.f, e);
        } else {
            a.a(e);
        }
        a.a(eVar.h);
        a.e(eVar.f);
        a.v();
        a.e(cn.com.smartdevices.bracelet.shoes.c.g.a(context));
        a.x();
        a.f(k.STATE_UNSYNCED.a());
        return a(context, a);
    }

    public static List<a> b(Context context) {
        return b(context, null, k.SYNC_STATE_DEFAULT);
    }

    public static List<a> b(Context context, c cVar) {
        return b(context, cVar, k.STATE_UNSYNCED);
    }

    public static List<a> b(Context context, c cVar, k kVar) {
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null || kVar == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        List arrayList = new ArrayList(3);
        if (!k.SYNC_STATE_DEFAULT.equals(kVar)) {
            stringBuilder.append("synced=?");
            arrayList.add(String.valueOf(kVar.a()));
        }
        if (cVar != null) {
            stringBuilder.append(" AND ").append("(mac=? AND ").append("sn=? OR ").append("mac=? AND ").append("sn='')");
            arrayList.add(cVar.b());
            arrayList.add(cVar.d());
            arrayList.add(cVar.b());
        }
        try {
            query = s.a(context).a(false).query(c.a, null, stringBuilder.length() > 0 ? stringBuilder.toString() : null, arrayList.size() > 0 ? (String[]) arrayList.toArray(new String[arrayList.size()]) : null, null, null, "date DESC ");
            try {
                List<a> a = a(query);
                if (query == null) {
                    return a;
                }
                query.close();
                return a;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.d(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.d(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean c(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        try {
            query = s.a(context).a(false).query(c.a, null, null, null, null, null, "date DESC ");
            try {
                List<a> a = a(query);
                if (a.size() == 0) {
                    if (query != null) {
                        query.close();
                    }
                    return false;
                }
                for (a aVar : a) {
                    C0596r.d(a, "printMyShoes: " + aVar.toString());
                }
                if (query == null) {
                    return true;
                }
                query.close();
                return true;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.d(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.d(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean c(Context context, c cVar) {
        if (context == null || cVar == null || cVar.e() || TextUtils.isEmpty(cVar.a())) {
            throw new IllegalArgumentException();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(g.t, cVar.a());
            return context.getContentResolver().update(a(n.d, cVar.b(), cVar.d(), cVar.c(), cVar.a()), contentValues, null, null) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    private static boolean c(Context context, c cVar, k kVar) {
        if (context == null || kVar == null || cVar == null || cVar.e()) {
            throw new IllegalArgumentException();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(h.k, Integer.valueOf(kVar.a()));
            return s.a(context).a(true).update(c.a, contentValues, "(mac=? AND sn=? OR mac=? AND sn='')", new String[]{cVar.b(), cVar.d(), cVar.b()}) > 0;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    public static boolean d(Context context, c cVar) {
        if (context != null && cVar != null && !cVar.e()) {
            return c(context, cVar, k.STATE_SYNCED_FROM_SERVER);
        }
        throw new IllegalArgumentException();
    }

    public static boolean e(Context context, c cVar) {
        if (context != null && cVar != null && !cVar.e()) {
            return c(context, cVar, k.STATE_SYNCED_TO_SERVER);
        }
        throw new IllegalArgumentException();
    }

    public static boolean f(Context context, c cVar) {
        if (context != null) {
            if (((cVar == null ? 1 : 0) | cVar.e()) == 0) {
                return c(context, cVar, k.STATE_UNSYNCED);
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean g(Context context, c cVar) {
        if (cVar == null || cVar.e()) {
            return false;
        }
        a a = a(context, cVar, k.SYNC_STATE_DEFAULT);
        if (a == null) {
            return true;
        }
        a.w();
        a.e(com.xiaomi.e.a.f);
        a.x();
        a.f(k.STATE_UNSYNCED.a());
        return a(context, a);
    }
}
