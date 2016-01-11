package cn.com.smartdevices.bracelet.lab.ui;

import android.app.DialogFragment;
import com.huami.android.view.e;

class ao implements e {
    final /* synthetic */ StepsCountActivity a;

    ao(StepsCountActivity stepsCountActivity) {
        this.a = stepsCountActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.a.finish();
    }

    public void c(DialogFragment dialogFragment) {
    }
}
