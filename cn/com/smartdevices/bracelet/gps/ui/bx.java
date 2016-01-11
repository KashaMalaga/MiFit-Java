package cn.com.smartdevices.bracelet.gps.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.view.View;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.commonsware.cwac.camera.c;
import com.commonsware.cwac.camera.m;
import com.commonsware.cwac.camera.o;

class bx extends o implements FaceDetectionListener {
    boolean a = false;
    final /* synthetic */ bw b;

    public bx(bw bwVar, Context context) {
        this.b = bwVar;
        super(context);
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public Parameters a(Parameters parameters) {
        return super.a(parameters);
    }

    public void a() {
    }

    public void a(c cVar) {
        Activity activity = this.b.getActivity();
        if (activity != null) {
            ((WatermarkActivity) activity).d();
        }
    }

    public void a(m mVar, Bitmap bitmap) {
    }

    public void a(m mVar, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            View view = this.b.getView();
            if (view != null) {
                Bitmap a = cn.com.smartdevices.bracelet.gps.h.c.a(bArr, view.getWidth(), view.getHeight());
                if (this.b.a == null) {
                    return;
                }
                if (b()) {
                    this.b.a.a(a(a));
                } else {
                    this.b.a.a(a);
                }
            }
        }
    }

    public boolean b() {
        return this.b.getArguments() == null ? false : this.b.getArguments().getBoolean("use_ffc");
    }

    public boolean c() {
        return false;
    }

    public void onFaceDetection(Face[] faceArr, Camera camera) {
    }
}
