package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v4.view.bK;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0261g extends Q {
    private static final boolean a = false;
    private ArrayList<aj> b = new ArrayList();
    private ArrayList<aj> c = new ArrayList();
    private ArrayList<C0272q> d = new ArrayList();
    private ArrayList<C0271p> e = new ArrayList();
    private ArrayList<ArrayList<aj>> f = new ArrayList();
    private ArrayList<ArrayList<C0272q>> g = new ArrayList();
    private ArrayList<ArrayList<C0271p>> h = new ArrayList();
    private ArrayList<aj> i = new ArrayList();
    private ArrayList<aj> j = new ArrayList();
    private ArrayList<aj> k = new ArrayList();
    private ArrayList<aj> l = new ArrayList();

    private void a(C0271p c0271p) {
        View view = null;
        aj ajVar = c0271p.a;
        View view2 = ajVar == null ? null : ajVar.a;
        aj ajVar2 = c0271p.b;
        if (ajVar2 != null) {
            view = ajVar2.a;
        }
        if (view2 != null) {
            this.l.add(c0271p.a);
            bK a = C0151az.y(view2).a(g());
            a.c((float) (c0271p.e - c0271p.c));
            a.d((float) (c0271p.f - c0271p.d));
            a.a(0.0f).a(new C0269n(this, c0271p, a)).start();
        }
        if (view != null) {
            this.l.add(c0271p.b);
            a = C0151az.y(view);
            a.c(0.0f).d(0.0f).a(g()).a(1.0f).a(new C0270o(this, c0271p, a, view)).start();
        }
    }

    private void a(List<C0271p> list, aj ajVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0271p c0271p = (C0271p) list.get(size);
            if (a(c0271p, ajVar) && c0271p.a == null && c0271p.b == null) {
                list.remove(c0271p);
            }
        }
    }

    private boolean a(C0271p c0271p, aj ajVar) {
        boolean z = false;
        if (c0271p.b == ajVar) {
            c0271p.b = null;
        } else if (c0271p.a != ajVar) {
            return false;
        } else {
            c0271p.a = null;
            z = true;
        }
        C0151az.c(ajVar.a, 1.0f);
        C0151az.a(ajVar.a, 0.0f);
        C0151az.b(ajVar.a, 0.0f);
        a(ajVar, z);
        return true;
    }

    private void b(aj ajVar, int i, int i2, int i3, int i4) {
        View view = ajVar.a;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            C0151az.y(view).c(0.0f);
        }
        if (i6 != 0) {
            C0151az.y(view).d(0.0f);
        }
        this.j.add(ajVar);
        bK y = C0151az.y(view);
        y.a(d()).a(new C0268m(this, ajVar, i5, i6, y)).start();
    }

    private void b(C0271p c0271p) {
        if (c0271p.a != null) {
            a(c0271p, c0271p.a);
        }
        if (c0271p.b != null) {
            a(c0271p, c0271p.b);
        }
    }

    private void j() {
        if (!b()) {
            i();
        }
    }

    private void p(aj ajVar) {
        bK y = C0151az.y(ajVar.a);
        y.a(f()).a(0.0f).a(new C0266k(this, ajVar, y)).start();
        this.k.add(ajVar);
    }

    private void q(aj ajVar) {
        View view = ajVar.a;
        this.i.add(ajVar);
        bK y = C0151az.y(view);
        y.a(1.0f).a(e()).a(new C0267l(this, ajVar, y)).start();
    }

    public void a() {
        int i = !this.b.isEmpty() ? 1 : 0;
        int i2 = !this.d.isEmpty() ? 1 : 0;
        int i3 = !this.e.isEmpty() ? 1 : 0;
        int i4 = !this.c.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c0262h;
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                p((aj) it.next());
            }
            this.b.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.d);
                this.g.add(arrayList);
                this.d.clear();
                c0262h = new C0262h(this, arrayList);
                if (i != 0) {
                    C0151az.a(((C0272q) arrayList.get(0)).a.a, c0262h, f());
                } else {
                    c0262h.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.e);
                this.h.add(arrayList);
                this.e.clear();
                c0262h = new C0263i(this, arrayList);
                if (i != 0) {
                    C0151az.a(((C0271p) arrayList.get(0)).a.a, c0262h, f());
                } else {
                    c0262h.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.c);
                this.f.add(arrayList2);
                this.c.clear();
                Runnable c0264j = new C0264j(this, arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c0264j.run();
                } else {
                    C0151az.a(((aj) arrayList2.get(0)).a, c0264j, (i != 0 ? f() : 0) + Math.max(i2 != 0 ? d() : 0, i3 != 0 ? g() : 0));
                }
            }
        }
    }

    void a(List<aj> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0151az.y(((aj) list.get(size)).a).d();
        }
    }

    public boolean a(aj ajVar) {
        c(ajVar);
        this.b.add(ajVar);
        return true;
    }

    public boolean a(aj ajVar, int i, int i2, int i3, int i4) {
        View view = ajVar.a;
        int u = (int) (((float) i) + C0151az.u(ajVar.a));
        int v = (int) (((float) i2) + C0151az.v(ajVar.a));
        c(ajVar);
        int i5 = i3 - u;
        int i6 = i4 - v;
        if (i5 == 0 && i6 == 0) {
            e(ajVar);
            return false;
        }
        if (i5 != 0) {
            C0151az.a(view, (float) (-i5));
        }
        if (i6 != 0) {
            C0151az.b(view, (float) (-i6));
        }
        this.d.add(new C0272q(ajVar, u, v, i3, i4));
        return true;
    }

    public boolean a(aj ajVar, aj ajVar2, int i, int i2, int i3, int i4) {
        float u = C0151az.u(ajVar.a);
        float v = C0151az.v(ajVar.a);
        float g = C0151az.g(ajVar.a);
        c(ajVar);
        int i5 = (int) (((float) (i3 - i)) - u);
        int i6 = (int) (((float) (i4 - i2)) - v);
        C0151az.a(ajVar.a, u);
        C0151az.b(ajVar.a, v);
        C0151az.c(ajVar.a, g);
        if (!(ajVar2 == null || ajVar2.a == null)) {
            c(ajVar2);
            C0151az.a(ajVar2.a, (float) (-i5));
            C0151az.b(ajVar2.a, (float) (-i6));
            C0151az.c(ajVar2.a, 0.0f);
        }
        this.e.add(new C0271p(ajVar, ajVar2, i, i2, i3, i4));
        return true;
    }

    public boolean b() {
        return (this.c.isEmpty() && this.e.isEmpty() && this.d.isEmpty() && this.b.isEmpty() && this.j.isEmpty() && this.k.isEmpty() && this.i.isEmpty() && this.l.isEmpty() && this.g.isEmpty() && this.f.isEmpty() && this.h.isEmpty()) ? false : true;
    }

    public boolean b(aj ajVar) {
        c(ajVar);
        C0151az.c(ajVar.a, 0.0f);
        this.c.add(ajVar);
        return true;
    }

    public void c() {
        int size;
        for (size = this.d.size() - 1; size >= 0; size--) {
            C0272q c0272q = (C0272q) this.d.get(size);
            View view = c0272q.a.a;
            C0151az.b(view, 0.0f);
            C0151az.a(view, 0.0f);
            e(c0272q.a);
            this.d.remove(size);
        }
        for (size = this.b.size() - 1; size >= 0; size--) {
            d((aj) this.b.get(size));
            this.b.remove(size);
        }
        for (size = this.c.size() - 1; size >= 0; size--) {
            aj ajVar = (aj) this.c.get(size);
            C0151az.c(ajVar.a, 1.0f);
            f(ajVar);
            this.c.remove(size);
        }
        for (size = this.e.size() - 1; size >= 0; size--) {
            b((C0271p) this.e.get(size));
        }
        this.e.clear();
        if (b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0272q c0272q2 = (C0272q) arrayList.get(size3);
                    View view2 = c0272q2.a.a;
                    C0151az.b(view2, 0.0f);
                    C0151az.a(view2, 0.0f);
                    e(c0272q2.a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    aj ajVar2 = (aj) arrayList.get(size3);
                    C0151az.c(ajVar2.a, 1.0f);
                    f(ajVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b((C0271p) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.h.remove(arrayList);
                    }
                }
            }
            a(this.k);
            a(this.j);
            a(this.i);
            a(this.l);
            i();
        }
    }

    public void c(aj ajVar) {
        int size;
        View view = ajVar.a;
        C0151az.y(view).d();
        for (size = this.d.size() - 1; size >= 0; size--) {
            if (((C0272q) this.d.get(size)).a == ajVar) {
                C0151az.b(view, 0.0f);
                C0151az.a(view, 0.0f);
                e(ajVar);
                this.d.remove(size);
            }
        }
        a(this.e, ajVar);
        if (this.b.remove(ajVar)) {
            C0151az.c(view, 1.0f);
            d(ajVar);
        }
        if (this.c.remove(ajVar)) {
            C0151az.c(view, 1.0f);
            f(ajVar);
        }
        for (size = this.h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.h.get(size);
            a(list, ajVar);
            if (list.isEmpty()) {
                this.h.remove(size);
            }
        }
        for (int size2 = this.g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0272q) arrayList.get(size3)).a == ajVar) {
                    C0151az.b(view, 0.0f);
                    C0151az.a(view, 0.0f);
                    e(ajVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f.get(size);
            if (arrayList.remove(ajVar)) {
                C0151az.c(view, 1.0f);
                f(ajVar);
                if (arrayList.isEmpty()) {
                    this.f.remove(size);
                }
            }
        }
        if (this.k.remove(ajVar)) {
        }
        if (this.i.remove(ajVar)) {
        }
        if (this.l.remove(ajVar)) {
        }
        if (this.j.remove(ajVar)) {
            j();
        } else {
            j();
        }
    }
}
