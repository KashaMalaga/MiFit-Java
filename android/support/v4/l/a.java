package android.support.v4.l;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends u<K, V> implements Map<K, V> {
    j<K, V> a;

    public a(int i) {
        super(i);
    }

    public a(u uVar) {
        super(uVar);
    }

    private j<K, V> b() {
        if (this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public boolean a(Collection<?> collection) {
        return j.a((Map) this, (Collection) collection);
    }

    public boolean b(Collection<?> collection) {
        return j.b(this, collection);
    }

    public boolean c(Collection<?> collection) {
        return j.c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return b().d();
    }

    public Set<K> keySet() {
        return b().e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return b().f();
    }
}
