package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.b.f;

class I implements f {
    final /* synthetic */ StatisticChartView a;

    I(StatisticChartView statisticChartView) {
        this.a = statisticChartView;
    }

    public void a(e eVar) {
        if (eVar != null) {
            if (!this.a.h(eVar.g)) {
                this.a.a((L) eVar);
            }
            this.a.y.remove(Integer.valueOf(eVar.g));
            if (this.a.y.isEmpty()) {
                if (this.a.A) {
                    c(this.a.x);
                }
                ((A) this.a.e).e();
                this.a.z.a(eVar);
            }
        }
    }

    public boolean a(int i) {
        return this.a.z.a(i);
    }

    public e b(int i) {
        e b = this.a.f.b(i);
        return b == null ? this.a.z.b(i) : b;
    }

    public void c(int i) {
        this.a.z.c(i);
    }
}
