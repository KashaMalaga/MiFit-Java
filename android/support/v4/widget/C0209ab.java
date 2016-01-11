package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View.OnTouchListener;

public class C0209ab {
    static final C0210ae a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new C0212ad();
        } else {
            a = new C0211ac();
        }
    }

    private C0209ab() {
    }

    public static OnTouchListener a(Object obj) {
        return a.a(obj);
    }
}
