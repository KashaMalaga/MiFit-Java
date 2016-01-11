package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.com.smartdevices.bracelet.chart.b.d;
import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.c;
import cn.com.smartdevices.bracelet.chart.base.l;
import cn.com.smartdevices.bracelet.chart.base.o;
import cn.com.smartdevices.bracelet.chart.base.p;
import cn.com.smartdevices.bracelet.chart.base.r;
import com.amap.api.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kankan.wheel.widget.a;

public class DynamicDetailChartView extends BaseChartView<C0411a> {
    private static final String a = "Chart.DynamicDetailChartView";
    private int A;
    private C0421k B;
    private o C;
    private r b;
    private r c;
    private r d;
    private r q;
    private r r;
    private r s;
    private r t;
    private r u;
    private r v;
    private r w;
    private l x;
    private int y;
    private ArrayList<Integer> z;

    public DynamicDetailChartView(Context context) {
        this(context, null);
    }

    public DynamicDetailChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicDetailChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.C = new C0419i(this);
        this.b = new p(1308622847);
        this.c = new p(-2130706433);
        this.d = new p(-1711303168);
        this.q = new p(452984831);
        this.r = new p(-855638017);
        this.s = new p(-855638017);
        this.t = new p(-27136);
        this.u = new p(872415231);
        this.v = new p(1308622847);
        this.w = new p(-855638017);
        this.e = new C0411a(context);
        ((C0411a) this.e).a((BaseChartView) this);
        this.m = new AccelerateDecelerateInterpolator();
        this.x = new l(getContext(), this.C);
        this.z = new ArrayList();
    }

    private void a(C0420j c0420j) {
        if (this.A == 16) {
            a(c0420j.c);
        }
        if (this.A == 1) {
            b(c0420j.d);
        }
    }

    public e a(int i, int... iArr) {
        int intValue;
        this.y = i;
        e b = this.f.b(i);
        if (b == null && this.f.c(i)) {
            this.z.add(Integer.valueOf(i));
        }
        if (iArr != null) {
            for (int i2 : iArr) {
                if (this.f.b(i2) == null && this.f.c(i2)) {
                    this.z.add(Integer.valueOf(i2));
                }
            }
        }
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            intValue = ((Integer) it.next()).intValue();
            this.f.a(intValue, new C0420j());
            this.f.a(intValue);
        }
        return b;
    }

    public void a(int i) {
        this.A = i;
        ((C0411a) this.e).a(this.A);
    }

    public void a(int i, int i2) {
        ((C0411a) this.e).a(i, i2);
    }

    public void a(d dVar) {
        this.f = dVar;
        this.B = (C0421k) dVar.d();
        this.f.a(new C0417g(this));
        ((C0411a) this.e).a(new C0418h(this));
    }

    public void a(List<C0422l> list) {
        Collection arrayList = new ArrayList();
        for (C0422l c0422l : list) {
            C0414d c0414d = new C0414d(getContext());
            c0414d.c = c0422l.f;
            c0414d.d = c0422l.g;
            c0414d.b = c0422l.e;
            switch (c0422l.e) {
                case kankan.wheel.widget.l.a /*1*/:
                    c0414d.a(this.d);
                    break;
                case a.k /*2*/:
                    c0414d.a(this.c);
                    break;
                case a.l /*3*/:
                    c0414d.a(this.b);
                    break;
                case a.aQ /*4*/:
                    c0414d.a(this.q);
                    break;
                default:
                    break;
            }
            arrayList.add(c0414d);
        }
        List arrayList2 = new ArrayList();
        arrayList2.addAll(((C0411a) this.e).c().u());
        arrayList2.addAll(arrayList);
        ((C0411a) this.e).c(arrayList2);
    }

    public void a(boolean z) {
        super.a(z);
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        if (this.A == 16) {
            boolean z2 = false;
            for (c cVar : ((C0411a) this.e).c().u()) {
                switch (cVar.b) {
                    case kankan.wheel.widget.l.a /*1*/:
                        cVar.a(this.d);
                        break;
                    case a.k /*2*/:
                        cVar.a(this.c);
                        break;
                    case a.l /*3*/:
                        cVar.a(this.b);
                        break;
                    case a.aQ /*4*/:
                        cVar.a(this.q);
                        break;
                }
                RectF m = cVar.m();
                if (f >= m.left && f <= m.right) {
                    switch (cVar.b) {
                        case kankan.wheel.widget.l.a /*1*/:
                            cVar.a(this.t);
                            break;
                        case a.k /*2*/:
                            cVar.a(this.s);
                            break;
                        case a.l /*3*/:
                            cVar.a(this.r);
                            break;
                        case a.aQ /*4*/:
                            cVar.a(this.u);
                            break;
                    }
                    this.B.a(cVar.c, cVar, cVar.c + ((int) (((f - m.left) / m.width()) * ((float) cVar.d))), f, f2);
                    z2 = true;
                }
            }
            c();
            return z2;
        } else if (this.A != 1) {
            return false;
        } else {
            for (c cVar2 : ((C0411a) this.e).d().u()) {
                cVar2.a(this.v);
                RectF m2 = cVar2.m();
                if (f >= m2.left && f <= m2.right) {
                    cVar2.a(this.w);
                    this.B.a(cVar2.c, cVar2, cVar2.c * 60, f, f2);
                    z = true;
                }
            }
            c();
            return z;
        }
    }

    public e b(int i) {
        return a(i, null);
    }

    public void b() {
        this.z.clear();
        this.f.c();
        ((C0411a) this.e).a();
        ((C0411a) this.e).b();
        ((C0411a) this.e).e();
    }

    public void b(List<n> list) {
        List arrayList = new ArrayList();
        for (n nVar : list) {
            C0414d c0414d = new C0414d(getContext());
            c0414d.b = nVar.b;
            c0414d.c = nVar.a;
            c0414d.d = 1;
            c0414d.a(this.v);
            arrayList.add(c0414d);
        }
        ((C0411a) this.e).a(arrayList);
    }

    public void b_() {
        ((C0411a) this.e).e();
    }

    public void c() {
        if (!a().isStarted()) {
            super.c();
        }
    }

    public void c(int i) {
        ((C0411a) this.e).b(i);
    }

    public void d(int i) {
        for (c cVar : ((C0411a) this.e).d().u()) {
            if (cVar.c == i) {
                cVar.a(this.w);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.g) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
            case a.k /*2*/:
                if (a(x, y)) {
                    return true;
                }
                this.B.a(x, y);
                return true;
            case kankan.wheel.widget.l.a /*1*/:
            case a.l /*3*/:
                a((float) GroundOverlayOptions.NO_DIMENSION, (float) GroundOverlayOptions.NO_DIMENSION);
                this.B.a(x, y);
                return true;
            default:
                return true;
        }
    }
}
