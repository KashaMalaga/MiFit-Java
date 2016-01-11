package com.c.a;

import java.lang.reflect.Field;

enum C0992i extends C0987d {
    C0992i(String str, int i) {
        super(str, i);
    }

    public String a(Field field) {
        return C0987d.b(field.getName(), "-").toLowerCase();
    }
}
