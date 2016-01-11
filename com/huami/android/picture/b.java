package com.huami.android.picture;

import android.annotation.TargetApi;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.huami.android.bitmapfun.E;

class b implements OnGlobalLayoutListener {
    final /* synthetic */ GalleryPickerActivity a;

    b(GalleryPickerActivity galleryPickerActivity) {
        this.a = galleryPickerActivity;
    }

    @TargetApi(16)
    public void onGlobalLayout() {
        if (this.a.l.a() == 0) {
            int floor = (int) Math.floor((double) (this.a.k.getWidth() / (this.a.n + this.a.o)));
            if (floor > 0) {
                int width = (this.a.k.getWidth() / floor) - this.a.o;
                this.a.l.b(floor);
                this.a.l.a(width);
                if (E.e()) {
                    this.a.k.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    this.a.k.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        }
    }
}
