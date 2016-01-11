package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0400z implements cz {
    SUCCESSFUL_REQUESTS((short) 1, "successful_requests"),
    FAILED_REQUESTS((short) 2, "failed_requests"),
    LAST_REQUEST_SPENT_MS((short) 3, "last_request_spent_ms");
    
    private static final Map<String, C0400z> d = null;
    private final short e;
    private final String f;

    static {
        d = new HashMap();
        Iterator it = EnumSet.allOf(C0400z.class).iterator();
        while (it.hasNext()) {
            C0400z c0400z = (C0400z) it.next();
            d.put(c0400z.b(), c0400z);
        }
    }

    private C0400z(short s, String str) {
        this.e = s;
        this.f = str;
    }

    public static C0400z a(int i) {
        switch (i) {
            case l.a /*1*/:
                return SUCCESSFUL_REQUESTS;
            case a.k /*2*/:
                return FAILED_REQUESTS;
            case a.l /*3*/:
                return LAST_REQUEST_SPENT_MS;
            default:
                return null;
        }
    }

    public static C0400z a(String str) {
        return (C0400z) d.get(str);
    }

    public static C0400z b(int i) {
        C0400z a = C0400z.a(i);
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
