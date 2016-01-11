package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0310bb implements cz {
    PAGE_NAME((short) 1, "page_name"),
    DURATION((short) 2, "duration");
    
    private static final Map<String, C0310bb> c = null;
    private final short d;
    private final String e;

    static {
        c = new HashMap();
        Iterator it = EnumSet.allOf(C0310bb.class).iterator();
        while (it.hasNext()) {
            C0310bb c0310bb = (C0310bb) it.next();
            c.put(c0310bb.b(), c0310bb);
        }
    }

    private C0310bb(short s, String str) {
        this.d = s;
        this.e = str;
    }

    public static C0310bb a(int i) {
        switch (i) {
            case l.a /*1*/:
                return PAGE_NAME;
            case a.k /*2*/:
                return DURATION;
            default:
                return null;
        }
    }

    public static C0310bb a(String str) {
        return (C0310bb) c.get(str);
    }

    public static C0310bb b(int i) {
        C0310bb a = C0310bb.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }
}
