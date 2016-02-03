package com.huami.android.zxing.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.c.b.o;
import com.huami.android.zxing.a.a.a;
import java.io.IOException;

public final class g {
    private static final String a = g.class.getSimpleName();
    private static final int b = 240;
    private static final int c = 240;
    private static final int d = 1200;
    private static final int e = 675;
    private final Context f;
    private final d g;
    private Camera h;
    private a i;
    private Rect j;
    private Rect k;
    private boolean l;
    private boolean m;
    private int n = -1;
    private int o;
    private int p;
    private final h q;

    public g(Context context) {
        this.f = context;
        this.g = new d(context);
        this.q = new h(this.g);
    }

    private static int a(int i, int i2, int i3) {
        int i4 = (i * 5) / 8;
        return i4 < i2 ? i2 : i4 > i3 ? i3 : i4;
    }

    public o a(byte[] bArr, int i, int i2) {
        Rect f = f();
        if (f == null) {
            return null;
        }
        return new o(bArr, i, i2, f.left, f.top, f.width(), f.height(), false);
    }

    public void a(int i) {
        this.g.a(i);
    }

    public synchronized void a(int i, int i2) {
        if (this.l) {
            Point b = this.g.b();
            if (i > b.x) {
                i = b.x;
            }
            if (i2 > b.y) {
                i2 = b.y;
            }
            int i3 = (b.x - i) / 2;
            int i4 = (b.y - i2) / 2;
            this.j = new Rect(i3, i4, i3 + i, i4 + i2);
            Log.d(a, "Calculated manual framing rect: " + this.j);
            this.k = null;
        } else {
            this.o = i;
            this.p = i2;
        }
    }

    public synchronized void a(Handler handler, int i) {
        Camera camera = this.h;
        if (camera != null && this.m) {
            this.q.a(handler, i);
            camera.setOneShotPreviewCallback(this.q);
        }
    }

    public synchronized void a(SurfaceHolder surfaceHolder) {
        Parameters parameters;
        Camera camera = this.h;
        if (camera == null) {
            camera = a.a(this.n);
            if (camera == null) {
                throw new IOException();
            }
            this.h = camera;
        }
        camera.setPreviewDisplay(surfaceHolder);
        if (!this.l) {
            this.l = true;
            this.g.a(camera);
            if (this.o > 0 && this.p > 0) {
                a(this.o, this.p);
                this.o = 0;
                this.p = 0;
            }
        }
        String flatten = camera.getParameters().flatten();
        try {
            this.g.a(camera, false);
        } catch (RuntimeException e) {
            Log.w(a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(a, "Resetting to saved camera params: " + flatten);
            parameters = camera.getParameters();
            parameters.unflatten(flatten);
            try {
                camera.setParameters(parameters);
                this.g.a(camera, true);
            } catch (RuntimeException e2) {
                Log.w(a, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
    }

    public synchronized void a(boolean z) {
        if (!(z == this.g.b(this.h) || this.h == null)) {
            if (this.i != null) {
                this.i.stop();
            }
            this.g.b(this.h, z);
            if (this.i != null) {
                this.i.start();
            }
        }
    }

    public synchronized boolean a() {
        return this.h != null;
    }

    public synchronized void b() {
        if (this.h != null) {
            this.h.release();
            this.h = null;
            this.j = null;
            this.k = null;
        }
    }

    public synchronized void b(int i) {
        this.n = i;
    }

    public synchronized void c() {
        Camera camera = this.h;
        if (!(camera == null || this.m)) {
            camera.startPreview();
            this.m = true;
            this.i = new a(this.h);
        }
    }

    public synchronized void d() {
        if (this.i != null) {
            this.i.stop();
            this.i = null;
        }
        if (this.h != null && this.m) {
            this.h.stopPreview();
            this.q.a(null, 0);
            this.m = false;
        }
    }

    public synchronized Rect e() {
        Rect rect = null;
        synchronized (this) {
            if (this.j == null) {
                if (this.h != null) {
                    Point b = this.g.b();
                    if (b != null) {
                        int a = a(b.x, (int) c, (int) d);
                        int i = (b.x - a) / 2;
                        int i2 = (b.y - a) / 3;
                        this.j = new Rect(i, i2, i + a, a + i2);
                        Log.d(a, "Calculated framing rect: " + this.j);
                    }
                }
            }
            rect = this.j;
        }
        return rect;
    }

    public synchronized Rect f() {
        Rect rect = null;
        synchronized (this) {
            if (this.k == null) {
                Rect e = e();
                if (e != null) {
                    Rect rect2 = new Rect(e);
                    Point a = this.g.a();
                    Point b = this.g.b();
                    if (!(a == null || b == null)) {
                        rect2.left = (rect2.left * a.y) / b.x;
                        rect2.right = (rect2.right * a.y) / b.x;
                        rect2.top = (rect2.top * a.x) / b.y;
                        rect2.bottom = (rect2.bottom * a.x) / b.y;
                        this.k = rect2;
                    }
                }
            }
            rect = this.k;
        }
        return rect;
    }
}
