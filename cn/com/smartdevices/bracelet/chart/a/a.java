package cn.com.smartdevices.bracelet.chart.a;

import android.os.Build.VERSION;
import android.view.View;

public class a {
    public static void a(View view) {
        if (VERSION.SDK_INT >= 16) {
            f.a(view);
        } else if (VERSION.SDK_INT >= 11) {
            d.a(view);
        } else {
            b.a(view);
        }
    }

    public static void a(View view, float f) {
        if (VERSION.SDK_INT >= 11) {
            d.a(view, f);
        } else {
            b.a(view, f);
        }
    }

    public static void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            f.a(view, runnable);
        } else if (VERSION.SDK_INT >= 11) {
            d.a(view, runnable);
        } else {
            b.a(view, runnable);
        }
    }
}
