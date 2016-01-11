package cn.com.smartdevices.bracelet.lab.ui;

import android.app.DialogFragment;
import com.huami.android.view.e;

class D implements e {
    final /* synthetic */ SportAnalyserActivity a;

    D(SportAnalyserActivity sportAnalyserActivity) {
        this.a = sportAnalyserActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.G = true;
        dialogFragment.dismiss();
        this.a.d(false);
        this.a.finish();
    }

    public void c(DialogFragment dialogFragment) {
    }
}
