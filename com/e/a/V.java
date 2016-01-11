package com.e.a;

import java.util.ArrayList;

class V extends ThreadLocal<ArrayList<R>> {
    V() {
    }

    protected ArrayList<R> a() {
        return new ArrayList();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
