package cn.com.smartdevices.bracelet;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.view.O;
import com.f.a.b.a.g;
import com.f.a.b.c.a;
import com.f.a.b.e.b;

public class C0561i implements a {
    final /* synthetic */ C0544h a;

    public C0561i(C0544h c0544h) {
        this.a = c0544h;
    }

    @SuppressLint({"NewApi"})
    public void a(Bitmap bitmap, com.f.a.b.e.a aVar, g gVar) {
        if (aVar instanceof b) {
            Bitmap a = O.a(bitmap);
            ImageView imageView = (ImageView) aVar.d();
            if (a != null && imageView != null) {
                imageView.setBackground(new BitmapDrawable(imageView.getResources(), a));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
