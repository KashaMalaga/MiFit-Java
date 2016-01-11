package com.huami.android.picture;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.huami.android.bitmapfun.E;

class a implements OnScrollListener {
    final /* synthetic */ GalleryPickerActivity a;

    a(GalleryPickerActivity galleryPickerActivity) {
        this.a = galleryPickerActivity;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 2) {
            this.a.p.c(false);
        } else if (!E.c()) {
            this.a.p.c(true);
        }
    }
}
