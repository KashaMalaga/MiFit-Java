package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.c;
import com.xiaomi.hm.health.bt.a.n;
import com.xiaomi.hm.health.bt.bleservice.a;
import com.xiaomi.hm.health.bt.profile.a.j;

public class eA extends c {
    private Activity a;
    private ProgressDialog b = null;

    private void a() {
        new n(new eB(this)).f();
    }

    protected int inflateLayout() {
        this.a = getActivity();
        C0596r.e(getTag(), "mContext = " + this.a);
        return com.xiaomi.hm.health.n.fragment_setting_reset_bracelet;
    }

    protected void onLeftButtonClicked() {
        j a = a.a();
        if (a == null) {
            dismiss();
            return;
        }
        a.a(false);
        a();
        this.mRightButton.setEnabled(false);
    }

    protected void onRightButtonClicked() {
        dismiss();
    }
}
