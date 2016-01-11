package android.support.v4.l;

import java.util.Iterator;
import java.util.Map.Entry;

final class n implements Iterator<Entry<K, V>>, Entry<K, V> {
    int a;
    int b;
    boolean c = false;
    final /* synthetic */ j d;

    n(j jVar) {
        this.d = jVar;
        this.a = jVar.a() - 1;
        this.b = -1;
    }

    public Entry<K, V> a() {
        this.b++;
        this.c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(e.a(entry.getKey(), this.d.a(this.b, 0)) && e.a(entry.getValue(), this.d.a(this.b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public K getKey() {
        if (this.c) {
            return this.d.a(this.b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.c) {
            return this.d.a(this.b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.b < this.a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.c) {
            Object a = this.d.a(this.b, 0);
            Object a2 = this.d.a(this.b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return a();
    }

    public void remove() {
        if (this.c) {
            this.d.a(this.b);
            this.b--;
            this.a--;
            this.c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public V setValue(V v) {
        if (this.c) {
            return this.d.a(this.b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
