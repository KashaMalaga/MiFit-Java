package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.view.View.OnClickListener;

class C0845s implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ PagerSlidingTabStrip b;

    C0845s(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.b = pagerSlidingTabStrip;
        this.a = i;
    }

    public void onClick(View view) {
        this.b.g.a(this.a);
    }
}
