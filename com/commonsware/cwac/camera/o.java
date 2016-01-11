package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class o implements b {
    private static final String[] a = new String[]{"image/jpeg"};
    private Context b = null;
    private int c = -1;
    private k d = null;
    private File e = null;
    private File f = null;
    private d g = null;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = true;
    private boolean l = false;

    public o(Context context) {
        this.b = context.getApplicationContext();
    }

    private void a(Context context) {
        this.d = k.a(context);
    }

    private void s() {
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = -1;
        if (numberOfCameras > 0) {
            CameraInfo cameraInfo = new CameraInfo();
            i = 0;
            while (i < numberOfCameras) {
                Camera.getCameraInfo(i, cameraInfo);
                if ((cameraInfo.facing == 0 && !b()) || (cameraInfo.facing == 1 && b())) {
                    break;
                }
                i++;
            }
            i = 0;
        }
        this.c = i;
    }

    private void t() {
        this.g = this.d.h();
        if (this.g == d.NONE) {
            this.g = d.ANY;
        }
    }

    private void u() {
        this.e = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    }

    private void v() {
        this.f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
    }

    public Parameters a(Parameters parameters) {
        return parameters;
    }

    public Parameters a(m mVar, Parameters parameters) {
        return parameters;
    }

    public Size a(int i, int i2, int i3, Parameters parameters) {
        return f.b(i, i2, i3, parameters);
    }

    @TargetApi(11)
    public Size a(int i, int i2, int i3, Parameters parameters, Size size) {
        return size != null ? size : VERSION.SDK_INT >= 11 ? parameters.getPreferredPreviewSizeForVideo() : null;
    }

    public void a() {
    }

    public void a(int i, MediaRecorder mediaRecorder) {
        mediaRecorder.setAudioSource(5);
    }

    public void a(c cVar) {
        Log.e("CWAC-Camera", String.format("Camera access failed: %d", new Object[]{Integer.valueOf(cVar.c)}));
    }

    public void a(m mVar, Bitmap bitmap) {
    }

    public void a(m mVar, byte[] bArr) {
        File l = l();
        if (l.exists()) {
            l.delete();
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream(l.getPath());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            fileOutputStream.getFD().sync();
            bufferedOutputStream.close();
            if (r()) {
                MediaScannerConnection.scanFile(this.b, new String[]{l.getPath()}, a, null);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    public void a(Exception exception) {
        Log.e(getClass().getSimpleName(), "Exception in setPreviewDisplay()", exception);
    }

    public Size b(m mVar, Parameters parameters) {
        return f.a((b) this, parameters);
    }

    public void b(int i, MediaRecorder mediaRecorder) {
        mediaRecorder.setOutputFile(o().getAbsolutePath());
    }

    protected boolean b() {
        return this.i;
    }

    @TargetApi(11)
    public void c(int i, MediaRecorder mediaRecorder) {
        if (VERSION.SDK_INT < 11 || CamcorderProfile.hasProfile(i, 1)) {
            mediaRecorder.setProfile(CamcorderProfile.get(i, 1));
        } else if (VERSION.SDK_INT < 11 || !CamcorderProfile.hasProfile(i, 0)) {
            throw new IllegalStateException("cannot find valid CamcorderProfile");
        } else {
            mediaRecorder.setProfile(CamcorderProfile.get(i, 0));
        }
    }

    public boolean c() {
        return this.l;
    }

    public void d() {
    }

    public int e() {
        if (this.c == -1) {
            s();
        }
        return this.c;
    }

    public k f() {
        if (this.d == null) {
            a(this.b);
        }
        return this.d;
    }

    public ShutterCallback g() {
        return null;
    }

    public boolean h() {
        return this.h;
    }

    public d i() {
        if (this.g == null) {
            t();
        }
        return this.g;
    }

    public boolean j() {
        return this.k;
    }

    public float k() {
        return 1.0f;
    }

    protected File l() {
        File m = m();
        m.mkdirs();
        return new File(m, n());
    }

    protected File m() {
        if (this.e == null) {
            u();
        }
        return this.e;
    }

    protected String n() {
        return "Photo_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".jpg";
    }

    protected File o() {
        File p = p();
        p.mkdirs();
        return new File(p, q());
    }

    @TargetApi(16)
    public void onAutoFocus(boolean z, Camera camera) {
        if (z && VERSION.SDK_INT >= 16) {
            new MediaActionSound().play(1);
        }
    }

    protected File p() {
        if (this.f == null) {
            v();
        }
        return this.f;
    }

    protected String q() {
        return "Video_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()) + ".mp4";
    }

    protected boolean r() {
        return this.j;
    }
}
