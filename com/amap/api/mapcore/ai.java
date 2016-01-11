package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.model.RunningReminderInfo;
import com.amap.api.mapcore.util.o;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.model.CameraPosition;
import kankan.wheel.widget.a;

public class ai implements x {
    public static volatile Context a;
    public int b = 0;
    private t c;
    private AMapOptions d;

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.c == null) {
            if (a == null && layoutInflater != null) {
                a = layoutInflater.getContext().getApplicationContext();
            }
            if (a == null) {
                throw new NullPointerException("Context \u4e3a null \u8bf7\u5728\u5730\u56fe\u8c03\u7528\u4e4b\u524d \u4f7f\u7528 MapsInitializer.initialize(Context paramContext) \u6765\u8bbe\u7f6eContext");
            }
            int i = a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                n.a = 0.5f;
            } else if (i <= 160) {
                n.a = 0.6f;
            } else if (i <= RunningReminderInfo.b) {
                n.a = 0.87f;
            } else if (i <= a.by) {
                n.a = 1.0f;
            } else if (i <= a.ax) {
                n.a = a.bg;
            } else if (i <= 640) {
                n.a = 1.8f;
            } else {
                n.a = 0.9f;
            }
            this.c = new AMapDelegateImpGLSurfaceView(a);
            this.c.h(this.b);
        }
        if (this.d == null && bundle != null) {
            this.d = (AMapOptions) bundle.getParcelable("MapOptions");
        }
        b(this.d);
        o.a("MapFragmentDelegateImp", "onCreateView", 113);
        return this.c.x();
    }

    public t a() {
        if (this.c == null) {
            if (a == null) {
                throw new NullPointerException("Context \u4e3a null \u8bf7\u5728\u5730\u56fe\u8c03\u7528\u4e4b\u524d \u4f7f\u7528 MapsInitializer.initialize(Context paramContext) \u6765\u8bbe\u7f6eContext");
            }
            int i = a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                n.a = 0.5f;
            } else if (i <= 160) {
                n.a = 0.8f;
            } else if (i <= RunningReminderInfo.b) {
                n.a = 0.87f;
            } else if (i <= a.by) {
                n.a = 1.0f;
            } else if (i <= a.ax) {
                n.a = a.bg;
            } else if (i <= 640) {
                n.a = 1.8f;
            } else {
                n.a = 0.9f;
            }
            this.c = new AMapDelegateImpGLSurfaceView(a);
        }
        return this.c;
    }

    public void a(int i) {
        this.b = i;
        if (this.c != null) {
            this.c.h(i);
        }
    }

    public void a(Activity activity, AMapOptions aMapOptions, Bundle bundle) {
        a = activity.getApplicationContext();
        this.d = aMapOptions;
    }

    public void a(Context context) {
        if (context != null) {
            a = context.getApplicationContext();
        }
    }

    public void a(Bundle bundle) {
        o.a("MapFragmentDelegateImp", "onCreate", 113);
    }

    public void a(AMapOptions aMapOptions) {
        this.d = aMapOptions;
    }

    public void b() {
        if (this.c != null) {
            this.c.onResume();
        }
    }

    public void b(Bundle bundle) {
        if (this.c != null) {
            if (this.d == null) {
                this.d = new AMapOptions();
            }
            this.d = this.d.camera(a().i(false));
            bundle.putParcelable("MapOptions", this.d);
        }
    }

    void b(AMapOptions aMapOptions) {
        if (aMapOptions != null && this.c != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.c.a(k.a(camera.target, camera.zoom, camera.bearing, camera.tilt));
            }
            ag u = this.c.u();
            u.h(aMapOptions.getRotateGesturesEnabled().booleanValue());
            u.e(aMapOptions.getScrollGesturesEnabled().booleanValue());
            u.g(aMapOptions.getTiltGesturesEnabled().booleanValue());
            u.b(aMapOptions.getZoomControlsEnabled().booleanValue());
            u.f(aMapOptions.getZoomGesturesEnabled().booleanValue());
            u.c(aMapOptions.getCompassEnabled().booleanValue());
            u.a(aMapOptions.getScaleControlsEnabled().booleanValue());
            u.a(aMapOptions.getLogoPosition());
            this.c.b(aMapOptions.getMapType());
            this.c.setZOrderOnTop(aMapOptions.getZOrderOnTop().booleanValue());
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.onPause();
        }
    }

    public void d() {
    }

    public void e() {
        if (this.c != null) {
            this.c.p();
            this.c.d();
        }
    }

    public void f() {
        Log.d("onLowMemory", "onLowMemory run");
    }
}
