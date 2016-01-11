package com.commonsware.cwac.camera;

import android.hardware.Camera;
import android.media.MediaRecorder;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;

class s implements Callback, n {
    private final CameraView a;
    private SurfaceView b = null;
    private SurfaceHolder c = null;

    s(CameraView cameraView) {
        this.a = cameraView;
        this.b = new SurfaceView(cameraView.getContext());
        this.c = this.b.getHolder();
        this.c.setType(3);
        this.c.addCallback(this);
    }

    public View a() {
        return this.b;
    }

    public void a(Camera camera) {
        camera.setPreviewDisplay(this.c);
    }

    public void a(MediaRecorder mediaRecorder) {
        mediaRecorder.setPreviewDisplay(this.c.getSurface());
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.a.b(i2, i3);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.a.p();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.a.q();
    }
}
