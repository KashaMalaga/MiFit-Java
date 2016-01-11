package cn.com.smartdevices.bracelet.shoes.ui;

import android.widget.Toast;
import com.xiaomi.hm.health.bt.a.d;

class C0658o extends d {
    final /* synthetic */ C0657n a;

    C0658o(C0657n c0657n) {
        this.a = c0657n;
    }

    public void a(Object obj) {
        super.a(obj);
        Toast.makeText(this.a.a.r, ((Boolean) obj).booleanValue() ? "\u8bbe\u7f6e\u5fc3\u8df3\u5305\u6210\u529f!" : "\u8bbe\u7f6e\u5fc3\u8df3\u5305\u5931\u8d25!", 0).show();
    }
}
