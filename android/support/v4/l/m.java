package android.support.v4.l;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class m implements Set<K> {
    final /* synthetic */ j a;

    m(j jVar) {
        this.a = jVar;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object obj) {
        return this.a.a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return j.a(this.a.b(), (Collection) collection);
    }

    public boolean equals(Object obj) {
        return j.a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.a.a() - 1; a >= 0; a--) {
            Object a2 = this.a.a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator<K> iterator() {
        return new k(this.a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.a.a(obj);
        if (a < 0) {
            return false;
        }
        this.a.a(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return j.b(this.a.b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return j.c(this.a.b(), collection);
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        return this.a.b(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.a.a((Object[]) tArr, 0);
    }
}
