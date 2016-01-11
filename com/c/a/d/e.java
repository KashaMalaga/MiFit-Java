package com.c.a.d;

import android.support.v4.view.a.C0113o;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class e implements Closeable, Flushable {
    private static final String[] a = new String[C0113o.h];
    private static final String[] b = ((String[]) a.clone());
    private final Writer c;
    private int[] d = new int[32];
    private int e = 0;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    static {
        for (int i = 0; i <= 31; i++) {
            a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        b[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }

    public e(Writer writer) {
        a(6);
        this.g = a.ci;
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.c = writer;
    }

    private int a() {
        if (this.e != 0) {
            return this.d[this.e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private e a(int i, int i2, String str) {
        int a = a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        } else {
            this.e--;
            if (a == i2) {
                k();
            }
            this.c.write(str);
            return this;
        }
    }

    private e a(int i, String str) {
        e(true);
        a(i);
        this.c.write(str);
        return this;
    }

    private void a(int i) {
        if (this.e == this.d.length) {
            Object obj = new int[(this.e * 2)];
            System.arraycopy(this.d, 0, obj, 0, this.e);
            this.d = obj;
        }
        int[] iArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        iArr[i2] = i;
    }

    private void b(int i) {
        this.d[this.e - 1] = i;
    }

    private void d(String str) {
        int i = 0;
        String[] strArr = this.i ? b : a;
        this.c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '\u0080') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.c.write(str, i, i2 - i);
                }
                this.c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == '\u2028') {
                    str2 = "\\u2028";
                } else if (charAt == '\u2029') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.c.write(str, i, i2 - i);
                }
                this.c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.c.write(str, i, length - i);
        }
        this.c.write("\"");
    }

    private void e(boolean z) {
        switch (a()) {
            case l.a /*1*/:
                b(2);
                k();
                return;
            case a.k /*2*/:
                this.c.append(',');
                k();
                return;
            case a.aQ /*4*/:
                this.c.append(this.g);
                b(5);
                return;
            case a.bt /*6*/:
                break;
            case a.bc /*7*/:
                if (!this.h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.h || z) {
            b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private void j() {
        if (this.j != null) {
            l();
            d(this.j);
            this.j = null;
        }
    }

    private void k() {
        if (this.f != null) {
            this.c.write("\n");
            int i = this.e;
            for (int i2 = 1; i2 < i; i2++) {
                this.c.write(this.f);
            }
        }
    }

    private void l() {
        int a = a();
        if (a == 5) {
            this.c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    public e a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        j();
        e(false);
        this.c.append(Double.toString(d));
        return this;
    }

    public e a(long j) {
        j();
        e(false);
        this.c.write(Long.toString(j));
        return this;
    }

    public e a(Number number) {
        if (number == null) {
            return f();
        }
        j();
        CharSequence obj = number.toString();
        if (this.h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            e(false);
            this.c.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public e a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.j != null) {
            throw new IllegalStateException();
        } else if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.j = str;
            return this;
        }
    }

    public e a(boolean z) {
        j();
        e(false);
        this.c.write(z ? "true" : "false");
        return this;
    }

    public e b() {
        j();
        return a(1, "[");
    }

    public e b(String str) {
        if (str == null) {
            return f();
        }
        j();
        e(false);
        d(str);
        return this;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public e c() {
        return a(1, 2, "]");
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f = null;
            this.g = a.ci;
            return;
        }
        this.f = str;
        this.g = ": ";
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public void close() {
        this.c.close();
        int i = this.e;
        if (i > 1 || (i == 1 && this.d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.e = 0;
    }

    public e d() {
        j();
        return a(3, "{");
    }

    public final void d(boolean z) {
        this.k = z;
    }

    public e e() {
        return a(3, 5, "}");
    }

    public e f() {
        if (this.j != null) {
            if (this.k) {
                j();
            } else {
                this.j = null;
                return this;
            }
        }
        e(false);
        this.c.write("null");
        return this;
    }

    public void flush() {
        if (this.e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.c.flush();
    }

    public boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public final boolean i() {
        return this.k;
    }
}
