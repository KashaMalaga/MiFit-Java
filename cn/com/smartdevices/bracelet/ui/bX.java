package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.amap.api.maps.model.BitmapDescriptorFactory;

class bX implements AnimatorUpdateListener {
    final /* synthetic */ float a;
    final /* synthetic */ MainUIActivity b;

    bX(MainUIActivity mainUIActivity, float f) {
        this.b = mainUIActivity;
        this.a = f;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue > BitmapDescriptorFactory.HUE_MAGENTA) {
            if (floatValue < 600.0f) {
                this.b.ae.setTranslationY((((floatValue - BitmapDescriptorFactory.HUE_MAGENTA) / BitmapDescriptorFactory.HUE_MAGENTA) * this.a) - this.a);
            } else if (floatValue >= 2600.0f) {
                this.b.ae.setTranslationY(((-(((floatValue - BitmapDescriptorFactory.HUE_MAGENTA) - BitmapDescriptorFactory.HUE_MAGENTA) - 2000.0f)) / BitmapDescriptorFactory.HUE_MAGENTA) * this.a);
            }
        }
    }
}
