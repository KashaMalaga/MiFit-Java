package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public class C0214ag {
    static final C0215aj a;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new C0217ai();
        } else {
            a = new C0216ah();
        }
    }

    private C0214ag() {
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        a.a(popupWindow, view, i, i2, i3);
    }
}
