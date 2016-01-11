package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;

class cS implements PanelSlideListener {
    final /* synthetic */ cL a;

    cS(cL cLVar) {
        this.a = cLVar;
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
        C0596r.e("TAG_FOR_SLIDINGPANEL", "onLastSlideOffset " + f);
    }

    public void onPanelAnchored(View view) {
        C0596r.e("TAG_FOR_SLIDINGPANEL", "onPanelAnchored");
    }

    public void onPanelCollapsed(View view) {
        C0596r.e("TAG_FOR_SLIDINGPANEL", "onPanelCollapsed");
    }

    public void onPanelExpanded(View view) {
        C0596r.e("TAG_FOR_SLIDINGPANEL", "onPanelExpanded");
    }

    public void onPanelSlide(View view, Boolean bool, float f) {
    }
}
