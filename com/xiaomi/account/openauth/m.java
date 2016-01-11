package com.xiaomi.account.openauth;

import android.os.Bundle;

public class m {
    public final int a;
    public final String b;

    public m(int i, String str) {
        this.a = i;
        this.b = str;
    }

    private static m b(Bundle bundle) {
        return new m(l.e(bundle, h.ag, h.P), l.d(bundle, h.ah, h.Q));
    }

    public String toString() {
        return "errorCode=" + this.a + ",errorMessage=" + this.b;
    }
}
