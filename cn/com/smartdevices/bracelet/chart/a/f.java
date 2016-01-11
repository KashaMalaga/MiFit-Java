package cn.com.smartdevices.bracelet.chart.a;

import android.annotation.SuppressLint;
import android.view.View;

@SuppressLint({"NewApi"})
class f {
    f() {
    }

    static void a(View view) {
        view.postInvalidateOnAnimation();
    }

    @SuppressLint({"NewApi"})
    static void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
