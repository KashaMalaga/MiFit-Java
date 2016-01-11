package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;
import cn.com.smartdevices.bracelet.model.PersonInfo;

class eL implements AnimatorListener {
    final /* synthetic */ StatisticChartView a;
    final /* synthetic */ StatisticChartView b;
    final /* synthetic */ StatisticFragment c;

    eL(StatisticFragment statisticFragment, StatisticChartView statisticChartView, StatisticChartView statisticChartView2) {
        this.c = statisticFragment;
        this.a = statisticChartView;
        this.b = statisticChartView2;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        C0596r.e("Statistic.Main", "OUT VIEW : " + this.b);
        this.b.setVisibility(4);
        this.b.setAlpha(1.0f);
        this.b.setScaleX(1.0f);
        if (this.c.s != 1) {
            this.c.ak.setEnabled(true);
        }
        if (this.c.s != PersonInfo.INCOMING_CALL_DISABLE_BIT) {
            this.c.al.setEnabled(true);
        }
        this.c.ae.d(true);
        this.c.af.d(true);
        this.c.ax = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        C0596r.e("Statistic.Main", "IN VIEW : " + this.a);
        this.a.setVisibility(0);
        if (this.c.N != null) {
            this.c.N.e = false;
        }
        this.b.c();
    }
}
