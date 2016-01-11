package com.c.a.b;

import java.math.BigDecimal;

public final class v extends Number {
    private final String a;

    public v(String str) {
        this.a = str;
    }

    private Object writeReplace() {
        return new BigDecimal(this.a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.a);
    }

    public float floatValue() {
        return Float.parseFloat(this.a);
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.a).longValue();
        }
    }

    public String toString() {
        return this.a;
    }
}
