package android.support.v7.widget;

class C0258c {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = 30;
    int f;
    int g;
    int h;

    C0258c(int i, int i2, int i3) {
        this.f = i;
        this.g = i2;
        this.h = i3;
    }

    String a() {
        switch (this.f) {
            case a /*0*/:
                return "add";
            case b /*1*/:
                return "rm";
            case c /*2*/:
                return "up";
            case d /*3*/:
                return "mv";
            default:
                return "??";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0258c c0258c = (C0258c) obj;
        return this.f != c0258c.f ? false : (this.f == d && Math.abs(this.h - this.g) == b && this.h == c0258c.g && this.g == c0258c.h) ? true : this.h != c0258c.h ? false : this.g == c0258c.g;
    }

    public int hashCode() {
        return (((this.f * 31) + this.g) * 31) + this.h;
    }

    public String toString() {
        return "[" + a() + ",s:" + this.g + "c:" + this.h + "]";
    }
}
