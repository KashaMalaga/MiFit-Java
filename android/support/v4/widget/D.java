package android.support.v4.widget;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class D implements OnApplyWindowInsetsListener {
    D() {
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((E) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
