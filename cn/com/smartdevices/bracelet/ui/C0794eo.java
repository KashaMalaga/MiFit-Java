package cn.com.smartdevices.bracelet.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.xiaomi.hm.health.k;
import com.xiaomi.hm.health.r;

class C0794eo implements AnimationListener {
    final /* synthetic */ C0784ee a;

    C0794eo(C0784ee c0784ee) {
        this.a = c0784ee;
    }

    public void onAnimationEnd(Animation animation) {
        this.a.a(false);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.a.z.setVisibility(0);
        this.a.p.setVisibility(8);
        this.a.y.setVisibility(8);
        this.a.z.setImageResource(k.mili_vertical_icon);
        this.a.u.a(0);
        this.a.q.setText(r.finding_bracelet);
    }
}
