package com.c.a.b.a;

import com.c.a.C0986j;
import com.c.a.C0993k;
import com.c.a.N;
import com.c.a.P;
import com.c.a.a.b;
import com.c.a.b.C0971b;
import com.c.a.b.C0975f;
import com.c.a.b.F;
import com.c.a.b.s;
import com.c.a.c.a;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class C0959p implements P {
    private final C0975f a;
    private final C0986j b;
    private final s c;

    public C0959p(C0975f c0975f, C0986j c0986j, s sVar) {
        this.a = c0975f;
        this.b = c0986j;
        this.c = sVar;
    }

    private C0960s a(C0993k c0993k, Field field, String str, a<?> aVar, boolean z, boolean z2) {
        return new C0961q(this, str, z, z2, c0993k, aVar, field, F.a(aVar.getRawType()));
    }

    private String a(Field field) {
        b bVar = (b) field.getAnnotation(b.class);
        return bVar == null ? this.b.a(field) : bVar.a();
    }

    private Map<String, C0960s> a(C0993k c0993k, a<?> aVar, Class<?> cls) {
        Map<String, C0960s> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        Class rawType;
        while (rawType != Object.class) {
            for (Field field : rawType.getDeclaredFields()) {
                boolean a = a(field, true);
                boolean a2 = a(field, false);
                if (a || a2) {
                    field.setAccessible(true);
                    C0960s a3 = a(c0993k, field, a(field), a.get(C0971b.a(r14.getType(), rawType, field.getGenericType())), a, a2);
                    a3 = (C0960s) linkedHashMap.put(a3.g, a3);
                    if (a3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + a3.g);
                    }
                }
            }
            a aVar2 = a.get(C0971b.a(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    public <T> N<T> a(C0993k c0993k, a<T> aVar) {
        Class rawType = aVar.getRawType();
        return !Object.class.isAssignableFrom(rawType) ? null : new C0962r(this.a.a((a) aVar), a(c0993k, aVar, rawType), null);
    }

    public boolean a(Field field, boolean z) {
        return (this.c.a(field.getType(), z) || this.c.a(field, z)) ? false : true;
    }
}
