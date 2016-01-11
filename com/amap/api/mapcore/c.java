package com.amap.api.mapcore;

import com.amap.api.mapcore.util.ad;
import com.amap.api.mapcore.util.ad.a;
import com.amap.api.mapcore.util.az;
import com.amap.api.mapcore.util.q;
import com.amap.api.mapcore.util.r;
import com.amap.api.mapcore.util.x;
import com.amap.api.maps.MapsInitializer;

class c extends Thread {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    c(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        boolean z = false;
        while (!MapsInitializer.getNetWorkEnable()) {
            try {
                Thread.currentThread();
                Thread.sleep(2000);
            } catch (Throwable th) {
                interrupt();
                az.a(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
                th.printStackTrace();
                return;
            }
        }
        r a = new q(this.a.s).a();
        a a2 = new a(n.b, "V2.4.1", n.c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore"});
        if (a != null) {
            z = a.a();
        }
        ad a3 = a2.a(z).a();
        n.e = a3;
        az.a(this.a.s, a3);
        x.a(this.a.s, a3);
        interrupt();
        if (x.a == 0) {
            this.a.i.sendEmptyMessage(2);
        }
        this.a.e(false);
    }
}
