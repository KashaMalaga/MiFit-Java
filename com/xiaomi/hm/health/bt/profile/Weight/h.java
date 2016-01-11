package com.xiaomi.hm.health.bt.profile.Weight;

import com.xiaomi.hm.health.bt.c.B;
import com.xiaomi.hm.health.bt.profile.a;

class h implements B {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void a(byte[] bArr) {
        if (this.a.C != null) {
            e a = a.a(bArr, true, false);
            if (a != null) {
                if (this.a.H != null) {
                    a.a(this.a.H.a);
                }
                this.a.C.a(a);
            }
        }
    }
}
