package cn.com.smartdevices.bracelet.relation;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.e;
import com.xiaomi.hm.health.R;

class C0598a implements e {
    final /* synthetic */ DetailActivity a;

    C0598a(DetailActivity detailActivity) {
        this.a = detailActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        Utils.a(this.a, (int) R.string.data_loading, true);
        this.a.j.c(this.a.i.n);
    }

    public void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }
}
