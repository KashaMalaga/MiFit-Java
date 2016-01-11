package android.support.v4.l;

import java.util.Collection;
import java.util.Iterator;

final class o implements Collection<V> {
    final /* synthetic */ j a;

    o(j jVar) {
        this.a = jVar;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object obj) {
        return this.a.b(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator<V> iterator() {
        return new k(this.a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.a.b(obj);
        if (b < 0) {
            return false;
        }
        this.a.a(b);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.a.a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.a.a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.a.a(i, 1))) {
                this.a.a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        return this.a.b(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.a.a((Object[]) tArr, 1);
    }
}
