package cn.com.smartdevices.bracelet.tag;

import android.app.DialogFragment;
import com.huami.android.view.e;

class j implements e {
    final /* synthetic */ TagDataActivity a;

    j(TagDataActivity tagDataActivity) {
        this.a = tagDataActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.f();
        this.a.l.e();
        this.a.finish();
    }

    public void c(DialogFragment dialogFragment) {
        this.a.q.setEnabled(true);
    }
}
