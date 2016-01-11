package android.support.v4.d.a;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

class c extends a {
    private final WindowManager b;

    public c(Context context) {
        this.b = (WindowManager) context.getSystemService("window");
    }

    public Display a(int i) {
        Display defaultDisplay = this.b.getDefaultDisplay();
        return defaultDisplay.getDisplayId() == i ? defaultDisplay : null;
    }

    public Display[] a() {
        return new Display[]{this.b.getDefaultDisplay()};
    }

    public Display[] a(String str) {
        return str == null ? a() : new Display[0];
    }
}
