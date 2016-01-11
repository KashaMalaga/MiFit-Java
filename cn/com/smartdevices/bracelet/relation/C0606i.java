package cn.com.smartdevices.bracelet.relation;

import android.animation.Animator;
import android.text.format.DateFormat;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0409b;
import cn.com.smartdevices.bracelet.chart.L;
import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.relation.db.a;
import com.xiaomi.hm.health.r;

class C0606i implements f {
    final /* synthetic */ C0605h a;

    C0606i(C0605h c0605h) {
        this.a = c0605h;
    }

    public void a(e eVar) {
        if (this.a.d) {
            this.a.d = false;
            Animator a = this.a.f.b.a();
            if (!a.isStarted()) {
                this.a.f.b.c();
                a.addListener(new C0607j(this, a));
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
        C0401a.a(this.a.f, C0409b.aP);
        if (this.a.h != null && i >= 0 && i < this.a.h.size()) {
            a aVar = (a) this.a.h.get(i);
            int i2 = aVar.n + aVar.m;
            this.a.f.y.setText(this.a.f.a(aVar.o, (int) r.label_sleep_record));
            this.a.f.B.setText(DateFormat.format("HH:mm", aVar.r * 1000));
            this.a.f.z.setText(DateFormat.format("HH:mm", aVar.s * 1000));
            this.a.f.A.setText(DetailActivity.a(i2));
        }
    }

    public L d(int i) {
        return (L) this.a.g.get(i);
    }
}
