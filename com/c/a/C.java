package com.c.a;

import com.c.a.b.C0970a;
import com.c.a.b.v;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class C extends w {
    private static final Class<?>[] a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public C(Boolean bool) {
        a((Object) bool);
    }

    public C(Character ch) {
        a((Object) ch);
    }

    public C(Number number) {
        a((Object) number);
    }

    C(Object obj) {
        a(obj);
    }

    public C(String str) {
        a((Object) str);
    }

    private static boolean a(C c) {
        if (!(c.b instanceof Number)) {
            return false;
        }
        Number number = (Number) c.b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    C a() {
        return this;
    }

    void a(Object obj) {
        if (obj instanceof Character) {
            this.b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || b(obj);
        C0970a.a(z);
        this.b = obj;
    }

    public boolean b() {
        return this.b instanceof Boolean;
    }

    public Number c() {
        return this.b instanceof String ? new v((String) this.b) : (Number) this.b;
    }

    public String d() {
        return y() ? c().toString() : b() ? x().toString() : (String) this.b;
    }

    public double e() {
        return y() ? c().doubleValue() : Double.parseDouble(d());
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C c = (C) obj;
        if (this.b == null) {
            return c.b == null;
        } else {
            if (a(this) && a(c)) {
                return c().longValue() == c.c().longValue();
            } else {
                if (!(this.b instanceof Number) || !(c.b instanceof Number)) {
                    return this.b.equals(c.b);
                }
                double doubleValue = c().doubleValue();
                double doubleValue2 = c.c().doubleValue();
                if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                    z = true;
                }
                return z;
            }
        }
    }

    public BigDecimal f() {
        return this.b instanceof BigDecimal ? (BigDecimal) this.b : new BigDecimal(this.b.toString());
    }

    public BigInteger g() {
        return this.b instanceof BigInteger ? (BigInteger) this.b : new BigInteger(this.b.toString());
    }

    public float h() {
        return y() ? c().floatValue() : Float.parseFloat(d());
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        long longValue;
        if (a(this)) {
            longValue = c().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.b instanceof Number)) {
            return this.b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(c().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public long i() {
        return y() ? c().longValue() : Long.parseLong(d());
    }

    public int j() {
        return y() ? c().intValue() : Integer.parseInt(d());
    }

    public byte k() {
        return y() ? c().byteValue() : Byte.parseByte(d());
    }

    public char l() {
        return d().charAt(0);
    }

    public short m() {
        return y() ? c().shortValue() : Short.parseShort(d());
    }

    public boolean n() {
        return b() ? x().booleanValue() : Boolean.parseBoolean(d());
    }

    /* synthetic */ w o() {
        return a();
    }

    Boolean x() {
        return (Boolean) this.b;
    }

    public boolean y() {
        return this.b instanceof Number;
    }

    public boolean z() {
        return this.b instanceof String;
    }
}
