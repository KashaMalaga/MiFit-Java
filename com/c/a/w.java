package com.c.a;

import com.c.a.b.G;
import com.c.a.d.e;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class w {
    public Number c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigDecimal f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte k() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public char l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short m() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    abstract w o();

    public boolean p() {
        return this instanceof t;
    }

    public boolean q() {
        return this instanceof z;
    }

    public boolean r() {
        return this instanceof C;
    }

    public boolean s() {
        return this instanceof y;
    }

    public z t() {
        if (q()) {
            return (z) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            e eVar = new e(stringWriter);
            eVar.b(true);
            G.a(this, eVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public t u() {
        if (p()) {
            return (t) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public C v() {
        if (r()) {
            return (C) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public y w() {
        if (s()) {
            return (y) this;
        }
        throw new IllegalStateException("This is not a JSON Null.");
    }

    Boolean x() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }
}
