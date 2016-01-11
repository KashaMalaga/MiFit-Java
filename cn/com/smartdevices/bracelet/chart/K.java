package cn.com.smartdevices.bracelet.chart;

import android.annotation.SuppressLint;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.o;

class K implements o {
    final /* synthetic */ StatisticChartView a;

    K(StatisticChartView statisticChartView) {
        this.a = statisticChartView;
    }

    public void a() {
        C0596r.e("Chart.StatisticChartView", "Scroll OnStart!!");
        this.a.i = true;
    }

    @SuppressLint({"NewApi"})
    public boolean a(int i) {
        if (this.a.G == 1) {
            i = -i;
        }
        ((A) this.a.e).d((float) i);
        this.a.postInvalidateOnAnimation();
        StatisticChartView.b(this.a, i);
        return true;
    }

    public void b() {
        C0596r.e("Chart.StatisticChartView", "Scroll OnJustify!!");
        if (Math.abs(this.a.j) > 1) {
            int c = ((A) this.a.e).c();
            if (this.a.G == 1) {
                c = -c;
            }
            this.a.h.a(c);
        }
    }

    public boolean b(int i) {
        return true;
    }

    public void c() {
        C0596r.e("Chart.StatisticChartView", "Scroll OnFinish!!");
        this.a.f.d(((A) this.a.e).d());
        if (this.a.i) {
            this.a.i = false;
        }
        this.a.j = 0;
    }
}
