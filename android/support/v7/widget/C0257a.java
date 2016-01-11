package android.support.v7.widget;

import android.support.v4.l.r;
import android.support.v4.l.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kankan.wheel.widget.a;

class C0257a implements C {
    static final int a = 0;
    static final int b = 1;
    private static final boolean i = false;
    private static final String j = "AHT";
    final ArrayList<C0258c> c;
    final ArrayList<C0258c> d;
    final C0256b e;
    Runnable f;
    final boolean g;
    final B h;
    private r<C0258c> k;

    C0257a(C0256b c0256b) {
        this(c0256b, i);
    }

    C0257a(C0256b c0256b, boolean z) {
        this.k = new s(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = c0256b;
        this.g = z;
        this.h = new B(this);
    }

    private void b(C0258c c0258c) {
        g(c0258c);
    }

    private boolean b(int i) {
        int size = this.d.size();
        for (int i2 = a; i2 < size; i2 += b) {
            C0258c c0258c = (C0258c) this.d.get(i2);
            if (c0258c.f == 3) {
                if (a(c0258c.h, i2 + b) == i) {
                    return true;
                }
            } else if (c0258c.f == 0) {
                int i3 = c0258c.g + c0258c.h;
                for (int i4 = c0258c.g; i4 < i3; i4 += b) {
                    if (a(i4, i2 + b) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return i;
    }

    private void c(C0258c c0258c) {
        int i = c0258c.g;
        int i2 = c0258c.g + c0258c.h;
        int i3 = -1;
        int i4 = c0258c.g;
        int i5 = a;
        while (i4 < i2) {
            int i6;
            if (this.e.a(i4) != null || b(i4)) {
                if (i3 == 0) {
                    e(b(b, i, i5));
                    i6 = b;
                } else {
                    i6 = a;
                }
                i3 = b;
            } else {
                if (i3 == b) {
                    g(b(b, i, i5));
                    i6 = b;
                } else {
                    i6 = a;
                }
                i3 = a;
            }
            if (i6 != 0) {
                i6 = i4 - i5;
                i4 = i2 - i5;
                i2 = b;
            } else {
                int i7 = i4;
                i4 = i2;
                i2 = i5 + b;
                i6 = i7;
            }
            i5 = i2;
            i2 = i4;
            i4 = i6 + b;
        }
        if (i5 != c0258c.h) {
            a(c0258c);
            c0258c = b(b, i, i5);
        }
        if (i3 == 0) {
            e(c0258c);
        } else {
            g(c0258c);
        }
    }

    private void d(C0258c c0258c) {
        int i = c0258c.g;
        int i2 = c0258c.g + c0258c.h;
        int i3 = c0258c.g;
        Object obj = -1;
        int i4 = a;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.e.a(i3) != null || b(i3)) {
                if (obj == null) {
                    e(b(2, i, i4));
                    i4 = a;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = b;
            } else {
                if (obj == b) {
                    g(b(2, i, i4));
                    i4 = a;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = a;
            }
            i3 += b;
            Object obj3 = obj2;
            i4 = i + b;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0258c.h) {
            a(c0258c);
            c0258c = b(2, i, i4);
        }
        if (obj == null) {
            e(c0258c);
        } else {
            g(c0258c);
        }
    }

    private int e(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.d.size() - 1; size >= 0; size--) {
            C0258c c0258c = (C0258c) this.d.get(size);
            if (c0258c.f == 3) {
                int i5;
                int i6;
                if (c0258c.g < c0258c.h) {
                    i5 = c0258c.g;
                    i3 = c0258c.h;
                } else {
                    i5 = c0258c.h;
                    i3 = c0258c.g;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0258c.g) {
                        if (i2 == 0) {
                            c0258c.g += b;
                            c0258c.h += b;
                            i6 = i4;
                        } else if (i2 == b) {
                            c0258c.g--;
                            c0258c.h--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0258c.g) {
                    if (i2 == 0) {
                        c0258c.h += b;
                    } else if (i2 == b) {
                        c0258c.h--;
                    }
                    i6 = i4 + b;
                } else {
                    if (i2 == 0) {
                        c0258c.g += b;
                    } else if (i2 == b) {
                        c0258c.g--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0258c.g <= i4) {
                if (c0258c.f == 0) {
                    i4 -= c0258c.h;
                } else if (c0258c.f == b) {
                    i4 += c0258c.h;
                }
            } else if (i2 == 0) {
                c0258c.g += b;
            } else if (i2 == b) {
                c0258c.g--;
            }
        }
        for (i3 = this.d.size() - 1; i3 >= 0; i3--) {
            c0258c = (C0258c) this.d.get(i3);
            if (c0258c.f == 3) {
                if (c0258c.h == c0258c.g || c0258c.h < 0) {
                    this.d.remove(i3);
                    a(c0258c);
                }
            } else if (c0258c.h <= 0) {
                this.d.remove(i3);
                a(c0258c);
            }
        }
        return i4;
    }

    private void e(C0258c c0258c) {
        if (c0258c.f == 0 || c0258c.f == 3) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int e = e(c0258c.g, c0258c.f);
        int i2 = c0258c.g;
        switch (c0258c.f) {
            case b /*1*/:
                i = a;
                break;
            case a.k /*2*/:
                i = b;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0258c);
        }
        int i3 = b;
        int i4 = e;
        e = i2;
        for (i2 = b; i2 < c0258c.h; i2 += b) {
            Object obj;
            int e2 = e(c0258c.g + (i * i2), c0258c.f);
            switch (c0258c.f) {
                case b /*1*/:
                    if (e2 != i4) {
                        obj = a;
                        break;
                    } else {
                        obj = b;
                        break;
                    }
                case a.k /*2*/:
                    if (e2 != i4 + b) {
                        obj = a;
                        break;
                    } else {
                        obj = b;
                        break;
                    }
                default:
                    obj = a;
                    break;
            }
            if (obj != null) {
                i3 += b;
            } else {
                C0258c b = b(c0258c.f, i4, i3);
                a(b, e);
                a(b);
                if (c0258c.f == 2) {
                    e += i3;
                }
                i3 = b;
                i4 = e2;
            }
        }
        a(c0258c);
        if (i3 > 0) {
            C0258c b2 = b(c0258c.f, i4, i3);
            a(b2, e);
            a(b2);
        }
    }

    private void f(C0258c c0258c) {
        g(c0258c);
    }

    private void g(C0258c c0258c) {
        this.d.add(c0258c);
        switch (c0258c.f) {
            case a /*0*/:
                this.e.d(c0258c.g, c0258c.h);
                return;
            case b /*1*/:
                this.e.b(c0258c.g, c0258c.h);
                return;
            case a.k /*2*/:
                this.e.c(c0258c.g, c0258c.h);
                return;
            case a.l /*3*/:
                this.e.e(c0258c.g, c0258c.h);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0258c);
        }
    }

    int a(int i) {
        return a(i, (int) a);
    }

    int a(int i, int i2) {
        int size = this.d.size();
        int i3 = i;
        while (i2 < size) {
            C0258c c0258c = (C0258c) this.d.get(i2);
            if (c0258c.f == 3) {
                if (c0258c.g == i3) {
                    i3 = c0258c.h;
                } else {
                    if (c0258c.g < i3) {
                        i3--;
                    }
                    if (c0258c.h <= i3) {
                        i3 += b;
                    }
                }
            } else if (c0258c.g > i3) {
                continue;
            } else if (c0258c.f == b) {
                if (i3 < c0258c.g + c0258c.h) {
                    return -1;
                }
                i3 -= c0258c.h;
            } else if (c0258c.f == 0) {
                i3 += c0258c.h;
            }
            i2 += b;
        }
        return i3;
    }

    C0257a a(C0258c... c0258cArr) {
        Collections.addAll(this.c, c0258cArr);
        return this;
    }

    void a() {
        a(this.c);
        a(this.d);
    }

    public void a(C0258c c0258c) {
        if (!this.g) {
            this.k.a(c0258c);
        }
    }

    void a(C0258c c0258c, int i) {
        this.e.a(c0258c);
        switch (c0258c.f) {
            case b /*1*/:
                this.e.a(i, c0258c.h);
                return;
            case a.k /*2*/:
                this.e.c(i, c0258c.h);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void a(List<C0258c> list) {
        int size = list.size();
        for (int i = a; i < size; i += b) {
            a((C0258c) list.get(i));
        }
        list.clear();
    }

    boolean a(int i, int i2, int i3) {
        boolean z = true;
        if (i == i2) {
            return i;
        }
        if (i3 != b) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.c.add(b(3, i, i2));
        if (this.c.size() != b) {
            z = i;
        }
        return z;
    }

    public C0258c b(int i, int i2, int i3) {
        C0258c c0258c = (C0258c) this.k.a();
        if (c0258c == null) {
            return new C0258c(i, i2, i3);
        }
        c0258c.f = i;
        c0258c.g = i2;
        c0258c.h = i3;
        return c0258c;
    }

    void b() {
        this.h.a(this.c);
        int size = this.c.size();
        for (int i = a; i < size; i += b) {
            C0258c c0258c = (C0258c) this.c.get(i);
            switch (c0258c.f) {
                case a /*0*/:
                    f(c0258c);
                    break;
                case b /*1*/:
                    c(c0258c);
                    break;
                case a.k /*2*/:
                    d(c0258c);
                    break;
                case a.l /*3*/:
                    b(c0258c);
                    break;
            }
            if (this.f != null) {
                this.f.run();
            }
        }
        this.c.clear();
    }

    boolean b(int i, int i2) {
        this.c.add(b(2, i, i2));
        return this.c.size() == b ? true : i;
    }

    void c() {
        int size = this.d.size();
        for (int i = a; i < size; i += b) {
            this.e.b((C0258c) this.d.get(i));
        }
        a(this.d);
    }

    boolean c(int i, int i2) {
        this.c.add(b(a, i, i2));
        return this.c.size() == b ? true : i;
    }

    boolean d() {
        return this.c.size() > 0 ? true : i;
    }

    boolean d(int i, int i2) {
        this.c.add(b(b, i, i2));
        return this.c.size() == b ? true : i;
    }

    void e() {
        c();
        int size = this.c.size();
        for (int i = a; i < size; i += b) {
            C0258c c0258c = (C0258c) this.c.get(i);
            switch (c0258c.f) {
                case a /*0*/:
                    this.e.b(c0258c);
                    this.e.d(c0258c.g, c0258c.h);
                    break;
                case b /*1*/:
                    this.e.b(c0258c);
                    this.e.a(c0258c.g, c0258c.h);
                    break;
                case a.k /*2*/:
                    this.e.b(c0258c);
                    this.e.c(c0258c.g, c0258c.h);
                    break;
                case a.l /*3*/:
                    this.e.b(c0258c);
                    this.e.e(c0258c.g, c0258c.h);
                    break;
            }
            if (this.f != null) {
                this.f.run();
            }
        }
        a(this.c);
    }
}
