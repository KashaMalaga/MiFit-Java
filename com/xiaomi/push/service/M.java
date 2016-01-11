package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.e.a;
import com.xiaomi.f.c.d;
import com.xiaomi.f.c.e;
import com.xiaomi.f.e.i;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.C1106m;
import com.xiaomi.h.a.C1112s;
import com.xiaomi.h.a.S;
import java.util.List;
import org.apache.thrift.b;

public class M {
    private static void a(XMPushService xMPushService, C1112s c1112s, String str) {
        xMPushService.a(new R(4, xMPushService, c1112s, str));
    }

    private static void a(XMPushService xMPushService, C1112s c1112s, String str, String str2) {
        xMPushService.a(new S(4, xMPushService, c1112s, str, str2));
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        C1112s c1112s = new C1112s();
        try {
            S.a(c1112s, bArr);
            if (TextUtils.isEmpty(c1112s.f)) {
                c.a("receive a mipush message without package name");
                return;
            }
            Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent.putExtra("mipush_payload", bArr);
            intent.setPackage(c1112s.f);
            String a = T.a(c1112s);
            i.a(xMPushService, a, j, true, System.currentTimeMillis());
            C1098e m = c1112s.m();
            String str;
            if (C1094a.SendMessage == c1112s.a() && J.a((Context) xMPushService).a(c1112s.f)) {
                str = a.f;
                if (m != null) {
                    str = m.b();
                }
                c.a("Drop a message for unregistered, msgid=" + str);
                a(xMPushService, c1112s, c1112s.f);
            } else if (C1094a.SendMessage != c1112s.a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), c1112s.f)) {
                if (m != null) {
                    if (m.b() != null) {
                        c.a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[]{c1112s.h(), m.b()}));
                    }
                }
                if (c(c1112s) && a((Context) xMPushService, a)) {
                    c(xMPushService, c1112s);
                } else if (a(c1112s) && !a((Context) xMPushService, a) && !b(c1112s)) {
                    d(xMPushService, c1112s);
                } else if (a((Context) xMPushService, intent)) {
                    if (C1094a.Registration == c1112s.a()) {
                        str = c1112s.j();
                        Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                        edit.putString(str, c1112s.e);
                        edit.commit();
                    }
                    if (m == null || TextUtils.isEmpty(m.h()) || TextUtils.isEmpty(m.j()) || m.h == 1 || (!T.a(m.s()) && T.a((Context) xMPushService, c1112s.f))) {
                        xMPushService.sendBroadcast(intent, C.a(c1112s.f));
                    } else {
                        boolean a2;
                        str = null;
                        if (m != null) {
                            if (m.j != null) {
                                str = (String) m.j.get("jobkey");
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = m.b();
                            }
                            a2 = U.a(xMPushService, c1112s.f, str);
                        } else {
                            a2 = false;
                        }
                        if (a2) {
                            c.a("drop a duplicate message, key=" + str);
                        } else {
                            T.a((Context) xMPushService, c1112s, bArr);
                        }
                        b(xMPushService, c1112s);
                    }
                    if (c1112s.a() == C1094a.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                        xMPushService.stopSelf();
                    }
                } else {
                    xMPushService.a(new N(4, xMPushService, c1112s));
                }
            } else {
                c.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + c1112s.f);
                a(xMPushService, c1112s, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + c1112s.f);
            }
        } catch (Throwable e) {
            c.a(e);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) ? false : true;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return (packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() && packageManager.queryIntentServices(intent, 32).isEmpty()) ? false : true;
        } catch (Throwable e) {
            c.a(e);
            return false;
        }
    }

    private static boolean a(C1112s c1112s) {
        return "com.xiaomi.xmsf".equals(c1112s.f) && c1112s.m() != null && c1112s.m().s() != null && c1112s.m().s().containsKey("miui_package_name");
    }

    private static void b(XMPushService xMPushService, C1112s c1112s) {
        xMPushService.a(new O(4, xMPushService, c1112s));
    }

    private static boolean b(C1112s c1112s) {
        return c1112s.m().s().containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, C1112s c1112s) {
        xMPushService.a(new P(4, xMPushService, c1112s));
    }

    private static boolean c(C1112s c1112s) {
        return (c1112s.m() == null || c1112s.m().s() == null) ? false : Constants.VIA_TO_TYPE_QQ_GROUP.equals(c1112s.m().s().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, C1112s c1112s) {
        xMPushService.a(new Q(4, xMPushService, c1112s));
    }

    private static C1112s e(XMPushService xMPushService, C1112s c1112s) {
        b c1106m = new C1106m();
        c1106m.b(c1112s.h());
        C1098e m = c1112s.m();
        if (m != null) {
            c1106m.a(m.b());
            c1106m.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                c1106m.c(m.f());
            }
        }
        C1112s a = xMPushService.a(c1112s.j(), c1112s.h(), c1106m, C1094a.AckMessage);
        a.a(c1112s.m().a());
        return a;
    }

    public void a(Context context, Z z, boolean z2, int i, String str) {
        if (!z2) {
            H a = I.a(context);
            if (a != null && "token-expired".equals(str)) {
                try {
                    I.a(context, a.d, a.e, a.f);
                } catch (Throwable e) {
                    c.a(e);
                } catch (Throwable e2) {
                    c.a(e2);
                }
            }
        }
    }

    public void a(XMPushService xMPushService, e eVar, Z z) {
        if (eVar instanceof d) {
            d dVar = (d) eVar;
            com.xiaomi.f.c.a p = dVar.p(GroupItemBaseInfo.KEY_START_TIME);
            if (p != null) {
                try {
                    a(xMPushService, C1149o.b(C1149o.a(z.i, dVar.k()), p.c()), (long) i.a(eVar.c()));
                    return;
                } catch (Throwable e) {
                    c.a(e);
                    return;
                }
            }
            return;
        }
        c.a("not a mipush message");
    }
}
