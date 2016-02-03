package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.Keeper;
import com.xiaomi.hm.health.R;

class C0698bY implements AnimatorListener {
    final /* synthetic */ MainUIActivity a;

    C0698bY(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.W.setBackgroundColor(0);
        this.a.Y.setX((float) this.a.am);
        this.a.Y.setY((float) this.a.an);
        this.a.Y.setVisibility(0);
        if (this.a.k != null) {
            this.a.k.b();
        }
        Keeper.keepIsPlayEnterAnimation(Boolean.valueOf(false));
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.X.setTranslationY(800.0f);
        this.a.W.setBackgroundResource(R.color.bg_mode_step);
        this.a.Y.setVisibility(8);
        this.a.af.notifyDataSetChanged();
    }
}
