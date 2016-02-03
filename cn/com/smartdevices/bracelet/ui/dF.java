package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class dF extends Handler {
    final /* synthetic */ dE a;

    dF(dE dEVar) {
        this.a = dEVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case l.a /*1*/:
                if (this.a.k == null) {
                    this.a.k = ProgressDialog.show(this.a.getActivity(), this.a.getString(R.string.upload_log), this.a.getString(R.string.prepare_log));
                    this.a.k.setCancelable(true);
                    return;
                }
                return;
            case a.k /*2*/:
                if (this.a.k != null) {
                    this.a.k.setMessage(this.a.getString(R.string.uploaded) + message.arg1 + "%");
                    return;
                }
                return;
            case a.l /*3*/:
                if (this.a.k != null) {
                    this.a.k.dismiss();
                    this.a.k = null;
                }
                if (this.a.getActivity() == null) {
                    return;
                }
                if (((Boolean) message.obj).booleanValue()) {
                    b.a(this.a.getActivity(), (int) R.string.upload_log_ok, 0).show();
                    return;
                } else {
                    b.a(this.a.getActivity(), (int) R.string.upload_log_fail, 0).show();
                    return;
                }
            default:
                return;
        }
    }
}
