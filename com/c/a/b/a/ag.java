package com.c.a.b.a;

import com.c.a.N;
import com.c.a.a.b;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.HashMap;
import java.util.Map;

final class ag<T extends Enum<T>> extends N<T> {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public ag(Class<T> cls) {
        try {
            for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                Object a;
                String name = enumR.name();
                b bVar = (b) cls.getField(name).getAnnotation(b.class);
                if (bVar != null) {
                    a = bVar.a();
                } else {
                    String str = name;
                }
                this.a.put(a, enumR);
                this.b.put(enumR, a);
            }
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        }
    }

    public T a(a aVar) {
        if (aVar.f() != d.NULL) {
            return (Enum) this.a.get(aVar.h());
        }
        aVar.j();
        return null;
    }

    public void a(e eVar, T t) {
        eVar.b(t == null ? null : (String) this.b.get(t));
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
