package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.F;
import cn.com.smartdevices.bracelet.shoes.sync.b.g;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.c.a;
import com.xiaomi.channel.a.e.d;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.C1108o;
import com.xiaomi.h.a.G;
import com.xiaomi.h.a.K;
import com.xiaomi.h.a.O;
import com.xiaomi.h.a.u;
import com.xiaomi.h.a.w;
import com.xiaomi.push.service.ad;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.thrift.b;

public abstract class f {
    public static final String a = "register";
    public static final String b = "set-alias";
    public static final String c = "unset-alias";
    public static final String d = "set-account";
    public static final String e = "unset-account";
    public static final String f = "subscribe-topic";
    public static final String g = "unsubscibe-topic";
    public static final String h = "accept-time";
    public static final String i = ",";
    private static boolean j = true;
    private static Context k;
    private static long l = System.currentTimeMillis();

    static {
        if (a.b || a.e || a.c || a.g) {
            c.a(0);
        }
    }

    protected static synchronized String a() {
        String str;
        synchronized (f.class) {
            str = d.a(4) + l;
            l++;
        }
        return str;
    }

    public static void a(Context context, int i) {
        u.a(context).b(i & -1);
    }

    public static void a(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / h.E) / 60);
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        rawOffset = ((rawOffset + ((long) ((i3 * 60) + i4))) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(rawOffset / 60), Long.valueOf(rawOffset % 60)}));
        if (!i(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            a(context, h, arrayList, str);
        } else if (1 == l.a(context)) {
            PushMessageHandler.a(context, str, h, 0, null, arrayList);
        } else {
            l.a(context, l.a(h, arrayList, 0, null, null));
        }
    }

    private static void a(Context context, PackageInfo packageInfo) {
        int i;
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", context.getPackageName() + ".permission.MIPUSH_RECEIVE", "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.GET_TASKS", "android.permission.VIBRATE"}));
        if (packageInfo.permissions != null) {
            for (PermissionInfo permissionInfo : packageInfo.permissions) {
                if (r4.equals(permissionInfo.name)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            throw new h(String.format("<permission android:name=\"%1$s\" /> is undefined.", new Object[]{r4}), null);
        }
        if (packageInfo.requestedPermissions != null) {
            for (CharSequence charSequence : packageInfo.requestedPermissions) {
                if (!TextUtils.isEmpty(charSequence) && hashSet.contains(charSequence)) {
                    hashSet.remove(charSequence);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new h(String.format("<use-permission android:name=\"%1$s\" /> is missing.", new Object[]{hashSet.iterator().next()}), null);
        }
    }

    public static void a(Context context, j jVar) {
        C1098e c1098e = new C1098e();
        c1098e.a(jVar.a());
        c1098e.b(jVar.f());
        c1098e.d(jVar.j());
        c1098e.c(jVar.k());
        c1098e.c(jVar.h());
        c1098e.a(jVar.g());
        c1098e.b(jVar.m());
        c1098e.a(jVar.n());
        a(context, jVar.a(), c1098e);
    }

    @Deprecated
    public static void a(Context context, String str) {
        a(context, str, null);
    }

    static void a(Context context, String str, C1098e c1098e) {
        if (m.a(context).b()) {
            b uVar = new u();
            uVar.b(m.a(context).c());
            uVar.c("bar:click");
            uVar.a(str);
            uVar.a(false);
            u.a(context).a(uVar, C1094a.Notification, false, c1098e);
        }
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, null);
    }

    @Deprecated
    public static void a(Context context, String str, String str2, g gVar) {
        boolean z = false;
        a((Object) context, "context");
        a((Object) str, "appID");
        a((Object) str2, "appToken");
        try {
            k = context.getApplicationContext();
            if (k == null) {
                k = context;
            }
            if (gVar != null) {
                PushMessageHandler.a(gVar);
            }
            if (m.a(k).m() != a.a()) {
                z = true;
            }
            if (z || !m.a(k).a(str, str2) || m.a(k).n()) {
                String a = d.a(6);
                m.a(k).h();
                m.a(k).a(a.a());
                m.a(k).a(str, str2, a);
                d(k);
                w wVar = new w();
                wVar.a(a());
                wVar.b(str);
                wVar.e(str2);
                wVar.d(context.getPackageName());
                wVar.f(a);
                wVar.c(m.a(context, context.getPackageName()));
                u.a(k).a(wVar, z);
            } else {
                if (1 == l.a(context)) {
                    a((Object) gVar, "callback");
                    gVar.a(0, null, m.a(context).e());
                } else {
                    List arrayList = new ArrayList();
                    arrayList.add(m.a(context).e());
                    l.a(k, l.a(a, arrayList, 0, null, null));
                }
                u.a(context).a();
                if (m.a(k).a()) {
                    b uVar = new u();
                    uVar.b(m.a(context).c());
                    uVar.c("client_info_update");
                    uVar.a(a());
                    uVar.h = new HashMap();
                    uVar.h.put("app_version", m.a(k, k.getPackageName()));
                    CharSequence g = m.a(k).g();
                    if (!TextUtils.isEmpty(g)) {
                        uVar.h.put(g.t, g);
                    }
                    u.a(context).a(uVar, C1094a.Notification, false, null);
                }
                if (a(k) && n(k)) {
                    b uVar2 = new u();
                    uVar2.b(m.a(k).c());
                    uVar2.c("pull");
                    uVar2.a(a());
                    uVar2.a(false);
                    u.a(k).a(uVar2, C1094a.Notification, false, null, false);
                    m(k);
                }
            }
            if (j) {
                k(k);
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    protected static void a(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!b.equalsIgnoreCase(str) || System.currentTimeMillis() - l(context, str2) >= com.xiaomi.mistatistic.sdk.d.h) {
            if (c.equalsIgnoreCase(str) && l(context, str2) < 0) {
                c.a("Don't cancel alias for " + arrayList + " is unseted");
            } else if (!d.equalsIgnoreCase(str) || System.currentTimeMillis() - k(context, str2) >= com.xiaomi.mistatistic.sdk.d.h) {
                if (!e.equalsIgnoreCase(str) || k(context, str2) >= 0) {
                    a(context, str, arrayList, str3);
                } else {
                    c.a("Don't cancel account for " + arrayList + " is unseted");
                }
            } else if (1 == l.a(context)) {
                PushMessageHandler.a(context, str3, str, 0, null, arrayList);
            } else {
                l.a(context, l.a(d, arrayList, 0, null, null));
            }
        } else if (1 == l.a(context)) {
            PushMessageHandler.a(context, str3, str, 0, null, arrayList);
        } else {
            l.a(context, l.a(b, arrayList, 0, null, null));
        }
    }

    protected static void a(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(m.a(context).c())) {
            b c1108o = new C1108o();
            c1108o.a(a());
            c1108o.b(m.a(context).c());
            c1108o.c(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c1108o.d((String) it.next());
            }
            c1108o.f(str2);
            c1108o.e(context.getPackageName());
            u.a(context).a(c1108o, C1094a.Command, null);
        }
    }

    private static void a(PackageManager packageManager, Intent intent, Class<?> cls, Boolean[] boolArr) {
        int i;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, C0113o.o)) {
            PackageItemInfo packageItemInfo = resolveInfo.activityInfo;
            if (packageItemInfo != null && cls.getCanonicalName().equals(packageItemInfo.name)) {
                if (boolArr[0].booleanValue() != packageItemInfo.enabled) {
                    throw new h(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:enabled should be %<b.", new Object[]{packageItemInfo.name, boolArr[0]}), packageItemInfo);
                } else if (boolArr[1].booleanValue() != packageItemInfo.exported) {
                    throw new h(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:exported should be %<b.", new Object[]{packageItemInfo.name, boolArr[1]}), packageItemInfo);
                } else {
                    i = 1;
                    if (i == 0) {
                        throw new h(String.format("<receiver android:name=\"%1$s\" /> is missing or disabled.", new Object[]{cls.getCanonicalName()}), null);
                    }
                }
            }
        }
        i = 0;
        if (i == 0) {
            throw new h(String.format("<receiver android:name=\"%1$s\" /> is missing or disabled.", new Object[]{cls.getCanonicalName()}), null);
        }
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    public static boolean a(Context context) {
        return u.a(context).b();
    }

    public static List<String> b(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring("alias_".length()));
            }
        }
        return arrayList;
    }

    public static void b(Context context, int i) {
        u.a(context).a(i);
    }

    private static void b(Context context, PackageInfo packageInfo) {
        Map hashMap = new HashMap();
        hashMap.put("com.xiaomi.push.service.XMPushService", new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)});
        hashMap.put(PushMessageHandler.class.getCanonicalName(), new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(true)});
        hashMap.put(MessageHandleService.class.getCanonicalName(), new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)});
        if (packageInfo.services != null) {
            for (PackageItemInfo packageItemInfo : packageInfo.services) {
                if (!TextUtils.isEmpty(packageItemInfo.name) && hashMap.containsKey(packageItemInfo.name)) {
                    Boolean[] boolArr = (Boolean[]) hashMap.remove(packageItemInfo.name);
                    if (boolArr[0].booleanValue() != packageItemInfo.enabled) {
                        throw new h(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:enabled should be %<b.", new Object[]{packageItemInfo.name, boolArr[0]}), packageItemInfo);
                    } else if (boolArr[1].booleanValue() != packageItemInfo.exported) {
                        throw new h(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:exported should be %<b.", new Object[]{packageItemInfo.name, boolArr[1]}), packageItemInfo);
                    } else if (hashMap.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap.isEmpty()) {
            throw new h(String.format("<service android:name=\"%1$s\" /> is missing or disabled.", new Object[]{hashMap.keySet().iterator().next()}), null);
        }
    }

    public static void b(Context context, String str) {
        a(context, 0, 0, 0, 0, str);
    }

    public static void b(Context context, String str, String str2) {
        a(context, b, str, str2);
    }

    public static List<String> c(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_")) {
                arrayList.add(str.substring("topic_".length()));
            }
        }
        return arrayList;
    }

    public static void c(Context context, String str) {
        a(context, 0, 0, 23, 59, str);
    }

    public static void c(Context context, String str, String str2) {
        a(context, c, str, str2);
    }

    protected static void d(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("wake_up", 0);
        Editor edit = sharedPreferences.edit();
        edit.clear();
        if (j > 0) {
            edit.putLong("wake_up", j);
        }
        edit.commit();
    }

    static synchronized void d(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void d(Context context, String str, String str2) {
        a(context, d, str, str2);
    }

    static void e(Context context) {
        if (m.a(context).i()) {
            String a = d.a(6);
            String c = m.a(context).c();
            String d = m.a(context).d();
            m.a(context).h();
            m.a(context).a(c, d, a);
            w wVar = new w();
            wVar.a(a());
            wVar.b(c);
            wVar.e(d);
            wVar.f(a);
            wVar.d(context.getPackageName());
            wVar.c(m.a(context, context.getPackageName()));
            u.a(context).a(wVar, false);
        }
    }

    static synchronized void e(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    public static void e(Context context, String str, String str2) {
        a(context, e, str, str2);
    }

    public static void f(Context context) {
        u.a(context).e();
    }

    static synchronized void f(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void f(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(m.a(context).c())) {
            if (System.currentTimeMillis() - j(context, str) > com.xiaomi.mistatistic.sdk.d.h) {
                b g = new G();
                g.a(a());
                g.b(m.a(context).c());
                g.c(str);
                g.d(context.getPackageName());
                g.e(str2);
                u.a(context).a(g, C1094a.Subscription, null);
            } else if (1 == l.a(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(str);
                l.a(context, l.a(f, arrayList, 0, null, null));
            }
        }
    }

    public static void g(Context context) {
        if (m.a(context).b()) {
            K k = new K();
            k.a(a());
            k.b(m.a(context).c());
            k.c(m.a(context).e());
            k.e(m.a(context).d());
            k.d(context.getPackageName());
            u.a(context).a(k);
            PushMessageHandler.a();
            m.a(context).k();
            d(context);
            f(context);
            h(context);
        }
    }

    static synchronized void g(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    public static void g(Context context, String str, String str2) {
        if (!m.a(context).b()) {
            return;
        }
        if (j(context, str) < 0) {
            c.a("Don't cancel subscribe for " + str + " is unsubscribed");
            return;
        }
        b o = new O();
        o.a(a());
        o.b(m.a(context).c());
        o.c(str);
        o.d(context.getPackageName());
        o.e(str2);
        u.a(context).a(o, C1094a.UnSubscription, null);
    }

    public static void h(Context context) {
        u.a(context).a(-1);
    }

    static synchronized void h(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void h(Context context, String str, String str2) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putString("accept_time", str + i + str2).commit();
        }
    }

    public static String i(Context context) {
        return m.a(context).i() ? m.a(context).e() : null;
    }

    static synchronized void i(Context context, String str) {
        synchronized (f.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    private static boolean i(Context context, String str, String str2) {
        return TextUtils.equals(context.getSharedPreferences("mipush_extra", 0).getString("accept_time", com.xiaomi.e.a.f), str + i + str2);
    }

    public static long j(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1);
    }

    public static void j(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4100);
            l(context);
            b(context, packageInfo);
            a(context, packageInfo);
        } catch (Throwable e) {
            c.a(e);
        }
    }

    public static long k(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1);
    }

    private static void k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        if (System.currentTimeMillis() - com.xiaomi.mistatistic.sdk.d.h >= sharedPreferences.getLong("wake_up", 0)) {
            sharedPreferences.edit().putLong("wake_up", System.currentTimeMillis()).commit();
            new Thread(new p(context)).start();
        }
    }

    public static long l(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1);
    }

    private static void l(Context context) {
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
        intent.setPackage(packageName);
        a(packageManager, intent, NetworkStatusReceiver.class, new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(true)});
        intent = new Intent(ad.l);
        intent.setPackage(packageName);
        try {
            a(packageManager, intent, Class.forName("com.xiaomi.push.service.receivers.PingReceiver"), new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)});
        } catch (Throwable e) {
            c.a(e);
        }
        intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(packageName);
        boolean z2 = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, C0113o.o)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null) {
                try {
                    if (!TextUtils.isEmpty(activityInfo.name) && PushMessageReceiver.class.isAssignableFrom(Class.forName(activityInfo.name)) && activityInfo.enabled) {
                        z = true;
                        if (z) {
                            break;
                        }
                        z2 = z;
                    }
                } catch (Throwable e2) {
                    c.a(e2);
                    z = z2;
                }
            }
            z = false;
            if (z) {
                break;
            }
            z2 = z;
        }
        z = z2;
        if (!z) {
            throw new h("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.", null);
        }
    }

    private static void m(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
    }

    private static boolean n(Context context) {
        return System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1) > F.a;
    }
}
