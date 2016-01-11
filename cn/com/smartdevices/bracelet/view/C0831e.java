package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;

class C0831e implements AnimatorListener {
    final /* synthetic */ DynamicView a;

    C0831e(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.a.B.setAlpha(0.0f);
        this.a.C.setAlpha(0.0f);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.a.B.setVisibility(0);
        this.a.C.setVisibility(0);
        this.a.b.setRotationY(-90.0f);
        this.a.b.setTranslationY(BitmapDescriptorFactory.HUE_MAGENTA);
        this.a.b.setAlpha(0.0f);
        this.a.B.setAlpha(1.0f);
        this.a.B.setTranslationX(0.0f);
        this.a.B.setTranslationY(0.0f);
        this.a.B.setScaleX(1.0f);
        this.a.B.setScaleY(1.0f);
        this.a.C.setAlpha(1.0f);
        this.a.C.setTranslationX(0.0f);
        this.a.C.setTranslationY(0.0f);
        this.a.C.setScaleX(1.0f);
        this.a.C.setScaleY(1.0f);
        ((View) this.a.J).setAlpha(0.0f);
        this.a.g();
    }
}
