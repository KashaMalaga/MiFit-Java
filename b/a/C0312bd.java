package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0312bd implements cz {
    STRING_VALUE((short) 1, "string_value"),
    LONG_VALUE((short) 2, "long_value");
    
    private static final Map<String, C0312bd> c = null;
    private final short d;
    private final String e;

    static {
        c = new HashMap();
        Iterator it = EnumSet.allOf(C0312bd.class).iterator();
        while (it.hasNext()) {
            C0312bd c0312bd = (C0312bd) it.next();
            c.put(c0312bd.b(), c0312bd);
        }
    }

    private C0312bd(short s, String str) {
        this.d = s;
        this.e = str;
    }

    public static C0312bd a(int i) {
        switch (i) {
            case l.a /*1*/:
                return STRING_VALUE;
            case a.k /*2*/:
                return LONG_VALUE;
            default:
                return null;
        }
    }

    public static C0312bd a(String str) {
        return (C0312bd) c.get(str);
    }

    public static C0312bd b(int i) {
        C0312bd a = C0312bd.a(i);
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
