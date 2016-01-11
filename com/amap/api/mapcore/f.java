package com.amap.api.mapcore;

class f implements Runnable {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    f(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        if (this.a.Q != null) {
            this.a.T = false;
            this.a.Q.setVisibility(8);
        }
    }
}
