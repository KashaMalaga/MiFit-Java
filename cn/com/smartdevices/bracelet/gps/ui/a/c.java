package cn.com.smartdevices.bracelet.gps.ui.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.edmodo.cropper.cropwindow.CropOverlayView;

class c implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float intValue = ((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / CropOverlayView.a;
        this.a.a.setAlpha(intValue);
        this.a.a.setScaleX(intValue);
        this.a.a.setScaleY(intValue);
    }
}
