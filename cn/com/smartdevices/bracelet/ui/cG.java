package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import com.huami.android.view.e;

class cG implements e {
    final /* synthetic */ NewAlarmActivity a;

    cG(NewAlarmActivity newAlarmActivity) {
        this.a = newAlarmActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }

    public void c(DialogFragment dialogFragment) {
        this.a.setResult(0);
        this.a.finish();
    }
}
