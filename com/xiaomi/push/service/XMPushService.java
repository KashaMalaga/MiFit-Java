package com.xiaomi.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.tencent.connect.common.Constants;
import com.xiaomi.c.a.L;
import com.xiaomi.channel.a.b.c;
import com.xiaomi.f.A;
import com.xiaomi.f.C1090a;
import com.xiaomi.f.C1091b;
import com.xiaomi.f.D;
import com.xiaomi.f.c.d;
import com.xiaomi.f.c.e;
import com.xiaomi.f.e.g;
import com.xiaomi.f.e.h;
import com.xiaomi.f.l;
import com.xiaomi.f.o;
import com.xiaomi.f.p;
import com.xiaomi.f.r;
import com.xiaomi.g.i;
import com.xiaomi.h.a.C1094a;
import com.xiaomi.h.a.C1104k;
import com.xiaomi.h.a.C1112s;
import com.xiaomi.h.a.S;
import com.xiaomi.h.a.u;
import com.xiaomi.h.a.w;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.network.f;
import com.xiaomi.push.service.a.a;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.thrift.b;

public class XMPushService extends Service implements p {
    public static int a = 1;
    private o b;
    private C1090a c;
    private C1150p d;
    private long e = 0;
    private A f;
    private C1091b g;
    private l h;
    private C i;
    private PacketSync j = null;
    private a k = null;
    private C1135E l = null;
    private r m = new C1152r(this);

    static {
        f.a("app.chat.xiaomi.net", "42.62.94.2");
        f.a("app.chat.xiaomi.net", "app01.nodes.gslb.mi-idc.com");
        f.a("app.chat.xiaomi.net", "120.134.33.29");
        f.a("app.chat.xiaomi.net", "app02.nodes.gslb.mi-idc.com");
        A.c = true;
        if (com.xiaomi.channel.a.c.a.b || com.xiaomi.channel.a.c.a.e || com.xiaomi.channel.a.c.a.c || com.xiaomi.channel.a.c.a.g) {
            c.a(0);
        }
    }

    private d a(d dVar, String str) {
        byte[] a = C1149o.a(str, dVar.k());
        d dVar2 = new d();
        dVar2.n(dVar.n());
        dVar2.m(dVar.m());
        dVar2.k(dVar.k());
        dVar2.l(dVar.l());
        dVar2.b(true);
        String a2 = C1149o.a(a, g.c(dVar.c()));
        com.xiaomi.f.c.a aVar = new com.xiaomi.f.c.a(GroupItemBaseInfo.KEY_START_TIME, null, (String[]) null, (String[]) null);
        aVar.b(a2);
        dVar2.a(aVar);
        return dVar2;
    }

    private e a(e eVar, String str, String str2, boolean z) {
        X a = X.a();
        List b = a.b(str);
        if (b.isEmpty()) {
            c.a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            eVar.o(str);
            String l = eVar.l();
            if (TextUtils.isEmpty(l)) {
                l = (String) b.get(0);
                eVar.l(l);
            }
            Z b2 = a.b(l, eVar.n());
            if (!f()) {
                c.a("drop a packet as the channel is not connected, chid=" + l);
            } else if (b2 == null || b2.m != ab.binded) {
                c.a("drop a packet as the channel is not opened, chid=" + l);
            } else if (TextUtils.equals(str2, b2.j)) {
                return ((eVar instanceof d) && z) ? a((d) eVar, b2.i) : eVar;
            } else {
                c.a("invalid session. " + str2);
            }
        }
        return null;
    }

    private String a(String str) {
        return "<iq to='" + str + "' id='0' chid='0' type='get'><ping xmlns='urn:xmpp:ping'>%1$s%2$s</ping></iq>";
    }

    private void a(Intent intent) {
        if (ad.j.equals(intent.getAction())) {
            int intExtra = intent.getIntExtra(ad.n, -1);
            int intExtra2 = intent.getIntExtra("ext_stats_key", -1);
            int intExtra3 = intent.getIntExtra("ext_stats_val", 0);
            String stringExtra = intent.getStringExtra("ext_stats_host");
            String stringExtra2 = intent.getStringExtra("ext_stats_magic");
            if (intExtra > 0 && intExtra < HeartRateInfo.HR_EMPTY_VALUE && intExtra2 != -1 && i.a(intExtra, intExtra2, intExtra3, stringExtra, stringExtra2)) {
                i.a(intExtra, intExtra2, intExtra3, stringExtra);
            }
        }
    }

    private void a(String str, int i) {
        Collection<Z> c = X.a().c(str);
        if (c != null) {
            for (Z z : c) {
                if (z != null) {
                    a(new C1146l(this, z, i, null, null));
                }
            }
        }
        X.a().a(str);
    }

    private boolean a(String str, Intent intent) {
        Z b = X.a().b(str, intent.getStringExtra(ad.m));
        boolean z = false;
        if (b == null || str == null) {
            return false;
        }
        Object stringExtra = intent.getStringExtra(ad.y);
        String stringExtra2 = intent.getStringExtra(ad.r);
        if (!(TextUtils.isEmpty(b.j) || TextUtils.equals(stringExtra, b.j))) {
            c.a("session changed. old session=" + b.j + ", new session=" + stringExtra);
            z = true;
        }
        if (stringExtra2.equals(b.i)) {
            return z;
        }
        c.a("security changed. ");
        return true;
    }

    private Z b(String str, Intent intent) {
        Z b = X.a().b(str, intent.getStringExtra(ad.m));
        if (b == null) {
            b = new Z(this);
        }
        b.h = intent.getStringExtra(ad.n);
        b.b = intent.getStringExtra(ad.m);
        b.c = intent.getStringExtra(ad.p);
        b.a = intent.getStringExtra(ad.v);
        b.f = intent.getStringExtra(ad.t);
        b.g = intent.getStringExtra(ad.u);
        b.e = intent.getBooleanExtra(ad.s, false);
        b.i = intent.getStringExtra(ad.r);
        b.j = intent.getStringExtra(ad.y);
        b.d = intent.getStringExtra(ad.q);
        b.k = this.i;
        b.l = getApplicationContext();
        X.a().a(b);
        return b;
    }

    private void j() {
        if (I.a(getApplicationContext()) != null) {
            Z a = I.a(getApplicationContext()).a(this);
            a(a);
            X.a().a(a);
            if (com.xiaomi.channel.a.d.a.d(getApplicationContext())) {
                a(true);
            }
        }
    }

    private void k() {
        if (!c()) {
            this.k.a();
        } else if (!this.k.b()) {
            this.k.a(true);
        }
    }

    private void l() {
        if (this.h != null && this.h.i()) {
            c.c("try to connect while connecting.");
        } else if (this.h == null || !this.h.j()) {
            this.b.b(com.xiaomi.channel.a.d.a.f(this));
            if (this.f.r()) {
                n();
                if (this.h == null || this.h.o() == 2) {
                    m();
                }
            } else {
                m();
                if (this.h == null || this.h.o() == 2) {
                    n();
                }
            }
            if (this.h == null) {
                V.a();
                X.a().a((Context) this);
                sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                return;
            }
            sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
        } else {
            c.c("try to connect while is connected.");
        }
    }

    private void m() {
        try {
            this.f.t();
            this.f.a(this.m, new B(this));
            this.h = this.f;
        } catch (Exception e) {
            c.a("fail to create xmpp connection", (Throwable) e);
            this.f.a(new com.xiaomi.f.c.g(com.xiaomi.f.c.i.unavailable), 3, e);
        }
    }

    private void n() {
        try {
            com.xiaomi.network.c a = f.a().a("mibind.chat.gslb.mi-idc.com");
            if (a != null) {
                this.c.a(a);
            }
            this.g.a();
            this.g.a(this.m, new C1153s(this));
            this.h = this.g;
        } catch (Throwable e) {
            c.a("fail to create BOSH connection", e);
            this.g.a(new com.xiaomi.f.c.g(com.xiaomi.f.c.i.unavailable), 3, e);
        }
    }

    public A a(o oVar) {
        return new A(this, oVar);
    }

    public d a(C1112s c1112s) {
        try {
            d dVar = new d();
            dVar.l(Constants.VIA_SHARE_TYPE_TEXT);
            dVar.m("xiaomi.com");
            dVar.n(I.a(this).a);
            dVar.b(true);
            dVar.f(cn.com.smartdevices.bracelet.push.a.c.a);
            dVar.o(c1112s.f);
            String str = I.a(this).a;
            c1112s.g.b = str.substring(0, str.indexOf("@"));
            c1112s.g.d = str.substring(str.indexOf("/") + 1);
            String valueOf = String.valueOf(com.xiaomi.channel.a.e.a.a(C1149o.a(C1149o.a(I.a(this).c, dVar.k()), S.a(c1112s))));
            com.xiaomi.f.c.a aVar = new com.xiaomi.f.c.a(GroupItemBaseInfo.KEY_START_TIME, null, (String[]) null, (String[]) null);
            aVar.b(valueOf);
            dVar.a(aVar);
            c.a("try send mi push message. packagename:" + c1112s.f + " action:" + c1112s.a);
            return dVar;
        } catch (Throwable e) {
            c.a(e);
            return null;
        }
    }

    public d a(byte[] bArr) {
        C1112s c1112s = new C1112s();
        try {
            S.a(c1112s, bArr);
            return a(c1112s);
        } catch (Throwable e) {
            c.a(e);
            return null;
        }
    }

    public C1112s a(String str, String str2) {
        b uVar = new u();
        uVar.b(str2);
        uVar.c("package uninstalled");
        uVar.a(e.j());
        uVar.a(false);
        return a(str, str2, uVar, C1094a.Notification);
    }

    public <T extends b<T, ?>> C1112s a(String str, String str2, T t, C1094a c1094a) {
        byte[] a = S.a(t);
        C1112s c1112s = new C1112s();
        C1104k c1104k = new C1104k();
        c1104k.a = 5;
        c1104k.b = "fakeid";
        c1112s.a(c1104k);
        c1112s.a(ByteBuffer.wrap(a));
        c1112s.a(c1094a);
        c1112s.c(true);
        c1112s.b(str);
        c1112s.a(false);
        c1112s.a(str2);
        return c1112s;
    }

    public void a() {
        this.d.a();
        Iterator it = X.a().b().iterator();
        while (it.hasNext()) {
            a(new C1136a(this, (Z) it.next()));
        }
    }

    public void a(int i) {
        this.l.a(i);
    }

    public void a(int i, Exception exception) {
        a(false);
    }

    public void a(e eVar) {
        if (this.h != null) {
            this.h.a(eVar);
            return;
        }
        throw new D("try send msg while connection is null.");
    }

    public void a(Z z) {
        z.a(new C1160z(this));
    }

    public void a(e eVar) {
        a(eVar, 0);
    }

    public void a(e eVar, long j) {
        this.l.a(eVar, j);
    }

    public void a(Exception exception) {
        a(false);
    }

    public void a(String str, String str2, int i, String str3, String str4) {
        Z b = X.a().b(str, str2);
        if (b != null) {
            a(new C1146l(this, b, i, str4, str3));
        }
        X.a().a(str, str2);
    }

    public void a(String str, byte[] bArr) {
        if (this.h != null) {
            e a = a(bArr);
            if (a != null) {
                this.h.a(a);
                return;
            } else {
                L.a(this, str, bArr, com.xiaomi.mipush.sdk.b.e, "not a valid message");
                return;
            }
        }
        throw new D("try send msg while connection is null.");
    }

    public void a(boolean z) {
        this.d.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            L.a(this, str, bArr, com.xiaomi.mipush.sdk.b.e, "null payload");
            c.a("register request without payload");
            return;
        }
        C1112s c1112s = new C1112s();
        try {
            S.a(c1112s, bArr);
            if (c1112s.a == C1094a.Registration) {
                w wVar = new w();
                try {
                    S.a(wVar, c1112s.f());
                    L.a(c1112s.j(), bArr);
                    a(new K(this, c1112s.j(), wVar.d(), wVar.h(), bArr));
                    return;
                } catch (Throwable e) {
                    c.a(e);
                    L.a(this, str, bArr, com.xiaomi.mipush.sdk.b.e, " data action error.");
                    return;
                }
            }
            L.a(this, str, bArr, com.xiaomi.mipush.sdk.b.e, " registration action required.");
            c.a("register request with invalid payload");
        } catch (Throwable e2) {
            c.a(e2);
            L.a(this, str, bArr, com.xiaomi.mipush.sdk.b.e, " data container error.");
        }
    }

    public void a(e[] eVarArr) {
        if (this.h != null) {
            this.h.a(eVarArr);
            return;
        }
        throw new D("try send msg while connection is null.");
    }

    public void b() {
        c.b("begin to connect...");
    }

    public void b(int i, Exception exception) {
        c.a("disconnect " + hashCode() + ", " + (this.h == null ? null : Integer.valueOf(this.h.hashCode())));
        if (this.h != null) {
            this.h.a(new com.xiaomi.f.c.g(com.xiaomi.f.c.i.unavailable), i, exception);
            this.h = null;
        }
        a(7);
        a(4);
        X.a().a((Context) this, i);
    }

    public void b(C1112s c1112s) {
        if (this.h != null) {
            e a = a(c1112s);
            if (a != null) {
                this.h.a(a);
                return;
            }
            return;
        }
        throw new D("try send msg while connection is null.");
    }

    public void b(Z z) {
        if (z != null) {
            long a = z.a();
            c.a("schedule rebind job in " + (a / 1000));
            a(new C1136a(this, z), a);
        }
    }

    public void b(e eVar) {
        this.l.a(eVar.d, (Object) eVar);
    }

    public boolean b(int i) {
        return this.l.b(i);
    }

    public boolean c() {
        return com.xiaomi.channel.a.d.a.d(this) && X.a().c() > 0;
    }

    public C d() {
        return new C();
    }

    public C e() {
        return this.i;
    }

    public boolean f() {
        return this.h != null && this.h.j();
    }

    public boolean g() {
        return this.h != null && this.h.i();
    }

    public l h() {
        return this.h;
    }

    public void i() {
        a(new C1154t(this, 10), 120000);
    }

    public IBinder onBind(Intent intent) {
        return new C1141g(this);
    }

    public void onCreate() {
        super.onCreate();
        h.a(this);
        H a = I.a(this);
        if (a != null) {
            com.xiaomi.channel.a.c.a.a(a.g);
        }
        f.a(this, null, null, Constants.VIA_RESULT_SUCCESS, cn.com.smartdevices.bracelet.push.a.c.a, "2.1");
        this.b = new o(null, 5222, "xiaomi.com", null);
        this.b.a(true);
        this.f = a(this.b);
        this.f.a(a("xiaomi.com"));
        this.c = new C1090a(false, new com.xiaomi.network.c("mibind.chat.gslb.mi-idc.com"), 80, "mibind/http-bind", "xiaomi.com", null);
        System.setProperty(L.class.getName() + ".emptyRequestDelay", String.valueOf(com.xiaomi.account.openauth.h.E));
        this.g = new C1091b(this, this.c);
        this.i = d();
        this.i.a((Context) this);
        this.k = new a(this);
        this.f.a((p) this);
        this.g.a((p) this);
        this.j = new PacketSync(this);
        this.d = new C1150p(this);
        new D().a();
        this.l = new C1135E("Connection Controller Thread");
        this.l.start();
        a(new C1155u(this, 11));
        X a2 = X.a();
        a2.e();
        a2.a(new C1156v(this));
    }

    public void onDestroy() {
        this.l.a();
        a(new A(this, 2));
        a(new C1140f(this));
        X.a().e();
        X.a().a((Context) this, 15);
        X.a().d();
        this.f.b((p) this);
        this.g.b((p) this);
        this.k.a();
        super.onDestroy();
        c.a("Service destroyed");
    }

    public void onStart(Intent intent, int i) {
        Z z = null;
        boolean z2 = true;
        boolean z3 = false;
        if (intent == null) {
            c.c("onStart() with intent NULL");
        } else {
            c.b("onStart() with intent.Action = " + intent.getAction());
        }
        X a = X.a();
        if (intent != null && intent.getAction() != null) {
            String stringExtra;
            if (ad.a.equalsIgnoreCase(intent.getAction()) || ad.g.equalsIgnoreCase(intent.getAction())) {
                stringExtra = intent.getStringExtra(ad.n);
                if (TextUtils.isEmpty(intent.getStringExtra(ad.r))) {
                    c.a("security is empty. ignore.");
                } else if (stringExtra != null) {
                    boolean a2 = a(stringExtra, intent);
                    Z b = b(stringExtra, intent);
                    if (!com.xiaomi.channel.a.d.a.d(this)) {
                        this.i.a(this, b, false, 2, null);
                    } else if (!f()) {
                        a(true);
                    } else if (b.m == ab.unbind) {
                        a(new C1136a(this, b));
                    } else if (a2) {
                        a(new C1144j(this, b));
                    } else if (b.m == ab.binding) {
                        c.a(String.format("the client is binding. %1$s %2$s.", new Object[]{b.h, b.b}));
                    } else if (b.m == ab.binded) {
                        this.i.a(this, b, true, 0, null);
                    }
                } else {
                    c.c("channel id is empty, do nothing!");
                }
            } else if (ad.f.equalsIgnoreCase(intent.getAction())) {
                stringExtra = intent.getStringExtra(ad.v);
                r2 = intent.getStringExtra(ad.n);
                Object stringExtra2 = intent.getStringExtra(ad.m);
                if (TextUtils.isEmpty(r2)) {
                    for (String stringExtra3 : a.b(stringExtra3)) {
                        a(stringExtra3, 2);
                    }
                } else if (TextUtils.isEmpty(stringExtra2)) {
                    a(r2, 2);
                } else {
                    a(r2, stringExtra2, 2, null, null);
                }
            } else if (ad.b.equalsIgnoreCase(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.v);
                r1 = intent.getStringExtra(ad.y);
                Bundle bundleExtra = intent.getBundleExtra("ext_packet");
                e a3 = a(new d(bundleExtra), stringExtra3, r1, intent.getBooleanExtra("ext_encrypt", true));
                if (a3 != null) {
                    a(new C1151q(this, a3));
                }
            } else if (ad.d.equalsIgnoreCase(intent.getAction())) {
                r1 = intent.getStringExtra(ad.v);
                r2 = intent.getStringExtra(ad.y);
                Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
                d[] dVarArr = new d[parcelableArrayExtra.length];
                boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
                while (r3 < parcelableArrayExtra.length) {
                    dVarArr[r3] = new d((Bundle) parcelableArrayExtra[r3]);
                    dVarArr[r3] = (d) a(dVarArr[r3], r1, r2, booleanExtra);
                    if (dVarArr[r3] != null) {
                        r3++;
                    } else {
                        return;
                    }
                }
                a(new C1147m(this, dVarArr));
            } else if (ad.c.equalsIgnoreCase(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.v);
                r1 = intent.getStringExtra(ad.y);
                r4 = new com.xiaomi.f.c.b(intent.getBundleExtra("ext_packet"));
                if (a(r4, stringExtra3, r1, false) != null) {
                    a(new C1151q(this, r4));
                }
            } else if (ad.e.equalsIgnoreCase(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.v);
                r1 = intent.getStringExtra(ad.y);
                r4 = new com.xiaomi.f.c.g(intent.getBundleExtra("ext_packet"));
                if (a(r4, stringExtra3, r1, false) != null) {
                    a(new C1151q(this, r4));
                }
            } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                    c.a("Service called on timer");
                } else if (System.currentTimeMillis() - this.e >= 30000) {
                    this.e = System.currentTimeMillis();
                    c.a("Service called on check alive.");
                } else {
                    return;
                }
                if (this.l.b()) {
                    c.c("ERROR, the job controller is blocked.");
                    X.a().a((Context) this, 14);
                    stopSelf();
                } else if (f()) {
                    if (this.h.q()) {
                        a(new C1143i(this));
                    } else {
                        a(new C1139d(this, 17, null));
                    }
                } else if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                    a(false);
                } else {
                    a(true);
                }
            } else if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                NetworkInfo activeNetworkInfo;
                try {
                    activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Throwable e) {
                    c.a(e);
                    activeNetworkInfo = null;
                }
                if (activeNetworkInfo != null) {
                    c.a("network changed, " + activeNetworkInfo.toString());
                } else {
                    c.a("network changed, no active network");
                }
                this.f.s();
                this.g.s();
                if (!com.xiaomi.channel.a.d.a.d(this)) {
                    a(new C1139d(this, 2, null));
                } else if (!(f() || g())) {
                    this.l.a(1);
                    a(new C1138c(this));
                }
                k();
            } else if (ad.h.equals(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.n);
                if (stringExtra3 != null) {
                    b(stringExtra3, intent);
                }
                a(new C1145k(this));
            } else if (ad.i.equals(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.v);
                List b2 = a.b(stringExtra3);
                if (b2.isEmpty()) {
                    c.a("open channel should be called first before update info, pkg=" + stringExtra3);
                    return;
                }
                stringExtra3 = intent.getStringExtra(ad.n);
                Object stringExtra4 = intent.getStringExtra(ad.m);
                if (TextUtils.isEmpty(stringExtra3)) {
                    stringExtra3 = (String) b2.get(0);
                }
                if (TextUtils.isEmpty(stringExtra4)) {
                    r0 = a.c(stringExtra3);
                    if (!(r0 == null || r0.isEmpty())) {
                        z = (Z) r0.iterator().next();
                    }
                } else {
                    z = a.b(stringExtra3, stringExtra4);
                }
                if (z != null) {
                    if (intent.hasExtra(ad.t)) {
                        z.f = intent.getStringExtra(ad.t);
                    }
                    if (intent.hasExtra(ad.u)) {
                        z.g = intent.getStringExtra(ad.u);
                    }
                }
            } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
                if (ae.a(getApplicationContext()).a() && ae.a(getApplicationContext()).b() == 0) {
                    c.a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                    return;
                }
                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                String stringExtra5 = intent.getStringExtra("mipush_app_package");
                boolean booleanExtra2 = intent.getBooleanExtra("mipush_env_chanage", false);
                r3 = intent.getIntExtra("mipush_env_type", 1);
                J.a((Context) this).c(stringExtra5);
                if (!booleanExtra2 || "com.xiaomi.xmsf".equals(getPackageName())) {
                    a(byteArrayExtra, stringExtra5);
                } else {
                    a(new C1157w(this, 14, r3, byteArrayExtra, stringExtra5));
                }
            } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                r1 = intent.getStringExtra("mipush_app_package");
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                z3 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                r0 = X.a().c(Constants.VIA_SHARE_TYPE_TEXT);
                if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                    J.a((Context) this).b(r1);
                }
                if (r0.isEmpty()) {
                    if (z3) {
                        L.b(r1, byteArrayExtra2);
                    }
                } else if (((Z) r0.iterator().next()).m == ab.binded) {
                    a(new C1158x(this, 4, r1, byteArrayExtra2));
                } else if (z3) {
                    L.b(r1, byteArrayExtra2);
                }
            } else if (C1148n.a.equals(intent.getAction())) {
                stringExtra3 = intent.getStringExtra("uninstall_pkg_name");
                if (stringExtra3 != null && !TextUtils.isEmpty(stringExtra3.trim())) {
                    try {
                        getPackageManager().getPackageInfo(stringExtra3, PersonInfo.INCOMING_CALL_DISABLE_BIT);
                        z2 = false;
                    } catch (NameNotFoundException e2) {
                    }
                    if ("com.xiaomi.channel".equals(stringExtra3) && !X.a().c(Constants.VIA_TO_TYPE_QQ_GROUP).isEmpty() && r9) {
                        a(Constants.VIA_TO_TYPE_QQ_GROUP, 0);
                        c.a("close the miliao channel as the app is uninstalled.");
                        return;
                    }
                    SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
                    r2 = sharedPreferences.getString(stringExtra3, null);
                    if (!TextUtils.isEmpty(r2) && r9) {
                        Editor edit = sharedPreferences.edit();
                        edit.remove(stringExtra3);
                        edit.commit();
                        if (T.e(this, stringExtra3)) {
                            T.d(this, stringExtra3);
                        }
                        T.b(this, stringExtra3);
                        if (f() && r2 != null) {
                            try {
                                b(a(stringExtra3, r2));
                                c.a("uninstall " + stringExtra3 + " msg sent");
                            } catch (Exception e3) {
                                c.c("Fail to send Message: " + e3.getMessage());
                                b(10, e3);
                            }
                        }
                    }
                }
            } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
                stringExtra3 = intent.getStringExtra(ad.v);
                r1 = intent.getIntExtra(ad.w, 0);
                if (!TextUtils.isEmpty(stringExtra3)) {
                    if (r1 >= 0) {
                        T.a((Context) this, stringExtra3, r1);
                    } else if (r1 == -1) {
                        T.b(this, stringExtra3);
                    }
                }
            } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
                r2 = intent.getStringExtra(ad.v);
                CharSequence stringExtra6 = intent.getStringExtra(ad.z);
                CharSequence b3;
                if (intent.hasExtra(ad.x)) {
                    r1 = intent.getIntExtra(ad.x, 0);
                    b3 = com.xiaomi.channel.a.e.c.b(r2 + r1);
                } else {
                    b3 = com.xiaomi.channel.a.e.c.b(r2);
                    r1 = 0;
                    z3 = true;
                }
                if (TextUtils.isEmpty(r2) || !TextUtils.equals(stringExtra6, r0)) {
                    c.c("invalid notification for " + r2);
                } else if (z3) {
                    T.d(this, r2);
                } else {
                    T.b((Context) this, r2, r1);
                }
            } else if (ad.j.equals(intent.getAction())) {
                a(new C1159y(this, 4, intent));
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return a;
    }
}
