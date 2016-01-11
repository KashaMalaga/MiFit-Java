package cn.com.smartdevices.bracelet.view;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class C0844r implements OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip a;

    C0844r(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.a = pagerSlidingTabStrip;
    }

    @SuppressLint({"NewApi"})
    public void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.a.i = this.a.g.c();
        this.a.b(this.a.i, 0);
    }
}
