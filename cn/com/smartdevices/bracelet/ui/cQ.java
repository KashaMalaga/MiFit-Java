package cn.com.smartdevices.bracelet.ui;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.relation.A;
import cn.com.smartdevices.bracelet.weibo.v;
import com.huami.android.view.e;

class cQ implements e {
    final /* synthetic */ cL a;

    cQ(cL cLVar) {
        this.a = cLVar;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        this.a.m();
        A.a().b();
        v.a().i(this.a.getActivity());
        C0401a.a(this.a.getActivity(), C0401a.dZ, C0401a.dC);
    }

    public void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        C0401a.a(this.a.getActivity(), C0401a.dZ, C0401a.dD);
    }
}
