package com.c.a;

import com.c.a.b.a.C0950g;
import com.c.a.b.a.C0952i;
import com.c.a.d.a;
import com.c.a.d.e;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class N<T> {
    public final N<T> a() {
        return new O(this);
    }

    public final T a(w wVar) {
        try {
            return b(new C0950g(wVar));
        } catch (Throwable e) {
            throw new x(e);
        }
    }

    public final T a(Reader reader) {
        return b(new a(reader));
    }

    public final T a(String str) {
        return a(new StringReader(str));
    }

    public final String a(T t) {
        Writer stringWriter = new StringWriter();
        a(stringWriter, (Object) t);
        return stringWriter.toString();
    }

    public abstract void a(e eVar, T t);

    public final void a(Writer writer, T t) {
        a(new e(writer), (Object) t);
    }

    public final w b(T t) {
        try {
            e c0952i = new C0952i();
            a(c0952i, (Object) t);
            return c0952i.a();
        } catch (Throwable e) {
            throw new x(e);
        }
    }

    public abstract T b(a aVar);
}
