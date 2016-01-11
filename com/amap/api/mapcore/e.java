package com.amap.api.mapcore;

class e implements Runnable {
    final /* synthetic */ AMapDelegateImpGLSurfaceView a;

    e(AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        this.a = aMapDelegateImpGLSurfaceView;
    }

    public void run() {
        if (this.a.Q != null) {
            this.a.T = true;
            if (this.a.S != null) {
                this.a.S.b(false);
            }
        }
    }
}
