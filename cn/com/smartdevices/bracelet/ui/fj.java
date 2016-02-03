package cn.com.smartdevices.bracelet.ui;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import cn.com.smartdevices.bracelet.C0401a;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

class fj extends d {
    final /* synthetic */ UnlockScreenHelperActivity a;

    fj(UnlockScreenHelperActivity unlockScreenHelperActivity) {
        this.a = unlockScreenHelperActivity;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        this.a.findViewById(R.id.start_setting).setEnabled(true);
        if (obj == null || !((Boolean) obj).booleanValue()) {
            b.a(this.a, (int) R.string.unlock_for_smartlock_pair_fail_tip, 0).show();
            return;
        }
        C0401a.a(this.a, C0401a.fi);
        b.a(this.a, (int) R.string.unlock_for_smartlock_pair_success_tip, 0).show();
        try {
            this.a.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            C0401a.a(this.a, C0401a.fj);
            this.a.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public void b(Object obj) {
        super.b(obj);
    }
}
