package android.support.v4.l;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class l implements Set<Entry<K, V>> {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public boolean a(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return a((Entry) obj);
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int a = this.a.a();
        for (Entry entry : collection) {
            this.a.a(entry.getKey(), entry.getValue());
        }
        return a != this.a.a();
    }

    public void clear() {
        this.a.c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.a.a(entry.getKey());
        return a >= 0 ? e.a(this.a.a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return j.a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.a.a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.a.a(a, 0);
            Object a3 = this.a.a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.a.a() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new n(this.a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.a.a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
