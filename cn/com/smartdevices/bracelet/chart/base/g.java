package cn.com.smartdevices.bracelet.chart.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.chart.util.t;
import java.util.ArrayList;
import java.util.List;

public abstract class g<T extends k> implements j, k {
    protected RectF j;
    protected float k;
    protected float l;
    protected float m;
    protected float n;
    protected r o;
    protected float p;
    protected float q;
    protected float r;
    protected List<T> s = new ArrayList();
    protected Context t;
    protected f u;
    protected g<? extends T> v;
    protected BaseChartView<? extends g<T>> w;

    public g(Context context) {
        this.p = t.a(context);
        this.q = t.b(context);
        this.t = context;
    }

    protected void a(float f) {
    }

    public void a(float f, float f2, float f3, float f4) {
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.n = f4;
        e();
    }

    public void a(Canvas canvas) {
        a(canvas, 1.0f);
    }

    public void a(Canvas canvas, float f) {
        a(canvas, this.j, f);
    }

    protected void a(Canvas canvas, float f, boolean z) {
        a(canvas, this.j, f, z);
    }

    protected abstract void a(Canvas canvas, RectF rectF, float f);

    protected void a(Canvas canvas, RectF rectF, float f, boolean z) {
        a(canvas, rectF, f);
    }

    public void a(Rect rect) {
        this.j = new RectF(rect);
        a(this.j);
        e();
    }

    protected void a(RectF rectF) {
    }

    public void a(f fVar) {
        this.u = fVar;
    }

    public void a(BaseChartView<? extends g<T>> baseChartView) {
        this.w = baseChartView;
    }

    public void a(g<? extends T> gVar) {
        this.v = gVar;
    }

    public void a(T t) {
        synchronized (this.s) {
            this.s.add(t);
            a_(this.s);
        }
    }

    public void a(r rVar) {
        this.o = rVar;
    }

    protected void a_(List<T> list) {
    }

    public void b(RectF rectF) {
        this.j = rectF;
        a(this.j);
        e();
    }

    public void d(float f) {
        this.r += f;
        a(f);
        e();
    }

    public void e() {
    }

    public void e(float f) {
        float f2 = f - this.r;
        this.r = f;
        a(f2);
        e();
    }

    public void f(List<? extends T> list) {
        synchronized (this.s) {
            this.s.clear();
            this.s.addAll(list);
            a_(this.s);
        }
    }

    public void g(List<? extends T> list) {
        synchronized (this.s) {
            this.s.addAll(list);
            a_(this.s);
        }
    }

    public void k() {
    }

    public Context l() {
        return this.t;
    }

    public RectF m() {
        return this.j;
    }

    public float n() {
        return this.k;
    }

    public float o() {
        return this.l;
    }

    public float p() {
        return this.m;
    }

    public float q() {
        return this.n;
    }

    public r r() {
        return this.o;
    }

    public float s() {
        return this.r;
    }

    public void t() {
        synchronized (this.s) {
            this.s.clear();
            a_(this.s);
        }
    }

    public List<T> u() {
        return this.s;
    }

    public g<? extends T> v() {
        return this.v;
    }

    public BaseChartView<? extends g<T>> w() {
        return this.w;
    }
}
