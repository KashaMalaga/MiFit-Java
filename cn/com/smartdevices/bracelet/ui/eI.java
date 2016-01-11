package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.f.a.b.f.d;

class eI extends d {
    final /* synthetic */ ShowImageActivity a;

    eI(ShowImageActivity showImageActivity) {
        this.a = showImageActivity;
    }

    public void a(String str, View view, Bitmap bitmap) {
        this.a.c = bitmap;
        this.a.a.setImageBitmap(bitmap);
    }
}
