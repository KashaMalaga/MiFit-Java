package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.core.d;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.b.Y;
import java.util.Iterator;
import java.util.Vector;

public class a {
    static a h = null;
    d a = null;
    c b = null;
    boolean c = false;
    long d;
    boolean e = true;
    boolean f = true;
    b g;
    private Context i;
    private Vector<g> j = null;
    private a k = null;
    private Vector<g> l = new Vector();
    private AMapLocation m;
    private AMapLocation n;
    private volatile Thread o;
    private long p = 2000;
    private float q = 10.0f;

    class a extends Handler {
        final /* synthetic */ a a;

        public a(a aVar) {
            this.a = aVar;
        }

        public a(a aVar, Looper looper) {
            this.a = aVar;
            super(looper);
            Looper.prepare();
        }

        public void handleMessage(Message message) {
            if (message != null) {
                try {
                    if (message.what == 100 && this.a.j != null) {
                        this.a.m = (AMapLocation) message.obj;
                        if (!(this.a.m == null || this.a.m.getAdCode() == null || this.a.m.getAdCode().length() <= 0)) {
                            this.a.n = this.a.m;
                        }
                        Iterator it = this.a.j.iterator();
                        while (it.hasNext()) {
                            g gVar = (g) it.next();
                            if (gVar.b != null) {
                                AMapLocation aMapLocation = (AMapLocation) message.obj;
                                if (gVar.c.booleanValue() || aMapLocation.getAMapException().getErrorCode() == 0) {
                                    gVar.b.onLocationChanged(aMapLocation);
                                    if (gVar.c.booleanValue() && gVar.a == -1 && this.a.l != null) {
                                        this.a.l.add(gVar);
                                    }
                                }
                            }
                        }
                        if (this.a.l != null && this.a.l.size() > 0) {
                            for (int i = 0; i < this.a.l.size(); i++) {
                                this.a.a(((g) this.a.l.get(i)).b);
                            }
                            this.a.l.clear();
                        }
                        if (this.a.m != null) {
                            d.a(this.a.i, this.a.m);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                }
            }
        }
    }

    private a(Context context, LocationManager locationManager) {
        this.i = context;
        e();
        if (Looper.myLooper() == null) {
            this.k = new a(this, context.getMainLooper());
        } else {
            this.k = new a(this);
        }
        this.a = new d(context, locationManager, this.k, this);
        this.b = new c(context, this.k, this);
        b(false);
        this.e = true;
        this.f = true;
        this.g = new b(this, context);
    }

    public static synchronized a a(Context context, LocationManager locationManager) {
        a aVar;
        synchronized (a.class) {
            if (h == null) {
                h = new a(context, locationManager);
            }
            aVar = h;
        }
        return aVar;
    }

    static synchronized void c() {
        synchronized (a.class) {
            if (h != null) {
                h.d();
            }
            h = null;
        }
    }

    private void c(boolean z) {
        this.e = z;
    }

    private void d(boolean z) {
        this.f = z;
    }

    private void e() {
        this.j = new Vector();
    }

    AMapLocation a() {
        return this.m != null ? this.m : d.b(this.i);
    }

    void a(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        Y y = new Y();
        y.b = d;
        y.a = d2;
        y.c = f;
        y.a(j);
        this.b.a(y, pendingIntent);
    }

    void a(final int i, final AMapLocalWeatherListener aMapLocalWeatherListener) {
        try {
            new Thread(this) {
                final /* synthetic */ a c;

                public void run() {
                    this.c.g.a(i, aMapLocalWeatherListener, this.c.n);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void a(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.p = j;
        this.q = f;
        if (aMapLocationListener != null) {
            this.j.add(new g(j, f, aMapLocationListener, str, z));
            if (GeocodeSearch.GPS.equals(str)) {
                this.a.a(j, f);
            } else if (LocationProviderProxy.AMapNetwork.equals(str)) {
                if (this.f) {
                    this.a.a(j, f);
                }
                this.b.a(j);
                c(true);
                if (this.o == null) {
                    this.b.b(true);
                    this.o = new Thread(this.b);
                    this.o.start();
                }
            }
        }
    }

    void a(PendingIntent pendingIntent) {
        this.b.a(pendingIntent);
    }

    void a(AMapLocationListener aMapLocationListener) {
        int i = 0;
        int size = this.j != null ? this.j.size() : 0;
        while (i < size) {
            int i2;
            g gVar = (g) this.j.get(i);
            if (gVar == null) {
                this.j.remove(i);
                i2 = i - 1;
                i = size - 1;
            } else if (gVar.b == null || aMapLocationListener.equals(gVar.b)) {
                this.j.remove(gVar);
                i2 = i - 1;
                i = size - 1;
            } else {
                i2 = i;
                i = size;
            }
            size = i;
            i = i2 + 1;
        }
        if (this.j == null || this.j.size() == 0) {
            b(false);
            c(false);
            b();
            if (this.a != null) {
                this.a.b();
            }
        }
    }

    void a(boolean z) {
        d(z);
        if (this.j != null && this.j.size() > 0) {
            if (z) {
                this.a.b();
                this.a.a(this.p, this.q);
                return;
            }
            this.a.b();
        }
    }

    void b() {
        if (this.b != null) {
            this.b.b(false);
        }
        if (this.o != null) {
            this.o.interrupt();
            this.o = null;
        }
    }

    void b(double d, double d2, float f, long j, PendingIntent pendingIntent) {
        Y y = new Y();
        y.b = d;
        y.a = d2;
        y.c = f;
        y.a(j);
        this.b.b(y, pendingIntent);
    }

    void b(PendingIntent pendingIntent) {
        this.b.b(pendingIntent);
    }

    void b(boolean z) {
        this.c = z;
    }

    void d() {
        if (this.a != null) {
            this.a.b();
            this.a.a();
            this.a = null;
        }
        if (this.b != null) {
            this.b.b();
        }
        if (this.j != null) {
            this.j.clear();
        }
        b(false);
    }
}
