package android.support.v4.view;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import java.util.Comparator;

class bE implements Comparator<View> {
    bE() {
    }

    public int a(View view, View view2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
        return layoutParams.a != layoutParams2.a ? layoutParams.a ? 1 : -1 : layoutParams.e - layoutParams2.e;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((View) obj, (View) obj2);
    }
}
