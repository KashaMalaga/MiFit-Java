package com.e.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

class C1047u {
    int a;
    C1051q b;
    C1051q c;
    Interpolator d;
    ArrayList<C1051q> e = new ArrayList();
    Q f;

    public C1047u(C1051q... c1051qArr) {
        this.a = c1051qArr.length;
        this.e.addAll(Arrays.asList(c1051qArr));
        this.b = (C1051q) this.e.get(0);
        this.c = (C1051q) this.e.get(this.a - 1);
        this.d = this.c.d();
    }

    public static C1047u a(float... fArr) {
        int i = 1;
        int length = fArr.length;
        C1052r[] c1052rArr = new C1052r[Math.max(length, 2)];
        if (length == 1) {
            c1052rArr[0] = (C1052r) C1051q.b(0.0f);
            c1052rArr[1] = (C1052r) C1051q.a(1.0f, fArr[0]);
        } else {
            c1052rArr[0] = (C1052r) C1051q.a(0.0f, fArr[0]);
            while (i < length) {
                c1052rArr[i] = (C1052r) C1051q.a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        return new C1048n(c1052rArr);
    }

    public static C1047u a(int... iArr) {
        int i = 1;
        int length = iArr.length;
        C1053s[] c1053sArr = new C1053s[Math.max(length, 2)];
        if (length == 1) {
            c1053sArr[0] = (C1053s) C1051q.a(0.0f);
            c1053sArr[1] = (C1053s) C1051q.a(1.0f, iArr[0]);
        } else {
            c1053sArr[0] = (C1053s) C1051q.a(0.0f, iArr[0]);
            while (i < length) {
                c1053sArr[i] = (C1053s) C1051q.a(((float) i) / ((float) (length - 1)), iArr[i]);
                i++;
            }
        }
        return new C1050p(c1053sArr);
    }

    public static C1047u a(C1051q... c1051qArr) {
        int i = 0;
        int length = c1051qArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (c1051qArr[i5] instanceof C1052r) {
                i4 = 1;
            } else if (c1051qArr[i5] instanceof C1053s) {
                i3 = 1;
            } else {
                i2 = 1;
            }
        }
        if (i4 != 0 && i3 == 0 && r0 == 0) {
            C1052r[] c1052rArr = new C1052r[length];
            while (i < length) {
                c1052rArr[i] = (C1052r) c1051qArr[i];
                i++;
            }
            return new C1048n(c1052rArr);
        } else if (i3 == 0 || i4 != 0 || r0 != 0) {
            return new C1047u(c1051qArr);
        } else {
            C1053s[] c1053sArr = new C1053s[length];
            for (int i6 = 0; i6 < length; i6++) {
                c1053sArr[i6] = (C1053s) c1051qArr[i6];
            }
            return new C1050p(c1053sArr);
        }
    }

    public static C1047u a(Object... objArr) {
        int i = 1;
        int length = objArr.length;
        C1051q[] c1051qArr = new C1054t[Math.max(length, 2)];
        if (length == 1) {
            c1051qArr[0] = (C1054t) C1051q.c(0.0f);
            c1051qArr[1] = (C1054t) C1051q.a(1.0f, objArr[0]);
        } else {
            c1051qArr[0] = (C1054t) C1051q.a(0.0f, objArr[0]);
            while (i < length) {
                c1051qArr[i] = (C1054t) C1051q.a(((float) i) / ((float) (length - 1)), objArr[i]);
                i++;
            }
        }
        return new C1047u(c1051qArr);
    }

    public Object a(float f) {
        if (this.a == 2) {
            if (this.d != null) {
                f = this.d.getInterpolation(f);
            }
            return this.f.a(f, this.b.b(), this.c.b());
        } else if (f <= 0.0f) {
            r0 = (C1051q) this.e.get(1);
            r1 = r0.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = this.b.c();
            return this.f.a((f - r1) / (r0.c() - r1), this.b.b(), r0.b());
        } else if (f >= 1.0f) {
            r0 = (C1051q) this.e.get(this.a - 2);
            r1 = this.c.d();
            if (r1 != null) {
                f = r1.getInterpolation(f);
            }
            r1 = r0.c();
            return this.f.a((f - r1) / (this.c.c() - r1), r0.b(), this.c.b());
        } else {
            C1051q c1051q = this.b;
            int i = 1;
            while (i < this.a) {
                r0 = (C1051q) this.e.get(i);
                if (f < r0.c()) {
                    r1 = r0.d();
                    if (r1 != null) {
                        f = r1.getInterpolation(f);
                    }
                    r1 = c1051q.c();
                    return this.f.a((f - r1) / (r0.c() - r1), c1051q.b(), r0.b());
                }
                i++;
                c1051q = r0;
            }
            return this.c.b();
        }
    }

    public void a(Q q) {
        this.f = q;
    }

    public C1047u b() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        C1051q[] c1051qArr = new C1051q[size];
        for (int i = 0; i < size; i++) {
            c1051qArr[i] = ((C1051q) arrayList.get(i)).f();
        }
        return new C1047u(c1051qArr);
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.a) {
            String stringBuilder = new StringBuilder(String.valueOf(str)).append(((C1051q) this.e.get(i)).b()).append("  ").toString();
            i++;
            str = stringBuilder;
        }
        return str;
    }
}
