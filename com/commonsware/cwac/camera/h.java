package com.commonsware.cwac.camera;

import android.util.Log;

class h implements Runnable {
    final /* synthetic */ CameraView a;
    private final /* synthetic */ m b;

    h(CameraView cameraView, m mVar) {
        this.a = cameraView;
        this.b = mVar;
    }

    public void run() {
        try {
            this.a.d.takePicture(this.b, null, new j(this.a, this.b));
        } catch (Throwable e) {
            Log.e(getClass().getSimpleName(), "Exception taking a picture", e);
        }
    }
}
