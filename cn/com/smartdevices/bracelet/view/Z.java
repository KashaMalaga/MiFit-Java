package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class Z implements OnLayoutChangeListener {
    final /* synthetic */ WeightUserAvatar a;

    Z(WeightUserAvatar weightUserAvatar) {
        this.a = weightUserAvatar;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.a.c) {
            this.a.b();
        }
    }
}
