package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import kankan.wheel.widget.a;

class C0834h implements AnimatorUpdateListener {
    final /* synthetic */ DynamicView a;

    C0834h(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 600.0f;
        this.a.D.setRotationY(BitmapDescriptorFactory.HUE_CYAN * floatValue);
        this.a.b.setRotationY(-180.0f + (BitmapDescriptorFactory.HUE_CYAN * floatValue));
        this.a.b.setAlpha(floatValue);
        float f = 1.0f - (2.0f * floatValue);
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.a.D.setAlpha(f);
        this.a.b.setTranslationY((1.0f - floatValue) * a.bP);
        this.a.D.setTranslationY((1.0f - floatValue) * a.bP);
    }
}
