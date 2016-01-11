package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.a.d;
import com.xiaomi.hm.health.r;

class cR extends d {
    final /* synthetic */ cL a;

    cR(cL cLVar) {
        this.a = cLVar;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.e("PersonInfoFragment", "sync to bracelet ok");
    }

    public void b(Object obj) {
        super.b(obj);
        if (this.a.getActivity() != null) {
            b.a(this.a.getActivity(), this.a.getActivity().getString(r.bt_operation_failed_tips), 0).show();
        }
    }
}
