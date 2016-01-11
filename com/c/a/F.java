package com.c.a;

import com.c.a.b.G;
import com.c.a.d.a;
import com.c.a.d.d;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class F implements Iterator<w> {
    private final a a;
    private final Object b;

    public F(Reader reader) {
        this.a = new a(reader);
        this.a.a(true);
        this.b = new Object();
    }

    public F(String str) {
        this(new StringReader(str));
    }

    public w a() {
        if (hasNext()) {
            try {
                return G.a(this.a);
            } catch (Throwable e) {
                throw new A("Failed parsing JSON source to Json", e);
            } catch (Throwable e2) {
                throw new A("Failed parsing JSON source to Json", e2);
            } catch (A e3) {
                A e4 = e3;
                if (e4.getCause() instanceof EOFException) {
                    e4 = new NoSuchElementException();
                }
                throw e4;
            }
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.a.f() != d.END_DOCUMENT;
            } catch (Throwable e) {
                throw new G(e);
            } catch (Throwable e2) {
                throw new x(e2);
            }
        }
        return z;
    }

    public /* synthetic */ Object next() {
        return a();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
