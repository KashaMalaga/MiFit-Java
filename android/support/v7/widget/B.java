package android.support.v7.widget;

import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class B {
    final C a;

    public B(C c) {
        this.a = c;
    }

    private void a(List<C0258c> list, int i, int i2) {
        C0258c c0258c = (C0258c) list.get(i);
        C0258c c0258c2 = (C0258c) list.get(i2);
        switch (c0258c2.f) {
            case a.i /*0*/:
                c(list, i, c0258c, i2, c0258c2);
                return;
            case l.a /*1*/:
                a(list, i, c0258c, i2, c0258c2);
                return;
            case a.k /*2*/:
                b(list, i, c0258c, i2, c0258c2);
                return;
            default:
                return;
        }
    }

    private int b(List<C0258c> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0258c) list.get(size)).f != 3) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void c(List<C0258c> list, int i, C0258c c0258c, int i2, C0258c c0258c2) {
        int i3 = 0;
        if (c0258c.h < c0258c2.g) {
            i3 = -1;
        }
        if (c0258c.g < c0258c2.g) {
            i3++;
        }
        if (c0258c2.g <= c0258c.g) {
            c0258c.g += c0258c2.h;
        }
        if (c0258c2.g <= c0258c.h) {
            c0258c.h += c0258c2.h;
        }
        c0258c2.g = i3 + c0258c2.g;
        list.set(i, c0258c2);
        list.set(i2, c0258c);
    }

    void a(List<C0258c> list) {
        while (true) {
            int b = b(list);
            if (b != -1) {
                a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void a(List<C0258c> list, int i, C0258c c0258c, int i2, C0258c c0258c2) {
        int i3;
        C0258c c0258c3;
        int i4 = 0;
        if (c0258c.g < c0258c.h) {
            i3 = (c0258c2.g == c0258c.g && c0258c2.h == c0258c.h - c0258c.g) ? 1 : 0;
        } else if (c0258c2.g == c0258c.h + 1 && c0258c2.h == c0258c.g - c0258c.h) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0258c.h < c0258c2.g) {
            c0258c2.g--;
        } else if (c0258c.h < c0258c2.g + c0258c2.h) {
            c0258c2.h--;
            c0258c.f = 1;
            c0258c.h = 1;
            if (c0258c2.h == 0) {
                list.remove(i2);
                this.a.a(c0258c2);
                return;
            }
            return;
        }
        if (c0258c.g <= c0258c2.g) {
            c0258c2.g++;
            c0258c3 = null;
        } else if (c0258c.g < c0258c2.g + c0258c2.h) {
            c0258c3 = this.a.b(1, c0258c.g + 1, (c0258c2.g + c0258c2.h) - c0258c.g);
            c0258c2.h = c0258c.g - c0258c2.g;
        } else {
            c0258c3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0258c2);
            list.remove(i2);
            this.a.a(c0258c);
            return;
        }
        if (i4 != 0) {
            if (c0258c3 != null) {
                if (c0258c.g > c0258c3.g) {
                    c0258c.g -= c0258c3.h;
                }
                if (c0258c.h > c0258c3.g) {
                    c0258c.h -= c0258c3.h;
                }
            }
            if (c0258c.g > c0258c2.g) {
                c0258c.g -= c0258c2.h;
            }
            if (c0258c.h > c0258c2.g) {
                c0258c.h -= c0258c2.h;
            }
        } else {
            if (c0258c3 != null) {
                if (c0258c.g >= c0258c3.g) {
                    c0258c.g -= c0258c3.h;
                }
                if (c0258c.h >= c0258c3.g) {
                    c0258c.h -= c0258c3.h;
                }
            }
            if (c0258c.g >= c0258c2.g) {
                c0258c.g -= c0258c2.h;
            }
            if (c0258c.h >= c0258c2.g) {
                c0258c.h -= c0258c2.h;
            }
        }
        list.set(i, c0258c2);
        if (c0258c.g != c0258c.h) {
            list.set(i2, c0258c);
        } else {
            list.remove(i2);
        }
        if (c0258c3 != null) {
            list.add(i, c0258c3);
        }
    }

    void b(List<C0258c> list, int i, C0258c c0258c, int i2, C0258c c0258c2) {
        Object obj;
        Object obj2 = null;
        if (c0258c.h < c0258c2.g) {
            c0258c2.g--;
            obj = null;
        } else if (c0258c.h < c0258c2.g + c0258c2.h) {
            c0258c2.h--;
            obj = this.a.b(2, c0258c.g, 1);
        } else {
            obj = null;
        }
        if (c0258c.g <= c0258c2.g) {
            c0258c2.g++;
        } else if (c0258c.g < c0258c2.g + c0258c2.h) {
            int i3 = (c0258c2.g + c0258c2.h) - c0258c.g;
            obj2 = this.a.b(2, c0258c.g + 1, i3);
            c0258c2.h -= i3;
        }
        list.set(i2, c0258c);
        if (c0258c2.h > 0) {
            list.set(i, c0258c2);
        } else {
            list.remove(i);
            this.a.a(c0258c2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
