package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.a.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class L {
    private static final Map<String, byte[]> a = new HashMap();
    private static final ArrayList<Pair<String, byte[]>> b = new ArrayList();

    public static void a(Context context, int i, String str) {
        synchronized (a) {
            for (String str2 : a.keySet()) {
                a(context, str2, (byte[]) a.get(str2), i, str);
            }
            a.clear();
        }
    }

    public static void a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C.a(str));
    }

    public static void a(XMPushService xMPushService) {
        try {
            synchronized (a) {
                for (String str : a.keySet()) {
                    xMPushService.a(str, (byte[]) a.get(str));
                }
                a.clear();
            }
        } catch (Exception e) {
            c.a((Throwable) e);
            xMPushService.b(10, e);
        }
    }

    public static void a(String str, byte[] bArr) {
        synchronized (a) {
            a.put(str, bArr);
        }
    }

    public static void b(XMPushService xMPushService) {
        try {
            synchronized (b) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    xMPushService.a((String) pair.first, (byte[]) pair.second);
                }
                b.clear();
            }
        } catch (Exception e) {
            c.a((Throwable) e);
            xMPushService.b(10, e);
        }
    }

    public static void b(String str, byte[] bArr) {
        synchronized (b) {
            b.add(new Pair(str, bArr));
        }
    }
}
