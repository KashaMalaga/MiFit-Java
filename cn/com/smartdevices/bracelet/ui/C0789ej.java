package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class C0789ej extends d {
    final /* synthetic */ C0788ei a;

    C0789ej(C0788ei c0788ei) {
        this.a = c0788ei;
    }

    public void a(Object obj) {
        C0596r.d("SettingFragment", "Sleep assist cmd:" + ((Boolean) obj).booleanValue());
    }
}
