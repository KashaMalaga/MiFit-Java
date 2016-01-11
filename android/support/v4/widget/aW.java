package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

class aW implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout a;

    aW(SwipeRefreshLayout swipeRefreshLayout) {
        this.a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.a.v) {
            this.a.L.setAlpha(HeartRateInfo.HR_EMPTY_VALUE);
            this.a.L.start();
            if (this.a.S && this.a.u != null) {
                this.a.u.a();
            }
        } else {
            this.a.L.stop();
            this.a.I.setVisibility(8);
            this.a.d((int) HeartRateInfo.HR_EMPTY_VALUE);
            if (this.a.E) {
                this.a.a(0.0f);
            } else {
                this.a.a(this.a.d - this.a.z, true);
            }
        }
        this.a.z = this.a.I.getTop();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
