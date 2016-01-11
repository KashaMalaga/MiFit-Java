package cn.com.smartdevices.bracelet.activity;

import android.graphics.Bitmap;
import android.view.View;
import cn.com.smartdevices.bracelet.C0596r;
import com.f.a.b.a.b;
import com.f.a.b.f.a;

class z implements a {
    int a;
    final /* synthetic */ StartUpActivity b;

    public z(StartUpActivity startUpActivity, int i) {
        this.b = startUpActivity;
        this.a = i;
    }

    private void a() {
        if (this.a == 0) {
            C0596r.d("StartUpActivity", "use local_cache img , type = " + this.a);
        } else if (this.a == 1) {
            C0596r.d("StartUpActivity", "down img from network , type = " + this.a);
        }
    }

    public void a(String str, View view) {
        C0596r.d("StartUpActivity", "onLoadingStarted time = " + System.currentTimeMillis());
        a();
    }

    public void a(String str, View view, Bitmap bitmap) {
        C0596r.d("StartUpActivity", "onLoadingComplete time = " + System.currentTimeMillis());
        C0596r.d("StartUpActivity", "onLoadingComplete height = " + bitmap.getHeight() + " , width  = " + bitmap.getWidth());
    }

    public void a(String str, View view, b bVar) {
        C0596r.d("StartUpActivity", "onLoadingFailed--");
    }

    public void b(String str, View view) {
    }
}
