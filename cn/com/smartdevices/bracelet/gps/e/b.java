package cn.com.smartdevices.bracelet.gps.e;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.relation.db.Friend;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class b {
    public static final int a = 1;
    public static final int b = 0;
    public static final int c = 16;
    public static final int d = 1;
    public static final int e = 0;
    private static final String f = "KeeperReflection";
    private static Class<?> g;
    private static Class<?> h;
    private static Class<?> i;

    static {
        g = null;
        h = null;
        i = null;
        try {
            i = Class.forName("cn.com.smartdevices.bracelet.Keeper");
            g = Class.forName("cn.com.smartdevices.bracelet.model.PersonInfo");
            h = Class.forName("cn.com.smartdevices.bracelet.model.MiliConfig");
        } catch (ClassNotFoundException e) {
            C0596r.a(f, e.getMessage());
        }
    }

    public static float a() {
        float f = 0.0f;
        try {
            Object g = g();
            if (!(g == null || g == null)) {
                Field declaredField = g.getDeclaredField(Friend.d);
                if (declaredField != null) {
                    f = declaredField.getFloat(g);
                }
            }
        } catch (Exception e) {
            C0596r.a(f, e.getMessage());
        }
        return f;
    }

    public static int b() {
        int i = e;
        try {
            Object g = g();
            if (!(g == null || g == null)) {
                Field declaredField = g.getDeclaredField(f.am);
                if (declaredField != null) {
                    i = declaredField.getInt(g);
                }
            }
        } catch (Exception e) {
            C0596r.a(f, e.getMessage());
        }
        return i;
    }

    public static int c() {
        int i = -1;
        try {
            Object g = g();
            if (!(g == null || g == null)) {
                Field declaredField = g.getDeclaredField("miliConfig");
                if (declaredField != null) {
                    i = h.getDeclaredField("unit").getInt(declaredField.get(g));
                }
            }
        } catch (Exception e) {
            C0596r.a(f, e.getMessage());
        }
        return i;
    }

    public static boolean d() {
        boolean z = false;
        try {
            Object g = g();
            if (!(g == null || g == null)) {
                Field declaredField = g.getDeclaredField("miliConfig");
                if (declaredField != null) {
                    z = h.getDeclaredField("hasHeartRate").getBoolean(declaredField.get(g));
                }
            }
        } catch (Exception e) {
            C0596r.a(f, e.getMessage());
        }
        return z;
    }

    public static String e() {
        try {
            try {
                Method method = Class.forName("cn.com.smartdevices.bracelet.Keeper").getMethod("readUUID", new Class[e]);
                if (method == null) {
                    throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper readUUID is gone");
                }
                Object invoke = method.invoke(null, new Object[e]);
                return invoke != null ? (String) invoke : null;
            } catch (Exception e) {
                C0596r.a(f, e.getMessage());
                throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper readUUID failed to invoke");
            }
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("cn.com.smartdevices.bracelet.Keeper is gone");
        }
    }

    public static int f() {
        int i = -1;
        try {
            Object g = g();
            if (!(g == null || g == null)) {
                Field declaredField = g.getDeclaredField("miliConfig");
                if (declaredField != null) {
                    i = h.getDeclaredField("weightUnit").getInt(declaredField.get(g));
                }
            }
        } catch (Exception e) {
            C0596r.a(f, e.getMessage());
        }
        return i;
    }

    private static Object g() {
        Method method = i.getMethod("readPersonInfoBase", new Class[e]);
        return method == null ? Float.valueOf(0.0f) : method.invoke(null, new Object[e]);
    }
}
