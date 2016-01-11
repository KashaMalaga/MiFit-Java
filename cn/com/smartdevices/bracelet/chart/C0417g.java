package cn.com.smartdevices.bracelet.chart;

import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.b.f;

class C0417g implements f {
    final /* synthetic */ DynamicDetailChartView a;

    C0417g(DynamicDetailChartView dynamicDetailChartView) {
        this.a = dynamicDetailChartView;
    }

    public void a(e eVar) {
        if (eVar != null) {
            C0420j c0420j = (C0420j) eVar;
            this.a.z.remove(Integer.valueOf(eVar.g));
            if (this.a.z.isEmpty()) {
                c(this.a.y);
                this.a.a(c0420j);
                this.a.b_();
                this.a.B.a(eVar);
            }
        }
    }

    public boolean a(int i) {
        return this.a.B.a(i);
    }

    public e b(int i) {
        return this.a.B.b(i);
    }

    public void c(int i) {
        this.a.B.c(i);
    }
}
