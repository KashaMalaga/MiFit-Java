package cn.com.smartdevices.bracelet.chart;

import android.content.Context;
import android.util.AttributeSet;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.base.BaseChartView;
import cn.com.smartdevices.bracelet.chart.base.p;
import cn.com.smartdevices.bracelet.chart.base.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicShareChartView extends BaseChartView<t> {
    private static final String a = "Chart.DynamicShareChartView";
    private r b;

    public DynamicShareChartView(Context context) {
        this(context, null);
    }

    public DynamicShareChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicShareChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new t(context);
        this.b = new p(1090519039);
    }

    private void a(List<n> list) {
        List arrayList = new ArrayList();
        for (n nVar : list) {
            v vVar = new v(getContext());
            vVar.b = nVar.b;
            vVar.c = nVar.a;
            vVar.a(this.b);
            arrayList.add(vVar);
        }
        ((t) this.e).f(arrayList);
        ((t) this.e).e();
    }

    public void a(HashMap<Integer, Integer> hashMap) {
        List arrayList = new ArrayList();
        int a = ((t) this.e).a();
        int i = 0;
        for (Integer num : hashMap.keySet()) {
            i = num.intValue() > i ? num.intValue() : i;
        }
        C0596r.e(a, "Max Index : " + i);
        if (i > a) {
            int i2 = i - a;
            i = i2 % 2 != 0 ? i2 + 2 : i2 + 1;
        } else {
            i = 1;
        }
        C0596r.e(a, "Index Offset: " + i);
        ((t) this.e).a(i);
        for (int i3 = i; i3 < i + a; i3++) {
            n nVar = new n();
            nVar.a = i3;
            if (hashMap.get(Integer.valueOf(i3)) != null) {
                nVar.b = ((Integer) hashMap.get(Integer.valueOf(i3))).intValue();
            }
            arrayList.add(nVar);
        }
        a(arrayList);
    }
}
