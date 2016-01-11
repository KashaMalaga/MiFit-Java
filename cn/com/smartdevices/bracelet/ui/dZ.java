package cn.com.smartdevices.bracelet.ui;

import com.huami.android.view.b;
import com.xiaomi.hm.health.bt.a.d;
import java.io.File;

class dZ extends d {
    final /* synthetic */ String a;
    final /* synthetic */ dW b;

    dZ(dW dWVar, String str) {
        this.b = dWVar;
        this.a = str;
    }

    public void a() {
        super.a();
        this.b.a((int) new File(this.a).length());
        this.b.d();
    }

    public void a(Object obj) {
        super.a(obj);
        int intValue = ((Integer) obj).intValue();
        if (intValue == 1) {
            b.a(this.b.getActivity(), "\u56fa\u4ef6\u5347\u7ea7\u5931\u8d25\uff01", 1).show();
        } else if (intValue == 2) {
            b.a(this.b.getActivity(), "\u56fa\u4ef6\u5347\u7ea7\u6210\u529f!", 1).show();
        } else if (intValue == 0) {
            b.a(this.b.getActivity(), "\u56fa\u4ef6\u5347\u7ea7\u72b6\u6001\u672a\u77e5\uff01", 1).show();
        }
        this.b.b();
    }
}
