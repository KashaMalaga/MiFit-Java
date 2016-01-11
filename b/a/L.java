package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum L implements cz {
    TS((short) 1, ay.H),
    NAME((short) 2, "name"),
    CKV((short) 3, "ckv"),
    DURATION((short) 4, "duration"),
    ACC((short) 5, "acc");
    
    private static final Map<String, L> f = null;
    private final short g;
    private final String h;

    static {
        f = new HashMap();
        Iterator it = EnumSet.allOf(L.class).iterator();
        while (it.hasNext()) {
            L l = (L) it.next();
            f.put(l.b(), l);
        }
    }

    private L(short s, String str) {
        this.g = s;
        this.h = str;
    }

    public static L a(int i) {
        switch (i) {
            case l.a /*1*/:
                return TS;
            case a.k /*2*/:
                return NAME;
            case a.l /*3*/:
                return CKV;
            case a.aQ /*4*/:
                return DURATION;
            case a.X /*5*/:
                return ACC;
            default:
                return null;
        }
    }

    public static L a(String str) {
        return (L) f.get(str);
    }

    public static L b(int i) {
        L a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.g;
    }

    public String b() {
        return this.h;
    }
}
