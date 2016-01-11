package com.c.a.b;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class y extends AbstractSet<Entry<K, V>> {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object obj) {
        return (obj instanceof Entry) && this.a.a((Entry) obj) != null;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new z(this);
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        D a = this.a.a((Entry) obj);
        if (a == null) {
            return false;
        }
        this.a.a(a, true);
        return true;
    }

    public int size() {
        return this.a.c;
    }
}
