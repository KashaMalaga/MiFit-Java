package com.c.a.b;

import java.util.AbstractSet;
import java.util.Iterator;

class A extends AbstractSet<K> {
    final /* synthetic */ w a;

    A(w wVar) {
        this.a = wVar;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return this.a.containsKey(obj);
    }

    public Iterator<K> iterator() {
        return new B(this);
    }

    public boolean remove(Object obj) {
        return this.a.b(obj) != null;
    }

    public int size() {
        return this.a.c;
    }
}
