package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;

class eE implements PanelSlideListener {
    final /* synthetic */ eD a;

    eE(eD eDVar) {
        this.a = eDVar;
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
        C0596r.e("SettingWeightFragment", "onPanelAnchored");
    }

    public void onPanelCollapsed(View view) {
        C0596r.e("SettingWeightFragment", "onPanelCollapsed");
    }

    public void onPanelExpanded(View view) {
        C0596r.e("SettingWeightFragment", "onPanelExpanded");
    }

    public void onPanelSlide(View view, Boolean bool, float f) {
        if (f <= 1.0f) {
            this.a.a(f);
        }
    }
}
