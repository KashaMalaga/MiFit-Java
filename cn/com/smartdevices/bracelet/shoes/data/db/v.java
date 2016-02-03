package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.c.g;
import cn.com.smartdevices.bracelet.shoes.model.e;
import cn.com.smartdevices.bracelet.shoes.model.j;
import cn.com.smartdevices.bracelet.shoes.model.k;
import com.huami.android.zxing.CaptureActivity;
import com.tencent.open.SocialConstants;
import com.xiaomi.channel.relationservice.data.a;
import java.util.ArrayList;
import java.util.List;

class v {
    private static final String a = "SDB";

    private v() {
    }

    private static ContentValues a(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CaptureActivity.n, jVar.e);
        contentValues.put(a.h, Integer.valueOf(jVar.f));
        contentValues.put(j.g, Long.valueOf(jVar.o));
        contentValues.put(SocialConstants.PARAM_SUMMARY, jVar.l());
        if (!TextUtils.isEmpty(jVar.m)) {
            contentValues.put(j.e, jVar.m);
        }
        if (!TextUtils.isEmpty(jVar.n)) {
            contentValues.put(j.f, jVar.n);
        }
        return contentValues;
    }

    public static List<e> a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        List<e> c = c(context);
        if (c == null || c.size() == 0) {
            C0596r.e(a, "No partners");
            return null;
        }
        cn.com.smartdevices.bracelet.shoes.model.a a = q.a(context, k.SYNC_STATE_DEFAULT);
        if (a == null) {
            C0596r.d(a, "getMergedShoesPartners no boundShoes");
            return c;
        }
        String a2 = g.a(context);
        for (e eVar : c) {
            if (!(eVar == null || TextUtils.isEmpty(eVar.e))) {
                eVar.b(a.e());
                eVar.b(a.i());
                if (eVar.e.equals(a.c())) {
                    eVar.a(true);
                    eVar.a(a.g());
                }
                if (!(!eVar.k() || TextUtils.isEmpty(a.l()) || a.l().equals(a2))) {
                    C0596r.d(a, "Rest unbind;system deviceId = " + a2 + ",id from shoes = " + a.l() + ",last mac = " + a.j());
                    eVar.a(false);
                }
            }
        }
        return c;
    }

    public static boolean a(Context context, e eVar) {
        if (context == null || eVar == null) {
            throw new IllegalArgumentException();
        }
        if (TextUtils.isEmpty(eVar.a()) || eVar.j() < 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        if (!TextUtils.isEmpty(eVar.n)) {
            contentValues.put(j.f, eVar.n);
        }
        if (!TextUtils.isEmpty(eVar.m)) {
            contentValues.put(j.e, eVar.m);
        }
        if (contentValues.size() == 0) {
            return true;
        }
        try {
            return s.a(context).a(true).update(i.a, contentValues, "brand=? AND type=?", new String[]{r2, String.valueOf(eVar.j())}) > 0;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, List<j> list) {
        boolean z = true;
        if (list == null || context == null) {
            throw new IllegalArgumentException();
        } else if (list.size() == 0) {
            return true;
        } else {
            SQLiteDatabase a = s.a(context).a(true);
            try {
                a.beginTransaction();
                for (j jVar : list) {
                    a.delete(i.a, "brand=? AND type=?", new String[]{jVar.e, String.valueOf(jVar.f)});
                }
                a.setTransactionSuccessful();
                return z;
            } catch (Exception e) {
                z = a;
                C0596r.d(z, e.getMessage());
                return false;
            } finally {
                a.endTransaction();
            }
        }
    }

    public static List<j> b(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            List<j> arrayList;
            query = s.a(context).a(false).query(i.a, null, null, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            Object string = query.getString(query.getColumnIndex(CaptureActivity.n));
                            if (!TextUtils.isEmpty(string)) {
                                long j = (long) query.getInt(query.getColumnIndex(j.g));
                                j jVar = new j(string, query.getInt(query.getColumnIndex(a.h)));
                                jVar.a(j);
                                arrayList.add(jVar);
                            }
                        }
                        if (query == null) {
                            return arrayList;
                        }
                        query.close();
                        return arrayList;
                    }
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
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            arrayList = new ArrayList(0);
            if (query == null) {
                return arrayList;
            }
            query.close();
            return arrayList;
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
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static boolean b(Context context, List<j> list) {
        if (list == null || context == null) {
            throw new IllegalArgumentException();
        } else if (list.size() == 0) {
            return true;
        } else {
            SQLiteDatabase a = s.a(context).a(true);
            try {
                a.beginTransaction();
                boolean z = true;
                for (j a2 : list) {
                    ContentValues a3 = a(a2);
                    int i = a.update(i.a, a3, "brand =? AND type =? ", new String[]{((j) r5.next()).e, String.valueOf(((j) r5.next()).f)}) > 0 ? 1 : 0;
                    if (i == 0) {
                        i = a.insert(i.a, null, a3) > 0 ? 1 : 0;
                    }
                    z &= i;
                }
                a.setTransactionSuccessful();
                return z;
            } catch (Exception e) {
                C0596r.d(a, e.getMessage());
                return false;
            } finally {
                a.endTransaction();
            }
        }
    }

    private static List<e> c(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            List<e> arrayList;
            query = s.a(context).a(false).query(i.a, null, null, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        arrayList = new ArrayList(query.getCount());
                        String str = com.xiaomi.e.a.f;
                        str = com.xiaomi.e.a.f;
                        str = com.xiaomi.e.a.f;
                        while (query.moveToNext()) {
                            str = query.getString(query.getColumnIndex(CaptureActivity.n));
                            int i = query.getInt(query.getColumnIndex(a.h));
                            String string = query.getString(query.getColumnIndex(SocialConstants.PARAM_SUMMARY));
                            String string2 = query.getString(query.getColumnIndex(j.e));
                            String string3 = query.getString(query.getColumnIndex(j.f));
                            long j = (long) query.getInt(query.getColumnIndex(j.g));
                            e eVar = new e(str, i);
                            eVar.e(string2);
                            eVar.a(string3);
                            eVar.a(j);
                            eVar.g(string);
                            arrayList.add(eVar);
                        }
                        if (query == null) {
                            return arrayList;
                        }
                        query.close();
                        return arrayList;
                    }
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
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            arrayList = new ArrayList(0);
            if (query == null) {
                return arrayList;
            }
            query.close();
            return arrayList;
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
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
