package b.a;

import java.lang.reflect.InvocationTargetException;

public class C0361cx {
    public static cw a(Class<? extends cw> cls, int i) {
        try {
            return (cw) cls.getMethod("findByValue", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (InvocationTargetException e3) {
            return null;
        }
    }
}
