package com.activeandroid.d;

import java.util.HashMap;

final class g extends HashMap<Class<?>, h> {
    g() {
        put(Byte.TYPE, h.INTEGER);
        put(Short.TYPE, h.INTEGER);
        put(Integer.TYPE, h.INTEGER);
        put(Long.TYPE, h.INTEGER);
        put(Float.TYPE, h.REAL);
        put(Double.TYPE, h.REAL);
        put(Boolean.TYPE, h.INTEGER);
        put(Character.TYPE, h.TEXT);
        put(byte[].class, h.BLOB);
        put(Byte.class, h.INTEGER);
        put(Short.class, h.INTEGER);
        put(Integer.class, h.INTEGER);
        put(Long.class, h.INTEGER);
        put(Float.class, h.REAL);
        put(Double.class, h.REAL);
        put(Boolean.class, h.INTEGER);
        put(Character.class, h.TEXT);
        put(String.class, h.TEXT);
        put(Byte[].class, h.BLOB);
    }
}
