package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import cn.com.smartdevices.bracelet.ui.fn;
import com.huami.android.view.c;

class l implements Runnable {
    final /* synthetic */ LoginActivity a;

    l(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @SuppressLint({"NewApi"})
    public void run() {
        this.a.u.setEnabled(true);
        this.a.n.setEnabled(true);
        this.a.o.setEnabled(true);
        this.a.s = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.a.s.setDuration(450);
        this.a.s.addUpdateListener(new m(this));
        this.a.s.start();
        if (this.a.b() && !this.a.p.isDestroyed()) {
            c.showPanel(this.a.p, fn.class);
        }
    }
}
