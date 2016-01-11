package cn.com.smartdevices.bracelet.weight;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.C0596r;

class T implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ Q b;

    T(Q q, int i) {
        this.b = q;
        this.a = i;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        C0596r.e("UserListActivity", "anim height " + intValue);
        this.b.i.setY((float) (this.a - intValue));
    }
}
