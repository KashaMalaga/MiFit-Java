package com.activeandroid.d;

import java.lang.reflect.Field;
import java.util.Comparator;

final class e implements Comparator<Field> {
    e() {
    }

    public int a(Field field, Field field2) {
        return field2.getName().compareTo(field.getName());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Field) obj, (Field) obj2);
    }
}
