package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class aR implements OnApplyWindowInsetsListener {
    final /* synthetic */ C0130ad a;

    aR(C0130ad c0130ad) {
        this.a = c0130ad;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((cg) this.a.a(view, new cg(windowInsets))).p();
    }
}
