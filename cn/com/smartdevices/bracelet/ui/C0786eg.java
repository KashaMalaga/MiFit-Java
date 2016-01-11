package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lua.ScrollSlidingUpPanelLayout.PanelSlideListener;

class C0786eg implements PanelSlideListener {
    final /* synthetic */ C0784ee a;

    C0786eg(C0784ee c0784ee) {
        this.a = c0784ee;
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
        C0596r.e("SettingFragment", "onPanelAnchored");
    }

    public void onPanelCollapsed(View view) {
        C0596r.e("SettingFragment", "onPanelCollapsed --open--");
    }

    public void onPanelExpanded(View view) {
        C0596r.e("SettingFragment", "onPanelExpanded --close--");
        this.a.z.invalidate();
    }

    public void onPanelSlide(View view, Boolean bool, float f) {
        C0596r.e("SettingFragment", "panel slideOffset : " + f);
        if (f <= 1.0f) {
            this.a.a(f);
        }
    }
}
