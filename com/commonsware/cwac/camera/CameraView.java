package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.gps.c.a;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.io.IOException;
import kankan.wheel.widget.l;

public class CameraView extends ViewGroup implements AutoFocusCallback {
    static final String a = "CWAC-Camera";
    private n b;
    private Size c;
    private Camera d;
    private boolean e;
    private b f;
    private i g;
    private int h;
    private int i;
    private int j;
    private MediaRecorder k;
    private Parameters l;
    private boolean m;
    private boolean n;
    private int o;

    public CameraView(Context context) {
        super(context);
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.g = new i(this, context.getApplicationContext());
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.k = null;
        this.l = null;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.g = new i(this, context.getApplicationContext());
        if (context instanceof e) {
            a(((e) context).a());
            return;
        }
        throw new IllegalArgumentException("To use the two- or three-parameter constructors on CameraView, your activity needs to implement the CameraHostProvider interface");
    }

    private void a(Parameters parameters) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.j, cameraInfo);
        if (cameraInfo.facing == 1) {
            this.i = (360 - this.h) % a.e;
        } else {
            this.i = this.h;
        }
        if (this.o != this.i) {
            parameters.setRotation(this.i);
            this.o = this.i;
        }
    }

    private int b(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.j, cameraInfo);
        int i2 = ((i + 45) / 90) * 90;
        return cameraInfo.facing == 1 ? ((cameraInfo.orientation - i2) + a.e) % a.e : (cameraInfo.orientation + i2) % a.e;
    }

    private void s() {
        if (this.e) {
            u();
        }
    }

    private void t() {
        this.d.startPreview();
        this.e = true;
        a().a();
    }

    private void u() {
        this.e = false;
        a().d();
        this.d.stopPreview();
    }

    private void v() {
        int i = 0;
        CameraInfo cameraInfo = new CameraInfo();
        int rotation = r().getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Camera.getCameraInfo(this.j, cameraInfo);
        r().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        switch (rotation) {
            case l.a /*1*/:
                i = 90;
                break;
            case kankan.wheel.widget.a.k /*2*/:
                i = a.i;
                break;
            case kankan.wheel.widget.a.l /*3*/:
                i = 270;
                break;
        }
        if (cameraInfo.facing == 1) {
            this.h = (i + cameraInfo.orientation) % a.e;
            this.h = (360 - this.h) % a.e;
        } else {
            this.h = ((cameraInfo.orientation - i) + a.e) % a.e;
        }
        boolean z = this.e;
        if (this.e) {
            u();
        }
        this.d.setDisplayOrientation(this.h);
        if (z) {
            t();
        }
    }

    public b a() {
        return this.f;
    }

    public u a(int i) {
        if (this.d == null) {
            throw new IllegalStateException("Yes, we have no camera, we have no camera today");
        }
        Parameters parameters = this.d.getParameters();
        if (i >= 0 && i <= parameters.getMaxZoom()) {
            return new u(this.d, i);
        }
        throw new IllegalArgumentException(String.format("Invalid zoom level: %d", new Object[]{Integer.valueOf(i)}));
    }

    void a(int i, int i2) {
        s();
        b(i, i2);
    }

    @TargetApi(14)
    public void a(int i, int i2, boolean z) {
        if (this.d != null) {
            Parameters parameters = this.d.getParameters();
            parameters.setPreviewSize(this.c.width, this.c.height);
            if (VERSION.SDK_INT >= 14) {
                parameters.setRecordingHint(a().i() != d.STILL_ONLY);
            }
            requestLayout();
            this.d.setParameters(a().a(parameters));
            t();
        }
    }

    public void a(b bVar) {
        this.f = bVar;
        if (bVar.f().a()) {
            this.b = new t(this);
        } else {
            this.b = new s(this);
        }
    }

    public void a(m mVar) {
        if (!this.e) {
            return;
        }
        if (this.n) {
            throw new IllegalStateException("Camera cannot take a picture while auto-focusing");
        }
        this.l = this.d.getParameters();
        Parameters parameters = this.d.getParameters();
        Size b = mVar.a.b(mVar, parameters);
        parameters.setPictureSize(b.width, b.height);
        parameters.setPictureFormat(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        if (mVar.g != null) {
            parameters.setFlashMode(mVar.g);
        }
        if (!this.g.a()) {
            a(parameters);
        }
        this.d.setParameters(mVar.a.a(mVar, parameters));
        mVar.h = this;
        postDelayed(new h(this, mVar), (long) mVar.a.f().g());
        this.e = false;
    }

    public void a(String str) {
        if (this.d != null) {
            Parameters parameters = this.d.getParameters();
            parameters.setFlashMode(str);
            this.d.setParameters(parameters);
        }
    }

    public void a(boolean z) {
        if (z) {
            r().setRequestedOrientation(6);
            this.g.enable();
            return;
        }
        this.g.disable();
    }

    public void a(boolean z, boolean z2) {
        a(new m(a()).a(z).b(z2));
    }

    @TargetApi(14)
    public void b() {
        addView(this.b.a());
        if (this.d == null) {
            this.j = a().e();
            if (this.j >= 0) {
                try {
                    this.d = Camera.open(this.j);
                    v();
                    if (VERSION.SDK_INT >= 14 && (a() instanceof FaceDetectionListener)) {
                        this.d.setFaceDetectionListener((FaceDetectionListener) a());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    a().a(c.UNKNOWN);
                    return;
                }
            }
            a().a(c.NO_CAMERAS_REPORTED);
        }
    }

    public void b(int i, int i2) {
        a(i, i2, true);
    }

    public void c() {
        if (this.d != null) {
            q();
        }
        removeView(this.b.a());
        this.g.disable();
        this.o = -1;
    }

    public int d() {
        return this.h;
    }

    public void e() {
        if (!this.e) {
            t();
        }
    }

    public boolean f() {
        return this.k != null;
    }

    public void g() {
        if (VERSION.SDK_INT < 11) {
            throw new UnsupportedOperationException("Video recording supported only on API Level 11+");
        } else if (this.h == 0 || this.h == a.i) {
            Parameters parameters = this.d.getParameters();
            a(parameters);
            this.d.setParameters(parameters);
            u();
            this.d.unlock();
            try {
                this.k = new MediaRecorder();
                this.k.setCamera(this.d);
                a().a(this.j, this.k);
                this.k.setVideoSource(1);
                a().c(this.j, this.k);
                a().b(this.j, this.k);
                this.k.setOrientationHint(this.i);
                this.b.a(this.k);
                this.k.prepare();
                this.k.start();
            } catch (IOException e) {
                this.k.release();
                this.k = null;
                throw e;
            }
        } else {
            throw new UnsupportedOperationException("Video recording supported only in landscape");
        }
    }

    public void h() {
        if (VERSION.SDK_INT < 11) {
            throw new UnsupportedOperationException("Video recording supported only on API Level 11+");
        }
        MediaRecorder mediaRecorder = this.k;
        this.k = null;
        mediaRecorder.stop();
        mediaRecorder.release();
        this.d.reconnect();
        t();
    }

    public void i() {
        if (this.e) {
            this.d.autoFocus(this);
            this.n = true;
        }
    }

    public void j() {
        this.d.cancelAutoFocus();
    }

    public boolean k() {
        return this.e;
    }

    public String l() {
        return this.d.getParameters().getFlashMode();
    }

    @TargetApi(14)
    public void m() {
        if (VERSION.SDK_INT >= 14 && this.d != null && !this.m && this.d.getParameters().getMaxNumDetectedFaces() > 0) {
            this.d.startFaceDetection();
            this.m = true;
        }
    }

    public void n() {
        if (VERSION.SDK_INT >= 14 && this.d != null && this.m) {
            try {
                this.d.stopFaceDetection();
            } catch (Exception e) {
            }
            this.m = false;
        }
    }

    public boolean o() {
        boolean z = true;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(a().e(), cameraInfo);
        k f = a().f();
        if (cameraInfo.facing != 1) {
            z = false;
        }
        return f.a(z);
    }

    public void onAutoFocus(boolean z, Camera camera) {
        this.n = false;
        if (a() instanceof AutoFocusCallback) {
            a().onAutoFocus(z, camera);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && getChildCount() > 0) {
            int i5;
            int i6;
            View childAt = getChildAt(0);
            int i7 = i3 - i;
            int i8 = i4 - i2;
            if (this.c == null) {
                i5 = i8;
                i6 = i7;
            } else if (d() == 90 || d() == 270) {
                i6 = this.c.height;
                i5 = this.c.width;
            } else {
                i6 = this.c.width;
                i5 = this.c.height;
            }
            int i9 = i7 * i5 > i8 * i6 ? 1 : 0;
            boolean j = a().j();
            if ((i9 == 0 || j) && !(i9 == 0 && j)) {
                i9 = (i5 * i7) / i6;
                childAt.layout(0, (i8 - i9) / 2, i7, (i9 + i8) / 2);
                return;
            }
            i9 = (i6 * i8) / i5;
            childAt.layout((i7 - i9) / 2, 0, (i9 + i7) / 2, i8);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r8, int r9) {
        /*
        r7 = this;
        r6 = 0;
        r0 = r7.getSuggestedMinimumWidth();
        r2 = resolveSize(r0, r8);
        r0 = r7.getSuggestedMinimumHeight();
        r3 = resolveSize(r0, r9);
        r7.setMeasuredDimension(r2, r3);
        if (r2 <= 0) goto L_0x0060;
    L_0x0016:
        if (r3 <= 0) goto L_0x0060;
    L_0x0018:
        r0 = r7.d;
        if (r0 == 0) goto L_0x0060;
    L_0x001c:
        r0 = r7.a();	 Catch:{ Exception -> 0x0061 }
        r0 = r0.i();	 Catch:{ Exception -> 0x0061 }
        r1 = com.commonsware.cwac.camera.d.STILL_ONLY;	 Catch:{ Exception -> 0x0061 }
        if (r0 == r1) goto L_0x0091;
    L_0x0028:
        r0 = r7.a();	 Catch:{ Exception -> 0x0061 }
        r1 = r7.d();	 Catch:{ Exception -> 0x0061 }
        r4 = r7.d;	 Catch:{ Exception -> 0x0061 }
        r4 = r4.getParameters();	 Catch:{ Exception -> 0x0061 }
        r5 = 0;
        r1 = r0.a(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0061 }
    L_0x003b:
        if (r1 == 0) goto L_0x0046;
    L_0x003d:
        r0 = r1.width;	 Catch:{ Exception -> 0x008f }
        r4 = r1.height;	 Catch:{ Exception -> 0x008f }
        r0 = r0 * r4;
        r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r0 >= r4) goto L_0x0058;
    L_0x0046:
        r0 = r7.a();	 Catch:{ Exception -> 0x008f }
        r4 = r7.d();	 Catch:{ Exception -> 0x008f }
        r5 = r7.d;	 Catch:{ Exception -> 0x008f }
        r5 = r5.getParameters();	 Catch:{ Exception -> 0x008f }
        r1 = r0.a(r4, r2, r3, r5);	 Catch:{ Exception -> 0x008f }
    L_0x0058:
        if (r1 == 0) goto L_0x0060;
    L_0x005a:
        r0 = r7.c;
        if (r0 != 0) goto L_0x0071;
    L_0x005e:
        r7.c = r1;
    L_0x0060:
        return;
    L_0x0061:
        r0 = move-exception;
        r1 = r6;
    L_0x0063:
        r4 = r7.getClass();
        r4 = r4.getSimpleName();
        r5 = "Could not work with camera parameters?";
        android.util.Log.e(r4, r5, r0);
        goto L_0x0058;
    L_0x0071:
        r0 = r7.c;
        r0 = r0.width;
        r4 = r1.width;
        if (r0 != r4) goto L_0x0081;
    L_0x0079:
        r0 = r7.c;
        r0 = r0.height;
        r4 = r1.height;
        if (r0 == r4) goto L_0x0060;
    L_0x0081:
        r0 = r7.e;
        if (r0 == 0) goto L_0x0088;
    L_0x0085:
        r7.u();
    L_0x0088:
        r7.c = r1;
        r0 = 0;
        r7.a(r2, r3, r0);
        goto L_0x0060;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0063;
    L_0x0091:
        r1 = r6;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.commonsware.cwac.camera.CameraView.onMeasure(int, int):void");
    }

    void p() {
        if (this.d != null) {
            try {
                this.b.a(this.d);
            } catch (Exception e) {
                a().a(e);
            }
        }
    }

    void q() {
        if (this.d != null) {
            s();
            this.d.release();
            this.d = null;
        }
    }

    Activity r() {
        return (Activity) getContext();
    }
}
