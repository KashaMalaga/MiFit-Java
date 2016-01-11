package com.commonsware.cwac.camera;

import android.hardware.Camera.ShutterCallback;

public class m implements ShutterCallback {
    b a = null;
    boolean b = false;
    boolean c = true;
    boolean d = false;
    boolean e = false;
    int f = 0;
    String g = null;
    CameraView h = null;
    private Object i = null;

    public m(b bVar) {
        this.a = bVar;
    }

    m a(int i) {
        this.f = i;
        return this;
    }

    public m a(Object obj) {
        this.i = obj;
        return this;
    }

    public m a(String str) {
        this.g = str;
        return this;
    }

    public m a(boolean z) {
        this.b = z;
        return this;
    }

    public Object a() {
        return this.i;
    }

    public m b(boolean z) {
        this.c = z;
        return this;
    }

    boolean b() {
        return this.e || this.a.c();
    }

    public m c(boolean z) {
        this.e = z;
        return this;
    }

    boolean c() {
        return this.d || this.a.h();
    }

    public m d(boolean z) {
        this.d = z;
        return this;
    }

    public void onShutter() {
        ShutterCallback g = this.a.g();
        if (g != null) {
            g.onShutter();
        }
    }
}
