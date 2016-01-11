package cn.com.smartdevices.bracelet.chart;

import android.annotation.SuppressLint;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.o;

class C0419i implements o {
    final /* synthetic */ DynamicDetailChartView a;

    C0419i(DynamicDetailChartView dynamicDetailChartView) {
        this.a = dynamicDetailChartView;
    }

    public void a() {
        C0596r.e("Chart.DynamicDetailChartView", "Scroll OnStart!!");
    }

    public boolean a(int i) {
        return false;
    }

    public void b() {
        C0596r.e("Chart.DynamicDetailChartView", "Scroll OnJustify!!");
    }

    @SuppressLint({"NewApi"})
    public boolean b(int i) {
        int s = (int) ((C0411a) this.a.e).s();
        int h = (int) ((C0411a) this.a.e).h();
        C0596r.e("Chart.DynamicDetailChartView", "Scrolled : " + s + " Edge : " + h + " Distance : " + i);
        if ((s == 0 && i > 0) || (s == h && i < 0)) {
            return false;
        }
        ((C0411a) this.a.e).d((float) i);
        this.a.postInvalidateOnAnimation();
        return true;
    }

    public void c() {
        C0596r.e("Chart.DynamicDetailChartView", "Scroll OnFinish!!");
    }
}
