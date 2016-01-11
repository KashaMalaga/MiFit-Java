package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.a.C0113o;
import android.support.v4.view.a.Y;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import com.d.a.a.C1012a;

class C0180bx extends C0125a {
    final /* synthetic */ ViewPager b;

    C0180bx(ViewPager viewPager) {
        this.b = viewPager;
    }

    private boolean b() {
        return this.b.s != null && this.b.s.b() > 1;
    }

    public void a(View view, C0113o c0113o) {
        super.a(view, c0113o);
        c0113o.b(ViewPager.class.getName());
        c0113o.l(b());
        if (this.b.canScrollHorizontally(1)) {
            c0113o.d((int) ChartData.d);
        }
        if (this.b.canScrollHorizontally(-1)) {
            c0113o.d((int) C1012a.e);
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        switch (i) {
            case ChartData.d /*4096*/:
                if (!this.b.canScrollHorizontally(1)) {
                    return false;
                }
                this.b.a(this.b.t + 1);
                return true;
            case C1012a.e /*8192*/:
                if (!this.b.canScrollHorizontally(-1)) {
                    return false;
                }
                this.b.a(this.b.t - 1);
                return true;
            default:
                return false;
        }
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        accessibilityEvent.setClassName(ViewPager.class.getName());
        Y b = Y.b();
        b.e(b());
        if (accessibilityEvent.getEventType() == ChartData.d && this.b.s != null) {
            b.a(this.b.s.b());
            b.c(this.b.t);
            b.d(this.b.t);
        }
    }
}
