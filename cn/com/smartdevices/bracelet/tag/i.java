package cn.com.smartdevices.bracelet.tag;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.Utils;
import com.huami.android.view.e;
import com.xiaomi.hm.health.R;

class i implements e {
    final /* synthetic */ TagDataActivity a;

    i(TagDataActivity tagDataActivity) {
        this.a = tagDataActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.f();
        Utils.a(this.a, (int) R.string.tag_data_collecting);
        this.a.l.g();
        this.a.n.setVisibility(0);
        this.a.s.setVisibility(8);
    }

    public void c(DialogFragment dialogFragment) {
        this.a.q.setEnabled(true);
    }
}
