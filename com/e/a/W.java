package com.e.a;

import java.util.ArrayList;

class W extends ThreadLocal<ArrayList<R>> {
    W() {
    }

    protected ArrayList<R> a() {
        return new ArrayList();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
