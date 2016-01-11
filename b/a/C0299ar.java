package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0299ar implements cz {
    SNAPSHOTS((short) 1, "snapshots"),
    JOURNALS((short) 2, "journals"),
    CHECKSUM((short) 3, "checksum");
    
    private static final Map<String, C0299ar> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C0299ar.class).iterator();
        while (it.hasNext()) {
            C0299ar c0299ar = (C0299ar) it.next();
            d.put(c0299ar.b(), c0299ar);
        }
    }

    private C0299ar(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static C0299ar a(int i) {
        switch (i) {
            case l.a /*1*/:
                return SNAPSHOTS;
            case a.k /*2*/:
                return JOURNALS;
            case a.l /*3*/:
                return CHECKSUM;
            default:
                return null;
        }
    }

    public static C0299ar a(String str) {
        return (C0299ar) d.get(str);
    }

    public static C0299ar b(int i) {
        C0299ar a = C0299ar.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }
}
