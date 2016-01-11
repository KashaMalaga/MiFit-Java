package com.huami.android.bitmapfun;

import android.os.Process;

class C1063c extends k<Params, Result> {
    final /* synthetic */ C1061a a;

    C1063c(C1061a c1061a) {
        this.a = c1061a;
        super();
    }

    public Result call() {
        this.a.r.set(true);
        Process.setThreadPriority(10);
        return this.a.d(this.a.a(this.b));
    }
}
