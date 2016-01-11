package com.xiaomi.c.a;

final class I extends a<String> implements Comparable {
    private static final I a;
    private final int b;
    private final int c;

    static {
        try {
            a = a("1.8");
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private I(String str) {
        super(str);
        int indexOf = str.indexOf(46);
        if (indexOf <= 0) {
            throw new C1070b("Illegal ver attribute value (not in major.minor form): " + str);
        }
        String substring = str.substring(0, indexOf);
        try {
            this.b = Integer.parseInt(substring);
            if (this.b < 0) {
                throw new C1070b("Major version may not be < 0");
            }
            substring = str.substring(indexOf + 1);
            try {
                this.c = Integer.parseInt(substring);
                if (this.c < 0) {
                    throw new C1070b("Minor version may not be < 0");
                }
            } catch (Throwable e) {
                throw new C1070b("Could not parse ver attribute value (minor ver): " + substring, e);
            }
        } catch (Throwable e2) {
            throw new C1070b("Could not parse ver attribute value (major ver): " + substring, e2);
        }
    }

    static I a(String str) {
        return str == null ? null : new I(str);
    }

    static I b() {
        return a;
    }

    public int compareTo(Object obj) {
        if (!(obj instanceof I)) {
            return 0;
        }
        I i = (I) obj;
        return this.b < i.b ? -1 : this.b > i.b ? 1 : this.c >= i.c ? this.c > i.c ? 1 : 0 : -1;
    }
}
