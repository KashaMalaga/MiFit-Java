package cn.com.smartdevices.bracelet.shoes.b;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import java.lang.reflect.Method;

public class b {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Class cls = Class.forName("cn.com.smartdevices.bracelet.lua.LuaEvent");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[]{Context.class});
            if (declaredMethod == null) {
                C0596r.e("Reflection", "getInstance is gone");
                return false;
            }
            Object invoke = declaredMethod.invoke(null, new Object[]{context});
            if (invoke == null) {
                C0596r.e("Reflection", "getInstance invoke is failed");
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("deleteLuaItem", new Class[]{String.class});
            if (declaredMethod2 == null) {
                C0596r.e("Reflection", "analysisDynamic invoke is gone");
                return false;
            }
            declaredMethod2.invoke(invoke, new Object[]{Integer.valueOf(3003)});
            return true;
        } catch (Exception e) {
            C0596r.e("Reflection", e.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            Class cls = Class.forName("cn.com.smartdevices.bracelet.DynamicManager");
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod == null) {
                C0596r.e("Reflection", "getInstance is gone");
                return false;
            }
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                C0596r.e("Reflection", "getInstance invoke is failed");
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("analysisDynamic", new Class[]{Context.class, Boolean.TYPE});
            if (declaredMethod2 == null) {
                C0596r.e("Reflection", "analysisDynamic invoke is gone");
                return false;
            }
            declaredMethod2.invoke(invoke, new Object[]{context, Boolean.valueOf(z)});
            return true;
        } catch (Exception e) {
            C0596r.e("Reflection", e.getMessage());
            return false;
        }
    }
}
