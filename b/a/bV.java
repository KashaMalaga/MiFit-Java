package b.a;

import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum bV implements cz {
    VERSION((short) 1, o.x),
    ADDRESS((short) 2, "address"),
    SIGNATURE((short) 3, o.g),
    SERIAL_NUM((short) 4, "serial_num"),
    TS_SECS((short) 5, "ts_secs"),
    LENGTH((short) 6, "length"),
    ENTITY((short) 7, "entity"),
    GUID((short) 8, "guid"),
    CHECKSUM((short) 9, "checksum");
    
    private static final Map<String, bV> j = null;
    private final short k;
    private final String l;

    static {
        j = new HashMap();
        Iterator it = EnumSet.allOf(bV.class).iterator();
        while (it.hasNext()) {
            bV bVVar = (bV) it.next();
            j.put(bVVar.b(), bVVar);
        }
    }

    private bV(short s, String str) {
        this.k = s;
        this.l = str;
    }

    public static bV a(int i) {
        switch (i) {
            case l.a /*1*/:
                return VERSION;
            case a.k /*2*/:
                return ADDRESS;
            case a.l /*3*/:
                return SIGNATURE;
            case a.aQ /*4*/:
                return SERIAL_NUM;
            case a.X /*5*/:
                return TS_SECS;
            case a.bt /*6*/:
                return LENGTH;
            case a.bc /*7*/:
                return ENTITY;
            case a.ba /*8*/:
                return GUID;
            case a.bo /*9*/:
                return CHECKSUM;
            default:
                return null;
        }
    }

    public static bV a(String str) {
        return (bV) j.get(str);
    }

    public static bV b(int i) {
        bV a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.k;
    }

    public String b() {
        return this.l;
    }
}
