package cn.com.smartdevices.bracelet.heartrate;

import android.view.View;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;

class r implements PanelSlideListener {
    final /* synthetic */ HeartRateMainActivity a;

    r(HeartRateMainActivity heartRateMainActivity) {
        this.a = heartRateMainActivity;
    }

    public int onGetPullDownDistance() {
        return 0;
    }

    public Boolean onGetPullDownDockEnable() {
        return Boolean.valueOf(false);
    }

    public float onGetThreshhold() {
        return 0.0f;
    }

    public float onGetThreshhold2() {
        return 0.0f;
    }

    public void onLastSlideOffset(View view, float f) {
    }

    public void onPanelAnchored(View view) {
    }

    public void onPanelCollapsed(View view) {
    }

    public void onPanelExpanded(View view) {
    }

    public void onPanelSlide(View view, Boolean bool, float f) {
        if (f <= 1.0f) {
            this.a.d.setRotationX(90.0f - (f * 90.0f));
            this.a.d.setAlpha(f);
            this.a.f.setTranslationY(((float) (-this.a.e)) * (1.0f - f));
            this.a.K.setAlpha(f);
            this.a.E.setAlpha(f);
            this.a.F.setAlpha(f);
            this.a.g.setTranslationY(((float) (-this.a.e)) * (1.0f - f));
            this.a.g.setAlpha(f);
        }
    }
}
