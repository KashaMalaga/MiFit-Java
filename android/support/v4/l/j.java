package android.support.v4.l;

import android.support.v4.l.j$android.support.v4.l.l;
import android.support.v4.l.j$android.support.v4.l.m;
import android.support.v4.l.j$android.support.v4.l.o;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class j<K, V> {
    l b;
    m c;
    o d;

    j() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    public <T> T[] a(T[] tArr, int i) {
        int a = a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    public Object[] b(int i) {
        int a = a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    protected abstract void c();

    public Set<Entry<K, V>> d() {
        if (this.b == null) {
            this.b = new l(this);
        }
        return this.b;
    }

    public Set<K> e() {
        if (this.c == null) {
            this.c = new m(this);
        }
        return this.c;
    }

    public Collection<V> f() {
        if (this.d == null) {
            this.d = new o(this);
        }
        return this.d;
    }
}
