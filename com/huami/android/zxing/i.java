package com.huami.android.zxing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import cn.com.smartdevices.bracelet.C0596r;
import com.c.b.c;
import com.c.b.e;
import com.c.b.j;
import com.c.b.k;
import com.c.b.p;
import com.c.b.r;
import com.huami.android.zxing.b.a;
import java.io.File;
import java.util.Map;

final class i extends Handler {
    private static final String a = i.class.getSimpleName();
    private static final int b = 1920000;
    private static final int c = 4;
    private final CaptureActivity d;
    private final k e = new k();
    private boolean f = true;

    i(CaptureActivity captureActivity, Map<e, Object> map) {
        this.e.a((Map) map);
        this.d = captureActivity;
    }

    private void a(File file) {
        Message obtain;
        Handler c = this.d.c();
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outWidth * options.outHeight >= b) {
                options.inSampleSize = c;
            }
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (decodeFile == null) {
                C0596r.a(a, "uri is not a bitmap," + file.toString());
                if (c != null) {
                    obtain = Message.obtain(c, l.c);
                    obtain.arg1 = l.h;
                    obtain.sendToTarget();
                    return;
                }
                return;
            }
            Object a;
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            int[] iArr = new int[(width * height)];
            decodeFile.getPixels(iArr, 0, width, 0, 0, width, height);
            decodeFile.recycle();
            j pVar = new p(width, height, iArr);
            int f = this.d.f();
            if (f > 0) {
                a.a(f);
            } else {
                a.e();
            }
            try {
                a = this.e.a(new c(new a(pVar)));
            } catch (Throwable e) {
                C0596r.a(a, "decode exception", e);
                a = null;
                if (a == null) {
                    if (c != null) {
                        obtain = Message.obtain(c, l.c);
                        obtain.arg1 = l.h;
                        obtain.sendToTarget();
                    }
                } else if (c != null) {
                    obtain = Message.obtain(c, l.b, a);
                    obtain.arg1 = l.h;
                    obtain.sendToTarget();
                }
                this.e.a();
            }
            if (a == null) {
                if (c != null) {
                    obtain = Message.obtain(c, l.b, a);
                    obtain.arg1 = l.h;
                    obtain.sendToTarget();
                }
            } else if (c != null) {
                obtain = Message.obtain(c, l.c);
                obtain.arg1 = l.h;
                obtain.sendToTarget();
            }
            this.e.a();
        } catch (Throwable e2) {
            C0596r.a(a, "decode exception", e2);
        }
    }

    private void a(byte[] bArr, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        byte[] bArr2 = new byte[bArr.length];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr2[(((i4 * i2) + i2) - i3) - 1] = bArr[(i3 * i) + i4];
            }
        }
        j a = this.d.d().a(bArr2, i2, i);
        if (a != null) {
            int f = this.d.f();
            if (f > 0) {
                a.a(f);
            } else {
                a.e();
            }
            try {
                obj = this.e.b(new c(new a(a)));
            } catch (r e) {
            } finally {
                this.e.a();
            }
        }
        Handler c = this.d.c();
        Message obtain;
        if (obj != null) {
            Log.d(a, "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (c != null) {
                obtain = Message.obtain(c, l.b, obj);
                obtain.arg1 = l.f;
                obtain.sendToTarget();
            }
        } else if (c != null) {
            obtain = Message.obtain(c, l.c);
            obtain.arg1 = l.f;
            obtain.sendToTarget();
        }
    }

    public void handleMessage(Message message) {
        if (this.f) {
            switch (message.what) {
                case l.f /*65542*/:
                    a((byte[]) message.obj, message.arg1, message.arg2);
                    return;
                case l.g /*65543*/:
                    this.f = false;
                    Looper.myLooper().quit();
                    return;
                case l.h /*65544*/:
                    a((File) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
