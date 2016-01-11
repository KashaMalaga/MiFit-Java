package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.xiaomi.account.openauth.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import kankan.wheel.widget.a;

class C0195s implements C0194r {
    private static final int e = ViewConfiguration.getLongPressTimeout();
    private static final int f = ViewConfiguration.getTapTimeout();
    private static final int g = ViewConfiguration.getDoubleTapTimeout();
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private VelocityTracker A;
    private int a;
    private int b;
    private int c;
    private int d;
    private final Handler k;
    private final OnGestureListener l;
    private OnDoubleTapListener m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private MotionEvent s;
    private MotionEvent t;
    private boolean u;
    private float v;
    private float w;
    private float x;
    private float y;
    private boolean z;

    public C0195s(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.k = new C0196t(this, handler);
        } else {
            this.k = new C0196t(this);
        }
        this.l = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            a((OnDoubleTapListener) onGestureListener);
        }
        a(context);
    }

    private void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.l == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.z = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.a = scaledTouchSlop * scaledTouchSlop;
            this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.r || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) g)) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.b;
    }

    private void b() {
        this.k.removeMessages(h);
        this.k.removeMessages(i);
        this.k.removeMessages(j);
        this.A.recycle();
        this.A = null;
        this.u = false;
        this.n = false;
        this.q = false;
        this.r = false;
        this.o = false;
        if (this.p) {
            this.p = false;
        }
    }

    private void c() {
        this.k.removeMessages(h);
        this.k.removeMessages(i);
        this.k.removeMessages(j);
        this.u = false;
        this.q = false;
        this.r = false;
        this.o = false;
        if (this.p) {
            this.p = false;
        }
    }

    private void d() {
        this.k.removeMessages(j);
        this.o = false;
        this.p = true;
        this.l.onLongPress(this.s);
    }

    public void a(OnDoubleTapListener onDoubleTapListener) {
        this.m = onDoubleTapListener;
    }

    public void a(boolean z) {
        this.z = z;
    }

    public boolean a() {
        return this.z;
    }

    public boolean a(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.A == null) {
            this.A = VelocityTracker.obtain();
        }
        this.A.addMovement(motionEvent);
        boolean z = (action & HeartRateInfo.HR_EMPTY_VALUE) == 6;
        int b = z ? Y.b(motionEvent) : -1;
        int c = Y.c(motionEvent);
        float f = 0.0f;
        float f2 = 0.0f;
        for (i = g; i < c; i += h) {
            if (b != i) {
                f2 += Y.c(motionEvent, i);
                f += Y.d(motionEvent, i);
            }
        }
        b = z ? c - 1 : c;
        f2 /= (float) b;
        f /= (float) b;
        boolean hasMessages;
        float b2;
        float a;
        switch (action & HeartRateInfo.HR_EMPTY_VALUE) {
            case g /*?: ONE_ARG  (wrap: int
  0x000c: INVOKE  (r0_2 int) =  android.view.ViewConfiguration.getDoubleTapTimeout():int type: STATIC)*/:
                if (this.m != null) {
                    hasMessages = this.k.hasMessages(j);
                    if (hasMessages) {
                        this.k.removeMessages(j);
                    }
                    if (this.s == null || this.t == null || !hasMessages || !a(this.s, this.t, motionEvent)) {
                        this.k.sendEmptyMessageDelayed(j, (long) g);
                    } else {
                        this.u = true;
                        b = (this.m.onDoubleTap(this.s) | g) | this.m.onDoubleTapEvent(motionEvent);
                        this.v = f2;
                        this.x = f2;
                        this.w = f;
                        this.y = f;
                        if (this.s != null) {
                            this.s.recycle();
                        }
                        this.s = MotionEvent.obtain(motionEvent);
                        this.q = true;
                        this.r = true;
                        this.n = true;
                        this.p = false;
                        this.o = false;
                        if (this.z) {
                            this.k.removeMessages(i);
                            this.k.sendEmptyMessageAtTime(i, (this.s.getDownTime() + ((long) f)) + ((long) e));
                        }
                        this.k.sendEmptyMessageAtTime(h, this.s.getDownTime() + ((long) f));
                        return b | this.l.onDown(motionEvent);
                    }
                }
                b = g;
                this.v = f2;
                this.x = f2;
                this.w = f;
                this.y = f;
                if (this.s != null) {
                    this.s.recycle();
                }
                this.s = MotionEvent.obtain(motionEvent);
                this.q = true;
                this.r = true;
                this.n = true;
                this.p = false;
                this.o = false;
                if (this.z) {
                    this.k.removeMessages(i);
                    this.k.sendEmptyMessageAtTime(i, (this.s.getDownTime() + ((long) f)) + ((long) e));
                }
                this.k.sendEmptyMessageAtTime(h, this.s.getDownTime() + ((long) f));
                return b | this.l.onDown(motionEvent);
            case h /*1*/:
                this.n = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.u) {
                    hasMessages = this.m.onDoubleTapEvent(motionEvent) | g;
                } else if (this.p) {
                    this.k.removeMessages(j);
                    this.p = false;
                    hasMessages = g;
                } else if (this.q) {
                    hasMessages = this.l.onSingleTapUp(motionEvent);
                    if (this.o && this.m != null) {
                        this.m.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.A;
                    int b3 = Y.b(motionEvent, g);
                    velocityTracker.computeCurrentVelocity(h.E, (float) this.d);
                    b2 = C0146au.b(velocityTracker, b3);
                    a = C0146au.a(velocityTracker, b3);
                    hasMessages = (Math.abs(b2) > ((float) this.c) || Math.abs(a) > ((float) this.c)) ? this.l.onFling(this.s, motionEvent, a, b2) : g;
                }
                if (this.t != null) {
                    this.t.recycle();
                }
                this.t = obtain;
                if (this.A != null) {
                    this.A.recycle();
                    this.A = null;
                }
                this.u = false;
                this.o = false;
                this.k.removeMessages(h);
                this.k.removeMessages(i);
                return hasMessages;
            case i /*2*/:
                if (this.p) {
                    return false;
                }
                a = this.v - f2;
                b2 = this.w - f;
                if (this.u) {
                    return false | this.m.onDoubleTapEvent(motionEvent);
                }
                if (this.q) {
                    i = (int) (f2 - this.x);
                    int i2 = (int) (f - this.y);
                    i = (i * i) + (i2 * i2);
                    if (i > this.a) {
                        hasMessages = this.l.onScroll(this.s, motionEvent, a, b2);
                        this.v = f2;
                        this.w = f;
                        this.q = false;
                        this.k.removeMessages(j);
                        this.k.removeMessages(h);
                        this.k.removeMessages(i);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.a) {
                        this.r = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b2) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.l.onScroll(this.s, motionEvent, a, b2);
                    this.v = f2;
                    this.w = f;
                    return onScroll;
                }
            case j /*3*/:
                b();
                return false;
            case a.X /*5*/:
                this.v = f2;
                this.x = f2;
                this.w = f;
                this.y = f;
                c();
                return false;
            case a.bt /*6*/:
                this.v = f2;
                this.x = f2;
                this.w = f;
                this.y = f;
                this.A.computeCurrentVelocity(h.E, (float) this.d);
                int b4 = Y.b(motionEvent);
                b = Y.b(motionEvent, b4);
                f2 = C0146au.a(this.A, b);
                float b5 = C0146au.b(this.A, b);
                for (b = g; b < c; b += h) {
                    if (b != b4) {
                        int b6 = Y.b(motionEvent, b);
                        if ((C0146au.b(this.A, b6) * b5) + (C0146au.a(this.A, b6) * f2) < 0.0f) {
                            this.A.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
