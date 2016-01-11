package b.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0332bx implements cz {
    ID((short) 1, SyncShoesDataService.d),
    START_TIME((short) 2, "start_time"),
    END_TIME((short) 3, "end_time"),
    DURATION((short) 4, "duration"),
    PAGES((short) 5, "pages"),
    LOCATIONS((short) 6, "locations"),
    TRAFFIC((short) 7, "traffic");
    
    private static final Map<String, C0332bx> h = null;
    private final short i;
    private final String j;

    static {
        h = new HashMap();
        Iterator it = EnumSet.allOf(C0332bx.class).iterator();
        while (it.hasNext()) {
            C0332bx c0332bx = (C0332bx) it.next();
            h.put(c0332bx.b(), c0332bx);
        }
    }

    private C0332bx(short s, String str) {
        this.i = s;
        this.j = str;
    }

    public static C0332bx a(int i) {
        switch (i) {
            case l.a /*1*/:
                return ID;
            case a.k /*2*/:
                return START_TIME;
            case a.l /*3*/:
                return END_TIME;
            case a.aQ /*4*/:
                return DURATION;
            case a.X /*5*/:
                return PAGES;
            case a.bt /*6*/:
                return LOCATIONS;
            case a.bc /*7*/:
                return TRAFFIC;
            default:
                return null;
        }
    }

    public static C0332bx a(String str) {
        return (C0332bx) h.get(str);
    }

    public static C0332bx b(int i) {
        C0332bx a = C0332bx.a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.i;
    }

    public String b() {
        return this.j;
    }
}
