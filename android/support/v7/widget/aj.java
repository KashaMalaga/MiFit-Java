package android.support.v7.widget;

import android.support.v4.view.C0151az;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.Log;
import android.view.View;

public abstract class aj {
    static final int i = 1;
    static final int j = 2;
    static final int k = 4;
    static final int l = 8;
    static final int m = 16;
    static final int n = 32;
    static final int o = 64;
    static final int p = 128;
    static final int q = 256;
    public final View a;
    int b = -1;
    int c = -1;
    long d = -1;
    int e = -1;
    int f = -1;
    aj g = null;
    aj h = null;
    private int r;
    private int s = 0;
    private aa t = null;

    public aj(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.a = view;
    }

    void a() {
        this.c = -1;
        this.f = -1;
    }

    void a(int i) {
        this.r |= i;
    }

    void a(int i, int i2) {
        this.r = (this.r & (i2 ^ -1)) | (i & i2);
    }

    void a(int i, int i2, boolean z) {
        a((int) l);
        a(i2, z);
        this.b = i;
    }

    void a(int i, boolean z) {
        if (this.c == -1) {
            this.c = this.b;
        }
        if (this.f == -1) {
            this.f = this.b;
        }
        if (z) {
            this.f += i;
        }
        this.b += i;
        if (this.a.getLayoutParams() != null) {
            ((LayoutParams) this.a.getLayoutParams()).d = true;
        }
    }

    void a(aa aaVar) {
        this.t = aaVar;
    }

    public final void a(boolean z) {
        this.s = z ? this.s - 1 : this.s + i;
        if (this.s < 0) {
            this.s = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && this.s == i) {
            this.r |= m;
        } else if (z && this.s == 0) {
            this.r &= -17;
        }
    }

    void b() {
        if (this.c == -1) {
            this.c = this.b;
        }
    }

    boolean c() {
        return (this.r & p) != 0;
    }

    public final int d() {
        return this.f == -1 ? this.b : this.f;
    }

    public final int e() {
        return this.c;
    }

    public final long f() {
        return this.d;
    }

    public final int g() {
        return this.e;
    }

    boolean h() {
        return this.t != null;
    }

    void i() {
        this.t.c(this);
    }

    boolean j() {
        return (this.r & n) != 0;
    }

    void k() {
        this.r &= -33;
    }

    void l() {
        this.r &= -257;
    }

    void m() {
        this.r &= -129;
    }

    boolean n() {
        return (this.r & k) != 0;
    }

    boolean o() {
        return (this.r & j) != 0;
    }

    boolean p() {
        return (this.r & o) != 0;
    }

    boolean q() {
        return (this.r & i) != 0;
    }

    boolean r() {
        return (this.r & l) != 0;
    }

    boolean s() {
        return (this.r & q) != 0;
    }

    void t() {
        this.r = 0;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = -1;
        this.s = 0;
        this.g = null;
        this.h = null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
        if (h()) {
            stringBuilder.append(" scrap");
        }
        if (n()) {
            stringBuilder.append(" invalid");
        }
        if (!q()) {
            stringBuilder.append(" unbound");
        }
        if (o()) {
            stringBuilder.append(" update");
        }
        if (r()) {
            stringBuilder.append(" removed");
        }
        if (c()) {
            stringBuilder.append(" ignored");
        }
        if (p()) {
            stringBuilder.append(" changed");
        }
        if (s()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!u()) {
            stringBuilder.append(" not recyclable(" + this.s + ")");
        }
        if (this.a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final boolean u() {
        return (this.r & m) == 0 && !C0151az.c(this.a);
    }
}
