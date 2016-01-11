package b.a;

import cn.com.smartdevices.bracelet.gps.services.ay;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.l;

public enum C0388n implements cz {
    TS((short) 1, ay.H);
    
    private static final Map<String, C0388n> b = null;
    private final short c;
    private final String d;

    static {
        b = new HashMap();
        Iterator it = EnumSet.allOf(C0388n.class).iterator();
        while (it.hasNext()) {
            C0388n c0388n = (C0388n) it.next();
            b.put(c0388n.b(), c0388n);
        }
    }

    private C0388n(short s, String str) {
        this.c = s;
        this.d = str;
    }

    public static C0388n a(int i) {
        switch (i) {
            case l.a /*1*/:
                return TS;
            default:
                return null;
        }
    }

    public static C0388n a(String str) {
        return (C0388n) b.get(str);
    }

    public static C0388n b(int i) {
        C0388n a = C0388n.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }
}
