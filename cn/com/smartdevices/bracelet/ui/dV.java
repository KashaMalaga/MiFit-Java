package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.j.n;
import com.d.a.a.h;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import org.apache.http.Header;

class dV extends h {
    final /* synthetic */ dT a;

    dV(dT dTVar) {
        this.a = dTVar;
    }

    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
        b.a(this.a.getActivity(), (int) R.string.feedback_failed, 0).show();
        this.a.d.setEnabled(true);
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String b = Utils.b(bArr);
        C0596r.e("DDDD", "Send Feedback : " + i + ",content : " + b);
        if (n.a(this.a.getActivity(), b).c()) {
            b.a(BraceletApp.a(), (int) R.string.feedback_ok, 0).show();
            if (this.a.getActivity() != null) {
                this.a.getActivity().finish();
                return;
            }
            return;
        }
        b.a(BraceletApp.a(), (int) R.string.feedback_failed, 0).show();
        this.a.d.setEnabled(true);
    }
}
