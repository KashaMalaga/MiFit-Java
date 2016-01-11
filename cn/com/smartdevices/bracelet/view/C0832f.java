package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.gps.c.d;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import kankan.wheel.widget.a;

class C0832f implements AnimatorUpdateListener {
    final /* synthetic */ DynamicView a;

    C0832f(DynamicView dynamicView) {
        this.a = dynamicView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.B.setTranslationX((a.bP * floatValue) / CropOverlayView.a);
        this.a.B.setTranslationY((-200.0f * floatValue) / CropOverlayView.a);
        this.a.B.setScaleX(1.0f - ((0.7f * floatValue) / CropOverlayView.a));
        this.a.B.setScaleY(1.0f - ((d.b * floatValue) / CropOverlayView.a));
        if (floatValue <= 50.0f) {
            this.a.B.setAlpha(1.0f - ((1.0f * floatValue) / 50.0f));
            this.a.C.setAlpha(1.0f - ((1.0f * floatValue) / 50.0f));
        }
        this.a.C.setTranslationX((450.0f * floatValue) / CropOverlayView.a);
        this.a.C.setTranslationY((floatValue * a.bP) / CropOverlayView.a);
    }
}
