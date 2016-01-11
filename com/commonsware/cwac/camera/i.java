package com.commonsware.cwac.camera;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.OrientationEventListener;

class i extends OrientationEventListener {
    final /* synthetic */ CameraView a;
    private boolean b = false;

    public i(CameraView cameraView, Context context) {
        this.a = cameraView;
        super(context);
        disable();
    }

    boolean a() {
        return this.b;
    }

    public void disable() {
        this.b = false;
        super.disable();
    }

    public void enable() {
        this.b = true;
        super.enable();
    }

    public void onOrientationChanged(int i) {
        if (this.a.d != null && i != -1) {
            int a = this.a.b(i);
            if (a != this.a.i) {
                this.a.i = a;
                Parameters parameters = this.a.d.getParameters();
                parameters.setRotation(this.a.i);
                try {
                    this.a.d.setParameters(parameters);
                    this.a.o = this.a.i;
                } catch (Throwable e) {
                    Log.e(getClass().getSimpleName(), "Exception updating camera parameters in orientation change", e);
                }
            }
        }
    }
}
