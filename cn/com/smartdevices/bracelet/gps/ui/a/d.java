package cn.com.smartdevices.bracelet.gps.ui.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.edmodo.cropper.cropwindow.CropOverlayView;

class d implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.a.setAlpha(((float) (100 - intValue)) / CropOverlayView.a);
        float f = (float) (((double) (((float) (100 - intValue)) / 200.0f)) + 0.5d);
        this.a.a.setScaleX(f);
        this.a.a.setScaleY(f);
    }
}
