package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.a.a;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.h.c;
import cn.com.smartdevices.bracelet.gps.services.b.i;
import cn.com.smartdevices.bracelet.gps.sync.w;
import com.amap.api.maps.model.WeightedLatLng;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class C0445d {
    private static final String a = ".track";
    private N b;
    private Executor c;
    private ConcurrentHashMap<String, C0446e> d;

    public C0445d() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = Executors.newScheduledThreadPool(2);
        this.d = new ConcurrentHashMap();
    }

    private static float a(double d, double d2, double d3, double d4) {
        float[] fArr = new float[1];
        Location.distanceBetween(d, d2, d3, d4, fArr);
        return fArr[0];
    }

    public static String a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException();
        }
        File file = new File(a.f(j + a).getAbsolutePath());
        return file.exists() ? file.getAbsolutePath() : com.xiaomi.e.a.f;
    }

    private String a(Context context, C0453l c0453l) {
        C0449h a = C0449h.a(c0453l.e());
        Bitmap a2 = new Y(context, a.c()).a(a.e);
        a.a();
        String absolutePath = a.f(c0453l.i() + a).getAbsolutePath();
        return c.a(absolutePath, a2) ? absolutePath : null;
    }

    private List<C0454m> a(List<cn.com.smartdevices.bracelet.gps.model.c> list, int i, int i2) {
        double d = -2.147483648E9d;
        double d2 = 2.147483647E9d;
        double d3 = -2.147483648E9d;
        double d4 = 2.147483647E9d;
        for (cn.com.smartdevices.bracelet.gps.model.c cVar : list) {
            if (cVar.p >= d) {
                d = cVar.p;
            }
            if (cVar.p <= d2) {
                d2 = cVar.p;
            }
            if (cVar.q >= d3) {
                d3 = cVar.q;
            }
            if (cVar.q <= d4) {
                d4 = cVar.q;
            }
        }
        int[] a = a(d2, d4, d, d3, i2, i);
        double[] a2 = i.a(d, d2, d3, d4, a[1], a[0]);
        if (a2.length != 2) {
            throw new IllegalArgumentException();
        }
        C0596r.e("Map", "getRatioWH scacleX = " + a2[0] + ",scacleY = " + a2[1] + ",width = " + i2 + ",height = " + i + ",ratioW = " + a[0] + ",ratioH = " + a[1]);
        List<C0454m> arrayList = new ArrayList();
        a = new int[2];
        for (cn.com.smartdevices.bracelet.gps.model.c cVar2 : list) {
            a = i.a(cVar2.p, cVar2.q, d4, d, a2[0], a2[1]);
            arrayList.add(new C0454m((short) a[0], (short) a[1], (short) 0));
        }
        return arrayList;
    }

    private void a(long j, String str) {
        if (this.b != null) {
            this.b.a(j, str);
        }
    }

    private int[] a(double d, double d2, double d3, double d4, int i, int i2) {
        double a = (double) C0445d.a(d3, d4, d, d4);
        double a2 = (double) C0445d.a(d, d2, d, d4);
        if (a2 <= 5.0d) {
            return new int[]{1, i};
        } else if (a <= 5.0d) {
            return new int[]{i, 1};
        } else if (a / a2 < WeightedLatLng.DEFAULT_INTENSITY) {
            r4 = (((double) i) * a) / a2;
            return new int[]{i, (int) r4};
        } else {
            r4 = (a2 * ((double) i2)) / a;
            return new int[]{(int) r4, i2};
        }
    }

    private void b() {
        for (C0446e a : this.d.values()) {
            a.a();
        }
        this.d.clear();
    }

    public void a() {
        this.b = null;
    }

    public void a(N n) {
        this.b = n;
    }

    public boolean a(Context context, int i, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        }
        C0448g c0448g = new C0448g(this, context, i);
        this.d.put(c0448g.b(), c0448g);
        List arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        c0448g.a(arrayList);
        c0448g.executeOnExecutor(this.c, new Void[0]);
        return true;
    }

    public boolean a(Context context, int i, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        C0448g c0448g = new C0448g(this, context, i);
        this.d.put(c0448g.b(), c0448g);
        c0448g.a((List) list);
        c0448g.executeOnExecutor(this.c, new Void[0]);
        return true;
    }

    public boolean a(Context context, List<cn.com.smartdevices.bracelet.gps.model.c> list, C0450i c0450i) {
        if (context == null || list == null || c0450i == null || c0450i.a()) {
            throw new IllegalArgumentException();
        }
        C0447f c0447f = new C0447f(this, context, c0450i);
        this.d.put(c0447f.b(), c0447f);
        c0447f.a((List) list);
        c0447f.executeOnExecutor(this.c, new Void[0]);
        return true;
    }

    public String b(Context context, int i, long j) {
        if (context == null || j <= 0) {
            throw new IllegalArgumentException();
        } else if (!w.a(context, i, j)) {
            return null;
        } else {
            String a = p.a(context, j, i);
            a(j, a);
            return a;
        }
    }

    public boolean b(Context context, int i, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            throw new IllegalArgumentException();
        }
        C0448g c0448g = new C0448g(this, context, i);
        this.d.put(c0448g.b(), c0448g);
        c0448g.a((List) list);
        c0448g.c();
        return true;
    }
}
