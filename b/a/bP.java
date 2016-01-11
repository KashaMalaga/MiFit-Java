package b.a;

import cn.com.smartdevices.bracelet.j.f;
import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import com.xiaomi.market.sdk.o;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum bP implements cz {
    GENDER((short) 1, f.B),
    AGE((short) 2, f.am),
    ID((short) 3, SyncShoesDataService.d),
    SOURCE((short) 4, o.L);
    
    private static final Map<String, bP> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(bP.class).iterator();
        while (it.hasNext()) {
            bP bPVar = (bP) it.next();
            e.put(bPVar.b(), bPVar);
        }
    }

    private bP(short s, String str) {
        this.f = s;
        this.g = str;
    }

    public static bP a(int i) {
        switch (i) {
            case l.a /*1*/:
                return GENDER;
            case a.k /*2*/:
                return AGE;
            case a.l /*3*/:
                return ID;
            case a.aQ /*4*/:
                return SOURCE;
            default:
                return null;
        }
    }

    public static bP a(String str) {
        return (bP) e.get(str);
    }

    public static bP b(int i) {
        bP a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }
}
