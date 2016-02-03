package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

class eB extends d {
    final /* synthetic */ eA a;

    eB(eA eAVar) {
        this.a = eAVar;
    }

    public void a() {
        super.a();
        if (this.a.getActivity() != null) {
            this.a.b = ProgressDialog.show(this.a.getActivity(), this.a.getString(R.string.reset_mili), this.a.getString(R.string.wait));
        }
    }

    public void a(Object obj) {
        super.a(obj);
        new Handler().postDelayed(new eC(this), 10000);
    }

    public void b(Object obj) {
        super.b(obj);
        if (this.a.b != null) {
            this.a.b.dismiss();
            this.a.b = null;
        }
        b.a(this.a.getActivity(), this.a.getActivity().getString(R.string.bt_operation_failed_tips), 0).show();
    }
}
