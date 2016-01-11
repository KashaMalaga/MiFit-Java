package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.amap.api.maps.model.BitmapDescriptorFactory;

class C0842p implements AnimatorListener {
    final /* synthetic */ DynamicView a;

    C0842p(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.f();
        this.a.d();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.b.setRotationY(-90.0f);
        this.a.b.setTranslationY(BitmapDescriptorFactory.HUE_MAGENTA);
        this.a.b.setAlpha(0.0f);
    }
}
