package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.os.Bundle;
import com.xiaomi.account.b;

class B extends b {
    final /* synthetic */ z c;

    B(z zVar) {
        this.c = zVar;
    }

    public void a() {
        this.c.setException(new OperationCanceledException());
    }

    public void a(Bundle bundle) {
        this.c.a(bundle);
    }
}
