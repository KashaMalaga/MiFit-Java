package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.edmodo.cropper.cropwindow.CropOverlayView;

class C0830d implements AnimatorUpdateListener {
    final /* synthetic */ DynamicView a;

    C0830d(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.b.setRotationY(-90.0f + ((90.0f * floatValue) / CropOverlayView.a));
        this.a.b.setTranslationY(BitmapDescriptorFactory.HUE_MAGENTA - ((BitmapDescriptorFactory.HUE_MAGENTA * floatValue) / CropOverlayView.a));
        if (floatValue < 50.0f) {
            this.a.b.setAlpha((floatValue * 0.5f) / CropOverlayView.a);
            return;
        }
        this.a.b.setAlpha(floatValue / CropOverlayView.a);
    }
}
