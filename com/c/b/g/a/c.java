package com.c.b.g.a;

import com.c.b.u;

public final class c {
    private final int a;
    private final int[] b;
    private final u[] c;

    public c(int i, int[] iArr, int i2, int i3, int i4) {
        this.a = i;
        this.b = iArr;
        this.c = new u[]{new u((float) i2, (float) i4), new u((float) i3, (float) i4)};
    }

    public int a() {
        return this.a;
    }

    public int[] b() {
        return this.b;
    }

    public u[] c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
