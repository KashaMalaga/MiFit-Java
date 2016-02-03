package cn.com.smartdevices.bracelet.relation;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.xiaomi.hm.health.R;

class Q implements Runnable {
    final /* synthetic */ MessageActivity a;

    Q(MessageActivity messageActivity) {
        this.a = messageActivity;
    }

    public void run() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.header_notify_out);
        if (loadAnimation != null) {
            loadAnimation.setAnimationListener(new C0597R(this));
            this.a.l.startAnimation(loadAnimation);
            return;
        }
        this.a.l.setVisibility(8);
    }
}
