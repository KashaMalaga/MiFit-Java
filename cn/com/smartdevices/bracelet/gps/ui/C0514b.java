package cn.com.smartdevices.bracelet.gps.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.edmodo.cropper.cropwindow.CropOverlayView;

class C0514b implements AnimatorUpdateListener {
    final /* synthetic */ GPSMainActivity a;

    C0514b(GPSMainActivity gPSMainActivity) {
        this.a = gPSMainActivity;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.t.a().a((float) this.a.D.x, 0.0f, (float) (((double) (((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / CropOverlayView.a)) * this.a.I));
    }
}
