package com.c.a;

import java.lang.reflect.Field;

enum C0991h extends C0987d {
    C0991h(String str, int i) {
        super(str, i);
    }

    public String a(Field field) {
        return C0987d.b(field.getName(), "_").toLowerCase();
    }
}
