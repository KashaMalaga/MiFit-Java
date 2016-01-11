package com.xiaomi.hm.health.bt.profile.b;

import cn.com.smartdevices.bracelet.C0596r;
import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.c.y;
import java.io.IOException;

class o implements B {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void a(byte[] bArr) {
        C0596r.d("RunningSyncDataTask", "data:" + y.b(bArr));
        try {
            n.a(this.a, bArr.length);
            if (this.a.j != null) {
                this.a.j.write(bArr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
