package cn.com.smartdevices.bracelet.shoes.ui;

import android.widget.Toast;
import com.xiaomi.hm.health.bt.a.d;

class C0654k extends d {
    final /* synthetic */ C0653j a;

    C0654k(C0653j c0653j) {
        this.a = c0653j;
    }

    public void a(Object obj) {
        super.a(obj);
        int intValue = ((Integer) obj).intValue();
        if (intValue == -1) {
            Toast.makeText(this.a.a.r, "\u672a\u83b7\u53d6\u5230\u8dd1\u978b\u7535\u91cf", 0).show();
        } else {
            Toast.makeText(this.a.a.r, "\u8dd1\u978b\u7535\u91cf\uff1a" + intValue + "%", 0).show();
        }
    }
}
