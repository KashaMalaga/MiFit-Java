package cn.com.smartdevices.bracelet.weight.family;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.b;
import com.huami.android.view.e;
import com.xiaomi.hm.health.R;

class i implements e {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        C0401a.a(this.a.getActivity().getApplicationContext(), C0401a.gg);
        if (Utils.l(this.a.getActivity().getApplicationContext())) {
            new j(this).execute(new Void[0]);
        } else {
            b.a(this.a.getActivity().getApplicationContext(), this.a.getString(R.string.please_connect_internet), 0).show();
        }
    }

    public void c(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
    }
}
