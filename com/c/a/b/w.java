package com.c.a.b;

import com.c.a.b.w$com.c.a.b.A;
import com.c.a.b.w$com.c.a.b.y;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class w<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f = (!w.class.desiredAssertionStatus());
    private static final Comparator<Comparable> g = new x();
    Comparator<? super K> a;
    D<K, V> b;
    int c;
    int d;
    final D<K, V> e;
    private y h;
    private A i;

    public w() {
        this(g);
    }

    public w(Comparator<? super K> comparator) {
        Comparator comparator2;
        this.c = 0;
        this.d = 0;
        this.e = new D();
        if (comparator == null) {
            comparator2 = g;
        }
        this.a = comparator2;
    }

    private void a(D<K, V> d) {
        int i = 0;
        D d2 = d.b;
        D d3 = d.c;
        D d4 = d3.b;
        D d5 = d3.c;
        d.c = d4;
        if (d4 != null) {
            d4.a = d;
        }
        a((D) d, d3);
        d3.b = d;
        d.a = d3;
        d.h = Math.max(d2 != null ? d2.h : 0, d4 != null ? d4.h : 0) + 1;
        int i2 = d.h;
        if (d5 != null) {
            i = d5.h;
        }
        d3.h = Math.max(i2, i) + 1;
    }

    private void a(D<K, V> d, D<K, V> d2) {
        D d3 = d.a;
        d.a = null;
        if (d2 != null) {
            d2.a = d3;
        }
        if (d3 == null) {
            this.b = d2;
        } else if (d3.b == d) {
            d3.b = d2;
        } else if (f || d3.c == d) {
            d3.c = d2;
        } else {
            throw new AssertionError();
        }
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void b(D<K, V> d) {
        int i = 0;
        D d2 = d.b;
        D d3 = d.c;
        D d4 = d2.b;
        D d5 = d2.c;
        d.b = d5;
        if (d5 != null) {
            d5.a = d;
        }
        a((D) d, d2);
        d2.c = d;
        d.a = d2;
        d.h = Math.max(d3 != null ? d3.h : 0, d5 != null ? d5.h : 0) + 1;
        int i2 = d.h;
        if (d4 != null) {
            i = d4.h;
        }
        d2.h = Math.max(i2, i) + 1;
    }

    private void b(D<K, V> d, boolean z) {
        D d2;
        while (d2 != null) {
            D d3 = d2.b;
            D d4 = d2.c;
            int i = d3 != null ? d3.h : 0;
            int i2 = d4 != null ? d4.h : 0;
            int i3 = i - i2;
            D d5;
            if (i3 == -2) {
                d3 = d4.b;
                d5 = d4.c;
                i2 = (d3 != null ? d3.h : 0) - (d5 != null ? d5.h : 0);
                if (i2 == -1 || (i2 == 0 && !z)) {
                    a(d2);
                } else if (f || i2 == 1) {
                    b(d4);
                    a(d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d4 = d3.b;
                d5 = d3.c;
                i2 = (d4 != null ? d4.h : 0) - (d5 != null ? d5.h : 0);
                if (i2 == 1 || (i2 == 0 && !z)) {
                    b(d2);
                } else if (f || i2 == -1) {
                    a(d3);
                    b(d2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                d2.h = i + 1;
                if (z) {
                    return;
                }
            } else if (f || i3 == -1 || i3 == 1) {
                d2.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            d2 = d2.a;
        }
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    D<K, V> a(Object obj) {
        D<K, V> d = null;
        if (obj != null) {
            try {
                d = a(obj, false);
            } catch (ClassCastException e) {
            }
        }
        return d;
    }

    D<K, V> a(K k, boolean z) {
        int i;
        Comparator comparator = this.a;
        D<K, V> d = this.b;
        if (d != null) {
            int compareTo;
            Comparable comparable = comparator == g ? (Comparable) k : null;
            while (true) {
                compareTo = comparable != null ? comparable.compareTo(d.f) : comparator.compare(k, d.f);
                if (compareTo == 0) {
                    return d;
                }
                D<K, V> d2 = compareTo < 0 ? d.b : d.c;
                if (d2 == null) {
                    break;
                }
                d = d2;
            }
            int i2 = compareTo;
            D d3 = d;
            i = i2;
        } else {
            D<K, V> d4 = d;
            i = 0;
        }
        if (!z) {
            return null;
        }
        D<K, V> d5;
        D d6 = this.e;
        if (d3 != null) {
            d5 = new D(d3, k, d6, d6.e);
            if (i < 0) {
                d3.b = d5;
            } else {
                d3.c = d5;
            }
            b(d3, true);
        } else if (comparator != g || (k instanceof Comparable)) {
            d5 = new D(d3, k, d6, d6.e);
            this.b = d5;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.c++;
        this.d++;
        return d5;
    }

    D<K, V> a(Entry<?, ?> entry) {
        D<K, V> a = a(entry.getKey());
        Object obj = (a == null || !a(a.g, entry.getValue())) ? null : 1;
        return obj != null ? a : null;
    }

    void a(D<K, V> d, boolean z) {
        int i = 0;
        if (z) {
            d.e.d = d.d;
            d.d.e = d.e;
        }
        D d2 = d.b;
        D d3 = d.c;
        D d4 = d.a;
        if (d2 == null || d3 == null) {
            if (d2 != null) {
                a((D) d, d2);
                d.b = null;
            } else if (d3 != null) {
                a((D) d, d3);
                d.c = null;
            } else {
                a((D) d, null);
            }
            b(d4, false);
            this.c--;
            this.d++;
            return;
        }
        int i2;
        d2 = d2.h > d3.h ? d2.b() : d3.a();
        a(d2, false);
        d4 = d.b;
        if (d4 != null) {
            i2 = d4.h;
            d2.b = d4;
            d4.a = d2;
            d.b = null;
        } else {
            i2 = 0;
        }
        d4 = d.c;
        if (d4 != null) {
            i = d4.h;
            d2.c = d4;
            d4.a = d2;
            d.c = null;
        }
        d2.h = Math.max(i2, i) + 1;
        a((D) d, d2);
    }

    D<K, V> b(Object obj) {
        D a = a(obj);
        if (a != null) {
            a(a, true);
        }
        return a;
    }

    public void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        D d = this.e;
        d.e = d;
        d.d = d;
    }

    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set set = this.h;
        if (set != null) {
            return set;
        }
        set = new y(this);
        this.h = set;
        return set;
    }

    public V get(Object obj) {
        D a = a(obj);
        return a != null ? a.g : null;
    }

    public Set<K> keySet() {
        Set set = this.i;
        if (set != null) {
            return set;
        }
        set = new A(this);
        this.i = set;
        return set;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        D a = a((Object) k, true);
        V v2 = a.g;
        a.g = v;
        return v2;
    }

    public V remove(Object obj) {
        D b = b(obj);
        return b != null ? b.g : null;
    }

    public int size() {
        return this.c;
    }
}
