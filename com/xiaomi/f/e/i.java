package com.xiaomi.f.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.d.a.a.h;
import com.xiaomi.channel.a.c.b;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.q;
import com.xiaomi.push.service.XMPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class i {
    private static b a = new b(true);
    private static int b = -1;
    private static final Object c = new Object();
    private static List<j> d = Collections.synchronizedList(new ArrayList());
    private static String e = a.f;
    private static com.xiaomi.push.b.a f = null;

    private static int a(Context context) {
        if (b == -1) {
            b = b(context);
        }
        return b;
    }

    public static int a(String str) {
        try {
            return str.getBytes(h.DEFAULT_CHARSET).length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    private static void a(j jVar) {
        for (j jVar2 : d) {
            if (jVar2.a(jVar)) {
                jVar2.f += jVar.f;
                return;
            }
        }
        d.add(jVar);
    }

    public static void a(XMPushService xMPushService, String str, long j, boolean z, long j2) {
        if (xMPushService != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(xMPushService.getPackageName()) && !"com.xiaomi.xmsf".equals(str)) {
            int a = a((Context) xMPushService);
            if (-1 != a) {
                boolean isEmpty;
                synchronized (c) {
                    isEmpty = d.isEmpty();
                    a(new j(str, j2, a, z ? 1 : 0, a == 0 ? c(xMPushService) : a.f, j));
                }
                if (isEmpty) {
                    a.a(new k(xMPushService), 5000);
                }
            }
        }
    }

    private static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? -1 : activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    private static void b(Context context, List<j> list) {
        synchronized (com.xiaomi.push.b.a.a) {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                for (j jVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(q.c, jVar.a);
                    contentValues.put("message_ts", Long.valueOf(jVar.b));
                    contentValues.put("network_type", Integer.valueOf(jVar.c));
                    contentValues.put("bytes", Long.valueOf(jVar.f));
                    contentValues.put("rcv", Integer.valueOf(jVar.d));
                    contentValues.put("imsi", jVar.e);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }

    private static synchronized String c(Context context) {
        String str;
        synchronized (i.class) {
            if (TextUtils.isEmpty(e)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        e = telephonyManager.getSubscriberId();
                    }
                } catch (Exception e) {
                }
                str = e;
            } else {
                str = e;
            }
        }
        return str;
    }

    private static com.xiaomi.push.b.a d(Context context) {
        if (f != null) {
            return f;
        }
        f = new com.xiaomi.push.b.a(context);
        return f;
    }
}
