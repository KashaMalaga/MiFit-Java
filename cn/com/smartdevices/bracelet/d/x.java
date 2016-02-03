package cn.com.smartdevices.bracelet.d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.i;
import cn.com.smartdevices.bracelet.model.BasicDateData;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.gamesdk.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class x {
    private static final String a = "FGDB";

    private x() {
    }

    public static int a(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        }
        try {
            return sQLiteDatabase.delete(G.a, "date>? AND type=? AND source=?", new String[]{str, a.f + c0595q.b(), a.f + c0595q.a()});
        } catch (Exception e) {
            C0596r.e(a, e.getMessage());
            return -1;
        }
    }

    public static ArrayList<BasicDateData> a(SQLiteDatabase sQLiteDatabase, C0595q c0595q) {
        Exception e;
        Throwable th;
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{a.f + c0595q.b(), a.f + c0595q.a(), Constants.VIA_RESULT_SUCCESS};
        Cursor query;
        try {
            query = sQLiteDatabase.query(G.a, new String[]{g.a, b.b, SocialConstants.PARAM_SUMMARY, H.k}, "type=? AND source=? AND sync=?", strArr, null, null, "date ASC");
            ArrayList<BasicDateData> arrayList;
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
            int count = query.getCount();
            arrayList = new ArrayList(count);
            arrayList.ensureCapacity(count);
            while (query.moveToNext()) {
                BasicDateData basicDateData = new BasicDateData();
                basicDateData.date = query.getString(query.getColumnIndex(g.a));
                basicDateData.data = query.getBlob(query.getColumnIndex(b.b));
                basicDateData.summary = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                basicDateData.indexs = query.getString(query.getColumnIndex(H.k));
                arrayList.add(basicDateData);
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

    public static boolean a(SQLiteDatabase sQLiteDatabase, BasicDateData basicDateData, int i, C0595q c0595q) {
        return a(sQLiteDatabase, basicDateData.date, basicDateData.data, c0595q, i, basicDateData.summary, basicDateData.indexs);
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, String str2, C0595q c0595q) {
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        } else {
            try {
                sQLiteDatabase.execSQL("update date_data_1 set summary = " + str + " where " + g.a + " = " + "'" + str2 + "'" + " and " + com.xiaomi.channel.relationservice.data.a.h + " = " + c0595q.b() + " and " + o.L + " = " + c0595q.a() + ";");
                return true;
            } catch (Exception e) {
                C0596r.a("DB", e.getMessage());
                return false;
            }
        }
    }

    private static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, C0595q c0595q, int i, String str2, String str3) {
        Exception e;
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0595q.b()));
        contentValues.put(o.L, Integer.valueOf(c0595q.a()));
        contentValues.put(g.a, str);
        contentValues.put(SocialConstants.PARAM_SUMMARY, str2);
        contentValues.put(H.k, str3);
        contentValues.put(b.b, bArr);
        contentValues.put(i.d, Integer.valueOf(i));
        String str4 = "date=? AND type=? AND source=?";
        String[] strArr = new String[]{str, a.f + c0595q.b(), a.f + c0595q.a()};
        Cursor query;
        try {
            boolean z;
            query = sQLiteDatabase.query(G.a, null, str4, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = sQLiteDatabase.update(G.a, contentValues, str4, strArr) > 0;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a("DB", e.getMessage());
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
            }
            z = sQLiteDatabase.insert(G.a, null, contentValues) > 0;
            if (query == null) {
                return z;
            }
            query.close();
            return z;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a("DB", e.getMessage());
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

    public static boolean a(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, String str2, String str3, C0595q c0595q) {
        Exception e;
        Throwable th;
        ContentValues contentValues = new ContentValues();
        contentValues.put(com.xiaomi.channel.relationservice.data.a.h, Integer.valueOf(c0595q.b()));
        contentValues.put(o.L, Integer.valueOf(c0595q.a()));
        contentValues.put(g.a, str);
        contentValues.put(SocialConstants.PARAM_SUMMARY, str2);
        contentValues.put(H.k, str3);
        contentValues.put(b.b, bArr);
        contentValues.put(i.d, Integer.valueOf(0));
        String str4 = "date=? AND type=? AND source=?";
        String[] strArr = new String[]{str, a.f + c0595q.b(), a.f + c0595q.a()};
        Cursor query;
        try {
            boolean z;
            query = sQLiteDatabase.query(G.a, null, str4, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        z = sQLiteDatabase.update(G.a, contentValues, str4, strArr) > 0;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C0596r.a("DB", e.getMessage());
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
            }
            z = sQLiteDatabase.insert(G.a, null, contentValues) > 0;
            if (query == null) {
                return z;
            }
            query.close();
            return z;
        } catch (Exception e3) {
            e = e3;
            query = null;
            C0596r.a("DB", e.getMessage());
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

    public static boolean a(SQLiteDatabase sQLiteDatabase, ArrayList<BasicDateData> arrayList, int i, C0595q c0595q) {
        String str = true;
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        } else if (arrayList == null || arrayList.size() < 1) {
            return true;
        } else {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("update date_data_1 set sync = " + i + " where " + g.a + " = " + "'" + ((BasicDateData) it.next()).date + "'" + " and " + com.xiaomi.channel.relationservice.data.a.h + " = " + c0595q.b() + " and " + o.L + " = " + c0595q.a() + ";");
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
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, List<BasicDateData> list, int i, C0595q c0595q) {
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        } else if (list == null || list.size() < 1) {
            return true;
        } else {
            try {
                sQLiteDatabase.beginTransaction();
                boolean z = true;
                for (BasicDateData basicDateData : list) {
                    z &= a(sQLiteDatabase, basicDateData.date, basicDateData.data, c0595q, i, basicDateData.summary, basicDateData.indexs);
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
    }

    public static String[] a(SQLiteDatabase sQLiteDatabase) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = sQLiteDatabase.query(G.a, null, null, null, null, null, "date ASC");
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        r0 = new String[2];
                        query.moveToFirst();
                        r0[0] = query.getString(query.getColumnIndex(g.a));
                        query.moveToLast();
                        r0[1] = query.getString(query.getColumnIndex(g.a));
                        if (query == null) {
                            return r0;
                        }
                        query.close();
                        return r0;
                    }
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
            if (query != null) {
                query.close();
            }
            return null;
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

    public static byte[] b(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        Exception e;
        Throwable th;
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{str, a.f + c0595q.b(), a.f + c0595q.a()};
        Cursor query;
        try {
            query = sQLiteDatabase.query(G.a, new String[]{b.b}, "date=? AND type=? AND source=?", strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        if (query.moveToNext()) {
                            byte[] blob = query.getBlob(query.getColumnIndex(b.b));
                            if (query == null) {
                                return blob;
                            }
                            query.close();
                            return blob;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
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
            }
            if (query != null) {
                query.close();
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

    public static byte[] c(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        Exception e;
        Throwable th;
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        }
        String[] strArr = new String[]{str, a.f + c0595q.b(), a.f + c0595q.a()};
        Cursor query;
        try {
            query = sQLiteDatabase.query(G.a, new String[]{SocialConstants.PARAM_SUMMARY}, "date=? AND type=? AND source=?", strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query.moveToNext()) {
                            byte[] blob = query.getBlob(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                            if (query == null) {
                                return blob;
                            }
                            query.close();
                            return blob;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return null;
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
            }
            if (query != null) {
                query.close();
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

    public static String d(SQLiteDatabase sQLiteDatabase, String str, C0595q c0595q) {
        Exception e;
        Throwable th;
        if (c0595q.b() != 0) {
            throw new IllegalArgumentException();
        }
        Cursor query;
        try {
            query = sQLiteDatabase.query(G.a, new String[]{SocialConstants.PARAM_SUMMARY}, "date=? AND type=? AND source=?", new String[]{str, String.valueOf(c0595q.b()), String.valueOf(c0595q.a())}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query.moveToNext()) {
                            String string = query.getString(0);
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
            }
            if (query != null) {
                query.close();
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
}
