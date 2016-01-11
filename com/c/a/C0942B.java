package com.c.a;

import com.c.a.b.G;
import com.c.a.d.a;
import com.c.a.d.d;
import java.io.Reader;
import java.io.StringReader;

public final class C0942B {
    public w a(a aVar) {
        boolean p = aVar.p();
        aVar.a(true);
        try {
            w a = G.a(aVar);
            aVar.a(p);
            return a;
        } catch (Throwable e) {
            throw new A("Failed parsing JSON source: " + aVar + " to Json", e);
        } catch (Throwable e2) {
            throw new A("Failed parsing JSON source: " + aVar + " to Json", e2);
        } catch (Throwable th) {
            aVar.a(p);
        }
    }

    public w a(Reader reader) {
        try {
            a aVar = new a(reader);
            w a = a(aVar);
            if (a.s() || aVar.f() == d.END_DOCUMENT) {
                return a;
            }
            throw new G("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new G(e);
        } catch (Throwable e2) {
            throw new x(e2);
        } catch (Throwable e22) {
            throw new G(e22);
        }
    }

    public w a(String str) {
        return a(new StringReader(str));
    }
}
