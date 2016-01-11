package com.amap.api.mapcore;

class g implements Runnable {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    g(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public synchronized void run() {
        if (this.a.aF) {
            this.a.aE = true;
            this.a.aF = false;
        }
    }
}
