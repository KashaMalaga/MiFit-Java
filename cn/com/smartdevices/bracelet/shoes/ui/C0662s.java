package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;

class C0662s extends d {
    final /* synthetic */ ShoesBindTestActivity a;

    C0662s(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.d("ShoesBindTestActivity", "onFinish:" + obj);
        this.a.o.sendEmptyMessage(4);
    }

    public void b(Object obj) {
        super.b(obj);
        C0596r.d("ShoesBindTestActivity", "onFailed:" + obj);
    }
}
