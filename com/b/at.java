package com.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.d.a.a.C1012a;
import com.xiaomi.account.openauth.h;
import com.xiaomi.channel.b.v;
import com.xiaomi.e.a;
import com.xiaomi.market.sdk.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

public class at {
    private static float P = 1.1f;
    private static float Q = 2.2f;
    private static float R = 2.3f;
    private static float S = 3.8f;
    private static int T = 3;
    private static int U = 10;
    private static int V = 2;
    private static int W = 7;
    private static int X = 20;
    private static int Y = 70;
    private static int Z = 120;
    protected static boolean a = false;
    protected static boolean b = true;
    private static int c = 10;
    private static int d = 2;
    private static int e = 10;
    private static int f = 10;
    private static int g = 50;
    private static int h = v.C;
    private static Object i = new Object();
    private static at j;
    private Thread A = null;
    private Looper B = null;
    private C0941z C = null;
    private Location D = null;
    private C0940y E = null;
    private Handler F = null;
    private A G = new A(this);
    private LocationListener H = new C0936u(this);
    private BroadcastReceiver I = new C0937v(this);
    private GpsStatus J = null;
    private int K = 0;
    private int L = 0;
    private HashMap M = null;
    private int N = 0;
    private int O = 0;
    private boolean k = false;
    private boolean l = false;
    private int m = -1;
    private int n = 0;
    private int o = 0;
    private int p = C1012a.b;
    private long q = 0;
    private Context r;
    private LocationManager s;
    private C0930o t;
    private C u;
    private K v;
    private C0927l w;
    private J x;
    private B y;
    private C0921f z;

    private at(Context context) {
        this.r = context;
        this.t = C0930o.a(context);
        this.z = new C0921f();
        this.u = new C(this.t);
        this.w = new C0927l(context);
        this.v = new K(this.w);
        this.x = new J(this.w);
        this.s = (LocationManager) this.r.getSystemService(LocationManagerProxy.KEY_LOCATION_CHANGED);
        this.y = B.a(this.r);
        this.y.a(this.G);
        n();
        List allProviders = this.s.getAllProviders();
        boolean z = allProviders != null && allProviders.contains(GeocodeSearch.GPS) && allProviders.contains("passive");
        this.l = z;
        L.a(context);
    }

    static /* synthetic */ int a(at atVar, ar arVar, int i) {
        if (atVar.N >= U) {
            return 1;
        }
        if (atVar.N <= T) {
            return 4;
        }
        double c = arVar.c();
        if (c <= ((double) P)) {
            return 1;
        }
        if (c >= ((double) Q)) {
            return 4;
        }
        c = arVar.b();
        return c > ((double) R) ? c >= ((double) S) ? 4 : i < W ? i <= V ? 4 : atVar.M != null ? atVar.a(atVar.M) : 3 : 1 : 1;
    }

    private int a(HashMap hashMap) {
        if (this.K > 4) {
            int i;
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i2 = 0;
            for (Entry value : hashMap.entrySet()) {
                List list = (List) value.getValue();
                if (list != null) {
                    Object a = a(list);
                    if (a != null) {
                        arrayList.add(a);
                        i = i2 + 1;
                        arrayList2.add(Integer.valueOf(i2));
                        i2 = i;
                    }
                }
                i = i2;
                i2 = i;
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    double[] dArr2 = (double[]) arrayList.get(i3);
                    i = ((Integer) arrayList2.get(i3)).intValue();
                    dArr2[0] = dArr2[0] * ((double) i);
                    dArr2[1] = dArr2[1] * ((double) i);
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr[1] + dArr2[1];
                }
                dArr[0] = dArr[0] / ((double) size);
                dArr[1] = dArr[1] / ((double) size);
                double d = dArr[0];
                double d2 = dArr[1];
                double toDegrees = d2 == 0.0d ? d > 0.0d ? 90.0d : d < 0.0d ? 270.0d : 0.0d : Math.toDegrees(Math.atan(d / d2));
                double[] dArr3 = new double[]{Math.sqrt((d * d) + (d2 * d2)), toDegrees};
                String.format(Locale.CHINA, "%d,%d,%d,%d", new Object[]{Long.valueOf(Math.round(dArr[0] * 100.0d)), Long.valueOf(Math.round(dArr[1] * 100.0d)), Long.valueOf(Math.round(dArr3[0] * 100.0d)), Long.valueOf(Math.round(dArr3[1] * 100.0d))});
                if (dArr3[0] <= ((double) Y)) {
                    return 1;
                }
                if (dArr3[0] >= ((double) Z)) {
                    return 4;
                }
            }
        }
        return 3;
    }

    public static at a(Context context) {
        if (j == null) {
            synchronized (i) {
                if (j == null) {
                    j = new at(context);
                }
            }
        }
        return j;
    }

    public static String a(String str) {
        return str.equals(o.x) ? "COL.14.1126r" : null;
    }

    static /* synthetic */ void a(at atVar, Location location, int i, long j) {
        boolean z;
        Location location2;
        C0920e a;
        Long valueOf;
        System.currentTimeMillis();
        boolean a2 = atVar.u.a(location);
        if (a2) {
            atVar.u.b.b = new Location(location);
        }
        boolean b = atVar.u.b(location);
        if (b) {
            atVar.u.a.b = new Location(location);
        }
        int i2 = 0;
        if (i == 1) {
            z = true;
            a2 = true;
            location2 = atVar.D;
        } else if (i == 2) {
            z = false;
            a2 = true;
            location2 = atVar.D;
        } else {
            z = a2;
            a2 = b;
            location2 = location;
        }
        if (z) {
            i2 = 1;
            if (a2) {
                i2 = 3;
            }
        } else if (a2) {
            i2 = 2;
        }
        try {
            C0921f c0921f = atVar.z;
            a = C0921f.a(location2, atVar.t, i2, (byte) atVar.O, j, false);
        } catch (Exception e) {
            a = null;
        }
        if (!(a == null || atVar.t == null)) {
            List n = atVar.t.n();
            valueOf = Long.valueOf(0);
            if (n != null && n.size() > 0) {
                valueOf = (Long) n.get(0);
            }
            atVar.v.a(valueOf.longValue(), a.a());
        }
        if (atVar.r != null && atVar.z != null) {
            SharedPreferences sharedPreferences = atVar.r.getSharedPreferences("app_pref", 0);
            if (!sharedPreferences.getString("get_sensor", a.f).equals("true")) {
                try {
                    C0921f c0921f2 = atVar.z;
                    a = C0921f.a(null, atVar.t, i2, (byte) atVar.O, j, true);
                } catch (Exception e2) {
                    a = null;
                }
                if (a != null && atVar.t != null) {
                    List n2 = atVar.t.n();
                    valueOf = Long.valueOf(0);
                    if (n2 != null && n2.size() > 0) {
                        valueOf = (Long) n2.get(0);
                    }
                    atVar.v.a(valueOf.longValue(), a.a());
                    sharedPreferences.edit().putString("get_sensor", "true").commit();
                }
            }
        }
    }

    private double[] a(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        for (GpsSatellite gpsSatellite : list) {
            if (gpsSatellite != null) {
                double elevation = (double) (90.0f - gpsSatellite.getElevation());
                double azimuth = (double) gpsSatellite.getAzimuth();
                double[] dArr2 = new double[]{Math.sin(Math.toRadians(azimuth)) * elevation, elevation * Math.cos(Math.toRadians(azimuth))};
                dArr[0] = dArr[0] + dArr2[0];
                dArr[1] = dArr[1] + dArr2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / ((double) size);
        dArr[1] = dArr[1] / ((double) size);
        return dArr;
    }

    static /* synthetic */ String b(at atVar, String str) {
        return str;
    }

    private void n() {
        this.n = this.y.b() * h.E;
        this.o = this.y.c();
        C c = this.u;
        int i = this.n;
        i = this.o;
        C.a();
    }

    public void a() {
        I.a = true;
        if (this.l && this.t != null && !a) {
            IntentFilter intentFilter = new IntentFilter("android.location.GPS_ENABLED_CHANGE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            b = true;
            this.r.registerReceiver(this.I, intentFilter);
            String str = a.f;
            this.s.removeUpdates(this.H);
            if (this.B != null) {
                this.B.quit();
                this.B = null;
            }
            if (this.A != null) {
                this.A.interrupt();
                this.A = null;
            }
            this.A = new C0938w(this, str);
            this.A.start();
            this.t.a();
            a = true;
        }
    }

    public void a(int i) {
        if (i == PersonInfo.INCOMING_CALL_DISABLE_BIT || i == 8736 || i == 768) {
            this.w.a(i);
            return;
        }
        throw new RuntimeException("invalid Size! must be COLLECTOR_SMALL_SIZE or COLLECTOR_BIG_SIZE or COLLECTOR_MEDIUM_SIZE");
    }

    public void a(C0926k c0926k, String str) {
        boolean a = this.y.a(str);
        if (c0926k != null) {
            byte[] a2 = c0926k.a();
            if (a && a2 != null) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.r.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getType() == 1) {
                        this.y.a(a2.length + this.y.e());
                    } else {
                        this.y.b(a2.length + this.y.f());
                    }
                }
            }
            c0926k.a(a);
            this.x.a(c0926k);
        }
    }

    public void b() {
        I.a = false;
        if (this.l && this.t != null && a) {
            if (this.I != null) {
                try {
                    this.r.unregisterReceiver(this.I);
                } catch (Exception e) {
                }
            }
            if (this.t != null) {
                this.t.w();
            }
            this.s.removeGpsStatusListener(this.E);
            this.s.removeNmeaListener(this.E);
            this.E = null;
            this.s.removeUpdates(this.H);
            if (this.B != null) {
                this.B.quit();
                this.B = null;
            }
            if (this.A != null) {
                this.A.interrupt();
                this.A = null;
            }
            if (this.C != null) {
                this.k = false;
                this.C.interrupt();
                this.C = null;
            }
            this.t.b();
            a = false;
        }
    }

    public void c() {
        if (this.l) {
            b();
        }
    }

    public C0926k d() {
        if (this.x == null) {
            return null;
        }
        e();
        return this.y.a() ? this.x.a(this.y.d()) : null;
    }

    public boolean e() {
        if (this.t == null) {
            return false;
        }
        List n = this.t.n();
        return (n == null || n.size() <= 0) ? false : this.w.b(((Long) n.get(0)).longValue());
    }

    public int f() {
        return this.x != null ? this.x.a() : 0;
    }
}
