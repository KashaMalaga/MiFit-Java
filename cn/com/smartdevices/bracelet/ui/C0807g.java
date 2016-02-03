package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Keeper;
import com.huami.android.view.b;
import com.xiaomi.hm.health.R;
import com.xiaomi.hm.health.bt.a.d;

class C0807g extends d {
    final /* synthetic */ boolean a;
    final /* synthetic */ C0806f b;

    C0807g(C0806f c0806f, boolean z) {
        this.b = c0806f;
        this.a = z;
    }

    public void a(Object obj) {
        super.a(obj);
        this.b.a.setEnabled(this.a);
        this.b.a.setUpdate(false);
        this.b.b.a.r.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.b.b.a.r);
        this.b.b.a.g();
    }

    public void b(Object obj) {
        super.b(obj);
        b.a(this.b.b.a.p, this.b.b.a.p.getString(R.string.bt_operation_failed_tips), 0).show();
    }
}
