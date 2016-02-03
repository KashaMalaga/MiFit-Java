package cn.com.smartdevices.bracelet.gps.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.d.C0425b;
import cn.com.smartdevices.bracelet.f.b;
import cn.com.smartdevices.bracelet.gps.c;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.model.l;
import cn.com.smartdevices.bracelet.gps.model.m;
import cn.com.smartdevices.bracelet.gps.services.C0453l;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.services.ay;
import cn.com.smartdevices.bracelet.gps.services.az;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import cn.com.smartdevices.bracelet.model.HeartRateItem;
import cn.com.smartdevices.bracelet.shoes.data.db.j;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import com.tencent.open.SocialConstants;
import com.xiaomi.e.a;
import com.xiaomi.mipush.sdk.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class p {
    public static final String a = "GPSDB";
    public static final int b = 100;

    private p() {
    }

    private static SQLiteDatabase a(Context context, boolean z) {
        return q.a(context).a(z);
    }

    public static String a(Context context, long j, int i) {
        if (context != null && j > 0) {
            return a(a(context, false), j, i);
        }
        throw new IllegalArgumentException();
    }

    private static String a(SQLiteDatabase sQLiteDatabase, long j, int i) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (j <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
            query = sQLiteDatabase2.query(b.a, new String[]{m.b, j.e}, "type = ? AND trackid =? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(j.e));
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
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
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
            C0596r.a(a, e.getMessage());
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

    public static ArrayList<HeartRateItem> a(int i, Context context, long j, long j2) {
        if (context != null) {
            return C0425b.a(context).a(i, j, j2);
        }
        throw new IllegalArgumentException();
    }

    public static List<Long> a(Context context, int i) {
        List<Long> list = null;
        int i2 = 0;
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        Object a = C0425b.a(context).a(b.b, false);
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split(f.i);
            if (split != null) {
                list = new ArrayList(split.length);
                int length = split.length;
                while (i2 < length) {
                    Object obj = split[i2];
                    if (!TextUtils.isEmpty(obj)) {
                        list.add(Long.valueOf(obj));
                    }
                    i2++;
                }
            }
        }
        return list;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<cn.com.smartdevices.bracelet.gps.services.aa> a(android.content.Context r14, int r15, long r16, int r18, java.util.List<java.lang.Long> r19) {
        /*
        if (r14 != 0) goto L_0x0008;
    L_0x0002:
        r2 = new java.lang.IllegalArgumentException;
        r2.<init>();
        throw r2;
    L_0x0008:
        r2 = 0;
        r2 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0014;
    L_0x000e:
        r2 = 0;
        r16 = cn.com.smartdevices.bracelet.gps.h.h.b(r2);
    L_0x0014:
        r2 = 1;
        r0 = r16;
        r12 = cn.com.smartdevices.bracelet.gps.h.h.b(r0, r2);
        r2 = 0;
        if (r19 == 0) goto L_0x0051;
    L_0x001e:
        r3 = r19.size();
        if (r3 <= 0) goto L_0x0051;
    L_0x0024:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r19.iterator();
    L_0x002d:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0047;
    L_0x0033:
        r2 = r4.next();
        r2 = (java.lang.Long) r2;
        r6 = r2.longValue();
        r2 = r3.append(r6);
        r5 = ",";
        r2.append(r5);
        goto L_0x002d;
    L_0x0047:
        r2 = r3.length();
        r2 = r2 + -1;
        r3.deleteCharAt(r2);
        r2 = r3;
    L_0x0051:
        r10 = 0;
        if (r18 <= 0) goto L_0x00e3;
    L_0x0054:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r3.<init>();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r4 = " LIMIT ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r9 = r3;
    L_0x006a:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        if (r3 == 0) goto L_0x00e7;
    L_0x0070:
        r2 = "";
        r5 = r2;
    L_0x0073:
        r2 = 4;
        r4 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = 0;
        r3 = "trackid";
        r4[r2] = r3;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = 1;
        r3 = "date";
        r4[r2] = r3;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = 2;
        r3 = "summary";
        r4[r2] = r3;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = 3;
        r3 = "sync";
        r4[r2] = r3;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = 0;
        r2 = a(r14, r2);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r3 = "trackinfo";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r6.<init>();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r7 = "type =? AND trackid >=? AND trackid <? ";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r5 = r6.append(r5);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r6 = 3;
        r6 = new java.lang.String[r6];	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r7 = 0;
        r8 = java.lang.String.valueOf(r15);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r7 = 1;
        r8 = java.lang.String.valueOf(r16);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r7 = 2;
        r8 = java.lang.String.valueOf(r12);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r6[r7] = r8;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r7 = 0;
        r8 = 0;
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r11.<init>();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r12 = "trackid DESC";
        r11 = r11.append(r12);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r9 = r11.append(r9);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r10 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        if (r10 != 0) goto L_0x0107;
    L_0x00d7:
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r3 = 0;
        r2.<init>(r3);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        if (r10 == 0) goto L_0x00e2;
    L_0x00df:
        r10.close();
    L_0x00e2:
        return r2;
    L_0x00e3:
        r3 = "";
        r9 = r3;
        goto L_0x006a;
    L_0x00e7:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r3.<init>();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r4 = " AND trackid NOT IN(";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = r3.append(r2);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r3 = ") ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0190, all -> 0x0186 }
        r5 = r2;
        goto L_0x0073;
    L_0x0107:
        r3 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4 = r10.getCount();	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4 = "";
        r4 = "";
        r4 = "";
    L_0x0116:
        r4 = r10.moveToNext();	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        if (r4 == 0) goto L_0x017e;
    L_0x011c:
        r4 = "summary";
        r4 = r10.getColumnIndex(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r6 = r10.getString(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        if (r4 != 0) goto L_0x0116;
    L_0x012c:
        r4 = "trackid";
        r4 = r10.getColumnIndex(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r11 = r10.getInt(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4 = "date";
        r4 = r10.getColumnIndex(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r9 = r10.getString(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4 = new cn.com.smartdevices.bracelet.gps.services.aa;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r6 = (long) r11;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r8 = r15;
        r4.<init>(r5, r6, r8, r9);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r5 = "sync";
        r5 = r10.getColumnIndex(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r5 = r10.getInt(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r4.a(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r6 = (long) r11;	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r5 = a(r2, r6, r15);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        if (r6 != 0) goto L_0x0167;
    L_0x0164:
        r4.a(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
    L_0x0167:
        r3.add(r4);	 Catch:{ Exception -> 0x016b, all -> 0x0186 }
        goto L_0x0116;
    L_0x016b:
        r2 = move-exception;
        r3 = r10;
    L_0x016d:
        r4 = "GPSDB";
        r2 = r2.getMessage();	 Catch:{ all -> 0x018d }
        cn.com.smartdevices.bracelet.C0596r.a(r4, r2);	 Catch:{ all -> 0x018d }
        if (r3 == 0) goto L_0x017b;
    L_0x0178:
        r3.close();
    L_0x017b:
        r2 = 0;
        goto L_0x00e2;
    L_0x017e:
        if (r10 == 0) goto L_0x0183;
    L_0x0180:
        r10.close();
    L_0x0183:
        r2 = r3;
        goto L_0x00e2;
    L_0x0186:
        r2 = move-exception;
    L_0x0187:
        if (r10 == 0) goto L_0x018c;
    L_0x0189:
        r10.close();
    L_0x018c:
        throw r2;
    L_0x018d:
        r2 = move-exception;
        r10 = r3;
        goto L_0x0187;
    L_0x0190:
        r2 = move-exception;
        r3 = r10;
        goto L_0x016d;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.gps.c.a.p.a(android.content.Context, int, long, int, java.util.List):java.util.List<cn.com.smartdevices.bracelet.gps.services.aa>");
    }

    public static List<m> a(Context context, int i, long j, long j2, int i2) {
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase a = a(context, false);
            String str = i2 > 0 ? " LIMIT  " + i2 : a.f;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j2 <= 0) {
                j2 = 0;
            }
            a.execSQL(n.c);
            Cursor rawQuery = a.rawQuery("SELECT month, SUM(distance) AS sumdistance, SUM(usedtime) AS sumtime FROM trackinfoview WHERE type =? " + " AND trackid <=?  AND trackid >=? " + " GROUP BY " + o.a + " ORDER BY " + o.a + " DESC " + str, new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j2)});
            if (rawQuery == null) {
                try {
                    List<m> arrayList = new ArrayList(0);
                    if (rawQuery == null) {
                        return arrayList;
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    cursor = rawQuery;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            str = a.f;
            List<m> arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList2.add(new m(h.b(rawQuery.getString(rawQuery.getColumnIndex(o.a))) / 1000, rawQuery.getFloat(rawQuery.getColumnIndex(o.d)), rawQuery.getLong(rawQuery.getColumnIndex(o.e))));
            }
            a.execSQL(n.a);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
    }

    private static List<C0466z> a(Context context, int i, t tVar, List<Long> list) {
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (!t.a(tVar)) {
            return null;
        } else {
            Object obj;
            if (list == null || list.size() <= 0) {
                obj = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (Long longValue : list) {
                    stringBuilder.append(longValue.longValue()).append(f.i);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                obj = stringBuilder;
            }
            String[] strArr = new String[]{i.d, e.i, m.b, g.a};
            try {
                SQLiteDatabase a = a(context, false);
                if (TextUtils.isEmpty(obj)) {
                    query = a.query(d.a, strArr, "type =? AND sync =?", new String[]{String.valueOf(i), String.valueOf(tVar.a())}, null, null, null);
                } else {
                    query = a.query(d.a, strArr, "type =? AND sync =? AND trackid IN(" + obj.toString() + ")", new String[]{String.valueOf(i), String.valueOf(tVar.a())}, null, null, null);
                }
                if (query == null) {
                    try {
                        ArrayList arrayList = new ArrayList(0);
                        if (query != null) {
                            query.close();
                        }
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            C0596r.a(a, e.getMessage());
                            if (query != null) {
                                return null;
                            }
                            query.close();
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
                }
                List<C0466z> arrayList2 = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    int i2 = query.getInt(query.getColumnIndex(e.i));
                    long j = query.getLong(query.getColumnIndex(m.b));
                    String string = query.getString(query.getColumnIndex(g.a));
                    int i3 = query.getInt(query.getColumnIndex(i.d));
                    C0466z c0466z = new C0466z(i, j, string);
                    c0466z.d(i3);
                    c0466z.b(i2);
                    arrayList2.add(c0466z);
                }
                if (query != null) {
                    query.close();
                }
                return arrayList2;
            } catch (Exception e3) {
                e = e3;
                query = null;
                C0596r.a(a, e.getMessage());
                if (query != null) {
                    return null;
                }
                query.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public static List<C0466z> a(Context context, int i, List<Long> list) {
        return a(context, i, t.STATE_SYNCED_FROM_SERVER_SUMMERY_DONE, (List) list);
    }

    public static List<m> a(Context context, int i, List<String> list, int i2) {
        Cursor cursor;
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        String str;
        Object stringBuilder;
        SQLiteDatabase a;
        Cursor rawQuery;
        List<m> arrayList;
        List<m> arrayList2;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    stringBuilder2.append("'").append(str2).append("'").append(f.i);
                }
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                stringBuilder = stringBuilder2.toString();
                cursor = null;
                a = a(context, true);
                a.execSQL(n.c);
                rawQuery = a.rawQuery("SELECT month, SUM(distance) AS sumdistance, SUM(usedtime) AS sumtime FROM trackinfoview WHERE type =? " + (TextUtils.isEmpty(stringBuilder) ? a.f : " AND month IN (" + stringBuilder + ")") + " GROUP BY " + o.a + " ORDER BY " + o.a + " DESC" + (i2 <= 0 ? " LIMIT  " + i2 : a.f), new String[]{String.valueOf(i)});
                if (rawQuery != null) {
                    try {
                        arrayList = new ArrayList(0);
                        if (rawQuery != null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    } catch (Exception e) {
                        e = e;
                        cursor = rawQuery;
                        try {
                            Exception e2;
                            C0596r.a(a, e2.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                }
                str2 = a.f;
                arrayList2 = new ArrayList();
                while (rawQuery.moveToNext()) {
                    arrayList2.add(new m(h.b(rawQuery.getString(rawQuery.getColumnIndex(o.a))) / 1000, rawQuery.getFloat(rawQuery.getColumnIndex(o.d)), rawQuery.getLong(rawQuery.getColumnIndex(o.e))));
                }
                a.execSQL(n.a);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return arrayList2;
            }
        }
        stringBuilder = null;
        cursor = null;
        try {
            a = a(context, true);
            a.execSQL(n.c);
            if (i2 <= 0) {
            }
            if (TextUtils.isEmpty(stringBuilder)) {
            }
            rawQuery = a.rawQuery("SELECT month, SUM(distance) AS sumdistance, SUM(usedtime) AS sumtime FROM trackinfoview WHERE type =? " + (TextUtils.isEmpty(stringBuilder) ? a.f : " AND month IN (" + stringBuilder + ")") + " GROUP BY " + o.a + " ORDER BY " + o.a + " DESC" + (i2 <= 0 ? " LIMIT  " + i2 : a.f), new String[]{String.valueOf(i)});
            if (rawQuery != null) {
                str2 = a.f;
                arrayList2 = new ArrayList();
                while (rawQuery.moveToNext()) {
                    arrayList2.add(new m(h.b(rawQuery.getString(rawQuery.getColumnIndex(o.a))) / 1000, rawQuery.getFloat(rawQuery.getColumnIndex(o.d)), rawQuery.getLong(rawQuery.getColumnIndex(o.e))));
                }
                a.execSQL(n.a);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return arrayList2;
            }
            arrayList = new ArrayList(0);
            if (rawQuery != null) {
                return arrayList;
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e3) {
            e2 = e3;
            C0596r.a(a, e2.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
    }

    public static List<Long> a(Context context, long j, long j2, int i) {
        Exception e;
        Throwable th;
        if (context == null || j <= 0 || j2 <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor cursor = null;
        Cursor query;
        try {
            query = a(context, false).query(d.a, new String[]{m.b}, "type =? AND trackid >=? AND trackid <=? AND sync !=?", new String[]{String.valueOf(4), String.valueOf(j), String.valueOf(j2), String.valueOf(t.STATE_UNSYNCED.a())}, null, null, "trackid DESC");
            List<Long> arrayList;
            if (query == null) {
                try {
                    arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a(a, e.getMessage());
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
            }
            arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                long j3 = query.getLong(query.getColumnIndex(m.b));
                if (j3 > 0) {
                    arrayList.add(Long.valueOf(j3));
                }
            }
            if (query == null) {
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a(a, e.getMessage());
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

    static List<aa> a(Context context, t tVar) {
        Cursor query;
        Exception e;
        Cursor cursor;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            SQLiteDatabase a = a(context, false);
            String[] strArr = new String[]{com.xiaomi.channel.relationservice.data.a.h, m.b, g.a, SocialConstants.PARAM_SUMMARY, i.d};
            if (t.a(tVar)) {
                query = a.query(d.a, strArr, "type =? AND sync =?", new String[]{String.valueOf(4), String.valueOf(tVar.a())}, null, null, "trackid DESC");
            } else {
                query = a.query(d.a, strArr, "type =?", new String[]{String.valueOf(4)}, null, null, "trackid DESC");
            }
            if (query == null) {
                try {
                    List<aa> arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            List<aa> arrayList2 = new ArrayList(query.getCount());
            String str = a.f;
            str = a.f;
            while (query.moveToNext()) {
                Object string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                if (!TextUtils.isEmpty(string)) {
                    int i = query.getInt(query.getColumnIndex(m.b));
                    String string2 = query.getString(query.getColumnIndex(g.a));
                    int i2 = query.getInt(query.getColumnIndex(com.xiaomi.channel.relationservice.data.a.h));
                    aa aaVar = new aa(new JSONObject(string), (long) i, i2, string2);
                    aaVar.a(query.getInt(query.getColumnIndex(i.d)));
                    String a2 = a(a, (long) i, i2);
                    if (!TextUtils.isEmpty(a2)) {
                        aaVar.a(a2);
                    }
                    arrayList2.add(aaVar);
                }
            }
            if (query != null) {
                query.close();
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        q.a(context).a();
    }

    public static boolean a(Context context, int i, t tVar) {
        if (context == null || !c.a(i)) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(i.d, Integer.valueOf(tVar.a()));
        try {
            return ((long) a(context, true).update(h.a, contentValues, "type =?", new String[]{String.valueOf(i)})) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            return ((long) a(context, true).delete(l.a, null, null)) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    private static boolean a(Context context, long j, int i, t tVar) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(cn.com.smartdevices.bracelet.shoes.data.db.h.k, Integer.valueOf(tVar.a()));
        try {
            return ((long) a(context, true).update(b.a, contentValues, "type =? AND trackid = ?", new String[]{String.valueOf(i), String.valueOf(j)})) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, long j, t tVar) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(i.d, Integer.valueOf(tVar.a()));
        try {
            return a(context, true).update(d.a, contentValues, "trackid=?", new String[]{new StringBuilder().append(a.f).append(j).toString()}) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, long j, String str) {
        if (context == null || TextUtils.isEmpty(str) || j <= 0) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(j.e, str);
        try {
            return a(context, true).update(b.a, contentValues, "trackid =? ", new String[]{String.valueOf(j)}) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, d dVar) {
        long update;
        long j;
        Exception exception;
        if (context == null || dVar == null) {
            throw new IllegalArgumentException();
        }
        JSONObject c = dVar.c();
        if (c.length() <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.gamesdk.b.b, c.toString());
        contentValues.put(i.d, Integer.valueOf(t.STATE_UNSYNCED.a()));
        try {
            SQLiteDatabase a = a(context, true);
            update = (long) a.update(h.a, contentValues, "type =?", new String[]{String.valueOf(dVar.i())});
            if (update <= 0) {
                try {
                    contentValues.put(com.xiaomi.channel.relationservice.data.a.h, String.valueOf(dVar.i()));
                    update = a.insert(h.a, null, contentValues);
                } catch (Exception e) {
                    Exception exception2 = e;
                    j = update;
                    exception = exception2;
                    C0596r.a(a, exception.getMessage());
                    update = j;
                    return update > 0;
                }
            }
        } catch (Exception e2) {
            exception = e2;
            j = 0;
            C0596r.a(a, exception.getMessage());
            update = j;
            if (update > 0) {
            }
            return update > 0;
        }
        if (update > 0) {
        }
        return update > 0;
    }

    public static boolean a(Context context, l lVar) {
        int i = 1;
        if (context == null || lVar == null) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(lVar.c()));
        contentValues.put(m.b, Long.valueOf(lVar.b()));
        contentValues.put(SocialConstants.PARAM_SUMMARY, lVar.a());
        contentValues.put(com.xiaomi.account.openauth.h.N, Integer.valueOf(lVar.e));
        try {
            SQLiteDatabase a = a(context, true);
            boolean z = a.update(j.a, contentValues, "type =? ", new String[]{new StringBuilder().append(a.f).append(lVar.c()).toString()}) > 0;
            if (z) {
                return z;
            }
            if (a.insert(j.a, null, contentValues) <= 0) {
                i = 0;
            }
            return i & z;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, ay ayVar) {
        if (context == null || ayVar == null || ayVar.b() <= 0) {
            throw new IllegalArgumentException();
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(m.b, Long.valueOf(ayVar.b()));
            contentValues.put(SocialConstants.PARAM_SUMMARY, ayVar.a().toString());
            return a(context, true).insert(l.a, null, contentValues) > 0;
        } catch (Exception e) {
            C0596r.a(a, "setDeathTrackInfo failed: " + e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, C0466z c0466z) {
        if (context != null && c0466z != null) {
            return c(context, c0466z);
        }
        throw new IllegalArgumentException();
    }

    public static boolean a(Context context, ArrayList<HeartRateItem> arrayList) {
        if (context != null) {
            return C0425b.a(context).a((List) arrayList, 0);
        }
        throw new IllegalArgumentException();
    }

    public static boolean a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Long longValue : list) {
                stringBuilder.append(longValue.longValue()).append(f.i);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String str = "(" + stringBuilder.toString() + ")";
            SQLiteDatabase a = a(context, false);
            a.delete(f.a, "trackid IN " + str, null);
            a.delete(b.a, "trackid IN " + str, null);
            return a.delete(d.a, new StringBuilder().append("trackid IN ").append(str).toString(), null) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, List<Long> list, int i) {
        boolean z = true;
        for (Long longValue : list) {
            z = a(context, longValue.longValue(), i, t.STATE_SYNCED_FROM_SERVER) & z;
        }
        return z;
    }

    public static boolean a(Context context, List<cn.com.smartdevices.bracelet.gps.model.c> list, long j) {
        boolean hasNext;
        if (context == null || list == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        SQLiteDatabase a = a(context, true);
        boolean z = true;
        try {
            ContentValues contentValues = new ContentValues();
            a.beginTransaction();
            Iterator it = list.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (!hasNext) {
                    break;
                }
                cn.com.smartdevices.bracelet.gps.model.c cVar = (cn.com.smartdevices.bracelet.gps.model.c) it.next();
                contentValues.clear();
                contentValues.put(m.b, Long.valueOf(j));
                contentValues.put(ParamKey.LATITUDE, Double.valueOf(cVar.p));
                contentValues.put(ParamKey.LONGITUDE, Double.valueOf(cVar.q));
                contentValues.put(g.e, Double.valueOf(cVar.o));
                contentValues.put(g.f, Long.valueOf(cVar.e()));
                contentValues.put(com.xiaomi.channel.relationservice.data.a.G, cVar.c().toString());
                z &= a.insert(f.a, null, contentValues) > 0 ? 1 : 0;
            }
            a.setTransactionSuccessful();
            return z;
        } catch (Exception e) {
            Exception exception = e;
            hasNext = true;
            z = exception;
            String str = a;
            z = z.getMessage();
            C0596r.a(str, (String) z);
            return hasNext;
        } finally {
            a.endTransaction();
        }
    }

    public static int b(Context context, long j) {
        Cursor cursor = null;
        int i = 0;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        try {
            cursor = a(context, false).rawQuery("SELECT count(_id) AS count FROM trackloc WHERE trackid = " + j, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor.moveToNext()) {
                i = cursor.getInt(cursor.getColumnIndex(ParamKey.COUNT));
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C0596r.e(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    private static d b(Context context, int i, t tVar) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{i.d, com.xiaomi.channel.gamesdk.b.b};
        Cursor query;
        try {
            SQLiteDatabase a = a(context, false);
            if (t.a(tVar)) {
                query = a.query(h.a, strArr, "type =? AND sync =?", new String[]{String.valueOf(i), String.valueOf(tVar.a())}, null, null, null);
            } else {
                query = a.query(h.a, strArr, "type =?", new String[]{String.valueOf(i)}, null, null, null);
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            Object string;
            do {
                try {
                    if (query.moveToNext()) {
                        string = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                    } else {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } while (TextUtils.isEmpty(string));
            int i2 = query.getInt(query.getColumnIndex(i.d));
            d dVar = new d(i, string);
            dVar.f(i2);
            if (query == null) {
                return dVar;
            }
            query.close();
            return dVar;
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                C0596r.a(a, e.getMessage());
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
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static aa b(Context context, long j, int i) {
        Exception e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        try {
            Cursor query = a(context, false).query(d.a, new String[]{m.b, g.a, SocialConstants.PARAM_SUMMARY, i.d}, "type =? AND trackid =? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            Object string;
            do {
                try {
                    if (query.moveToNext()) {
                        string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    } else {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = query;
                }
            } while (TextUtils.isEmpty(string));
            aa aaVar = new aa(new JSONObject(string), j, i, query.getString(query.getColumnIndex(g.a)));
            aaVar.a(query.getInt(query.getColumnIndex(i.d)));
            if (query == null) {
                return aaVar;
            }
            query.close();
            return aaVar;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            try {
                C0596r.a(a, e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public static List<aa> b(Context context) {
        return a(context, t.SYNC_STATE_DEFAULT);
    }

    public static List<Long> b(Context context, int i) {
        Cursor rawQuery;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            List<Long> arrayList;
            rawQuery = a(context, false).rawQuery("SELECT trackid FROM trackinfo WHERE type = " + i + " AND (" + i.d + " = " + t.STATE_SYNCED_FROM_SERVER.a() + ") AND " + m.b + " NOT IN (SELECT " + m.b + " FROM " + b.a + " WHERE " + com.xiaomi.channel.relationservice.data.a.h + " = " + i + " AND " + cn.com.smartdevices.bracelet.shoes.data.db.h.k + " = " + t.STATE_SYNCED_FROM_SERVER.a() + ")", null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() != 0) {
                        arrayList = new ArrayList(rawQuery.getCount());
                        while (rawQuery.moveToNext()) {
                            arrayList.add(Long.valueOf(rawQuery.getLong(rawQuery.getColumnIndex(m.b))));
                        }
                        if (rawQuery == null) {
                            return arrayList;
                        }
                        rawQuery.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            arrayList = new ArrayList(0);
            if (rawQuery == null) {
                return arrayList;
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            rawQuery = null;
            C0596r.a(a, e.getMessage());
            if (rawQuery != null) {
                rawQuery.close();
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

    public static List<aa> b(Context context, int i, long j, int i2, List<Long> list) {
        List<aa> linkedList = new LinkedList();
        for (aa aaVar : a(context, i, j, i2, (List) list)) {
            if (aaVar.k() != t.STATE_TO_BE_DELETED.a()) {
                linkedList.add(aaVar);
            }
        }
        return linkedList;
    }

    public static List<m> b(Context context, int i, long j, long j2, int i2) {
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        Cursor cursor = null;
        try {
            SQLiteDatabase a = a(context, false);
            String str = i2 > 0 ? " LIMIT  " + i2 : a.f;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j2 <= 0) {
                j2 = 0;
            }
            a.execSQL(n.c);
            Cursor rawQuery = a.rawQuery("SELECT month, SUM(distance) AS sumdistance, SUM(usedtime) AS sumtime FROM trackinfoview WHERE type =? " + (" AND trackid <=?  AND trackid >=? AND sync!=" + t.STATE_TO_BE_DELETED.a()) + " GROUP BY " + o.a + " ORDER BY " + o.a + " DESC " + str, new String[]{String.valueOf(i), String.valueOf(j), String.valueOf(j2)});
            if (rawQuery == null) {
                try {
                    List<m> arrayList = new ArrayList(0);
                    if (rawQuery == null) {
                        return arrayList;
                    }
                    rawQuery.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    cursor = rawQuery;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            str = a.f;
            List<m> arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList2.add(new m(h.b(rawQuery.getString(rawQuery.getColumnIndex(o.a))) / 1000, rawQuery.getFloat(rawQuery.getColumnIndex(o.d)), rawQuery.getLong(rawQuery.getColumnIndex(o.e))));
            }
            a.execSQL(n.a);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        }
    }

    public static List<C0453l> b(Context context, int i, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            return b(context, (List) list, i);
        }
        throw new IllegalArgumentException();
    }

    private static List<C0453l> b(Context context, List<Long> list, int i) {
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Object obj;
        if (list == null || list.size() <= 0) {
            obj = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Long longValue : list) {
                stringBuilder.append(longValue.longValue()).append(f.i);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            obj = stringBuilder;
        }
        String[] strArr = new String[]{m.b, com.xiaomi.channel.relationservice.data.a.h, c.g, com.xiaomi.channel.gamesdk.b.b, c.d};
        try {
            SQLiteDatabase a = a(context, false);
            if (TextUtils.isEmpty(obj)) {
                query = a.query(b.a, strArr, "type =? AND synced =?", new String[]{String.valueOf(i), String.valueOf(t.STATE_UNSYNCED.a())}, null, null, null);
            } else {
                query = a.query(b.a, strArr, "type =? AND synced =? AND trackid IN(" + obj.toString() + ")", new String[]{String.valueOf(i), String.valueOf(t.STATE_UNSYNCED.a())}, null, null, null);
            }
            if (query == null) {
                try {
                    ArrayList arrayList = new ArrayList(0);
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (query != null) {
                            return null;
                        }
                        query.close();
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
            }
            List<C0453l> arrayList2 = new ArrayList(query.getCount());
            String str = a.f;
            str = a.f;
            while (query.moveToNext()) {
                C0453l c0453l = new C0453l(i, query.getLong(query.getColumnIndex(m.b)));
                c0453l.b(query.getInt(query.getColumnIndex(c.g)));
                str = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                c0453l.b(query.getString(query.getColumnIndex(c.d)));
                c0453l.a(str);
                arrayList2.add(c0453l);
            }
            if (query != null) {
                query.close();
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a(a, e.getMessage());
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static boolean b(Context context, long j, int i, t tVar) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(i.d, Integer.valueOf(tVar.a()));
        try {
            return ((long) a(context, true).update(d.a, contentValues, "type =? AND trackid = ?", new String[]{String.valueOf(i), String.valueOf(j)})) > 0;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        }
    }

    public static boolean b(Context context, C0466z c0466z) {
        long update;
        long j;
        Exception exception;
        if (context == null || c0466z == null) {
            throw new IllegalArgumentException();
        }
        JSONObject b = c0466z.b();
        if (b == null) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(g.a, c0466z.j());
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0466z.v()));
        contentValues.put(m.b, Long.valueOf(c0466z.G()));
        contentValues.put(cn.com.smartdevices.bracelet.relation.db.a.g, Float.valueOf(c0466z.C()));
        contentValues.put(e.f, Long.valueOf(c0466z.F()));
        contentValues.put(SocialConstants.PARAM_SUMMARY, b.toString());
        contentValues.put(i.d, Integer.valueOf(t.STATE_UNSYNCED.a()));
        try {
            contentValues.put(e.i, Integer.valueOf(b.getInt(az.K)));
        } catch (JSONException e) {
            C0596r.a(a, e.getMessage());
        }
        JSONArray a = c0466z.a();
        if (a != null && a.length() > 0) {
            contentValues.put(com.xiaomi.channel.gamesdk.b.b, a.toString());
        }
        try {
            SQLiteDatabase a2 = a(context, true);
            update = (long) a2.update(d.a, contentValues, "trackid=?", new String[]{String.valueOf(c0466z.G())});
            if (update <= 0) {
                try {
                    update = a2.insert(d.a, null, contentValues);
                } catch (Exception e2) {
                    Exception exception2 = e2;
                    j = update;
                    exception = exception2;
                    C0596r.a(a, exception.getMessage());
                    update = j;
                    return update > 0;
                }
            }
        } catch (Exception e3) {
            exception = e3;
            j = 0;
            C0596r.a(a, exception.getMessage());
            update = j;
            if (update > 0) {
            }
            return update > 0;
        }
        if (update > 0) {
        }
        return update > 0;
    }

    public static boolean b(Context context, List<C0453l> list) {
        if (context == null || list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        SQLiteDatabase a = a(context, true);
        try {
            ContentValues contentValues = new ContentValues();
            a.beginTransaction();
            boolean z = true;
            for (C0453l c0453l : list) {
                contentValues.put(m.b, Long.valueOf(c0453l.i()));
                contentValues.put(c.g, Integer.valueOf(c0453l.c()));
                contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0453l.f()));
                if (!TextUtils.isEmpty(c0453l.d())) {
                    contentValues.put(j.e, c0453l.d());
                }
                contentValues.put(SportBaseInfo.VERSION, Integer.valueOf(c0453l.j()));
                contentValues.put(c.d, c0453l.b().toString());
                contentValues.put(com.xiaomi.channel.gamesdk.b.b, c0453l.a().toString());
                contentValues.put(cn.com.smartdevices.bracelet.shoes.data.db.h.k, Integer.valueOf(c0453l.h()));
                int i = a.update(b.a, contentValues, "trackid = ? ", new String[]{String.valueOf(c0453l.i())}) > 0 ? 1 : 0;
                if (i == 0) {
                    i = a.insert(b.a, null, contentValues) > 0 ? 1 : 0;
                }
                z &= i;
            }
            a.setTransactionSuccessful();
            return z;
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            return false;
        } finally {
            a.endTransaction();
        }
    }

    public static long c(Context context) {
        Exception e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            Cursor query = a(context, false).query(l.a, new String[]{m.b}, null, null, null, null, "trackid DESC ");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return -1;
            }
            try {
                if (query.moveToNext()) {
                    long j = query.getLong(query.getColumnIndex(m.b));
                    if (query == null) {
                        return j;
                    }
                    query.close();
                    return j;
                }
                if (query != null) {
                    query.close();
                }
                return -1;
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                try {
                    C0596r.a(a, e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor2 = query;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public static l c(Context context, int i) {
        Cursor query;
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            query = a(context, false).query(j.a, new String[]{com.xiaomi.account.openauth.h.N, SocialConstants.PARAM_SUMMARY, m.b}, "type=?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        l lVar;
                        if (query.moveToNext()) {
                            lVar = new l(i);
                            lVar.e = query.getInt(query.getColumnIndex(com.xiaomi.account.openauth.h.N));
                            lVar.a(query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY)));
                            lVar.a((long) query.getInt(query.getColumnIndex(m.b)));
                        } else {
                            lVar = null;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return lVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (query != null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query == null) {
                return null;
            }
            query.close();
            return null;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a(a, e.getMessage());
            if (query != null) {
                return null;
            }
            query.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static ay c(Context context, long j) {
        Exception e;
        Throwable th;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        C0596r.e(a, "getDeathTrackInfoById trackId = " + j);
        Cursor query;
        try {
            query = a(context, false).query(l.a, new String[]{m.b, SocialConstants.PARAM_SUMMARY}, "trackid=?", new String[]{String.valueOf(j)}, null, null, "trackid DESC ");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                C0596r.e(a, "getDeathTrackInfoById count = " + query.getCount());
                if (query.moveToNext()) {
                    ay ayVar = new ay(j);
                    ayVar.a(query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY)));
                    if (query == null) {
                        return ayVar;
                    }
                    query.close();
                    return ayVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
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
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static C0453l c(Context context, long j, int i) {
        Exception e;
        Throwable th;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = a(context, false).query(b.a, new String[]{m.b, c.d, j.e, SportBaseInfo.VERSION, com.xiaomi.channel.relationservice.data.a.h, cn.com.smartdevices.bracelet.shoes.data.db.h.k, c.g, com.xiaomi.channel.gamesdk.b.b}, "type = ? AND trackid =? ", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                String str = a.f;
                str = a.f;
                if (query.moveToNext()) {
                    C0453l c0453l = new C0453l(i, j);
                    c0453l.c(query.getString(query.getColumnIndex(j.e)));
                    c0453l.b(query.getInt(query.getColumnIndex(c.g)));
                    c0453l.d(query.getInt(query.getColumnIndex(SportBaseInfo.VERSION)));
                    c0453l.c(query.getInt(query.getColumnIndex(cn.com.smartdevices.bracelet.shoes.data.db.h.k)));
                    String string = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                    c0453l.b(query.getString(query.getColumnIndex(c.d)));
                    c0453l.a(string);
                    if (query == null) {
                        return c0453l;
                    }
                    query.close();
                    return c0453l;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
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
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static List<C0466z> c(Context context, int i, t tVar) {
        Exception e;
        Cursor cursor;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{i.d, e.i, g.a, m.b, SocialConstants.PARAM_SUMMARY, com.xiaomi.channel.gamesdk.b.b};
        Cursor query;
        try {
            SQLiteDatabase a = a(context, false);
            if (t.a(tVar)) {
                query = a.query(d.a, strArr, "type =? AND sync =? ", new String[]{String.valueOf(i), String.valueOf(tVar.a())}, null, null, null);
            } else {
                query = a.query(d.a, strArr, "type =? ", new String[]{String.valueOf(i)}, null, null, null);
            }
            if (query == null) {
                try {
                    List<C0466z> arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            List<C0466z> arrayList2 = new ArrayList(query.getCount());
            String str = a.f;
            while (query.moveToNext()) {
                Object string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                if (!TextUtils.isEmpty(string)) {
                    int i2 = query.getInt(query.getColumnIndex(e.i));
                    long j = query.getLong(query.getColumnIndex(m.b));
                    String string2 = query.getString(query.getColumnIndex(g.a));
                    int i3 = query.getInt(query.getColumnIndex(i.d));
                    C0466z c0466z = new C0466z(i, j, string2);
                    c0466z.d(i3);
                    c0466z.a(j, i, string2, string);
                    c0466z.b(i2);
                    String string3 = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                    if (!TextUtils.isEmpty(string3)) {
                        c0466z.a(j, string3);
                    }
                    String a2 = a(a, j, i);
                    if (!TextUtils.isEmpty(a2)) {
                        c0466z.a(a2);
                    }
                    arrayList2.add(c0466z);
                }
            }
            if (query != null) {
                query.close();
            }
            return arrayList2;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean c(Context context, int i, List<Long> list) {
        if (context == null || !C0595q.a(i) || list == null) {
            throw new IllegalArgumentException();
        }
        String str = a.f;
        if (list.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Long longValue : list) {
                stringBuilder.append(longValue.longValue()).append(f.i);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            str = stringBuilder.toString();
        }
        C0596r.e(a, "saveFailedToDeleteFromServerTrackList value = " + str);
        return C0425b.a(context).a(b.b, str, cn.com.smartdevices.bracelet.f.c.ETERNAL);
    }

    private static boolean c(Context context, C0466z c0466z) {
        if (context == null || c0466z == null) {
            throw new IllegalArgumentException();
        }
        C0425b.a(context).b(1, c0466z.x(), c0466z.z());
        return false;
    }

    public static ay d(Context context) {
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = a(context, false).query(l.a, new String[]{m.b, SocialConstants.PARAM_SUMMARY}, null, null, null, null, "trackid DESC ");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToNext()) {
                    long j = query.getLong(query.getColumnIndex(m.b));
                    ay ayVar = new ay(j);
                    ayVar.a(query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY)));
                    C0596r.e(a, "getDeathTrackInfo trackId = " + j);
                    if (query == null) {
                        return ayVar;
                    }
                    query.close();
                    return ayVar;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
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
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static C0466z d(Context context, long j) {
        Exception e;
        Cursor cursor;
        Throwable th;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{i.d, com.xiaomi.channel.relationservice.data.a.h, g.a, m.b, SocialConstants.PARAM_SUMMARY, com.xiaomi.channel.gamesdk.b.b};
        Cursor query;
        try {
            SQLiteDatabase a = a(context, false);
            query = a.query(d.a, strArr, "trackid =? ", new String[]{String.valueOf(j)}, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                if (query.moveToNext()) {
                    Object string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    if (TextUtils.isEmpty(string)) {
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    }
                    int i = query.getInt(query.getColumnIndex(com.xiaomi.channel.relationservice.data.a.h));
                    String string2 = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                    String string3 = query.getString(query.getColumnIndex(g.a));
                    int i2 = query.getInt(query.getColumnIndex(i.d));
                    C0466z c0466z = new C0466z(i, j, string3);
                    c0466z.d(i2);
                    c0466z.a(j, i, string3, string);
                    if (!TextUtils.isEmpty(string2)) {
                        c0466z.a(j, string2);
                    }
                    String a2 = a(a, j, i);
                    if (!TextUtils.isEmpty(a2)) {
                        c0466z.a(a2);
                    }
                    if (query == null) {
                        return c0466z;
                    }
                    query.close();
                    return c0466z;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                cursor = query;
                try {
                    C0596r.a(a, e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static List<aa> d(Context context, int i) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        List<aa> linkedList = new LinkedList();
        Cursor query;
        try {
            query = a(context, false).query(d.a, new String[]{m.b, g.a, SocialConstants.PARAM_SUMMARY, i.d}, "type =?", new String[]{String.valueOf(i)}, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(query.getColumnIndex(m.b));
                    Object string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    if (!TextUtils.isEmpty(string)) {
                        aa aaVar = new aa(new JSONObject(string), j, i, query.getString(query.getColumnIndex(g.a)));
                        aaVar.a(query.getInt(query.getColumnIndex(i.d)));
                        linkedList.add(aaVar);
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
            return linkedList;
        } catch (Exception e3) {
            e = e3;
            try {
                C0596r.a(a, e.getMessage());
                if (cursor != null) {
                    cursor.close();
                }
                return linkedList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean d(Context context, long j, int i) {
        return a(context, j, i, t.STATE_SYNCED_FROM_SERVER);
    }

    public static long e(Context context) {
        long j = -1;
        Cursor cursor = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            cursor = a(context, false).rawQuery("SELECT min(trackid) AS minId FROM trackinfo", null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor.moveToNext()) {
                j = cursor.getLong(cursor.getColumnIndex("minId"));
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return j;
    }

    public static List<O> e(Context context, int i) {
        Exception e;
        Throwable th;
        if (context == null || i <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = a(context, false).query(d.a, new String[]{com.xiaomi.channel.gamesdk.b.b}, "type = ? AND trackid =? ", new String[]{String.valueOf(4), String.valueOf(i)}, null, null, null);
            List<O> arrayList;
            if (query == null) {
                try {
                    arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a(a, e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            } else if (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(com.xiaomi.channel.gamesdk.b.b));
                if (TextUtils.isEmpty(string)) {
                    arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                }
                arrayList = O.a(string);
                if (query == null) {
                    return arrayList;
                }
                query.close();
                return arrayList;
            } else {
                if (query != null) {
                    query.close();
                }
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static List<cn.com.smartdevices.bracelet.gps.model.c> e(Context context, long j) {
        Exception e;
        Throwable th;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = a(context, false).query(f.a, new String[]{g.f, ParamKey.LONGITUDE, ParamKey.LATITUDE, g.e, com.xiaomi.channel.relationservice.data.a.G}, "trackid =?", new String[]{String.valueOf(j)}, null, null, "time ASC");
            List<cn.com.smartdevices.bracelet.gps.model.c> arrayList;
            if (query == null) {
                try {
                    arrayList = new ArrayList(0);
                    if (query == null) {
                        return arrayList;
                    }
                    query.close();
                    return arrayList;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.e(a, e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            arrayList = new ArrayList(query.getCount());
            int i = 0;
            while (query.moveToNext()) {
                cn.com.smartdevices.bracelet.gps.model.c cVar = new cn.com.smartdevices.bracelet.gps.model.c();
                cVar.a(query.getLong(query.getColumnIndex(g.f)));
                cVar.p = query.getDouble(query.getColumnIndex(ParamKey.LATITUDE));
                cVar.q = query.getDouble(query.getColumnIndex(ParamKey.LONGITUDE));
                cVar.o = query.getDouble(query.getColumnIndex(g.e));
                int i2 = i + 1;
                cVar.c(i);
                cVar.a(query.getString(query.getColumnIndex(com.xiaomi.channel.relationservice.data.a.G)));
                arrayList.add(cVar);
                i = i2;
            }
            if (query == null) {
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.e(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean e(Context context, long j, int i) {
        return a(context, j, i, t.STATE_SYNCED_TO_SERVER);
    }

    public static d f(Context context) {
        return b(context, 4, t.SYNC_STATE_DEFAULT);
    }

    public static az f(Context context, long j) {
        Exception e;
        Throwable th;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{com.xiaomi.channel.relationservice.data.a.h, g.a, SocialConstants.PARAM_SUMMARY};
        Cursor query;
        try {
            SQLiteDatabase a = a(context, false);
            query = a.query(d.a, strArr, "type =? AND trackid =?", new String[]{String.valueOf(4), String.valueOf(j)}, null, null, "trackid DESC");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                String str = a.f;
                str = a.f;
                while (query.moveToNext()) {
                    Object string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                    if (!TextUtils.isEmpty(string)) {
                        String string2 = query.getString(query.getColumnIndex(g.a));
                        int i = query.getInt(query.getColumnIndex(com.xiaomi.channel.relationservice.data.a.h));
                        az azVar = new az(new JSONObject(string), j, i, string2);
                        Object a2 = a(a, j, i);
                        if (!TextUtils.isEmpty(a2)) {
                            azVar.a((String) a2);
                        }
                        if (query == null) {
                            return azVar;
                        }
                        query.close();
                        return azVar;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static List<C0453l> f(Context context, int i) {
        if (context != null) {
            return b(context, null, i);
        }
        throw new IllegalArgumentException();
    }

    public static boolean f(Context context, long j, int i) {
        return b(context, j, i, t.STATE_SYNCED_FROM_SERVER);
    }

    public static int g(Context context, long j) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = a(context, false).query(d.a, new String[]{i.d}, "type =? AND trackid =?", new String[]{String.valueOf(4), String.valueOf(j)}, null, null, "trackid DESC");
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return -1;
            }
            try {
                if (query.moveToNext()) {
                    int i = query.getInt(query.getColumnIndex(i.d));
                    if (query == null) {
                        return i;
                    }
                    query.close();
                    return i;
                }
                if (query != null) {
                    query.close();
                }
                return -1;
            } catch (Exception e2) {
                e = e2;
                try {
                    C0596r.a(a, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return -1;
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
            C0596r.a(a, e.getMessage());
            if (query != null) {
                query.close();
            }
            return -1;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static d g(Context context) {
        return b(context, 4, t.STATE_UNSYNCED);
    }

    public static List<C0466z> g(Context context, int i) {
        return c(context, i, t.STATE_UNSYNCED);
    }

    public static boolean g(Context context, long j, int i) {
        return b(context, j, i, t.STATE_SYNCED_TO_SERVER);
    }

    public static List<Long> h(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        List<Long> linkedList = new LinkedList();
        String str = "sync=?";
        try {
            query = a(context, false).query(d.a, new String[]{m.b}, str, new String[]{a.f + t.STATE_TO_BE_DELETED.a()}, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    linkedList.add(Long.valueOf(query.getLong(query.getColumnIndex(m.b))));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                C0596r.a(a, e.getMessage());
                if (query != null) {
                    query.close();
                }
                return linkedList;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return linkedList;
    }

    public static boolean h(Context context, int i) {
        return a(context, i, t.STATE_SYNCED_FROM_SERVER);
    }

    public static boolean h(Context context, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        C0466z d = d(context, j);
        if (d != null) {
            List n = d.n();
            if (n != null && n.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(Context context, long j, int i) {
        return b(context, j, i, t.STATE_UNSYNCED);
    }

    public static boolean i(Context context, int i) {
        return a(context, i, t.STATE_SYNCED_TO_SERVER);
    }

    public static boolean i(Context context, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        try {
            a(context, true).delete(b.a, m.b, new String[]{String.valueOf(j)});
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
        }
        return false;
    }

    public static boolean i(Context context, long j, int i) {
        return b(context, j, i, t.STATE_SYNCED_FROM_SERVER_SUMMERY_DONE);
    }

    public static void j(Context context, int i) {
        for (aa o : b(context)) {
            h(context, o.o(), i);
        }
    }

    public static boolean j(Context context, long j) {
        if (context != null && j > 0) {
            return k(context, j);
        }
        throw new IllegalArgumentException();
    }

    private static boolean k(Context context, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        SQLiteDatabase a = a(context, true);
        try {
            a.delete(b.a, "trackid =? ", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            C0596r.a(a, e.getMessage());
        }
        try {
            a.delete(f.a, "trackid =? ", new String[]{String.valueOf(j)});
            a.delete(d.a, "trackid =? ", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e2) {
            C0596r.a(a, e2.getMessage());
            return false;
        }
    }
}
