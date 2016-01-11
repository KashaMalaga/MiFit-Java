package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.widget.C0219am;
import android.view.View;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import kankan.wheel.widget.a;

class ai implements Runnable {
    final /* synthetic */ RecyclerView a;
    private int b;
    private int c;
    private C0219am d;
    private Interpolator e = RecyclerView.aq;
    private boolean f = false;
    private boolean g = false;

    public ai(RecyclerView recyclerView) {
        this.a = recyclerView;
        this.d = C0219am.a(recyclerView.getContext(), RecyclerView.aq);
    }

    private float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private int b(int i, int i2, int i3, int i4) {
        int round;
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        Object obj = abs > abs2 ? 1 : null;
        int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
        int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
        int width = obj != null ? this.a.getWidth() : this.a.getHeight();
        int i5 = width / 2;
        float a = (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
        if (sqrt > 0) {
            round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
        } else {
            round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * BitmapDescriptorFactory.HUE_MAGENTA);
        }
        return Math.min(round, a.bZ);
    }

    private void b() {
        this.g = false;
        this.f = true;
    }

    private void c() {
        this.f = false;
        if (this.g) {
            a();
        }
    }

    void a() {
        if (this.f) {
            this.g = true;
        } else {
            C0151az.a(this.a, (Runnable) this);
        }
    }

    public void a(int i, int i2) {
        this.a.h(2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, i, i2, af.a, Integer.MAX_VALUE, af.a, Integer.MAX_VALUE);
        a();
    }

    public void a(int i, int i2, int i3) {
        a(i, i2, i3, RecyclerView.aq);
    }

    public void a(int i, int i2, int i3, int i4) {
        a(i, i2, b(i, i2, i3, i4));
    }

    public void a(int i, int i2, int i3, Interpolator interpolator) {
        if (this.e != interpolator) {
            this.e = interpolator;
            this.d = C0219am.a(this.a.getContext(), interpolator);
        }
        this.a.h(2);
        this.c = 0;
        this.b = 0;
        this.d.a(0, 0, i, i2, i3);
        a();
    }

    public void b(int i, int i2) {
        a(i, i2, 0, 0);
    }

    public void run() {
        b();
        this.a.z();
        C0219am c0219am = this.d;
        ae aeVar = this.a.D.v;
        if (c0219am.g()) {
            int b;
            int i;
            int top;
            int h;
            int b2 = c0219am.b();
            int c = c0219am.c();
            int i2 = b2 - this.b;
            int i3 = c - this.c;
            int i4 = 0;
            int i5 = 0;
            this.b = b2;
            this.c = c;
            int i6 = 0;
            int i7 = 0;
            if (this.a.C != null) {
                this.a.h();
                this.a.R = true;
                if (i2 != 0) {
                    i4 = this.a.D.a(i2, this.a.h, this.a.p);
                    i6 = i2 - i4;
                }
                if (i3 != 0) {
                    i5 = this.a.D.b(i3, this.a.h, this.a.p);
                    i7 = i3 - i5;
                }
                if (this.a.D()) {
                    b = this.a.j.b();
                    for (i = 0; i < b; i++) {
                        View b3 = this.a.j.b(i);
                        aj a = this.a.a(b3);
                        if (!(a == null || a.h == null)) {
                            View view = a.h != null ? a.h.a : null;
                            if (view != null) {
                                int left = b3.getLeft();
                                top = b3.getTop();
                                if (left != view.getLeft() || top != view.getTop()) {
                                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                                }
                            }
                        }
                    }
                }
                if (!(aeVar == null || aeVar.f() || !aeVar.g())) {
                    h = this.a.p.h();
                    if (h == 0) {
                        aeVar.stop();
                    } else if (aeVar.h() >= h) {
                        aeVar.d(h - 1);
                        aeVar.a(i2 - i6, i3 - i7);
                    } else {
                        aeVar.a(i2 - i6, i3 - i7);
                    }
                }
                this.a.R = false;
                this.a.b(false);
            }
            h = i7;
            i = i6;
            b = i5;
            top = i4;
            Object obj = (i2 == top && i3 == b) ? 1 : null;
            if (!this.a.F.isEmpty()) {
                this.a.invalidate();
            }
            if (C0151az.a(this.a) != 2) {
                this.a.i(i2, i3);
            }
            if (!(i == 0 && h == 0)) {
                i6 = (int) c0219am.f();
                if (i != b2) {
                    i5 = i < 0 ? -i6 : i > 0 ? i6 : 0;
                    i4 = i5;
                } else {
                    i4 = 0;
                }
                if (h == c) {
                    i6 = 0;
                } else if (h < 0) {
                    i6 = -i6;
                } else if (h <= 0) {
                    i6 = 0;
                }
                if (C0151az.a(this.a) != 2) {
                    this.a.d(i4, i6);
                }
                if ((i4 != 0 || i == b2 || c0219am.d() == 0) && (i6 != 0 || h == c || c0219am.e() == 0)) {
                    c0219am.h();
                }
            }
            if (!(top == 0 && b == 0)) {
                this.a.onScrollChanged(0, 0, 0, 0);
                if (this.a.al != null) {
                    this.a.al.a(this.a, top, b);
                }
            }
            if (!this.a.awakenScrollBars()) {
                this.a.invalidate();
            }
            if (c0219am.a() || obj == null) {
                this.a.h(0);
            } else {
                a();
            }
        }
        if (aeVar != null && aeVar.f()) {
            aeVar.a(0, 0);
        }
        c();
    }

    public void stop() {
        this.a.removeCallbacks(this);
        this.d.h();
    }
}
