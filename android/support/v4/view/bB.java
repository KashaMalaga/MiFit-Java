package android.support.v4.view;

import android.database.DataSetObserver;

class bB extends DataSetObserver {
    final /* synthetic */ ViewPager a;

    private bB(ViewPager viewPager) {
        this.a = viewPager;
    }

    public void onChanged() {
        this.a.f();
    }

    public void onInvalidated() {
        this.a.f();
    }
}
