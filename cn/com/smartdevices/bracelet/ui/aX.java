package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.r;

class aX implements AnimatorUpdateListener {
    final /* synthetic */ FwUpgradeActivity a;

    aX(FwUpgradeActivity fwUpgradeActivity) {
        this.a = fwUpgradeActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        C0596r.e("FwUpgradeActivity", "fw upgrade progress:" + this.a.y + ", " + ((this.a.y * 100) / this.a.z) + "%");
        this.a.q.setText(this.a.getString(r.fw_upgrade_progress, new Object[]{Integer.valueOf(r0)}));
        if (this.a.m == 2) {
            this.a.t.a((float) this.a.y);
        } else {
            this.a.r.b(this.a.y);
        }
    }
}
