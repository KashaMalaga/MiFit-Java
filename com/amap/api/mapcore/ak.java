package com.amap.api.mapcore;

import java.util.concurrent.CopyOnWriteArrayList;

class ak {
    AMapDelegateImpGLSurfaceView a;
    private CopyOnWriteArrayList<k> b = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<aj> c = new CopyOnWriteArrayList();

    public ak(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public aj a() {
        if (b() == 0) {
            return null;
        }
        aj ajVar = (aj) this.c.get(0);
        this.c.remove(ajVar);
        return ajVar;
    }

    public synchronized void a(aj ajVar) {
        this.a.e(false);
        this.c.add(ajVar);
        this.a.e(false);
    }

    public void a(k kVar) {
        this.a.e(false);
        this.b.add(kVar);
        this.a.e(false);
    }

    public synchronized int b() {
        return this.c.size();
    }

    public k c() {
        if (d() == 0) {
            return null;
        }
        k kVar = (k) this.b.get(0);
        this.b.remove(kVar);
        this.a.e(false);
        return kVar;
    }

    public int d() {
        return this.b.size();
    }
}
