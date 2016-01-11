package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import cn.com.smartdevices.bracelet.chart.util.p;

class C0688ar implements p {
    final /* synthetic */ C0681ak a;

    C0688ar(C0681ak c0681ak) {
        this.a = c0681ak;
    }

    public void a(int i) {
        Activity activity = this.a.getActivity();
        if (activity != null) {
            ((SystemBarTintActivity) activity).applyStatusBarTint(i);
        }
    }
}
