package com.c.a.b;

import java.util.Comparator;

final class x implements Comparator<Comparable> {
    x() {
    }

    public int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Comparable) obj, (Comparable) obj2);
    }
}
