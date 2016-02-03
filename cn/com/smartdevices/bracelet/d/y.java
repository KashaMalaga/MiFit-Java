package cn.com.smartdevices.bracelet.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.f.c;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.c.a.i;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import cn.com.smartdevices.bracelet.partner.Partner;
import cn.com.smartdevices.bracelet.relation.db.f;
import com.amap.api.location.LocationManagerProxy;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import com.xiaomi.mistatistic.sdk.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kankan.wheel.widget.l;

class y {
    private static final String a = "MDB";

    private y() {
    }

    public static int a(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        String[] strArr = new String[]{str, a.f + c0595q.b()};
        return sQLiteDatabase.delete(E.a, "date>? AND type=?", strArr);
    }

    public static Partner a(SQLiteDatabase sQLiteDatabase, String str) {
        Partner partner = null;
        String[] strArr = new String[]{SocialConstants.PARAM_URL, f.h, SocialConstants.PARAM_TITLE, B.f, B.g, C0430g.d, B.h, cn.com.smartdevices.bracelet.push.f.n, LocationManagerProxy.KEY_STATUS_CHANGED};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(A.a, strArr, "third_app_id = ?", new String[]{str}, partner, partner, partner);
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    partner = Partner.fromCursor(query);
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return partner;
    }

    public static String a(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q, int i) {
        String str2 = null;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, i == 1 ? new String[]{F.j} : new String[]{SocialConstants.PARAM_SUMMARY}, "date=? AND type=?", new String[]{str, String.valueOf(c0595q.b())}, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    str2 = query.getString(0);
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return str2;
    }

    public static String a(SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Throwable th;
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr;
        String[] strArr2 = new String[]{C0432i.b};
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "key=?";
        if (z) {
            str2 = str2 + " AND expire_time>?";
            strArr = new String[]{str, String.valueOf(currentTimeMillis)};
        } else {
            strArr = new String[]{str};
        }
        try {
            Cursor query = sQLiteDatabase.query(C0429f.e, strArr2, str2, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        if (query.moveToNext()) {
                            String string = query.getString(query.getColumnIndex(C0432i.b));
                            if (query == null) {
                                return string;
                            }
                            query.close();
                            return string;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
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

    public static ArrayList<HeartRateItem> a(SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = new String[]{O.j, g.f, com.xiaomi.channel.relationservice.data.a.h};
        String[] strArr2 = new String[]{String.valueOf(i), String.valueOf(0)};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(cn.com.smartdevices.bracelet.shoes.sync.b.g.d, strArr, "type=? AND sync= ?", strArr2, null, null, null);
        try {
            ArrayList<HeartRateItem> fromCursor2Items = HeartRateItem.fromCursor2Items(query);
            return fromCursor2Items;
        } finally {
            query.close();
        }
    }

    public static ArrayList<HeartRateItem> a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String[] strArr = new String[]{String.valueOf(i)};
        String str = cn.com.smartdevices.bracelet.shoes.sync.b.g.d;
        String str2 = i2 + a.f;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(str, new String[]{O.j, g.f}, "type=?", strArr, null, null, "time DESC", str2);
        try {
            ArrayList<HeartRateItem> fromCursor2Items = HeartRateItem.fromCursor2Items(query);
            return fromCursor2Items;
        } finally {
            query.close();
        }
    }

    public static ArrayList<HeartRateItem> a(SQLiteDatabase sQLiteDatabase, int i, long j, long j2) {
        String[] strArr = new String[]{String.valueOf(i), String.valueOf(j - 1), String.valueOf(1 + j2)};
        String str = cn.com.smartdevices.bracelet.shoes.sync.b.g.d;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(str, new String[]{O.j, g.f}, "type=? AND time> ? and time < ?", strArr, null, null, "time ASC");
        try {
            ArrayList<HeartRateItem> fromCursor2Items = HeartRateItem.fromCursor2Items(query);
            return fromCursor2Items;
        } finally {
            query.close();
        }
    }

    public static ArrayList<BasicDateData> a(SQLiteDatabase sQLiteDatabase, C0595q c0595q) {
        ArrayList<BasicDateData> arrayList = null;
        String[] strArr = new String[]{cn.com.smartdevices.bracelet.shoes.sync.b.g.a, b.b, SocialConstants.PARAM_SUMMARY, H.k, F.i, F.j, o.L, com.xiaomi.channel.relationservice.data.a.h};
        String[] strArr2 = new String[]{a.f + c0595q.b(), Constants.VIA_RESULT_SUCCESS};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, strArr, "type=? AND sync=?", strArr2, null, null, "date ASC");
        if (query != null) {
            arrayList = new ArrayList();
            try {
                arrayList.ensureCapacity(query.getCount());
                while (query.moveToNext()) {
                    BasicDateData basicDateData = new BasicDateData();
                    basicDateData.type = query.getInt(query.getColumnIndex(com.xiaomi.channel.relationservice.data.a.h));
                    basicDateData.source = query.getInt(query.getColumnIndex(o.L));
                    basicDateData.date = query.getString(query.getColumnIndex(cn.com.smartdevices.bracelet.shoes.sync.b.g.a));
                    basicDateData.data = query.getBlob(query.getColumnIndex(b.b));
                    basicDateData.summary = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    basicDateData.indexs = query.getString(query.getColumnIndex(H.k));
                    basicDateData.dataHR = query.getBlob(query.getColumnIndex(F.i));
                    basicDateData.summaryHR = query.getString(query.getColumnIndex(F.j));
                    arrayList.add(basicDateData);
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        if (strArr == null) {
            return new HashMap(0);
        }
        Cursor query = sQLiteDatabase.query(C0427d.a, strArr, null, null, null, null, null);
        if (query == null) {
            return new HashMap(0);
        }
        Map<String, String> hashMap = new HashMap(strArr.length);
        try {
            for (String str : strArr) {
                if (C0427d.a(str)) {
                    hashMap.put(str, query.getString(query.getColumnIndex(str)));
                }
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    public static synchronized boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z;
        int i = 0;
        synchronized (y.class) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(3));
            if (((long) sQLiteDatabase.update(cn.com.smartdevices.bracelet.shoes.sync.b.g.d, contentValues, "time=?", new String[]{String.valueOf(j)})) >= 0) {
                i = 1;
            }
            z = i & true;
        }
        return z;
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, BasicDateData basicDateData, int i, C0595q c0595q) {
        return a(sQLiteDatabase, basicDateData.date, basicDateData.data, c0595q, i, basicDateData.summary, basicDateData.indexs);
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, HeartRateItem heartRateItem) {
        Throwable th;
        Cursor cursor;
        int i = 0;
        if (heartRateItem == null) {
            return false;
        }
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("select time from heartrate where time = " + heartRateItem.time, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        C0596r.d(a, "insertHeartRateItem duplicate at:" + heartRateItem.time);
                        if (rawQuery == null) {
                            return false;
                        }
                        rawQuery.close();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (sQLiteDatabase.insert(cn.com.smartdevices.bracelet.shoes.sync.b.g.d, null, heartRateItem.toContentValues()) >= 0) {
                i = 1;
            }
            return i & true;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, int i, String str2) {
        boolean z = true;
        try {
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(LocationManagerProxy.KEY_STATUS_CHANGED, Integer.valueOf(i));
            contentValues.put(SocialConstants.PARAM_URL, str2);
            if (sQLiteDatabase.update(A.a, contentValues, "third_app_id=?", new String[]{str}) <= 0) {
                z = false;
            }
            sQLiteDatabase.setTransactionSuccessful();
            return z;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2, c cVar) {
        boolean z = true;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a = a(sQLiteDatabase, str, false);
        ContentValues contentValues = new ContentValues();
        contentValues.put(C0432i.b, str2);
        contentValues.put(i.d, Integer.valueOf(0));
        long currentTimeMillis = System.currentTimeMillis();
        switch (z.a[cVar.ordinal()]) {
            case l.a /*1*/:
                currentTimeMillis += C0429f.a;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                currentTimeMillis += d.h;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                currentTimeMillis += C0429f.c;
                break;
            default:
                currentTimeMillis = -1;
                break;
        }
        try {
            contentValues.put(C0430g.d, Long.valueOf(currentTimeMillis));
            if (a != null) {
                String[] strArr = new String[]{str};
                if (sQLiteDatabase.update(C0429f.e, contentValues, "key=?", strArr) <= 0) {
                    z = false;
                }
                return z;
            }
            contentValues.put(C0430g.b, str);
            if (sQLiteDatabase.insert(C0429f.e, null, contentValues) <= 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2, C0595q c0595q) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            sQLiteDatabase.execSQL("update date_data set summary = " + str + " where " + cn.com.smartdevices.bracelet.shoes.sync.b.g.a + " = " + "'" + str2 + "'" + " and " + com.xiaomi.channel.relationservice.data.a.h + " = " + c0595q.b() + " and " + o.L + " = " + c0595q.a() + ";");
            return true;
        } catch (Exception e) {
            C0596r.a("DB", e.getMessage());
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, C0595q c0595q, int i, String str2, String str3) {
        return a(sQLiteDatabase, str, bArr, c0595q, i, str2, str3, null, null);
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, C0595q c0595q, int i, String str2, String str3, byte[] bArr2, String str4) {
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0595q.b()));
        contentValues.put(o.L, Integer.valueOf(c0595q.a()));
        contentValues.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.a, str);
        contentValues.put(SocialConstants.PARAM_SUMMARY, str2);
        contentValues.put(H.k, str3);
        contentValues.put(b.b, bArr);
        contentValues.put(i.d, Integer.valueOf(i));
        if (bArr2 != null && bArr2.length > 0) {
            contentValues.put(F.i, bArr2);
        }
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put(F.j, str4);
        }
        String str5 = "date=? AND type=?";
        String[] strArr = new String[]{str, a.f + c0595q.b()};
        Cursor query;
        try {
            boolean z;
            query = sQLiteDatabase.query(E.a, null, str5, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = sQLiteDatabase.update(E.a, contentValues, str5, strArr) > 0;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            z = sQLiteDatabase.insert(E.a, null, contentValues) > 0;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, String str2, String str3, C0595q c0595q) {
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0595q.b()));
        contentValues.put(o.L, Integer.valueOf(c0595q.a()));
        contentValues.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.a, str);
        contentValues.put(SocialConstants.PARAM_SUMMARY, str2);
        contentValues.put(H.k, str3);
        contentValues.put(b.b, bArr);
        contentValues.put(i.d, Integer.valueOf(0));
        String str4 = "date=? AND type=?";
        String[] strArr = new String[]{str, a.f + c0595q.b()};
        Cursor query;
        try {
            boolean z;
            query = sQLiteDatabase.query(E.a, null, str4, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = sQLiteDatabase.update(E.a, contentValues, str4, strArr) > 0;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            z = sQLiteDatabase.insert(E.a, null, contentValues) > 0;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, String str2, String str3, C0595q c0595q, byte[] bArr2, String str4) {
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0595q.b()));
        contentValues.put(o.L, Integer.valueOf(c0595q.a()));
        contentValues.put(cn.com.smartdevices.bracelet.shoes.sync.b.g.a, str);
        contentValues.put(SocialConstants.PARAM_SUMMARY, str2);
        contentValues.put(H.k, str3);
        contentValues.put(b.b, bArr);
        contentValues.put(i.d, Integer.valueOf(0));
        if (bArr2 != null && bArr2.length > 0) {
            contentValues.put(F.i, bArr2);
        }
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put(F.j, str4);
        }
        String str5 = "date=? AND type=?";
        String[] strArr = new String[]{str, a.f + c0595q.b()};
        Cursor query;
        try {
            boolean z;
            query = sQLiteDatabase.query(E.a, null, str5, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = sQLiteDatabase.update(E.a, contentValues, str5, strArr) > 0;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            z = sQLiteDatabase.insert(E.a, null, contentValues) > 0;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, ArrayList<HeartRateItem> arrayList, int i) {
        String str = true;
        if (arrayList == null || arrayList.size() < 1) {
            return true;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("update heartrate set sync = " + i + " where " + g.f + " = " + ((HeartRateItem) it.next()).time);
            }
            sQLiteDatabase.setTransactionSuccessful();
            return str;
        } catch (Exception e) {
            str = "DB";
            C0596r.a(str, e.getMessage());
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        if (arrayList == null || arrayList.size() < 1) {
            return true;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator it = arrayList.iterator();
            boolean z = true;
            while (it.hasNext()) {
                BasicDateData basicDateData = (BasicDateData) it.next();
                z &= a(sQLiteDatabase, basicDateData.date, basicDateData.data, c0595q, i, basicDateData.summary, basicDateData.indexs);
            }
            sQLiteDatabase.setTransactionSuccessful();
            return z;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, List<Partner> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            sQLiteDatabase.beginTransaction();
            boolean z = true;
            for (Partner toContentValues : list) {
                z &= sQLiteDatabase.insert(A.a, null, toContentValues.toContentValues()) >= 0 ? 1 : 0;
            }
            sQLiteDatabase.setTransactionSuccessful();
            return z;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, List<HeartRateItem> list, int i) {
        Throwable th;
        Cursor cursor;
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            int i2 = 0;
            Cursor cursor2 = null;
            boolean z = true;
            while (i2 < size) {
                try {
                    boolean z2;
                    HeartRateItem heartRateItem = (HeartRateItem) list.get(i2);
                    cursor2 = sQLiteDatabase.rawQuery("select time from heartrate where time = " + heartRateItem.time, null);
                    if (cursor2 == null || cursor2.getCount() <= 0) {
                        ContentValues toContentValues = heartRateItem.toContentValues();
                        toContentValues.put(i.d, Integer.valueOf(i));
                        z2 = (sQLiteDatabase.insert(cn.com.smartdevices.bracelet.shoes.sync.b.g.d, null, toContentValues) >= 0 ? 1 : 0) & z;
                    } else {
                        C0596r.d(a, "insertHeartRateItem duplicate at:" + heartRateItem.time);
                        z2 = z;
                    }
                    i2++;
                    z = z2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (cursor2 != null) {
                cursor2.close();
            }
            sQLiteDatabase.endTransaction();
            return z;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, List<BasicDateData> list, int i, C0595q c0595q) {
        if (list == null || list.size() < 1) {
            return true;
        }
        try {
            sQLiteDatabase.beginTransaction();
            boolean z = true;
            for (BasicDateData basicDateData : list) {
                z &= a(sQLiteDatabase, basicDateData.date, basicDateData.data, new C0595q(c0595q.b(), basicDateData.source), i, basicDateData.summary, basicDateData.indexs, basicDateData.dataHR, basicDateData.summaryHR);
            }
            sQLiteDatabase.setTransactionSuccessful();
            return z;
        } catch (Exception e) {
            C0596r.e(a, e.getMessage());
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String[] strArr, String[] strArr2) {
        if (strArr == null || C0427d.a(strArr)) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        int i = 0;
        for (String put : strArr) {
            contentValues.put(put, strArr2[i]);
            i++;
        }
        return sQLiteDatabase.insert(C0427d.a, null, contentValues) > 0;
    }

    public static String[] a(SQLiteDatabase sQLiteDatabase) {
        String[] strArr = null;
        Cursor query = sQLiteDatabase.query(E.a, null, null, null, null, null, "date ASC");
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    strArr = new String[2];
                    query.moveToFirst();
                    strArr[0] = query.getString(query.getColumnIndex(cn.com.smartdevices.bracelet.shoes.sync.b.g.a));
                    query.moveToLast();
                    strArr[1] = query.getString(query.getColumnIndex(cn.com.smartdevices.bracelet.shoes.sync.b.g.a));
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return strArr;
    }

    public static List<Partner> b(SQLiteDatabase sQLiteDatabase) {
        List<Partner> list = null;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(A.a, new String[]{SocialConstants.PARAM_URL, f.h, SocialConstants.PARAM_TITLE, B.f, B.g, C0430g.d, B.h, cn.com.smartdevices.bracelet.push.f.n, LocationManagerProxy.KEY_STATUS_CHANGED}, null, null, null, null, null);
        if (query != null) {
            try {
                int count = query.getCount();
                if (count > 0) {
                    list = new ArrayList(count);
                    while (query.moveToNext()) {
                        list.add(Partner.fromCursor(query));
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return list;
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, int i, long j, long j2) {
        return sQLiteDatabase.delete(cn.com.smartdevices.bracelet.shoes.sync.b.g.d, "type=? AND time> ? and time < ?", new String[]{String.valueOf(i), String.valueOf(j - 1), String.valueOf(1 + j2)}) > 0;
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        String str = true;
        if (arrayList == null || arrayList.size() < 1) {
            return true;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL("update date_data set sync = " + i + " where " + cn.com.smartdevices.bracelet.shoes.sync.b.g.a + " = " + "'" + ((BasicDateData) it.next()).date + "'" + " and " + com.xiaomi.channel.relationservice.data.a.h + " = " + c0595q.b());
            }
            sQLiteDatabase.setTransactionSuccessful();
            return str;
        } catch (Exception e) {
            str = "DB";
            C0596r.a(str, e.getMessage());
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static byte[] b(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        byte[] bArr = null;
        String[] strArr = new String[]{b.b};
        String[] strArr2 = new String[]{str, a.f + c0595q.b()};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, strArr, "date=? AND type=?", strArr2, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    bArr = query.getBlob(query.getColumnIndex(b.b));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return bArr;
    }

    public static boolean c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            boolean z = sQLiteDatabase.delete(A.a, null, null) >= 0;
            sQLiteDatabase.setTransactionSuccessful();
            return z;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public static byte[] c(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        byte[] bArr = null;
        String[] strArr = new String[]{F.i};
        String[] strArr2 = new String[]{str, a.f + c0595q.b()};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, strArr, "date=? AND type=?", strArr2, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    bArr = query.getBlob(query.getColumnIndex(F.i));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return bArr;
    }

    public static byte[] d(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        byte[] bArr = null;
        String[] strArr = new String[]{SocialConstants.PARAM_SUMMARY};
        String[] strArr2 = new String[]{str, a.f + c0595q.b()};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, strArr, "date=? AND type=?", strArr2, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    bArr = query.getBlob(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                } else {
                    query.close();
                }
            } finally {
                query.close();
            }
        }
        return bArr;
    }

    public static String e(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        return a(sQLiteDatabase, str, c0595q, -1);
    }

    public static BasicDateData f(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        BasicDateData basicDateData = null;
        String[] strArr = new String[]{cn.com.smartdevices.bracelet.shoes.sync.b.g.a, b.b, SocialConstants.PARAM_SUMMARY, H.k, F.i, F.j};
        String[] strArr2 = new String[]{a.f + c0595q.b(), str};
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(E.a, strArr, "type=? AND date=?", strArr2, null, null, cn.com.smartdevices.bracelet.shoes.sync.b.g.a);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    basicDateData = new BasicDateData();
                    basicDateData.date = query.getString(query.getColumnIndex(cn.com.smartdevices.bracelet.shoes.sync.b.g.a));
                    basicDateData.data = query.getBlob(query.getColumnIndex(b.b));
                    basicDateData.summary = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    basicDateData.indexs = query.getString(query.getColumnIndex(H.k));
                    basicDateData.dataHR = query.getBlob(query.getColumnIndex(F.i));
                    basicDateData.summaryHR = query.getString(query.getColumnIndex(F.j));
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
            }
        }
        return basicDateData;
    }
}
