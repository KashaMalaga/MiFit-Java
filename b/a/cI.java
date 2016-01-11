package b.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class cI implements Serializable {
    private static Map<Class<? extends cq>, Map<? extends cz, cI>> d = new HashMap();
    public final String a;
    public final byte b;
    public final cJ c;

    public cI(String str, byte b, cJ cJVar) {
        this.a = str;
        this.b = b;
        this.c = cJVar;
    }

    public static Map<? extends cz, cI> a(Class<? extends cq> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return (Map) d.get(cls);
    }

    public static void a(Class<? extends cq> cls, Map<? extends cz, cI> map) {
        d.put(cls, map);
    }
}
