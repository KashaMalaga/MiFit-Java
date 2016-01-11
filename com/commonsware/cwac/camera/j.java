package com.commonsware.cwac.camera;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;

class j implements PictureCallback {
    m a = null;
    final /* synthetic */ CameraView b;

    j(CameraView cameraView, m mVar) {
        this.b = cameraView;
        this.a = mVar;
    }

    public void onPictureTaken(byte[] bArr, Camera camera) {
        camera.setParameters(this.b.l);
        if (bArr != null) {
            new l(this.b.getContext(), bArr, this.b.j, this.a).start();
        }
        if (!this.a.b()) {
            this.b.t();
        }
    }
}
