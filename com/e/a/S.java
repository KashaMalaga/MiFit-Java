package com.e.a;

import java.util.ArrayList;

class S extends ThreadLocal<ArrayList<R>> {
    S() {
    }

    protected ArrayList<R> a() {
        return new ArrayList();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
