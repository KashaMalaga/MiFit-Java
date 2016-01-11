package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.Keeper;
import com.huami.android.view.e;

class C0683am implements e {
    final /* synthetic */ C0692av a;
    final /* synthetic */ C0681ak b;

    C0683am(C0681ak c0681ak, C0692av c0692av) {
        this.b = c0681ak;
        this.a = c0692av;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
    }

    public void c(DialogFragment dialogFragment) {
        this.a.dismiss();
        Keeper.keepShowSensorHubTip(false);
    }
}
