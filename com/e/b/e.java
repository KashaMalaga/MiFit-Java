package com.e.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class e<T, V> extends d<T, V> {
    private static final String a = "get";
    private static final String b = "is";
    private static final String c = "set";
    private Method d;
    private Method e;
    private Field f;

    public e(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        char toUpperCase = Character.toUpperCase(str.charAt(0));
        String stringBuilder = new StringBuilder(String.valueOf(toUpperCase)).append(str.substring(1)).toString();
        String stringBuilder2 = new StringBuilder(a).append(stringBuilder).toString();
        try {
            this.e = cls.getMethod(stringBuilder2, null);
        } catch (NoSuchMethodException e) {
            try {
                this.e = cls.getDeclaredMethod(stringBuilder2, null);
                this.e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                stringBuilder2 = new StringBuilder(b).append(stringBuilder).toString();
                try {
                    this.e = cls.getMethod(stringBuilder2, null);
                } catch (NoSuchMethodException e3) {
                    try {
                        this.e = cls.getDeclaredMethod(stringBuilder2, null);
                        this.e.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        this.f = cls.getField(str);
                        Class type = this.f.getType();
                        if (!a((Class) cls2, type)) {
                            throw new c("Underlying type (" + type + ") " + "does not match Property type (" + cls2 + ")");
                        }
                        return;
                    } catch (NoSuchFieldException e5) {
                        throw new c("No accessor method or field found for property with name " + str);
                    }
                }
            }
        }
        Class returnType = this.e.getReturnType();
        if (a((Class) cls2, returnType)) {
            stringBuilder = new StringBuilder(c).append(stringBuilder).toString();
            try {
                this.d = cls.getDeclaredMethod(stringBuilder, new Class[]{returnType});
                this.d.setAccessible(true);
                return;
            } catch (NoSuchMethodException e6) {
                return;
            }
        }
        throw new c("Underlying type (" + returnType + ") " + "does not match Property type (" + cls2 + ")");
    }

    private boolean a(Class<V> cls, Class cls2) {
        return cls2 != cls ? cls2.isPrimitive() ? (cls2 == Float.TYPE && cls == Float.class) || ((cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))))) : false : true;
    }

    public V a(T t) {
        V invoke;
        if (this.e != null) {
            try {
                invoke = this.e.invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.f != null) {
            try {
                invoke = this.f.get(t);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
        return invoke;
    }

    public void a(T t, V v) {
        if (this.d != null) {
            try {
                this.d.invoke(t, new Object[]{v});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.f != null) {
            try {
                this.f.set(t, v);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + b() + " is read-only");
        }
    }

    public boolean a() {
        return this.d == null && this.f == null;
    }
}
