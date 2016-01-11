package com.xiaomi.hm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.Thread.State;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class GifView extends ImageView implements a, h {
    private d e;
    private Bitmap f;
    private b g;
    private boolean h;
    private int i;
    private boolean j;
    private int k;
    private int l;
    private g m;
    private boolean n;
    private int o;
    private f p;
    private Handler q;

    public GifView(Context context) {
        super(context);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = -1;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = false;
        this.o = 0;
        this.p = f.SYNC_DECODER;
        this.q = new i(this);
        setScaleType(ScaleType.FIT_XY);
        this.g = new b();
        this.g.a((h) this);
    }

    public GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = -1;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = false;
        this.o = 0;
        this.p = f.SYNC_DECODER;
        this.q = new i(this);
        setScaleType(ScaleType.FIT_XY);
        this.g = new b();
        this.g.a((h) this);
    }

    private void a(Resources resources, int i) {
        g();
        this.e.a(resources, i);
        this.e.start();
    }

    private void b(byte[] bArr) {
        g();
        this.e.a(bArr);
        this.e.start();
    }

    private void g() {
        h();
        if (this.f != null) {
            this.f = null;
        }
        if (this.e != null) {
            i();
            this.e.destroy();
            this.e = null;
        }
        this.k = 0;
        this.e = new d(this);
        if (this.j) {
            this.e.a();
        }
    }

    private void h() {
        if (!this.n) {
            this.g.c();
            this.h = false;
        }
    }

    private void i() {
        if (this.e != null && this.e.getState() != State.TERMINATED) {
            this.e.interrupt();
            this.e.destroy();
        }
    }

    private void j() {
        if (!this.n) {
            h();
            this.k = 0;
            this.g.d();
        }
    }

    private int k() {
        if (this.e == null) {
            return -1;
        }
        e i = this.e.i();
        if (i == null) {
            return -1;
        }
        if (i.a != null) {
            this.f = i.a;
        }
        return i.b;
    }

    private void l() {
        if (this.q != null) {
            this.q.sendMessage(this.q.obtainMessage());
        }
    }

    private void m() {
        if (this.f == null || !(this.f == null || this.f.isRecycled())) {
            setImageBitmap(this.f);
            invalidate();
            if (this.m == null) {
                return;
            }
            if (this.o == 2 || this.o == 3) {
                this.l++;
                this.m.b(this.l);
            }
        }
    }

    public void a() {
        this.k++;
        if (this.i > 0 && this.k >= this.i) {
            h();
            i();
        }
        if (this.m != null) {
            if (this.o == 1 || this.o == 3) {
                this.m.a(this.k);
            }
            this.l = 0;
        }
    }

    public void a(int i) {
        if (getVisibility() != 8 && getVisibility() != 4) {
            switch (i) {
                case l.a /*1*/:
                    Log.d("parseReturn", "FIRST");
                    if (this.p == f.COVER || this.p == f.SYNC_DECODER) {
                        this.f = this.e.g();
                        l();
                        return;
                    }
                    return;
                case a.k /*2*/:
                    Log.d("parseReturn", "FINISH");
                    if (this.e.d() == 1) {
                        k();
                        l();
                        h();
                        i();
                        this.n = true;
                        return;
                    }
                    this.n = false;
                    if (!this.h) {
                        j();
                        this.h = true;
                        return;
                    }
                    return;
                case a.l /*3*/:
                    Log.d("parseReturn", "CACHE_FINISH");
                    if (!this.h) {
                        j();
                        this.h = true;
                        return;
                    }
                    return;
                case a.aQ /*4*/:
                    Log.e("parseReturn", "ERROR");
                    return;
                default:
                    return;
            }
        }
    }

    public void a(f fVar) {
        if (this.e == null) {
            this.p = fVar;
        }
    }

    public void a(g gVar, int i) {
        this.m = gVar;
        if (i >= 1 && i <= 3) {
            this.o = i;
        }
    }

    public void a(String str) {
        g();
        this.e.a(str);
        this.e.start();
    }

    public void a(byte[] bArr) {
        b(bArr);
    }

    public int b() {
        int k = k();
        m();
        return k;
    }

    public void b(int i) {
        if (i > 1) {
            this.i = i;
            c();
        }
    }

    public void c() {
        this.j = true;
        if (this.e != null) {
            this.e.a();
        }
    }

    public void c(int i) {
        a(getResources(), i);
    }

    public void d() {
        h();
        i();
        this.g.e();
        this.e.destroy();
        this.e = null;
        this.g = null;
    }

    public void dispatchWindowVisibilityChanged(int i) {
        if (i == 8 || i == 4) {
            f();
        } else if (i == 0) {
            e();
        }
        super.dispatchWindowVisibilityChanged(i);
    }

    public void e() {
        if (!this.n && this.h) {
            this.g.b();
        }
    }

    public void f() {
        if (!this.n) {
            this.g.a();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            h();
        } else if (i == 0) {
            j();
        }
    }
}
