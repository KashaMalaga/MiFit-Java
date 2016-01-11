package cn.com.smartdevices.bracelet.ui;

import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.E;
import cn.com.smartdevices.bracelet.chart.b.e;
import cn.com.smartdevices.bracelet.chart.b.f;
import cn.com.smartdevices.bracelet.chart.util.a;

class eR implements f {
    final /* synthetic */ StatisticFragment a;

    eR(StatisticFragment statisticFragment) {
        this.a = statisticFragment;
    }

    public void a(e eVar) {
        if (this.a.b == null || !this.a.b.j()) {
            C0596r.g("Statistic.Main", "Chart Already Detached From UI : onDataLoaded , " + this.a.b);
        } else if (this.a.ax) {
            a.a((ViewGroup) this.a.aq, (ViewGroup) this.a.ap);
            if ((this.a.aC & 2) == 0) {
                this.a.h();
            }
            if (this.a.ay) {
                this.a.av = this.a.a(this.a.b, this.a.ag, (int) this.a.ag.d(), this.a.ag.getWidth(), this.a.L, this.a.M, 450);
            } else {
                this.a.N = this.a.b.a(this.a.r, this.a.K);
                if (this.a.N != null) {
                    this.a.L = (int) this.a.N.m().height();
                    int i = this.a.N.b;
                    this.a.M = (int) ((((float) ((E) this.a.N).a) / ((float) i)) * ((float) this.a.L));
                } else {
                    this.a.L = 0;
                    this.a.M = 0;
                }
                C0596r.e("Statistic.Main", "BarItem Height : " + this.a.L);
                this.a.av = this.a.b(this.a.b, this.a.ag, this.a.b.getWidth(), (int) this.a.b.d(), this.a.L, this.a.M, 450);
            }
            this.a.av.start();
        } else if (this.a.S) {
            this.a.S = false;
            if ((this.a.aC & 2) == 0) {
                this.a.h();
            }
            if (this.a.aw == null) {
                this.a.aw = this.a.b.a();
            }
            if (!this.a.aw.isStarted()) {
                this.a.b.b();
                this.a.aw.addListener(new eS(this));
                this.a.aw.setDuration(300);
                if (this.a.T) {
                    this.a.aw.setStartDelay(150);
                    this.a.T = false;
                }
                if (this.a.H) {
                    this.a.aw.setInterpolator(new DecelerateInterpolator());
                }
                this.a.aw.start();
            }
        }
    }

    public boolean a(int i) {
        return this.a.O.b(i);
    }

    public e b(int i) {
        return this.a.O.a(i);
    }

    public void c(int i) {
        if (this.a.b == null || !this.a.b.j()) {
            C0596r.g("Statistic.Main", "Chart Already Detached From UI : onToItem , " + this.a.b);
        } else {
            this.a.O.c(i);
        }
    }
}
