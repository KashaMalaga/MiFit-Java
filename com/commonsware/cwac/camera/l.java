package com.commonsware.cwac.camera;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import android.support.v4.view.a.C0099a;
import android.util.Log;
import cn.com.smartdevices.bracelet.gps.c.a;
import com.a.a.a.C0895d;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class l extends Thread {
    private byte[] a;
    private int b;
    private m c = null;
    private boolean d = true;

    l(Context context, byte[] bArr, int i, m mVar) {
        boolean z = true;
        this.a = bArr;
        this.b = i;
        this.c = mVar;
        if (((float) bArr.length) / ((float) a(context)) >= mVar.a.k()) {
            z = false;
        }
        this.d = z;
    }

    @TargetApi(11)
    private static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int memoryClass = (VERSION.SDK_INT < 11 || (context.getApplicationInfo().flags & C0099a.n) == 0) ? activityManager.getMemoryClass() : activityManager.getLargeMemoryClass();
        return memoryClass * C0099a.n;
    }

    private Matrix a(Matrix matrix) {
        float[] fArr = new float[]{GroundOverlayOptions.NO_DIMENSION, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        Matrix matrix2 = new Matrix();
        matrix2.setValues(fArr);
        matrix.postConcat(matrix2);
        return matrix;
    }

    private Matrix a(Matrix matrix, int i) {
        matrix.setRotate((float) i);
        return matrix;
    }

    private Matrix b(Matrix matrix) {
        float[] fArr = new float[]{GroundOverlayOptions.NO_DIMENSION, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        Matrix matrix2 = new Matrix();
        matrix2.setValues(fArr);
        matrix.preScale(1.0f, GroundOverlayOptions.NO_DIMENSION);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public void run() {
        Matrix b;
        Bitmap bitmap = null;
        int i = 270;
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(this.b, cameraInfo);
        if (this.d) {
            C0895d c0895d;
            Integer h;
            Bitmap createBitmap;
            if (cameraInfo.facing == 1) {
                if (this.c.a.f().b() && (this.c.f == 90 || this.c.f == 270)) {
                    b = b(new Matrix());
                    if (this.c.a.f().f()) {
                        c0895d = new C0895d();
                        c0895d.a(this.a);
                        h = c0895d.h(C0895d.m);
                        if (h != null) {
                            if (h.intValue() != 6) {
                                i = 90;
                            } else if (h.intValue() != 8) {
                                if (h.intValue() != 3) {
                                    i = a.i;
                                } else if (h.intValue() == 1) {
                                    i = 0;
                                }
                            }
                        }
                        i = 0;
                    } else {
                        i = this.c.f;
                    }
                    if (i != 0) {
                        if (b == null) {
                        }
                        b = a(b == null ? new Matrix() : b, i);
                    }
                    if (b != null) {
                        bitmap = BitmapFactory.decodeByteArray(this.a, 0, this.a.length);
                        createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), b, true);
                        bitmap.recycle();
                        bitmap = createBitmap;
                    }
                } else if (this.c.c()) {
                    b = a(new Matrix());
                    if (this.c.a.f().f()) {
                        i = this.c.f;
                    } else {
                        c0895d = new C0895d();
                        c0895d.a(this.a);
                        h = c0895d.h(C0895d.m);
                        if (h != null) {
                            if (h.intValue() != 6) {
                                i = 90;
                            } else if (h.intValue() != 8) {
                                if (h.intValue() != 3) {
                                    i = a.i;
                                } else if (h.intValue() == 1) {
                                    i = 0;
                                }
                            }
                        }
                        i = 0;
                    }
                    if (i != 0) {
                        b = a(b == null ? new Matrix() : b, i);
                    }
                    if (b != null) {
                        bitmap = BitmapFactory.decodeByteArray(this.a, 0, this.a.length);
                        createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), b, true);
                        bitmap.recycle();
                        bitmap = createBitmap;
                    }
                }
            }
            b = null;
            try {
                if (this.c.a.f().f()) {
                    i = this.c.f;
                } else {
                    c0895d = new C0895d();
                    c0895d.a(this.a);
                    h = c0895d.h(C0895d.m);
                    if (h != null) {
                        if (h.intValue() != 6) {
                            i = 90;
                        } else if (h.intValue() != 8) {
                            if (h.intValue() != 3) {
                                i = a.i;
                            } else if (h.intValue() == 1) {
                                i = 0;
                            }
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    if (b == null) {
                    }
                    b = a(b == null ? new Matrix() : b, i);
                }
            } catch (Throwable e) {
                Log.e("CWAC-Camera", "Exception parsing JPEG", e);
            }
            if (b != null) {
                bitmap = BitmapFactory.decodeByteArray(this.a, 0, this.a.length);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), b, true);
                bitmap.recycle();
                bitmap = createBitmap;
            }
        } else {
            b = null;
        }
        if (this.c.b) {
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeByteArray(this.a, 0, this.a.length);
            }
            this.c.a.a(this.c, bitmap);
        }
        if (this.c.c) {
            if (b != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                this.a = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e2) {
                    Log.e("CWAC-Camera", "Exception in closing a BAOS???", e2);
                }
            }
            this.c.a.a(this.c, this.a);
        }
        System.gc();
    }
}
