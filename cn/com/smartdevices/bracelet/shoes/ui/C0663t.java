package cn.com.smartdevices.bracelet.shoes.ui;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.a.d;
import java.util.List;

class C0663t extends d {
    final /* synthetic */ ShoesBindTestActivity a;

    C0663t(ShoesBindTestActivity shoesBindTestActivity) {
        this.a = shoesBindTestActivity;
    }

    public void a() {
        super.a();
        C0596r.e("ShoesBindTestActivity", "onStart!");
    }

    public void a(int i) {
        super.a(i);
        C0596r.e("ShoesBindTestActivity", "onProgress:" + i);
    }

    public void a(Object obj) {
        super.a(obj);
        C0596r.e("ShoesBindTestActivity", "onFinish:" + obj);
        if (obj != null) {
            this.a.a((List) obj);
        }
    }

    public void b(Object obj) {
        super.b(obj);
        C0596r.e("ShoesBindTestActivity", "onFailed!");
    }
}
