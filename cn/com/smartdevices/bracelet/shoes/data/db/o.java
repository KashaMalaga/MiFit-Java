package cn.com.smartdevices.bracelet.shoes.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.shoes.d;
import cn.com.smartdevices.bracelet.shoes.model.c;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.xiaomi.channel.relationservice.data.a;

class o {
    private static final String a = "SDB";

    private o() {
    }

    public static long a(Context context) {
        return a(context, null);
    }

    static long a(Context context, c cVar) {
        Exception e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0596r.e(a, "getNextSyncDateTime indentity:" + cVar);
        p a = a(cVar);
        try {
            Cursor query = s.a(context).a(false).query(e.a, null, a.a, a.b, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() != 0) {
                        if (query.moveToNext()) {
                            long j = query.getLong(query.getColumnIndex(f.h));
                            if (query == null) {
                                return j;
                            }
                            query.close();
                            return j;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return 0;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        C0596r.d(a, e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
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
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            C0596r.d(a, e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private static p a(c cVar) {
        if (cVar == null) {
            return new p("type =? AND source=?", new String[]{String.valueOf(d.a), String.valueOf(0)});
        }
        return new p("type=? AND source=? AND (mac=? sn=? OR mac=? AND sn='')", new String[]{String.valueOf(d.a), String.valueOf(0), cVar.b(), cVar.d(), cVar.b()});
    }

    public static boolean a(Context context, long j) {
        return a(context, j, null);
    }

    static boolean a(Context context, long j, c cVar) {
        boolean z = true;
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            SQLiteDatabase a = s.a(context).a(true);
            p a2 = a(cVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put(f.h, Long.valueOf(j));
            boolean z2 = a.update(e.a, contentValues, a2.a, a2.b) > 0;
            if (z2) {
                z = z2;
            } else {
                contentValues.put(com.xiaomi.market.sdk.o.L, Integer.valueOf(0));
                contentValues.put(a.h, Integer.valueOf(d.a));
                contentValues.put(g.q, cVar == null ? com.xiaomi.e.a.f : k.a(cVar.b()));
                contentValues.put(g.p, cVar == null ? com.xiaomi.e.a.f : k.a(cVar.d()));
                contentValues.put(b.e, cVar == null ? com.xiaomi.e.a.f : k.a(cVar.c()));
                contentValues.put(g.t, cVar == null ? com.xiaomi.e.a.f : k.a(cVar.a()));
                if (a.insert(e.a, null, contentValues) <= 0) {
                    z = false;
                }
            }
            C0596r.e(a, "saveNextSyncDateTime isSuccceeded= " + z + ",timestamp = " + j);
            return z;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        try {
            String[] strArr = new String[]{String.valueOf(d.a), String.valueOf(0)};
            s.a(context).a(true).delete(e.a, "type =? AND source=?", strArr);
            return true;
        } catch (Exception e) {
            C0596r.d(a, e.getMessage());
            return false;
        }
    }
}
