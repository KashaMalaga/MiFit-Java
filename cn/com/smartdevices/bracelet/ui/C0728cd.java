package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.amap.api.maps.model.BitmapDescriptorFactory;

class C0728cd implements AnimatorUpdateListener {
    final /* synthetic */ MainUIActivity a;

    C0728cd(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = 0.5f + (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.5f);
        float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.ab.setScaleX(floatValue);
        this.a.ab.setScaleY(floatValue);
        this.a.ac.setScaleX(floatValue);
        this.a.ac.setScaleY(floatValue);
        this.a.ab.setAlpha(floatValue);
        this.a.ac.setAlpha(floatValue);
        this.a.Z.setRotation(360.0f - (floatValue2 * BitmapDescriptorFactory.HUE_CYAN));
    }
}
