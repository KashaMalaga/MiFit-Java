package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.E;
import java.util.List;

public class l {
    public static final String a = "message_type";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final String f = "key_message";
    public static final String g = "key_command";
    public static final int h = 1;
    public static final int i = 2;
    private static int j = 0;

    public static int a(Context context) {
        if (j == 0) {
            if (b(context)) {
                a((int) h);
            } else {
                a((int) i);
            }
        }
        return j;
    }

    public static i a(String str, List<String> list, long j, String str2, String str3) {
        i iVar = new i();
        iVar.a(str);
        iVar.a((List) list);
        iVar.a(j);
        iVar.b(str2);
        iVar.c(str3);
        return iVar;
    }

    public static j a(E e, C1098e c1098e, boolean z) {
        j jVar = new j();
        jVar.a(e.c());
        if (!TextUtils.isEmpty(e.j())) {
            jVar.a((int) h);
            jVar.c(e.j());
        } else if (!TextUtils.isEmpty(e.h())) {
            jVar.a((int) i);
            jVar.e(e.h());
        } else if (TextUtils.isEmpty(e.r())) {
            jVar.a(0);
        } else {
            jVar.a((int) d);
            jVar.d(e.r());
        }
        jVar.h(e.p());
        if (e.l() != null) {
            jVar.b(e.l().e());
        }
        if (c1098e != null) {
            if (TextUtils.isEmpty(jVar.a())) {
                jVar.a(c1098e.b());
            }
            if (TextUtils.isEmpty(jVar.f())) {
                jVar.e(c1098e.f());
            }
            jVar.f(c1098e.j());
            jVar.g(c1098e.h());
            jVar.b(c1098e.l());
            jVar.c(c1098e.q());
            jVar.d(c1098e.o());
            jVar.a(c1098e.s());
        }
        jVar.a(z);
        return jVar;
    }

    private static void a(int i) {
        j = i;
    }

    public static void a(Context context, i iVar) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(a, d);
        intent.putExtra(g, iVar);
        context.sendBroadcast(intent);
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) ? false : true;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return a(context, intent);
    }

    public static void c(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(a, e);
        context.sendBroadcast(intent);
    }
}
