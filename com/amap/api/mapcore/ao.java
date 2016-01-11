package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.RemoteException;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.l;

class ao {
    private t a;
    private Marker b;
    private v c;
    private MyLocationStyle d;
    private LatLng e;
    private double f;
    private Context g;
    private ax h;
    private int i = 1;
    private boolean j = false;
    private final String k = "location_map_gps_locked.png";
    private final String l = "location_map_gps_3d.png";
    private boolean m = false;

    ao(t tVar, Context context) {
        this.g = context;
        this.a = tVar;
        this.h = new ax(this.g, tVar);
    }

    private void b(float f) {
        if (this.a != null) {
            try {
                this.a.a(k.c(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void b(Location location) {
        float bearing = location.getBearing() % 360.0f;
        if (bearing > BitmapDescriptorFactory.HUE_CYAN) {
            bearing -= 360.0f;
        } else if (bearing < -180.0f) {
            bearing += 360.0f;
        }
        if (this.b != null) {
            this.b.setRotateAngle(-bearing);
        }
    }

    private void c(float f) {
        if (this.a != null) {
            try {
                this.a.a(k.d(f));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void d() {
        if (this.b != null) {
            c(0.0f);
            this.h.b();
            if (!this.m) {
                this.b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.b.setFlat(false);
            b(0.0f);
        }
    }

    private void e() {
        if (this.b != null) {
            c(0.0f);
            this.h.b();
            if (!this.m) {
                this.b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            }
            this.b.setFlat(false);
            b(0.0f);
        }
    }

    private void f() {
        if (this.b != null) {
            this.b.setRotateAngle(0.0f);
            this.h.a();
            if (!this.m) {
                this.b.setIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_3d.png"));
            }
            this.b.setFlat(true);
            try {
                this.a.a(k.a(17.0f));
                b(45.0f);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void g() {
        if (this.i != 1 || !this.j) {
            try {
                IPoint iPoint = new IPoint();
                MapProjection.lonlat2Geo(this.e.longitude, this.e.latitude, iPoint);
                this.a.b(k.a(iPoint));
            } catch (Throwable e) {
                az.a(e, "MyLocationOverlay", "locaitonFollow");
                e.printStackTrace();
            }
        }
    }

    private void h() {
        if (this.d == null) {
            j();
        } else {
            k();
        }
    }

    private void i() {
        if (this.c != null) {
            try {
                this.a.a(this.c.c());
            } catch (Throwable e) {
                az.a(e, "MyLocationOverlay", "locationIconRemove");
                e.printStackTrace();
            }
            this.c = null;
        }
        if (this.b != null) {
            this.b.remove();
            this.b.destroy();
            this.b = null;
            this.h.a(null);
        }
    }

    private void j() {
        try {
            this.c = this.a.a(new CircleOptions().strokeWidth(0.1f).fillColor(Color.argb(50, 0, 0, a.i)).strokeColor(Color.argb(HeartRateInfo.HR_EMPTY_VALUE, 0, 0, a.f)).center(new LatLng(0.0d, 0.0d)));
            this.c.a(1.0f);
            this.c.a(200.0d);
            this.b = this.a.a(new MarkerOptions().visible(false).anchor(0.5f, 0.5f).position(new LatLng(0.0d, 0.0d)));
            a(this.i);
            this.b.setVisible(true);
            this.h.a(this.b);
        } catch (Throwable e) {
            az.a(e, "MyLocationOverlay", "defaultLocStyle");
            e.printStackTrace();
        }
    }

    private void k() {
        if (this.d != null) {
            try {
                this.m = true;
                this.c = this.a.a(new CircleOptions().strokeWidth(this.d.getStrokeWidth()).fillColor(this.d.getRadiusFillColor()).strokeColor(this.d.getStrokeColor()).center(new LatLng(0.0d, 0.0d)).zIndex(1.0f));
                if (this.e != null) {
                    this.c.a(this.e);
                }
                this.c.a(this.f);
                this.b = this.a.a(new MarkerOptions().visible(false).anchor(this.d.getAnchorU(), this.d.getAnchorV()).icon(this.d.getMyLocationIcon()).position(new LatLng(0.0d, 0.0d)));
                a(this.i);
                if (this.e != null) {
                    this.b.setPosition(this.e);
                    this.b.setVisible(true);
                }
                this.h.a(this.b);
            } catch (Throwable e) {
                az.a(e, "MyLocationOverlay", "myLocStyle");
                e.printStackTrace();
            }
        }
    }

    public void a() {
        if (this.h != null) {
            this.h.b();
        }
    }

    public void a(float f) {
        if (this.b != null) {
            this.b.setRotateAngle(f);
        }
    }

    public void a(int i) {
        this.i = i;
        this.j = false;
        switch (this.i) {
            case l.a /*1*/:
                d();
                return;
            case kankan.wheel.widget.a.k /*2*/:
                e();
                return;
            case kankan.wheel.widget.a.l /*3*/:
                f();
                return;
            default:
                return;
        }
    }

    public void a(Location location) {
        if (location != null) {
            this.e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f = (double) location.getAccuracy();
            if (this.b == null && this.c == null) {
                h();
            }
            if (this.b != null) {
                this.b.setPosition(this.e);
            }
            if (this.c != null) {
                try {
                    this.c.a(this.e);
                    if (this.f != -1.0d) {
                        this.c.a(this.f);
                    }
                } catch (Throwable e) {
                    az.a(e, "MyLocationOverlay", "setCentAndRadius");
                    e.printStackTrace();
                }
                g();
                if (this.i != 3) {
                    b(location);
                }
                this.j = true;
            }
        }
    }

    public void a(MyLocationStyle myLocationStyle) {
        try {
            this.d = myLocationStyle;
            if (this.b != null || this.c != null) {
                i();
                this.h.a(this.b);
                k();
            }
        } catch (Throwable th) {
            az.a(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void b() {
        if (this.i == 3 && this.h != null) {
            this.h.a();
        }
    }

    public void c() {
        i();
        if (this.h != null) {
            this.h.b();
            this.h = null;
        }
    }
}
