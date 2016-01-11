package com.commonsware.cwac.camera;

import android.hardware.Camera;
import android.hardware.Camera.OnZoomChangeListener;
import android.hardware.Camera.Parameters;

public final class u implements OnZoomChangeListener {
    private Camera a;
    private int b;
    private Runnable c = null;
    private OnZoomChangeListener d = null;

    u(Camera camera, int i) {
        this.a = camera;
        this.b = i;
    }

    public u a(OnZoomChangeListener onZoomChangeListener) {
        this.d = onZoomChangeListener;
        return this;
    }

    public u a(Runnable runnable) {
        this.c = runnable;
        return this;
    }

    public void a() {
        Parameters parameters = this.a.getParameters();
        if (parameters.isSmoothZoomSupported()) {
            this.a.setZoomChangeListener(this);
            this.a.startSmoothZoom(this.b);
            return;
        }
        parameters.setZoom(this.b);
        this.a.setParameters(parameters);
        onZoomChange(this.b, true, this.a);
    }

    public void b() {
        this.a.stopSmoothZoom();
    }

    public void onZoomChange(int i, boolean z, Camera camera) {
        if (this.d != null) {
            this.d.onZoomChange(i, z, camera);
        }
        if (z && this.c != null) {
            this.c.run();
        }
    }
}
