package cn.com.smartdevices.bracelet.gps.c.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.b;

class q extends a {
    private static boolean b = false;
    private static q c = null;
    private Context d = null;

    protected q(Context context) {
        super(context);
        this.d = context;
    }

    public static synchronized q a(Context context) {
        q qVar;
        boolean z = false;
        synchronized (q.class) {
            if (c == null) {
                c = new q(context);
                try {
                    SQLiteDatabase a = c.a(false);
                    if (!b && b.i(context)) {
                        z = true;
                    }
                    C0596r.e("SDB", "SportDBHelper getInstance isNeedForceTransfer = " + z);
                    if (z) {
                        r.a(context, a);
                    }
                } catch (SQLiteException e) {
                    e();
                }
            }
            qVar = c;
        }
        return qVar;
    }

    private static void e() {
        try {
            c.close();
        } catch (Exception e) {
            a.a(e);
        }
        try {
            c.a(false);
        } catch (Exception e2) {
            a.a(e2);
        }
    }

    public SQLiteDatabase a(boolean z) {
        return super.a(z);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        b = true;
        super.onCreate(sQLiteDatabase);
        C0596r.e("SDB", "SportDBHelper onCreate");
        r.a(this.d, sQLiteDatabase);
    }
}
