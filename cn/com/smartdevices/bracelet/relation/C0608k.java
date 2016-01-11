package cn.com.smartdevices.bracelet.relation;

import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.chart.b.a;
import cn.com.smartdevices.bracelet.chart.b.f;
import java.util.ArrayList;
import java.util.List;

class C0608k extends a {
    public boolean d = true;
    f e = new C0609l(this);
    final /* synthetic */ DetailActivity f;
    private List<L> g = new ArrayList();
    private List<cn.com.smartdevices.bracelet.relation.db.a> h = null;

    public C0608k(DetailActivity detailActivity) {
        this.f = detailActivity;
        a(this.e);
    }

    public void a(List<cn.com.smartdevices.bracelet.relation.db.a> list) {
        if (list != null) {
            this.g.clear();
            c();
            this.h = list;
            for (cn.com.smartdevices.bracelet.relation.db.a aVar : list) {
                L l = new L();
                l.f = this.f.a(aVar.o);
                l.a = aVar.l;
                this.g.add(l);
            }
        }
    }
}
