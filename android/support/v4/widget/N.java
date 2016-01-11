package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnTouchListener;

public class N {
    static final Q a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new P();
        } else {
            a = new O();
        }
    }

    private N() {
    }

    public static OnTouchListener a(Object obj, View view) {
        return a.a(obj, view);
    }
}
