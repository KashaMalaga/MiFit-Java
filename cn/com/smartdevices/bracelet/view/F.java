package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.widget.HorizontalScrollView;

class F implements G {
    private F() {
    }

    public boolean a(View view, int i) {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view;
        int scrollX = horizontalScrollView.getScrollX();
        return horizontalScrollView.getChildCount() == 0 ? false : (i < 0 && scrollX < horizontalScrollView.getChildAt(0).getWidth() - horizontalScrollView.getWidth()) || (i > 0 && scrollX > 0);
    }

    public boolean b(View view, int i) {
        return false;
    }
}
