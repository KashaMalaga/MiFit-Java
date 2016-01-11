package com.c.b.i.a;

import com.c.b.u;

public final class r {
    private final boolean a;

    r(boolean z) {
        this.a = z;
    }

    public void a(u[] uVarArr) {
        if (this.a && uVarArr != null && uVarArr.length >= 3) {
            u uVar = uVarArr[0];
            uVarArr[0] = uVarArr[2];
            uVarArr[2] = uVar;
        }
    }

    public boolean a() {
        return this.a;
    }
}
