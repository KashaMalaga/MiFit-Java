package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.edmodo.cropper.cropwindow.CropOverlayView;

class C0837k implements AnimatorUpdateListener {
    final /* synthetic */ DynamicView a;

    C0837k(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.d.setAlpha(floatValue / CropOverlayView.a);
        ((View) this.a.J).setAlpha(floatValue / CropOverlayView.a);
    }
}
