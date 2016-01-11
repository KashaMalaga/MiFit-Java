package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ae;
import android.view.View;

class H implements G {
    private H() {
    }

    public boolean a(View view, int i) {
        ViewPager viewPager = (ViewPager) view;
        ae b = viewPager.b();
        if (b == null || b.b() == 0) {
            return false;
        }
        int c = viewPager.c();
        return (i < 0 && c < b.b() - 1) || (i > 0 && c > 0);
    }

    public boolean b(View view, int i) {
        return false;
    }
}
