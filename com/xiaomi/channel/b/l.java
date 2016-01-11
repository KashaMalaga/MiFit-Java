package com.xiaomi.channel.b;

import android.os.Bundle;
import java.util.concurrent.Callable;

class l implements Callable<Bundle> {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public Bundle a() {
        throw new IllegalStateException("this should never be called");
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
