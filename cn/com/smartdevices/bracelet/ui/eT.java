package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import com.huami.android.view.c;
import com.huami.android.view.e;

class eT implements e {
    final /* synthetic */ c a;
    final /* synthetic */ StatisticFragment b;

    eT(StatisticFragment statisticFragment, c cVar) {
        this.b = statisticFragment;
        this.a = cVar;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.dismiss();
    }

    public void c(DialogFragment dialogFragment) {
        this.a.dismiss();
        this.b.a(this.b.F);
    }
}
