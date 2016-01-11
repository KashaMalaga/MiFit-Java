package android.support.v4.view;

import android.view.View;
import android.view.View.OnClickListener;

class C0132ag implements OnClickListener {
    final /* synthetic */ PagerTabStrip a;

    C0132ag(PagerTabStrip pagerTabStrip) {
        this.a = pagerTabStrip;
    }

    public void onClick(View view) {
        this.a.a.a(this.a.a.c() + 1);
    }
}
