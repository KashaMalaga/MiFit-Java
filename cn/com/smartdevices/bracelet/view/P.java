package cn.com.smartdevices.bracelet.view;

import java.util.Comparator;

final class P implements Comparator<S> {
    P() {
    }

    public int a(S s, S s2) {
        return s.b - s2.b;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((S) obj, (S) obj2);
    }
}
