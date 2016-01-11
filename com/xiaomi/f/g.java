package com.xiaomi.f;

import com.xiaomi.c.a.C1071c;
import com.xiaomi.c.a.U;

class g implements U {
    final /* synthetic */ C1091b a;

    g(C1091b c1091b) {
        this.a = c1091b;
    }

    public boolean a(C1071c c1071c) {
        if (c1071c.a() != null) {
            try {
                this.a.w.write(c1071c.a().d());
                this.a.w.flush();
            } catch (Exception e) {
            }
        }
        return false;
    }
}
