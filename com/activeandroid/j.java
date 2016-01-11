package com.activeandroid;

import android.text.TextUtils;
import android.util.Log;
import com.activeandroid.a.a;
import com.activeandroid.a.d;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j {
    private Class<? extends g> a;
    private String b;
    private String c = d.a;
    private Map<Field, String> d = new LinkedHashMap();

    public j(Class<? extends g> cls) {
        this.a = cls;
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar != null) {
            this.b = dVar.a();
            this.c = dVar.b();
        } else {
            this.b = cls.getSimpleName();
        }
        this.d.put(a((Class) cls), this.c);
        List<Field> linkedList = new LinkedList(com.activeandroid.d.d.c(cls));
        Collections.reverse(linkedList);
        for (Field field : linkedList) {
            if (field.isAnnotationPresent(a.class)) {
                Object a = ((a) field.getAnnotation(a.class)).a();
                if (TextUtils.isEmpty(a)) {
                    a = field.getName();
                }
                this.d.put(field, a);
            }
        }
    }

    private Field a(Class<?> cls) {
        if (cls.equals(g.class)) {
            try {
                return cls.getDeclaredField("mId");
            } catch (NoSuchFieldException e) {
                Log.e("Impossible!", e.toString());
            }
        } else {
            if (cls.getSuperclass() != null) {
                return a(cls.getSuperclass());
            }
            return null;
        }
    }

    public Class<? extends g> a() {
        return this.a;
    }

    public String a(Field field) {
        return (String) this.d.get(field);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public Collection<Field> d() {
        return this.d.keySet();
    }
}
