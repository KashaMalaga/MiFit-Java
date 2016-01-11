package com.xiaomi.account.openauth;

import java.util.concurrent.Callable;

class k implements Callable<V> {
    k() {
    }

    public V call() {
        throw new IllegalStateException("this should never be called");
    }
}
