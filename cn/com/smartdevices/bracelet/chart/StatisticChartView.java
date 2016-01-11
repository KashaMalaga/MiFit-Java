package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.chart.b.d;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.base.l;
import cn.com.smartdevices.bracelet.chart.base.o;
import cn.com.smartdevices.bracelet.chart.base.p;
import cn.com.smartdevices.bracelet.chart.base.r;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kankan.wheel.widget.a;

public class StatisticChartView extends BaseChartView<A> {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final String q = "Chart.StatisticChartView";
    private boolean A;
    private float B;
    private float C;
    private float D;
    private float E;
    private int F;
    private int G;
    private boolean H;
    private o I;
    private r r;
    private r s;
    private List<E> t;
    private List<E> u;
    private List<H> v;
    private List<B> w;
    private int x;
    private ArrayList<Integer> y;
    private f z;

    public StatisticChartView(Context context) {
        this(context, null);
    }

    public StatisticChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a);
    }

    public StatisticChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = false;
        this.I = new K(this);
        this.r = new p(a);
        this.s = new p(a);
        this.e = new A(context);
        this.m = new AccelerateDecelerateInterpolator();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.h = new l(getContext(), this.I);
        this.y = new ArrayList();
    }

    private void a(L l) {
        if (this.F == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            H h = new H(getContext());
            h.b = (int) (l.e * 10.0f);
            h.c = l.g;
            h.a(this.r);
            h.a(this.e);
            this.v.add(h);
        } else {
            E e = new E(getContext());
            e.b = l.a;
            e.a = l.b;
            e.c = l.g;
            e.a(this.r);
            e.a(this.e);
            this.t.add(e);
            e = new E(getContext());
            e.b = l.c;
            e.a = l.d;
            e.c = l.g;
            e.a(this.s);
            e.a(this.e);
            this.u.add(e);
        }
        B b = new B();
        b.a = l.g;
        b.b = l.f;
        this.w.add(b);
        n();
    }

    static /* synthetic */ int b(StatisticChartView statisticChartView, int i) {
        int i2 = statisticChartView.j + i;
        statisticChartView.j = i2;
        return i2;
    }

    private boolean h(int i) {
        List list = null;
        switch (this.F) {
            case b /*1*/:
                list = this.t;
                break;
            case a.bp /*16*/:
                list = this.u;
                break;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                list = this.v;
                break;
        }
        for (c cVar : r0) {
            if (cVar.c == i) {
                return true;
            }
        }
        return false;
    }

    private void n() {
        if (this.F == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            Collections.sort(this.v);
            ((A) this.e).d(this.v);
        } else {
            ((A) this.e).b(this.t);
            ((A) this.e).c(this.u);
        }
        ((A) this.e).e(this.w);
    }

    public Animator a() {
        this.B = GroundOverlayOptions.NO_DIMENSION;
        this.C = GroundOverlayOptions.NO_DIMENSION;
        this.D = GroundOverlayOptions.NO_DIMENSION;
        this.E = GroundOverlayOptions.NO_DIMENSION;
        return super.a();
    }

    public Animator a(float f, float f2) {
        this.B = GroundOverlayOptions.NO_DIMENSION;
        this.C = f;
        this.D = GroundOverlayOptions.NO_DIMENSION;
        this.E = f2;
        return super.a();
    }

    public Animator a(long j, float f, float f2) {
        this.B = f;
        this.C = GroundOverlayOptions.NO_DIMENSION;
        this.D = f2;
        this.E = GroundOverlayOptions.NO_DIMENSION;
        return super.d(j);
    }

    public c a(int i, int i2) {
        List list;
        switch (this.F) {
            case b /*1*/:
                list = this.t;
                break;
            case a.bp /*16*/:
                list = this.u;
                break;
            case PersonInfo.INCOMING_CALL_DISABLE_BIT /*256*/:
                list = this.v;
                break;
            default:
                list = null;
                break;
        }
        for (c cVar : r0) {
            if (cVar.c == i2) {
                return cVar;
            }
        }
        return null;
    }

    public void a(float f) {
        ((A) this.e).c((int) (10.0f * f));
    }

    public void a(int i) {
        this.F = i;
        ((A) this.e).e(i);
    }

    public void a(d dVar) {
        this.z = dVar.d();
        this.f = dVar;
        this.f.a(new I(this));
        ((A) this.e).a(new J(this));
    }

    public Animator b(long j, float f, float f2) {
        this.B = GroundOverlayOptions.NO_DIMENSION;
        this.C = f;
        this.D = GroundOverlayOptions.NO_DIMENSION;
        this.E = f2;
        return super.d(j);
    }

    public void b() {
        this.B = GroundOverlayOptions.NO_DIMENSION;
        this.C = GroundOverlayOptions.NO_DIMENSION;
        this.D = GroundOverlayOptions.NO_DIMENSION;
        this.E = GroundOverlayOptions.NO_DIMENSION;
    }

    public void b(float f) {
        ((A) this.e).d((int) (10.0f * f));
    }

    public void b(int i) {
        this.G = i;
        ((A) this.e).f(i);
    }

    public void b(boolean z) {
        this.H = z;
    }

    public void c() {
        this.B = GroundOverlayOptions.NO_DIMENSION;
        this.C = GroundOverlayOptions.NO_DIMENSION;
        this.D = GroundOverlayOptions.NO_DIMENSION;
        this.E = GroundOverlayOptions.NO_DIMENSION;
        super.c();
    }

    public void c(int i) {
        ((A) this.e).g(i);
    }

    public float d() {
        return ((A) this.e).b();
    }

    public void d(int i) {
        this.x = i;
        this.A = true;
        int a = ((((A) this.e).a() + b) / c) - 1;
        int i2 = -1;
        int a2 = ((A) this.e).a();
        if (this.F == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            i2 = -3;
            a2 += c;
        }
        while (i2 <= a2) {
            int i3 = (i - i2) + a;
            if (!this.y.contains(Integer.valueOf(i3)) && this.z.a(i3)) {
                this.y.add(Integer.valueOf(i3));
            }
            i2 += b;
        }
        if (this.y.size() > 0) {
            Iterator it = this.y.iterator();
            while (it.hasNext()) {
                this.f.a(((Integer) it.next()).intValue());
            }
        }
    }

    public void e() {
        this.u.clear();
        this.t.clear();
        this.v.clear();
        this.w.clear();
        n();
        this.y.clear();
        ((A) this.e).f();
        ((A) this.e).e();
    }

    public void e(int i) {
        ((A) this.e).a(i);
    }

    public void f() {
        int b = (int) ((A) this.e).b();
        if (this.G == b) {
            b = -b;
        }
        this.h.a(b);
    }

    public void f(int i) {
        ((A) this.e).h(-i);
    }

    public void g() {
        int i = -((int) ((A) this.e).b());
        if (this.G == b) {
            i = -i;
        }
        this.h.a(i);
    }

    public void g(int i) {
        int i2 = -((int) (((A) this.e).b() * ((float) i)));
        if (this.G == b) {
            i2 = -i2;
        }
        this.h.a(i2);
    }

    protected void onDraw(Canvas canvas) {
        ((A) this.e).a(canvas, this.o, this.B, this.C, this.D, this.E, this.l);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return false;
        }
        if (!(getParent() == null || this.H)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        switch (motionEvent.getAction()) {
            case b /*1*/:
                if (!this.i) {
                    this.h.a(((A) this.e).b(motionEvent.getX()));
                    break;
                }
                break;
        }
        return this.h.a(motionEvent);
    }
}
