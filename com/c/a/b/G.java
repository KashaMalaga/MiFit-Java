package com.c.a.b;

import com.c.a.b.a.C0968y;
import com.c.a.d.a;
import com.c.a.d.e;
import com.c.a.w;
import com.c.a.x;
import com.c.a.y;
import java.io.Writer;

public final class G {
    public static w a(a aVar) {
        Object obj = 1;
        try {
            aVar.f();
            obj = null;
            return (w) C0968y.P.b(aVar);
        } catch (Throwable e) {
            if (obj != null) {
                return y.a;
            }
            throw new com.c.a.G(e);
        } catch (Throwable e2) {
            throw new com.c.a.G(e2);
        } catch (Throwable e22) {
            throw new x(e22);
        } catch (Throwable e222) {
            throw new com.c.a.G(e222);
        }
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new I(appendable, null);
    }

    public static void a(w wVar, e eVar) {
        C0968y.P.a(eVar, (Object) wVar);
    }
}
