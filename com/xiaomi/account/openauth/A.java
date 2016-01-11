package com.xiaomi.account.openauth;

import android.os.Bundle;
import java.util.concurrent.Callable;

class A implements Callable<Bundle> {
    A() {
    }

    public Bundle a() {
        throw new IllegalStateException("this should never be called");
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
