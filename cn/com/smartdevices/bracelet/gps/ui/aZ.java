package cn.com.smartdevices.bracelet.gps.ui;

import android.app.DialogFragment;
import android.content.Intent;
import com.huami.android.view.e;
import com.xiaomi.channel.b.n;

class aZ implements e {
    final /* synthetic */ RunningMainActivity a;

    aZ(RunningMainActivity runningMainActivity) {
        this.a = runningMainActivity;
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        this.a.startActivityForResult(new Intent("cn.com.smartdevices.bracelet.intent.action.LOGIN"), n.b);
    }

    public void c(DialogFragment dialogFragment) {
    }
}
