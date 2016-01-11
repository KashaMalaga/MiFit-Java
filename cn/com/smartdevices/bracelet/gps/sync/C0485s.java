package cn.com.smartdevices.bracelet.gps.sync;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0595q;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.config.b;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.d;
import cn.com.smartdevices.bracelet.gps.h.h;
import cn.com.smartdevices.bracelet.gps.model.k;
import cn.com.smartdevices.bracelet.gps.model.n;
import cn.com.smartdevices.bracelet.gps.services.C0466z;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.i;
import java.util.Calendar;
import java.util.List;

public class C0485s {
    private C0485s() {
    }

    public static boolean a(Context context, int i) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0480n c0480n = new C0480n();
        i iVar = new i(context, i);
        if (!iVar.o.isValid()) {
            return false;
        }
        iVar.m = i;
        C0475h.a(iVar, e.a(C0475h.l), new C0486t(c0480n, context));
        return c0480n.a;
    }

    static boolean a(Context context, int i, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        C0466z d = p.d(context, j);
        if (d == null) {
            C0596r.e("Sync", "syncTrackInfoToServer failed sql. trackId = " + j);
            return false;
        }
        boolean a = A.a(context, i, d);
        if (a) {
            return a;
        }
        C0596r.e("Sync", "syncTrackInfoToServer failed trackId = " + j);
        return a;
    }

    static boolean a(Context context, int i, N n) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        List<C0466z> g = p.g(context, i);
        if (g == null) {
            C0596r.e("Sync", "syncIntegralTrackToServer  !isNeedToSync sql error");
            return false;
        }
        int size = g.size();
        if (size <= 0) {
            C0596r.e("Sync", "syncIntegralTrackToServer  !isNeedToSync no data");
            return true;
        } else if (n == null) {
            r2 = new C0480n();
            for (C0466z c0466z : g) {
                r2.a = A.a(context, i, c0466z) & r2.a;
            }
            return r2.a;
        } else {
            C0478l c0478l = new C0478l(size);
            r2 = new C0480n();
            int i2 = 0;
            for (C0466z c0466z2 : g) {
                long G = c0466z2.G();
                boolean a = A.a(context, i, c0466z2);
                r2.a &= a;
                int i3 = i2 + 1;
                n.a(G, c0478l.a(i3), a);
                i2 = i3;
            }
            return r2.a;
        }
    }

    public static boolean a(Context context, long j) {
        if (context == null) {
            throw new IllegalArgumentException();
        } else if (j <= 0) {
            return false;
        } else {
            C0466z d = p.d(context, j);
            if (d != null && d.L()) {
                return A.a(context, j, d.r(), d.v());
            }
            C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync trackId = " + j);
            if (d != null) {
                C0596r.e("Sync", "syncSportDataFromServer  !isNeedToSync syncState = " + d.B());
            }
            return true;
        }
    }

    static void b(Context context, int i, N n) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        } else if (b.h().g.ENABLE_RUNNING.booleanValue()) {
            if (n != null) {
                n.a();
            }
            d f = p.f(context);
            if (f == null) {
                C0485s.d(context, 4);
            } else if (!f.o()) {
                C0485s.c(context, 4);
            }
            int a = 1 & F.a(context, 4, null);
            if (a == 0) {
                C0596r.e("Sync", "Two-way sync deleteTargetTrackIdList failed");
            }
            a &= C0485s.c(context, 4, n);
            if (a == 0) {
                C0596r.e("Sync", "Two-way sync syncInitDataFromServerSyncedIfNeeded failed");
            }
            boolean d = a & C0485s.d(context, 4, n);
            if (!d) {
                C0596r.e("Sync", "Two-way sync syncIntegralTrackToServerSynced failed");
            }
            if (n != null) {
                n.a(d);
            }
        } else {
            C0596r.d("Sync", "!Config.getInstance().RUNNER.ENABLE");
        }
    }

    static boolean b(Context context, int i) {
        d f = p.f(context);
        int c = (f == null || f.o()) ? 1 : C0485s.c(context, 4) & 1;
        int a = 1 & C0485s.a(context, 4, null);
        if (a != 0) {
            a = w.a(context, 4);
            if (a == 0) {
                C0596r.e("Sync", "One-way sync syncContourTrackToServer failed");
            }
        } else {
            C0596r.e("Sync", "One-way sync syncSportTrackInfoToSever failed");
        }
        return c & a;
    }

    static boolean c(Context context, int i) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        d g = p.g(context);
        if (g == null || g.o()) {
            C0596r.e("Sync", "syncSportConfigToSever  !isNeedToSyncTo sportType = " + i);
            return false;
        }
        C0480n c0480n = new C0480n();
        n nVar = new n(g.c().toString());
        i iVar = new i(context, i);
        if (!iVar.o.isValid()) {
            return false;
        }
        C0475h.a(iVar, e.a(C0475h.a), nVar.c(), null, new u(c0480n, context, i));
        return c0480n.a;
    }

    private static boolean c(Context context, int i, N n) {
        boolean z = true;
        if (!S.a(context, 4).b()) {
            C0596r.d("Sync", "syncInitDataFromServerSyncedIfNeeded !isRunningDataSaved");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long b = h.b(currentTimeMillis, -2);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(b * 1000);
            k kVar = new k(instance);
            long a = h.a(currentTimeMillis);
            instance.setTimeInMillis(a * 1000);
            k kVar2 = new k(instance);
            C0596r.e("Sync", "syncInitDataFromServerSyncedIfNeeded startDay = " + kVar.c() + ",endDay = " + kVar2.c());
            z = F.a(context, 4, kVar.b(), kVar2.b()).a;
            Q.a(context, 4, z);
            if (!z) {
                C0596r.d("Sync", "syncInitDataFromServerSyncedIfNeeded failed");
            }
            n.a(b, a, z);
        }
        return z;
    }

    private static boolean d(Context context, int i) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        C0480n c0480n = new C0480n();
        i iVar = new i(context, i);
        if (!iVar.o.isValid()) {
            return false;
        }
        C0475h.a(iVar, e.a(C0475h.b), new v(c0480n, i, context));
        return c0480n.a;
    }

    private static boolean d(Context context, int i, N n) {
        if (context == null || !C0595q.a(i)) {
            throw new IllegalArgumentException();
        }
        int a = 1 & C0485s.a(context, 4, n);
        if (a == 0) {
            C0596r.e("Sync", "syncIntegralTrackToServer syncSportTrackInfoToSever failed");
            return false;
        }
        boolean a2 = a & w.a(context, 4);
        if (a2) {
            return a2;
        }
        C0596r.e("Sync", "syncIntegralTrackToServer syncContourTrackToServer failed");
        return a2;
    }
}
