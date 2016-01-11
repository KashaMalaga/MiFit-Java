package com.huami.android.zxing.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

final class d {
    private static final String a = "CameraConfiguration";
    private final Context b;
    private Point c;
    private Point d;
    private int e = -1;

    d(Context context) {
        this.b = context;
    }

    private void a(Parameters parameters) {
        if (this.e >= 0 && parameters.isZoomSupported()) {
            int maxZoom = parameters.getMaxZoom();
            if (this.e > maxZoom) {
                this.e = maxZoom;
            }
            parameters.setZoom(this.e);
        }
    }

    private void a(Parameters parameters, boolean z) {
        e.a(parameters, z);
    }

    private void b(Parameters parameters) {
        a(parameters, false);
    }

    Point a() {
        return this.d;
    }

    void a(int i) {
        this.e = i;
    }

    void a(Camera camera) {
        Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.c = point;
        Log.i(a, "Screen resolution: " + this.c);
        Point point2 = new Point();
        point2.x = this.c.x;
        point2.y = this.c.y;
        this.d = e.a(parameters, point2);
        Log.i(a, "Camera resolution: " + this.d);
    }

    void a(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        Log.i(a, "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w(a, "In camera config safe mode -- most settings will not be honored");
        }
        b(parameters);
        e.a(parameters, true, true, z);
        parameters.setPreviewSize(this.d.x, this.d.y);
        a(parameters);
        Log.i(a, "Final camera parameters: " + parameters.flatten());
        camera.setParameters(parameters);
        camera.setDisplayOrientation(90);
        Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize == null) {
            return;
        }
        if (this.d.x != previewSize.width || this.d.y != previewSize.height) {
            Log.w(a, "Camera said it supported preview size " + this.d.x + 'x' + this.d.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            this.d.x = previewSize.width;
            this.d.y = previewSize.height;
        }
    }

    Point b() {
        return this.c;
    }

    void b(Camera camera, boolean z) {
        Parameters parameters = camera.getParameters();
        a(parameters, z);
        camera.setParameters(parameters);
    }

    boolean b(Camera camera) {
        if (camera == null) {
            return false;
        }
        Parameters parameters = camera.getParameters();
        if (parameters == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return flashMode != null ? "on".equals(flashMode) || "torch".equals(flashMode) : false;
    }
}
