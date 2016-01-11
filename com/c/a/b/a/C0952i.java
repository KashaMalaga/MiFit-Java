package com.c.a.b.a;

import com.c.a.C;
import com.c.a.d.e;
import com.c.a.t;
import com.c.a.w;
import com.c.a.y;
import com.c.a.z;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class C0952i extends e {
    private static final Writer a = new C0953j();
    private static final C b = new C("closed");
    private final List<w> c = new ArrayList();
    private String d;
    private w e = y.a;

    public C0952i() {
        super(a);
    }

    private void a(w wVar) {
        if (this.d != null) {
            if (!wVar.s() || i()) {
                ((z) j()).a(this.d, wVar);
            }
            this.d = null;
        } else if (this.c.isEmpty()) {
            this.e = wVar;
        } else {
            w j = j();
            if (j instanceof t) {
                ((t) j).a(wVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private w j() {
        return (w) this.c.get(this.c.size() - 1);
    }

    public e a(double d) {
        if (g() || !(Double.isNaN(d) || Double.isInfinite(d))) {
            a(new C(Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public e a(long j) {
        a(new C(Long.valueOf(j)));
        return this;
    }

    public e a(Number number) {
        if (number == null) {
            return f();
        }
        if (!g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new C(number));
        return this;
    }

    public e a(String str) {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof z) {
            this.d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public e a(boolean z) {
        a(new C(Boolean.valueOf(z)));
        return this;
    }

    public w a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    public e b() {
        w tVar = new t();
        a(tVar);
        this.c.add(tVar);
        return this;
    }

    public e b(String str) {
        if (str == null) {
            return f();
        }
        a(new C(str));
        return this;
    }

    public e c() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof t) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void close() {
        if (this.c.isEmpty()) {
            this.c.add(b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public e d() {
        w zVar = new z();
        a(zVar);
        this.c.add(zVar);
        return this;
    }

    public e e() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        } else if (j() instanceof z) {
            this.c.remove(this.c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public e f() {
        a(y.a);
        return this;
    }

    public void flush() {
    }
}
