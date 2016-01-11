package com.activeandroid.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v4.view.a.C0113o;
import com.activeandroid.a.a;
import com.activeandroid.c.e;
import com.activeandroid.g;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class d {
    public static <T> T a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), C0113o.h);
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.get(str);
            }
        } catch (Exception e) {
            b.d("Couldn't find meta-data: " + str);
        }
        return null;
    }

    public static boolean a(Class<?> cls) {
        return a((Class) cls, g.class) && !Modifier.isAbstract(cls.getModifiers());
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return cls.getSuperclass() != null ? cls.getSuperclass().equals(cls2) ? true : a(cls.getSuperclass(), (Class) cls2) : false;
    }

    public static boolean b(Class<?> cls) {
        return a((Class) cls, e.class);
    }

    public static Set<Field> c(Class<?> cls) {
        Set<Field> emptySet = Collections.emptySet();
        if (a((Class) cls, g.class) || g.class.equals(cls)) {
            emptySet = new LinkedHashSet();
            Field[] declaredFields = cls.getDeclaredFields();
            Arrays.sort(declaredFields, new e());
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(a.class)) {
                    emptySet.add(field);
                }
            }
            Class superclass = cls.getSuperclass();
            if (superclass != null) {
                emptySet.addAll(c(superclass));
            }
        }
        return emptySet;
    }
}
