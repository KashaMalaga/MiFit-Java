package android.support.v4.l;

import java.util.Map;

class b extends j<K, V> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    protected int a() {
        return this.a.h;
    }

    protected int a(Object obj) {
        return this.a.a(obj);
    }

    protected Object a(int i, int i2) {
        return this.a.g[(i << 1) + i2];
    }

    protected V a(int i, V v) {
        return this.a.a(i, (Object) v);
    }

    protected void a(int i) {
        this.a.d(i);
    }

    protected void a(K k, V v) {
        this.a.put(k, v);
    }

    protected int b(Object obj) {
        return this.a.b(obj);
    }

    protected Map<K, V> b() {
        return this.a;
    }

    protected void c() {
        this.a.clear();
    }
}
