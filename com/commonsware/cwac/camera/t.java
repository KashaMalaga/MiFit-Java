package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;

@TargetApi(14)
class t implements SurfaceTextureListener, n {
    private final CameraView a;
    private TextureView b = null;
    private SurfaceTexture c = null;

    t(CameraView cameraView) {
        this.a = cameraView;
        this.b = new TextureView(cameraView.getContext());
        this.b.setSurfaceTextureListener(this);
    }

    public View a() {
        return this.b;
    }

    public void a(Camera camera) {
        camera.setPreviewTexture(this.c);
    }

    public void a(MediaRecorder mediaRecorder) {
        if (VERSION.SDK_INT < 16) {
            throw new IllegalStateException("Cannot use TextureView with MediaRecorder");
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.c = surfaceTexture;
        this.a.p();
        this.a.b(i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.a.q();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.a.a(i, i2);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
