package cn.com.smartdevices.bracelet.view;

import android.database.DataSetObserver;

class V extends DataSetObserver {
    final /* synthetic */ VerticalViewPager a;

    private V(VerticalViewPager verticalViewPager) {
        this.a = verticalViewPager;
    }

    public void onChanged() {
        this.a.f();
    }

    public void onInvalidated() {
        this.a.f();
    }
}
