package com.xiaomi.c.a;

abstract class v extends a<Integer> {
    protected v(String str) {
        super(Integer.valueOf(a(str)));
    }

    private static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable e) {
            throw new C1070b("Could not parse an integer from the value provided: " + str, e);
        }
    }

    protected final void a(int i) {
        int intValue = ((Integer) a()).intValue();
        if (intValue < i) {
            throw new C1070b("Illegal attribute value '" + intValue + "' provided.  " + "Must be >= " + i);
        }
    }

    public int b() {
        return ((Integer) a()).intValue();
    }
}
