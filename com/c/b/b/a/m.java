package com.c.b.b.a;

public final class m extends q {
    private final double a;
    private final double b;
    private final double c;
    private final String d;

    m(double d, double d2, double d3, String str) {
        super(r.GEO);
        this.a = d;
        this.b = d2;
        this.c = d3;
        this.d = str;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("geo:");
        stringBuilder.append(this.a);
        stringBuilder.append(',');
        stringBuilder.append(this.b);
        if (this.c > 0.0d) {
            stringBuilder.append(',');
            stringBuilder.append(this.c);
        }
        if (this.d != null) {
            stringBuilder.append('?');
            stringBuilder.append(this.d);
        }
        return stringBuilder.toString();
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.b;
    }

    public double d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public String q() {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append(this.b);
        if (this.c > 0.0d) {
            stringBuilder.append(", ");
            stringBuilder.append(this.c);
            stringBuilder.append('m');
        }
        if (this.d != null) {
            stringBuilder.append(" (");
            stringBuilder.append(this.d);
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
