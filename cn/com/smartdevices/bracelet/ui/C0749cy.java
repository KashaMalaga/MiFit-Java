package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import com.huami.android.ui.a;

class C0749cy implements bR {
    final /* synthetic */ MainUIActivity a;

    C0749cy(MainUIActivity mainUIActivity) {
        this.a = mainUIActivity;
    }

    public void a() {
        this.a.m = false;
        if (a.b(this.a.E)) {
            this.a.getWindow().getDecorView().destroyDrawingCache();
            return;
        }
        View findViewById = this.a.findViewById(16908290);
        if (findViewById != null) {
            findViewById.destroyDrawingCache();
        }
    }
}
