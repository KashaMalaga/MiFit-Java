package cn.com.smartdevices.bracelet.shoes.ui;

import android.content.Context;
import android.widget.Toast;
import com.xiaomi.hm.health.bt.a.d;

class C0656m extends d {
    final /* synthetic */ C0655l a;

    C0656m(C0655l c0655l) {
        this.a = c0655l;
    }

    public void a() {
        super.a();
    }

    public void a(Object obj) {
        super.a(obj);
        Context a = this.a.a.r;
        CharSequence charSequence = (obj == null || !((Boolean) obj).booleanValue()) ? "\u9759\u6001\u6807\u5b9a\u5931\u8d25!" : "\u9759\u6001\u6807\u5b9a\u6210\u529f\uff01";
        Toast.makeText(a, charSequence, 0).show();
        this.a.a.s.setText("\u5f00\u59cb\u9759\u6001\u6807\u5b9a");
        this.a.a.s.setTag("start_calibrate");
    }
}
