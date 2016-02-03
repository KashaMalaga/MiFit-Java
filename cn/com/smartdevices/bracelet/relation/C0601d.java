package cn.com.smartdevices.bracelet.relation;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xiaomi.hm.health.R;

class C0601d implements Runnable {
    final /* synthetic */ DetailActivity a;

    C0601d(DetailActivity detailActivity) {
        this.a = detailActivity;
    }

    public void run() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.header_notify_out);
        if (loadAnimation != null) {
            loadAnimation.setAnimationListener(new C0602e(this));
            this.a.J.startAnimation(loadAnimation);
            return;
        }
        this.a.J.setVisibility(8);
    }
}
