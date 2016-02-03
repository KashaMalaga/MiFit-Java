package cn.com.smartdevices.bracelet;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.market.sdk.C1123b;
import com.xiaomi.market.sdk.e;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

final class V implements e {
    final /* synthetic */ Activity a;
    final /* synthetic */ boolean b;

    V(Activity activity, boolean z) {
        this.a = activity;
        this.b = z;
    }

    @SuppressLint({"NewApi"})
    public void a(int i, C1123b c1123b) {
        switch (i) {
            case a.i /*0*/:
                C0596r.d("Utils", " UpdateResponse: " + c1123b);
                if (!this.a.isDestroyed()) {
                    Utils.b(c1123b, this.a);
                    return;
                }
                return;
            case l.a /*1*/:
                if (this.b) {
                    b.a(this.a, (int) R.string.apk_uptodate, 1).show();
                    return;
                }
                return;
            case a.k /*2*/:
                if (this.b) {
                    b.a(this.a, (int) R.string.network_error, 1).show();
                    return;
                }
                return;
            case a.l /*3*/:
                if (this.b) {
                    b.a(this.a, (int) R.string.network_error, 1).show();
                    return;
                }
                return;
            case a.aQ /*4*/:
                if (this.b) {
                    b.a(this.a, (int) R.string.network_error, 1).show();
                    return;
                }
                return;
            case a.X /*5*/:
                if (this.b) {
                    b.a(this.a, (int) R.string.local_app_failed, 1).show();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
