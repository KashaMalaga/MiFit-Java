package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.view.a.C0113o;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.channel.a.e.d;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1096c;
import com.xiaomi.h.a.C1098e;
import com.xiaomi.h.a.C1106m;
import com.xiaomi.h.a.C1110q;
import com.xiaomi.h.a.C1112s;
import com.xiaomi.h.a.E;
import com.xiaomi.h.a.I;
import com.xiaomi.h.a.M;
import com.xiaomi.h.a.Q;
import com.xiaomi.h.a.S;
import com.xiaomi.h.a.u;
import com.xiaomi.h.a.y;
import com.xiaomi.push.service.T;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;
import org.apache.thrift.b;
import org.apache.thrift.f;

public class s {
    private static s a = null;
    private static Queue<String> c;
    private static String d = Constants.VIA_TO_TYPE_QQ_GROUP;
    private static String e = Constants.VIA_SSO_LOGIN;
    private static String f = Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP;
    private static Object g = new Object();
    private Context b;

    private s(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    private k a(C1112s c1112s, boolean z, byte[] bArr) {
        URISyntaxException e;
        Intent intent;
        MalformedURLException malformedURLException;
        k kVar = null;
        try {
            b a = q.a(this.b, c1112s);
            if (a == null) {
                c.c("receiving an un-recognized message. " + c1112s.a);
                return null;
            }
            c.b("receive a message." + a);
            C1094a a2 = c1112s.a();
            c.a("processing a message, action=" + a2);
            List list;
            switch (t.a[a2.ordinal()]) {
                case l.a /*1*/:
                    y yVar = (y) a;
                    if (yVar.f == 0) {
                        m.a(this.b).b(yVar.h, yVar.i);
                    }
                    if (TextUtils.isEmpty(yVar.h)) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(yVar.h);
                    }
                    kVar = l.a(f.a, list, yVar.f, yVar.g, null);
                    u.a(this.b).d();
                    return kVar;
                case a.k /*2*/:
                    if (((M) a).f == 0) {
                        m.a(this.b).h();
                        f.d(this.b);
                    }
                    PushMessageHandler.a();
                    return null;
                case a.l /*3*/:
                    if (!m.a(this.b).l() || z) {
                        E e2 = (E) a;
                        C1096c l = e2.l();
                        if (l == null) {
                            c.c("receive an empty message without push content, drop it");
                            return null;
                        }
                        if (z) {
                            f.a(this.b, l.b(), c1112s.m());
                        }
                        if (!TextUtils.isEmpty(e2.j()) && f.l(this.b, e2.j()) < 0) {
                            f.d(this.b, e2.j());
                        } else if (!TextUtils.isEmpty(e2.h()) && f.j(this.b, e2.h()) < 0) {
                            f.h(this.b, e2.h());
                        }
                        String str = (c1112s.h == null || c1112s.h.s() == null) ? null : (String) c1112s.h.j.get("jobkey");
                        if (TextUtils.isEmpty(str)) {
                            str = l.b();
                        }
                        if (z || !a(this.b, str)) {
                            Serializable a3 = l.a(e2, c1112s.m(), z);
                            if (a3.m() == 0 && !z && T.a(a3.n())) {
                                T.a(this.b, c1112s, bArr);
                                return null;
                            }
                            c.a("receive a message, msgid=" + l.b());
                            if (z && a3.n() != null && a3.n().containsKey("notify_effect")) {
                                Intent launchIntentForPackage;
                                Map n = a3.n();
                                String str2 = (String) n.get("notify_effect");
                                String str3 = "com.xiaomi.xmsf".equals(this.b.getPackageName()) ? (String) n.get("miui_package_name") : null;
                                if (d.equals(str2)) {
                                    try {
                                        PackageManager packageManager = this.b.getPackageManager();
                                        if (TextUtils.isEmpty(str3)) {
                                            str3 = this.b.getPackageName();
                                        }
                                        launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                                    } catch (Exception e3) {
                                        c.c("Cause: " + e3.getMessage());
                                        launchIntentForPackage = null;
                                    }
                                } else {
                                    if (e.equals(str2)) {
                                        if (n.containsKey("intent_uri")) {
                                            str = (String) n.get("intent_uri");
                                            if (str != null) {
                                                try {
                                                    launchIntentForPackage = Intent.parseUri(str, 1);
                                                    try {
                                                        if (TextUtils.isEmpty(str3)) {
                                                            str3 = this.b.getPackageName();
                                                        }
                                                        launchIntentForPackage.setPackage(str3);
                                                    } catch (URISyntaxException e4) {
                                                        e = e4;
                                                        c.c("Cause: " + e.getMessage());
                                                        if (launchIntentForPackage == null) {
                                                            return null;
                                                        }
                                                        if (!str2.equals(f)) {
                                                            launchIntentForPackage.putExtra(l.f, a3);
                                                        }
                                                        launchIntentForPackage.addFlags(268435456);
                                                        try {
                                                            if (this.b.getPackageManager().resolveActivity(launchIntentForPackage, C0113o.q) == null) {
                                                                return null;
                                                            }
                                                            this.b.startActivity(launchIntentForPackage);
                                                            return null;
                                                        } catch (Exception e5) {
                                                            c.c("Cause: " + e5.getMessage());
                                                            return null;
                                                        }
                                                    }
                                                } catch (URISyntaxException e6) {
                                                    e = e6;
                                                    launchIntentForPackage = null;
                                                    c.c("Cause: " + e.getMessage());
                                                    if (launchIntentForPackage == null) {
                                                        return null;
                                                    }
                                                    if (str2.equals(f)) {
                                                        launchIntentForPackage.putExtra(l.f, a3);
                                                    }
                                                    launchIntentForPackage.addFlags(268435456);
                                                    if (this.b.getPackageManager().resolveActivity(launchIntentForPackage, C0113o.q) == null) {
                                                        return null;
                                                    }
                                                    this.b.startActivity(launchIntentForPackage);
                                                    return null;
                                                }
                                            }
                                            launchIntentForPackage = null;
                                        } else if (n.containsKey("class_name")) {
                                            str = (String) n.get("class_name");
                                            Intent intent2 = new Intent();
                                            if (TextUtils.isEmpty(str3)) {
                                                str3 = this.b.getPackageName();
                                            }
                                            intent2.setComponent(new ComponentName(str3, str));
                                            try {
                                                if (n.containsKey("intent_flag")) {
                                                    intent2.setFlags(Integer.parseInt((String) n.get("intent_flag")));
                                                }
                                            } catch (NumberFormatException e7) {
                                                c.c("Cause by intent_flag: " + e7.getMessage());
                                            }
                                            launchIntentForPackage = intent2;
                                        }
                                    } else if (f.equals(str2)) {
                                        str = (String) n.get("web_uri");
                                        if (str != null) {
                                            str = str.trim().toLowerCase();
                                            str3 = (str.startsWith("http://") || str.startsWith("https://")) ? str : "http://" + str;
                                            try {
                                                str = new URL(str3).getProtocol();
                                                if ("http".equals(str) || "https".equals(str)) {
                                                    launchIntentForPackage = new Intent("android.intent.action.VIEW");
                                                    try {
                                                        launchIntentForPackage.setData(Uri.parse(str3));
                                                    } catch (MalformedURLException e8) {
                                                        MalformedURLException malformedURLException2 = e8;
                                                        intent = launchIntentForPackage;
                                                        malformedURLException = malformedURLException2;
                                                        c.c("Cause: " + malformedURLException.getMessage());
                                                        launchIntentForPackage = intent;
                                                        if (launchIntentForPackage == null) {
                                                            return null;
                                                        }
                                                        if (str2.equals(f)) {
                                                            launchIntentForPackage.putExtra(l.f, a3);
                                                        }
                                                        launchIntentForPackage.addFlags(268435456);
                                                        if (this.b.getPackageManager().resolveActivity(launchIntentForPackage, C0113o.q) == null) {
                                                            return null;
                                                        }
                                                        this.b.startActivity(launchIntentForPackage);
                                                        return null;
                                                    }
                                                }
                                                launchIntentForPackage = null;
                                            } catch (MalformedURLException e9) {
                                                malformedURLException = e9;
                                                Object obj = null;
                                                c.c("Cause: " + malformedURLException.getMessage());
                                                launchIntentForPackage = intent;
                                                if (launchIntentForPackage == null) {
                                                    return null;
                                                }
                                                if (str2.equals(f)) {
                                                    launchIntentForPackage.putExtra(l.f, a3);
                                                }
                                                launchIntentForPackage.addFlags(268435456);
                                                if (this.b.getPackageManager().resolveActivity(launchIntentForPackage, C0113o.q) == null) {
                                                    return null;
                                                }
                                                this.b.startActivity(launchIntentForPackage);
                                                return null;
                                            }
                                        }
                                    }
                                    launchIntentForPackage = null;
                                }
                                if (launchIntentForPackage == null) {
                                    return null;
                                }
                                if (str2.equals(f)) {
                                    launchIntentForPackage.putExtra(l.f, a3);
                                }
                                launchIntentForPackage.addFlags(268435456);
                                if (this.b.getPackageManager().resolveActivity(launchIntentForPackage, C0113o.q) == null) {
                                    return null;
                                }
                                this.b.startActivity(launchIntentForPackage);
                                return null;
                            }
                            Serializable serializable = a3;
                        } else {
                            c.a("drop a duplicate message, key=" + str);
                        }
                        if (c1112s.m() != null || z) {
                            return kVar;
                        }
                        a(e2, c1112s.m());
                        return kVar;
                    }
                    c.a("receive a message in pause state. drop it");
                    return null;
                case a.aQ /*4*/:
                    I i = (I) a;
                    if (i.f == 0) {
                        f.h(this.b, i.h());
                    }
                    if (TextUtils.isEmpty(i.h())) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(i.h());
                    }
                    return l.a(f.f, list, i.f, i.g, i.k());
                case a.X /*5*/:
                    Q q = (Q) a;
                    if (q.f == 0) {
                        f.i(this.b, q.h());
                    }
                    if (TextUtils.isEmpty(q.h())) {
                        list = null;
                    } else {
                        list = new ArrayList();
                        list.add(q.h());
                    }
                    return l.a(f.g, list, q.f, q.g, q.k());
                case a.bt /*6*/:
                    C1110q c1110q = (C1110q) a;
                    Object e10 = c1110q.e();
                    list = c1110q.k();
                    if (c1110q.g == 0) {
                        if (TextUtils.equals(e10, f.h) && list != null && list.size() > 1) {
                            f.h(this.b, (String) list.get(0), (String) list.get(1));
                            if ("00:00".equals(list.get(0)) && "00:00".equals(list.get(1))) {
                                m.a(this.b).a(true);
                            } else {
                                m.a(this.b).a(false);
                            }
                        } else if (TextUtils.equals(e10, f.b) && list != null && list.size() > 0) {
                            f.d(this.b, (String) list.get(0));
                        } else if (TextUtils.equals(e10, f.c) && list != null && list.size() > 0) {
                            f.e(this.b, (String) list.get(0));
                        } else if (TextUtils.equals(e10, f.d) && list != null && list.size() > 0) {
                            f.f(this.b, (String) list.get(0));
                        } else if (TextUtils.equals(e10, f.e) && list != null && list.size() > 0) {
                            f.g(this.b, (String) list.get(0));
                        }
                    }
                    return l.a(e10, list, c1110q.g, c1110q.h, c1110q.m());
                case a.bc /*7*/:
                    u uVar = (u) a;
                    if ("registration id expired".equalsIgnoreCase(uVar.e)) {
                        f.e(this.b);
                        return null;
                    } else if (!"client_info_update_ok".equalsIgnoreCase(uVar.e) || uVar.h() == null || !uVar.h().containsKey("app_version")) {
                        return null;
                    } else {
                        m.a(this.b).a((String) uVar.h().get("app_version"));
                        return null;
                    }
                default:
                    return null;
            }
        } catch (Throwable e11) {
            c.a(e11);
            c.c("receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static s a(Context context) {
        if (a == null) {
            a = new s(context);
        }
        return a;
    }

    private void a(E e, C1098e c1098e) {
        b c1106m = new C1106m();
        c1106m.b(e.e());
        c1106m.a(e.c());
        c1106m.a(e.l().g());
        if (!TextUtils.isEmpty(e.h())) {
            c1106m.c(e.h());
        }
        if (!TextUtils.isEmpty(e.j())) {
            c1106m.d(e.j());
        }
        u.a(this.b).a(c1106m, C1094a.AckMessage, c1098e);
    }

    private void a(C1112s c1112s) {
        C1098e m = c1112s.m();
        b c1106m = new C1106m();
        c1106m.b(c1112s.h());
        c1106m.a(m.b());
        c1106m.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            c1106m.c(m.f());
        }
        u.a(this.b).a(c1106m, C1094a.AckMessage, false, c1112s.m());
    }

    private static boolean a(Context context, String str) {
        boolean z = false;
        synchronized (g) {
            SharedPreferences j = m.a(context).j();
            if (c == null) {
                String[] split = j.getString("pref_msg_ids", com.xiaomi.e.a.f).split(f.i);
                c = new LinkedList();
                for (Object add : split) {
                    c.add(add);
                }
            }
            if (c.contains(str)) {
                z = true;
            } else {
                c.add(str);
                if (c.size() > 10) {
                    c.poll();
                }
                String a = d.a(c, f.i);
                Editor edit = j.edit();
                edit.putString("pref_msg_ids", a);
                edit.commit();
            }
        }
        return z;
    }

    public k a(Intent intent) {
        k kVar = null;
        String action = intent.getAction();
        c.a("receive an intent from server, action=" + action);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                c.c("receiving an empty message, drop");
            } else {
                C1112s c1112s = new C1112s();
                try {
                    S.a(c1112s, byteArrayExtra);
                    m a = m.a(this.b);
                    if (!(c1112s.a() != C1094a.SendMessage || c1112s.m() == null || a.l() || booleanExtra)) {
                        a(c1112s);
                    }
                    if (!a.i() && c1112s.a != C1094a.Registration) {
                        c.c("receive message without registration. need unregister or re-register!");
                    } else if (!a.i() || !a.n()) {
                        kVar = a(c1112s, booleanExtra, byteArrayExtra);
                    } else if (c1112s.a == C1094a.UnRegistration) {
                        a.h();
                        f.d(this.b);
                        PushMessageHandler.a();
                    } else {
                        f.g(this.b);
                    }
                } catch (Throwable e) {
                    c.a(e);
                } catch (Throwable e2) {
                    c.a(e2);
                }
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            kVar = new i();
            Object c1112s2 = new C1112s();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    S.a(c1112s2, byteArrayExtra2);
                }
            } catch (f e3) {
            }
            kVar.a(String.valueOf(c1112s2.a()));
            kVar.a((long) intent.getIntExtra("mipush_error_code", 0));
            kVar.b(intent.getStringExtra("mipush_error_msg"));
            c.c("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
        }
        return kVar;
    }
}
