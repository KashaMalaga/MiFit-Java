package com.e.a;

import java.util.ArrayList;

class T extends ThreadLocal<ArrayList<R>> {
    T() {
    }

    protected ArrayList<R> a() {
        return new ArrayList();
    }

    protected /* synthetic */ Object initialValue() {
        return a();
    }
}
