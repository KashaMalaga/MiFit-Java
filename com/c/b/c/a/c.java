package com.c.b.c.a;

import com.c.b.c.b;
import com.c.b.n;
import com.c.b.u;

public final class c {
    private static final int a = 10;
    private static final int b = 1;
    private final b c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public c(b bVar) {
        this(bVar, a, bVar.f() / 2, bVar.g() / 2);
    }

    public c(b bVar, int i, int i2, int i3) {
        this.c = bVar;
        this.d = bVar.g();
        this.e = bVar.f();
        int i4 = i / 2;
        this.f = i2 - i4;
        this.g = i2 + i4;
        this.i = i3 - i4;
        this.h = i4 + i3;
        if (this.i < 0 || this.f < 0 || this.h >= this.d || this.g >= this.e) {
            throw n.a();
        }
    }

    private u a(float f, float f2, float f3, float f4) {
        int a = a.a(a.a(f, f2, f3, f4));
        float f5 = (f3 - f) / ((float) a);
        float f6 = (f4 - f2) / ((float) a);
        for (int i = 0; i < a; i += b) {
            int a2 = a.a((((float) i) * f5) + f);
            int a3 = a.a((((float) i) * f6) + f2);
            if (this.c.a(a2, a3)) {
                return new u((float) a2, (float) a3);
            }
        }
        return null;
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.c.a(i, i3)) {
                    return true;
                }
                i += b;
            }
        } else {
            while (i <= i2) {
                if (this.c.a(i3, i)) {
                    return true;
                }
                i += b;
            }
        }
        return false;
    }

    private u[] a(u uVar, u uVar2, u uVar3, u uVar4) {
        float a = uVar.a();
        float b = uVar.b();
        float a2 = uVar2.a();
        float b2 = uVar2.b();
        float a3 = uVar3.a();
        float b3 = uVar3.b();
        float a4 = uVar4.a();
        float b4 = uVar4.b();
        if (a < ((float) this.e) / 2.0f) {
            return new u[]{new u(a4 - 1.0f, b4 + 1.0f), new u(a2 + 1.0f, b2 + 1.0f), new u(a3 - 1.0f, b3 - 1.0f), new u(a + 1.0f, b - 1.0f)};
        }
        return new u[]{new u(a4 + 1.0f, b4 + 1.0f), new u(a2 + 1.0f, b2 - 1.0f), new u(a3 - 1.0f, b3 + 1.0f), new u(a - 1.0f, b - 1.0f)};
    }

    public u[] a() {
        int i;
        boolean z = false;
        int i2 = b;
        int i3 = this.f;
        int i4 = this.g;
        int i5 = this.i;
        int i6 = this.h;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = b;
        while (i7 != 0) {
            boolean z7 = true;
            boolean z8 = z5;
            z5 = false;
            while (true) {
                if ((z7 || !z8) && i4 < this.e) {
                    z7 = a(i5, i6, i4, false);
                    if (z7) {
                        i4 += b;
                        z8 = b;
                        z5 = b;
                    } else if (!z8) {
                        i4 += b;
                    }
                }
            }
            if (i4 >= this.e) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z7 = z4;
            z4 = z5;
            z5 = true;
            while (true) {
                if ((z5 || !z7) && i6 < this.d) {
                    z5 = a(i3, i4, i6, true);
                    if (z5) {
                        i6 += b;
                        z7 = b;
                        z4 = b;
                    } else if (!z7) {
                        i6 += b;
                    }
                }
            }
            if (i6 >= this.d) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z5 = z3;
            z3 = z4;
            z4 = true;
            while (true) {
                if ((z4 || !z5) && i3 >= 0) {
                    z4 = a(i5, i6, i3, false);
                    if (z4) {
                        i3--;
                        z5 = b;
                        z3 = b;
                    } else if (!z5) {
                        i3--;
                    }
                }
            }
            if (i3 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            z4 = z3;
            z3 = z2;
            z2 = true;
            while (true) {
                if ((z2 || !z3) && i5 >= 0) {
                    z2 = a(i3, i4, i5, true);
                    if (z2) {
                        i5--;
                        z3 = b;
                        z4 = b;
                    } else if (!z3) {
                        i5--;
                    }
                }
            }
            if (i5 < 0) {
                z = true;
                i = i4;
                i4 = i6;
                i6 = i3;
                i3 = i5;
                break;
            }
            if (z4) {
                z6 = b;
            }
            z2 = z3;
            z3 = z5;
            z5 = z8;
            boolean z9 = z7;
            z7 = z4;
            z4 = z9;
        }
        i = i4;
        i4 = i6;
        i6 = i3;
        i3 = i5;
        if (z || !r0) {
            throw n.a();
        }
        int i8;
        u uVar;
        int i9 = i - i6;
        u uVar2 = null;
        for (i8 = b; i8 < i9; i8 += b) {
            uVar2 = a((float) i6, (float) (i4 - i8), (float) (i6 + i8), (float) i4);
            if (uVar2 != null) {
                uVar = uVar2;
                break;
            }
        }
        uVar = uVar2;
        if (uVar == null) {
            throw n.a();
        }
        u uVar3;
        uVar2 = null;
        for (i8 = b; i8 < i9; i8 += b) {
            uVar2 = a((float) i6, (float) (i3 + i8), (float) (i6 + i8), (float) i3);
            if (uVar2 != null) {
                uVar3 = uVar2;
                break;
            }
        }
        uVar3 = uVar2;
        if (uVar3 == null) {
            throw n.a();
        }
        u uVar4;
        uVar2 = null;
        for (i8 = b; i8 < i9; i8 += b) {
            uVar2 = a((float) i, (float) (i3 + i8), (float) (i - i8), (float) i3);
            if (uVar2 != null) {
                uVar4 = uVar2;
                break;
            }
        }
        uVar4 = uVar2;
        if (uVar4 == null) {
            throw n.a();
        }
        uVar2 = null;
        while (i2 < i9) {
            uVar2 = a((float) i, (float) (i4 - i2), (float) (i - i2), (float) i4);
            if (uVar2 != null) {
                break;
            }
            i2 += b;
        }
        if (uVar2 != null) {
            return a(uVar2, uVar, uVar4, uVar3);
        }
        throw n.a();
    }
}
