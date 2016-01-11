package com.e.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class C1038e extends C1034a {
    boolean b = false;
    private ArrayList<C1034a> c = new ArrayList();
    private HashMap<C1034a, C1044k> d = new HashMap();
    private ArrayList<C1044k> e = new ArrayList();
    private ArrayList<C1044k> f = new ArrayList();
    private boolean g = true;
    private C1040g h = null;
    private boolean i = false;
    private long j = 0;
    private R k = null;
    private long l = -1;

    private void n() {
        int size;
        C1044k c1044k;
        int i;
        if (this.g) {
            this.f.clear();
            ArrayList arrayList = new ArrayList();
            size = this.e.size();
            for (int i2 = 0; i2 < size; i2++) {
                c1044k = (C1044k) this.e.get(i2);
                if (c1044k.b == null || c1044k.b.size() == 0) {
                    arrayList.add(c1044k);
                }
            }
            Object arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (i = 0; i < size2; i++) {
                    c1044k = (C1044k) arrayList.get(i);
                    this.f.add(c1044k);
                    if (c1044k.e != null) {
                        int size3 = c1044k.e.size();
                        for (size = 0; size < size3; size++) {
                            C1044k c1044k2 = (C1044k) c1044k.e.get(size);
                            c1044k2.d.remove(c1044k);
                            if (c1044k2.d.size() == 0) {
                                arrayList2.add(c1044k2);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.g = false;
            if (this.f.size() != this.e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.e.size();
        for (i = 0; i < size4; i++) {
            c1044k = (C1044k) this.e.get(i);
            if (c1044k.b != null && c1044k.b.size() > 0) {
                int size5 = c1044k.b.size();
                for (size = 0; size < size5; size++) {
                    C1042i c1042i = (C1042i) c1044k.b.get(size);
                    if (c1044k.d == null) {
                        c1044k.d = new ArrayList();
                    }
                    if (!c1044k.d.contains(c1042i.c)) {
                        c1044k.d.add(c1042i.c);
                    }
                }
            }
            c1044k.f = false;
        }
    }

    public C1041h a(C1034a c1034a) {
        if (c1034a == null) {
            return null;
        }
        this.g = true;
        return new C1041h(this, c1034a);
    }

    public void a() {
        this.b = true;
        if (f()) {
            Iterator it;
            ArrayList arrayList;
            if (this.a != null) {
                ArrayList arrayList2 = (ArrayList) this.a.clone();
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C1035b) it.next()).c(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.k != null && this.k.e()) {
                this.k.a();
            } else if (this.f.size() > 0) {
                it = this.f.iterator();
                while (it.hasNext()) {
                    ((C1044k) it.next()).a.a();
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((C1035b) it2.next()).b(this);
                }
            }
            this.i = false;
        }
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(Interpolator interpolator) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((C1044k) it.next()).a.a(interpolator);
        }
    }

    public void a(Object obj) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            C1034a c1034a = ((C1044k) it.next()).a;
            if (c1034a instanceof C1038e) {
                ((C1038e) c1034a).a(obj);
            } else if (c1034a instanceof C1055v) {
                ((C1055v) c1034a).a(obj);
            }
        }
    }

    public void a(Collection<C1034a> collection) {
        if (collection != null && collection.size() > 0) {
            this.g = true;
            C1041h c1041h = null;
            for (C1034a c1034a : collection) {
                if (c1041h == null) {
                    c1041h = a(c1034a);
                } else {
                    c1041h.a(c1034a);
                }
            }
        }
    }

    public void a(List<C1034a> list) {
        if (list != null && list.size() > 0) {
            this.g = true;
            if (list.size() == 1) {
                a((C1034a) list.get(0));
                return;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                a((C1034a) list.get(i)).b((C1034a) list.get(i + 1));
            }
        }
    }

    public void a(C1034a... c1034aArr) {
        int i = 1;
        if (c1034aArr != null) {
            this.g = true;
            C1041h a = a(c1034aArr[0]);
            while (i < c1034aArr.length) {
                a.a(c1034aArr[i]);
                i++;
            }
        }
    }

    public /* synthetic */ C1034a b(long j) {
        return c(j);
    }

    public void b() {
        this.b = true;
        if (f()) {
            Iterator it;
            if (this.f.size() != this.e.size()) {
                n();
                it = this.f.iterator();
                while (it.hasNext()) {
                    C1044k c1044k = (C1044k) it.next();
                    if (this.h == null) {
                        this.h = new C1040g(this, this);
                    }
                    c1044k.a.a(this.h);
                }
            }
            if (this.k != null) {
                this.k.a();
            }
            if (this.f.size() > 0) {
                it = this.f.iterator();
                while (it.hasNext()) {
                    ((C1044k) it.next()).a.b();
                }
            }
            if (this.a != null) {
                it = ((ArrayList) this.a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1035b) it.next()).b(this);
                }
            }
            this.i = false;
        }
    }

    public void b(C1034a... c1034aArr) {
        int i = 0;
        if (c1034aArr != null) {
            this.g = true;
            if (c1034aArr.length == 1) {
                a(c1034aArr[0]);
                return;
            }
            while (i < c1034aArr.length - 1) {
                a(c1034aArr[i]).b(c1034aArr[i + 1]);
                i++;
            }
        }
    }

    public long c() {
        return this.j;
    }

    public C1038e c(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((C1044k) it.next()).a.b(j);
        }
        this.l = j;
        return this;
    }

    public long d() {
        return this.l;
    }

    public boolean e() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if (((C1044k) it.next()).a.e()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.i;
    }

    public /* synthetic */ C1034a i() {
        return m();
    }

    public void j() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((C1044k) it.next()).a.j();
        }
    }

    public void k() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((C1044k) it.next()).a.k();
        }
    }

    public ArrayList<C1034a> l() {
        ArrayList<C1034a> arrayList = new ArrayList();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(((C1044k) it.next()).a);
        }
        return arrayList;
    }

    public C1038e m() {
        C1038e c1038e = (C1038e) super.i();
        c1038e.g = true;
        c1038e.b = false;
        c1038e.i = false;
        c1038e.c = new ArrayList();
        c1038e.d = new HashMap();
        c1038e.e = new ArrayList();
        c1038e.f = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            C1044k c1044k = (C1044k) it.next();
            C1044k a = c1044k.a();
            hashMap.put(c1044k, a);
            c1038e.e.add(a);
            c1038e.d.put(a.a, a);
            a.b = null;
            a.c = null;
            a.e = null;
            a.d = null;
            ArrayList g = a.a.g();
            if (g != null) {
                Iterator it2 = g.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    C1035b c1035b = (C1035b) it2.next();
                    if (c1035b instanceof C1040g) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c1035b);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        g.remove((C1035b) it3.next());
                    }
                }
            }
        }
        it = this.e.iterator();
        while (it.hasNext()) {
            c1044k = (C1044k) it.next();
            a = (C1044k) hashMap.get(c1044k);
            if (c1044k.b != null) {
                Iterator it4 = c1044k.b.iterator();
                while (it4.hasNext()) {
                    C1042i c1042i = (C1042i) it4.next();
                    a.a(new C1042i((C1044k) hashMap.get(c1042i.c), c1042i.d));
                }
            }
        }
        return c1038e;
    }

    public void start() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.b = false;
        this.i = true;
        n();
        int size = this.f.size();
        for (i = 0; i < size; i++) {
            C1044k c1044k = (C1044k) this.f.get(i);
            Collection g = c1044k.a.g();
            if (g != null && g.size() > 0) {
                Iterator it = new ArrayList(g).iterator();
                while (it.hasNext()) {
                    C1035b c1035b = (C1035b) it.next();
                    if ((c1035b instanceof C1043j) || (c1035b instanceof C1040g)) {
                        c1044k.a.b(c1035b);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            c1044k = (C1044k) this.f.get(i2);
            if (this.h == null) {
                this.h = new C1040g(this, this);
            }
            if (c1044k.b == null || c1044k.b.size() == 0) {
                arrayList2.add(c1044k);
            } else {
                int size2 = c1044k.b.size();
                for (i = 0; i < size2; i++) {
                    C1042i c1042i = (C1042i) c1044k.b.get(i);
                    c1042i.c.a.a(new C1043j(this, c1044k, c1042i.d));
                }
                c1044k.c = (ArrayList) c1044k.b.clone();
            }
            c1044k.a.a(this.h);
        }
        if (this.j <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c1044k = (C1044k) it2.next();
                c1044k.a.start();
                this.c.add(c1044k.a);
            }
        } else {
            this.k = R.b(0.0f, 1.0f);
            this.k.d(this.j);
            this.k.a(new C1039f(this, arrayList2));
            this.k.start();
        }
        if (this.a != null) {
            arrayList = (ArrayList) this.a.clone();
            i2 = arrayList.size();
            for (i = 0; i < i2; i++) {
                ((C1035b) arrayList.get(i)).a(this);
            }
        }
        if (this.e.size() == 0 && this.j == 0) {
            this.i = false;
            if (this.a != null) {
                arrayList = (ArrayList) this.a.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((C1035b) arrayList.get(i3)).b(this);
                    i3++;
                }
            }
        }
    }
}
