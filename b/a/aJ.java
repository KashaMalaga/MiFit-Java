package b.a;

import cn.com.smartdevices.bracelet.shoes.sync.SyncShoesDataService;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum aJ implements cz {
    ID((short) 1, SyncShoesDataService.d),
    ERRORS((short) 2, "errors"),
    EVENTS((short) 3, "events"),
    GAME_EVENTS((short) 4, "game_events");
    
    private static final Map<String, aJ> e = null;
    private final short f;
    private final String g;

    static {
        e = new HashMap();
        Iterator it = EnumSet.allOf(aJ.class).iterator();
        while (it.hasNext()) {
            aJ aJVar = (aJ) it.next();
            e.put(aJVar.b(), aJVar);
        }
    }

    private aJ(short s, String str) {
        this.f = s;
        this.g = str;
    }

    public static aJ a(int i) {
        switch (i) {
            case l.a /*1*/:
                return ID;
            case a.k /*2*/:
                return ERRORS;
            case a.l /*3*/:
                return EVENTS;
            case a.aQ /*4*/:
                return GAME_EVENTS;
            default:
                return null;
        }
    }

    public static aJ a(String str) {
        return (aJ) e.get(str);
    }

    public static aJ b(int i) {
        aJ a = a(i);
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
