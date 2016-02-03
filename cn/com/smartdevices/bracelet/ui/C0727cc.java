package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.Utils;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.xiaomi.hm.health.R;

class C0727cc implements AnimatorListener {
    final /* synthetic */ MainUIActivity a;

    C0727cc(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.ab.setScaleX(1.0f);
        this.a.ab.setScaleY(1.0f);
        this.a.ac.setScaleX(1.0f);
        this.a.ac.setScaleY(1.0f);
        this.a.ab.setAlpha(1.0f);
        this.a.ac.setAlpha(1.0f);
        this.a.Z.setRotation(BitmapDescriptorFactory.HUE_CYAN);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.Y.setScaleX(1.0f);
        this.a.Y.setScaleY(1.0f);
        this.a.Y.setAlpha(1.0f);
        this.a.ab.setScaleX(0.5f);
        this.a.ab.setScaleY(0.5f);
        this.a.ac.setScaleX(0.5f);
        this.a.ac.setScaleY(0.5f);
        this.a.ab.setAlpha(0.5f);
        this.a.ac.setAlpha(0.5f);
        this.a.Z.setRotation(0.0f);
        this.a.ab.setText(R.string.dynamic_pull_release_to_sync);
        this.a.ac.setText(Utils.a(this.a, (int) R.string.dynamic_pull_last_sync_time));
    }
}
