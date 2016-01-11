package com.e.a;

import java.util.ArrayList;

class U extends ThreadLocal<ArrayList<R>> {
    U() {
    }

    protected ArrayList<R> a() {
        return new ArrayList();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
