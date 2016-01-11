package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.relation.db.a;
import com.xiaomi.hm.health.r;

class C0609l implements f {
    final /* synthetic */ C0608k a;

    C0609l(C0608k c0608k) {
        this.a = c0608k;
    }

    public void a(e eVar) {
        if (this.a.d) {
            this.a.d = false;
            Animator a = this.a.f.a.a();
            if (!a.isStarted()) {
                this.a.f.a.c();
                a.addListener(new C0610m(this, a));
                a.setDuration(300);
                a.setStartDelay(150);
                a.start();
            }
        }
    }

    public boolean a(int i) {
        return i >= 0 && i < this.a.g.size();
    }

    public /* synthetic */ e b(int i) {
        return d(i);
    }

    public void c(int i) {
        C0401a.a(this.a.f, C0409b.aO);
        if (this.a.h != null && i >= 0 && i < this.a.h.size()) {
            a aVar = (a) this.a.h.get(i);
            this.a.f.u.setText(this.a.f.a(aVar.o, (int) r.label_activity_record));
            this.a.f.v.setText(aVar.l + com.xiaomi.e.a.f);
            this.a.f.w.setText(ChartData.a(this.a.f, aVar.p)[0]);
            this.a.f.M.setText(this.a.f.getString(r.label_mileage_dynamic, new Object[]{r1[1]}));
            this.a.f.x.setText(ChartData.a((long) aVar.q));
        }
    }

    public L d(int i) {
        return (L) this.a.g.get(i);
    }
}
