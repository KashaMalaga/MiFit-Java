package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class aa {
    private static final int i = 2;
    final ArrayList<aj> a = new ArrayList();
    final ArrayList<aj> b = new ArrayList();
    final /* synthetic */ RecyclerView c;
    private ArrayList<aj> d = null;
    private final List<aj> e = Collections.unmodifiableList(this.a);
    private int f = i;
    private Z g;
    private ah h;

    public aa(RecyclerView recyclerView) {
        this.c = recyclerView;
    }

    private void a(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int visibility = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(visibility);
    }

    private void e(aj ajVar) {
        if (ajVar.a instanceof ViewGroup) {
            a((ViewGroup) ajVar.a, false);
        }
    }

    private void e(View view) {
        if (this.c.P != null && this.c.P.isEnabled()) {
            if (C0151az.e(view) == 0) {
                C0151az.d(view, 1);
            }
            if (!C0151az.b(view)) {
                C0151az.a(view, this.c.ao.b());
            }
        }
    }

    aj a(int i, int i2, boolean z) {
        View a;
        int i3 = 0;
        int size = this.a.size();
        int i4 = 0;
        while (i4 < size) {
            aj ajVar = (aj) this.a.get(i4);
            if (ajVar.j() || ajVar.d() != i || ajVar.n() || (!this.c.p.j && ajVar.r())) {
                i4++;
            } else if (i2 == -1 || ajVar.g() == i2) {
                ajVar.a(32);
                return ajVar;
            } else {
                Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + ajVar.g() + " but expected " + i2 + ")");
                if (!z) {
                    a = this.c.j.a(i, i2);
                    if (a != null) {
                        this.c.l.c(this.c.a(a));
                    }
                }
                i4 = this.b.size();
                while (i3 < i4) {
                    ajVar = (aj) this.b.get(i3);
                    if (ajVar.n() || ajVar.d() != i) {
                        i3++;
                    } else if (z) {
                        return ajVar;
                    } else {
                        this.b.remove(i3);
                        return ajVar;
                    }
                }
                return null;
            }
        }
        if (z) {
            a = this.c.j.a(i, i2);
            if (a != null) {
                this.c.l.c(this.c.a(a));
            }
        }
        i4 = this.b.size();
        while (i3 < i4) {
            ajVar = (aj) this.b.get(i3);
            if (ajVar.n()) {
            }
            i3++;
        }
        return null;
    }

    aj a(long j, int i, boolean z) {
        int size;
        for (size = this.a.size() - 1; size >= 0; size--) {
            aj ajVar = (aj) this.a.get(size);
            if (ajVar.f() == j && !ajVar.j()) {
                if (i == ajVar.g()) {
                    ajVar.a(32);
                    if (!ajVar.r() || this.c.p.b()) {
                        return ajVar;
                    }
                    ajVar.a((int) i, 14);
                    return ajVar;
                } else if (!z) {
                    this.a.remove(size);
                    this.c.removeDetachedView(ajVar.a, false);
                    c(ajVar.a);
                }
            }
        }
        for (size = this.b.size() - 1; size >= 0; size--) {
            ajVar = (aj) this.b.get(size);
            if (ajVar.f() == j) {
                if (i == ajVar.g()) {
                    if (z) {
                        return ajVar;
                    }
                    this.b.remove(size);
                    return ajVar;
                } else if (!z) {
                    d(size);
                }
            }
        }
        return null;
    }

    View a(int i, boolean z) {
        boolean z2 = true;
        if (i < 0 || i >= this.c.p.h()) {
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.c.p.h());
        }
        boolean z3;
        aj ajVar;
        boolean z4;
        int a;
        aj ajVar2;
        boolean z5;
        LayoutParams layoutParams;
        RecyclerView.LayoutParams layoutParams2;
        if (this.c.p.b()) {
            aj f = f(i);
            aj ajVar3 = f;
            z3 = f != null;
            ajVar = ajVar3;
        } else {
            ajVar = null;
            z3 = false;
        }
        if (ajVar == null) {
            ajVar = a(i, -1, z);
            if (ajVar != null) {
                if (a(ajVar)) {
                    z4 = true;
                } else {
                    if (!z) {
                        ajVar.a(4);
                        if (ajVar.h()) {
                            this.c.removeDetachedView(ajVar.a, false);
                            ajVar.i();
                        } else if (ajVar.j()) {
                            ajVar.k();
                        }
                        b(ajVar);
                    }
                    ajVar = null;
                    z4 = z3;
                }
                if (ajVar == null) {
                    a = this.c.i.a(i);
                    if (a >= 0 || a >= this.c.C.a()) {
                        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.c.p.h());
                    }
                    int a2 = this.c.C.a(a);
                    if (this.c.C.b()) {
                        ajVar = a(this.c.C.b(a), a2, z);
                        if (ajVar != null) {
                            ajVar.b = a;
                            z4 = true;
                        }
                    }
                    if (ajVar == null && this.h != null) {
                        View a3 = this.h.a(this, i, a2);
                        if (a3 != null) {
                            ajVar = this.c.a(a3);
                            if (ajVar == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                            } else if (ajVar.c()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                            }
                        }
                    }
                    if (ajVar == null) {
                        ajVar = f().a(this.c.C.a(a));
                        if (ajVar != null) {
                            ajVar.t();
                            if (RecyclerView.u) {
                                e(ajVar);
                            }
                        }
                    }
                    if (ajVar == null) {
                        ajVar = this.c.C.b(this.c, this.c.C.a(a));
                        z3 = z4;
                        ajVar2 = ajVar;
                        if (!this.c.p.b() && ajVar2.q()) {
                            ajVar2.f = i;
                            z5 = false;
                        } else if (ajVar2.q() || ajVar2.o() || ajVar2.n()) {
                            this.c.C.b(ajVar2, this.c.i.a(i));
                            e(ajVar2.a);
                            if (this.c.p.b()) {
                                ajVar2.f = i;
                            }
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        layoutParams = ajVar2.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
                            ajVar2.a.setLayoutParams(layoutParams2);
                        } else if (this.c.checkLayoutParams(layoutParams)) {
                            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                        } else {
                            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
                            ajVar2.a.setLayoutParams(layoutParams2);
                        }
                        layoutParams2.b = ajVar2;
                        if (!(z3 && r5)) {
                            z2 = false;
                        }
                        layoutParams2.e = z2;
                        return ajVar2.a;
                    }
                }
                z3 = z4;
                ajVar2 = ajVar;
                if (!this.c.p.b()) {
                }
                if (ajVar2.q()) {
                }
                this.c.C.b(ajVar2, this.c.i.a(i));
                e(ajVar2.a);
                if (this.c.p.b()) {
                    ajVar2.f = i;
                }
                z5 = true;
                layoutParams = ajVar2.a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
                    ajVar2.a.setLayoutParams(layoutParams2);
                } else if (this.c.checkLayoutParams(layoutParams)) {
                    layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                } else {
                    layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
                    ajVar2.a.setLayoutParams(layoutParams2);
                }
                layoutParams2.b = ajVar2;
                z2 = false;
                layoutParams2.e = z2;
                return ajVar2.a;
            }
        }
        z4 = z3;
        if (ajVar == null) {
            a = this.c.i.a(i);
            if (a >= 0) {
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.c.p.h());
        }
        z3 = z4;
        ajVar2 = ajVar;
        if (!this.c.p.b()) {
        }
        if (ajVar2.q()) {
        }
        this.c.C.b(ajVar2, this.c.i.a(i));
        e(ajVar2.a);
        if (this.c.p.b()) {
            ajVar2.f = i;
        }
        z5 = true;
        layoutParams = ajVar2.a.getLayoutParams();
        if (layoutParams != null) {
            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
            ajVar2.a.setLayoutParams(layoutParams2);
        } else if (this.c.checkLayoutParams(layoutParams)) {
            layoutParams2 = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams);
            ajVar2.a.setLayoutParams(layoutParams2);
        } else {
            layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        }
        layoutParams2.b = ajVar2;
        z2 = false;
        layoutParams2.e = z2;
        return ajVar2.a;
    }

    public void a() {
        this.a.clear();
        c();
    }

    public void a(int i) {
        this.f = i;
        for (int size = this.b.size() - 1; size >= 0 && this.b.size() > i; size--) {
            d(size);
        }
        while (this.b.size() > i) {
            this.b.remove(this.b.size() - 1);
        }
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.b.size();
        for (int i6 = 0; i6 < size; i6++) {
            aj ajVar = (aj) this.b.get(i6);
            if (ajVar != null && ajVar.b >= r3 && ajVar.b <= r2) {
                if (ajVar.b == i) {
                    ajVar.a(i2 - i, false);
                } else {
                    ajVar.a(i3, false);
                }
            }
        }
    }

    void a(N n, N n2, boolean z) {
        a();
        f().a(n, n2, z);
    }

    void a(Z z) {
        if (this.g != null) {
            this.g.c();
        }
        this.g = z;
        if (z != null) {
            this.g.a(this.c.d());
        }
    }

    void a(ah ahVar) {
        this.h = ahVar;
    }

    public void a(View view) {
        aj b = RecyclerView.b(view);
        if (b.s()) {
            this.c.removeDetachedView(view, false);
        }
        if (b.h()) {
            b.i();
        } else if (b.j()) {
            b.k();
        }
        b(b);
    }

    public void a(View view, int i) {
        boolean z = true;
        aj b = RecyclerView.b(view);
        if (b == null) {
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
        }
        int a = this.c.i.a(i);
        if (a < 0 || a >= this.c.C.a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + a + ")." + "state:" + this.c.p.h());
        }
        RecyclerView.LayoutParams layoutParams;
        this.c.C.b(b, a);
        e(view);
        if (this.c.p.b()) {
            b.f = i;
        }
        LayoutParams layoutParams2 = b.a.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = (RecyclerView.LayoutParams) this.c.generateDefaultLayoutParams();
            b.a.setLayoutParams(layoutParams);
        } else if (this.c.checkLayoutParams(layoutParams2)) {
            layoutParams = (RecyclerView.LayoutParams) layoutParams2;
        } else {
            layoutParams = (RecyclerView.LayoutParams) this.c.generateLayoutParams(layoutParams2);
            b.a.setLayoutParams(layoutParams);
        }
        layoutParams.d = true;
        layoutParams.b = b;
        if (b.a.getParent() != null) {
            z = false;
        }
        layoutParams.e = z;
    }

    boolean a(aj ajVar) {
        if (ajVar.r()) {
            return true;
        }
        if (ajVar.b >= 0 && ajVar.b < this.c.C.a()) {
            return (this.c.p.b() || this.c.C.a(ajVar.b) == ajVar.g()) ? !this.c.C.b() || ajVar.f() == this.c.C.b(ajVar.b) : false;
        } else {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + ajVar);
        }
    }

    public int b(int i) {
        if (i >= 0 && i < this.c.p.h()) {
            return !this.c.p.b() ? i : this.c.i.a(i);
        } else {
            throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.c.p.h());
        }
    }

    public List<aj> b() {
        return this.e;
    }

    void b(int i, int i2) {
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            aj ajVar = (aj) this.b.get(i3);
            if (ajVar != null && ajVar.d() >= i) {
                ajVar.a(i2, true);
            }
        }
    }

    void b(int i, int i2, boolean z) {
        int i3 = i + i2;
        int size = this.b.size() - 1;
        while (size >= 0) {
            aj ajVar = (aj) this.b.get(size);
            if (ajVar != null) {
                if (ajVar.d() >= i3) {
                    ajVar.a(-i2, z);
                } else if (ajVar.d() >= i && !d(size)) {
                    ajVar.a(4);
                }
            }
            size--;
        }
    }

    void b(aj ajVar) {
        boolean z = true;
        boolean z2 = false;
        if (ajVar.h() || ajVar.a.getParent() != null) {
            StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(ajVar.h()).append(" isAttached:");
            if (ajVar.a.getParent() == null) {
                z = false;
            }
            throw new IllegalArgumentException(append.append(z).toString());
        } else if (ajVar.s()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + ajVar);
        } else if (ajVar.c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        } else {
            if (ajVar.u()) {
                if (!ajVar.n() && ((this.c.p.j || !ajVar.r()) && !ajVar.p())) {
                    if (this.b.size() == this.f && !this.b.isEmpty()) {
                        int i = 0;
                        while (i < this.b.size() && !d(i)) {
                            i++;
                        }
                    }
                    if (this.b.size() < this.f) {
                        this.b.add(ajVar);
                        z2 = true;
                    }
                }
                if (!z2) {
                    f().a(ajVar);
                    d(ajVar);
                }
            }
            this.c.p.a(ajVar);
        }
    }

    void b(View view) {
        b(RecyclerView.b(view));
    }

    public View c(int i) {
        return a(i, false);
    }

    void c() {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            d(size);
        }
        this.b.clear();
    }

    void c(int i, int i2) {
        int i3 = i + i2;
        int size = this.b.size();
        for (int i4 = 0; i4 < size; i4++) {
            aj ajVar = (aj) this.b.get(i4);
            if (ajVar != null) {
                int d = ajVar.d();
                if (d >= i && d < i3) {
                    ajVar.a((int) i);
                }
            }
        }
    }

    void c(aj ajVar) {
        if (ajVar.p() && this.c.D() && this.d != null) {
            this.d.remove(ajVar);
        } else {
            this.a.remove(ajVar);
        }
        ajVar.t = null;
        ajVar.k();
    }

    void c(View view) {
        aj b = RecyclerView.b(view);
        b.t = null;
        b.k();
        b(b);
    }

    int d() {
        return this.a.size();
    }

    void d(aj ajVar) {
        if (this.c.E != null) {
            this.c.E.a(ajVar);
        }
        if (this.c.C != null) {
            this.c.C.a(ajVar);
        }
        if (this.c.p != null) {
            this.c.p.a(ajVar);
        }
    }

    void d(View view) {
        aj b = RecyclerView.b(view);
        b.a(this);
        if (b.p() && this.c.D()) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(b);
        } else if (!b.n() || b.r() || this.c.C.b()) {
            this.a.add(b);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
    }

    boolean d(int i) {
        aj ajVar = (aj) this.b.get(i);
        if (!ajVar.u()) {
            return false;
        }
        f().a(ajVar);
        d(ajVar);
        this.b.remove(i);
        return true;
    }

    View e(int i) {
        return ((aj) this.a.get(i)).a;
    }

    void e() {
        this.a.clear();
    }

    Z f() {
        if (this.g == null) {
            this.g = new Z();
        }
        return this.g;
    }

    aj f(int i) {
        int i2 = 0;
        if (this.d != null) {
            int size = this.d.size();
            if (size != 0) {
                aj ajVar;
                int i3 = 0;
                while (i3 < size) {
                    ajVar = (aj) this.d.get(i3);
                    if (ajVar.j() || ajVar.d() != i) {
                        i3++;
                    } else {
                        ajVar.a(32);
                        return ajVar;
                    }
                }
                if (this.c.C.b()) {
                    int a = this.c.i.a(i);
                    if (a > 0 && a < this.c.C.a()) {
                        long b = this.c.C.b(a);
                        while (i2 < size) {
                            ajVar = (aj) this.d.get(i2);
                            if (ajVar.j() || ajVar.f() != b) {
                                i2++;
                            } else {
                                ajVar.a(32);
                                return ajVar;
                            }
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    void g() {
        int size;
        if (this.c.C == null || !this.c.C.b()) {
            for (size = this.b.size() - 1; size >= 0; size--) {
                if (!d(size)) {
                    ((aj) this.b.get(size)).a(6);
                }
            }
            return;
        }
        int size2 = this.b.size();
        for (size = 0; size < size2; size++) {
            aj ajVar = (aj) this.b.get(size);
            if (ajVar != null) {
                ajVar.a(6);
            }
        }
    }

    void h() {
        int i;
        int i2 = 0;
        int size = this.b.size();
        for (i = 0; i < size; i++) {
            ((aj) this.b.get(i)).a();
        }
        size = this.a.size();
        for (i = 0; i < size; i++) {
            ((aj) this.a.get(i)).a();
        }
        if (this.d != null) {
            i = this.d.size();
            while (i2 < i) {
                ((aj) this.d.get(i2)).a();
                i2++;
            }
        }
    }

    void i() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((aj) this.b.get(i)).a.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.d = true;
            }
        }
    }
}
