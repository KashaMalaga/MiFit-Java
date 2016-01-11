package b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum bJ implements cz {
    CLIENT_STATS((short) 1, "client_stats"),
    APP_INFO((short) 2, "app_info"),
    DEVICE_INFO((short) 3, "device_info"),
    MISC_INFO((short) 4, "misc_info"),
    ACTIVATE_MSG((short) 5, "activate_msg"),
    INSTANT_MSGS((short) 6, "instant_msgs"),
    SESSIONS((short) 7, "sessions"),
    IMPRINT((short) 8, "imprint"),
    ID_TRACKING((short) 9, "id_tracking");
    
    private static final Map<String, bJ> j = null;
    private final short k;
    private final String l;

    static {
        j = new HashMap();
        Iterator it = EnumSet.allOf(bJ.class).iterator();
        while (it.hasNext()) {
            bJ bJVar = (bJ) it.next();
            j.put(bJVar.b(), bJVar);
        }
    }

    private bJ(short s, String str) {
        this.k = s;
        this.l = str;
    }

    public static bJ a(int i) {
        switch (i) {
            case l.a /*1*/:
                return CLIENT_STATS;
            case a.k /*2*/:
                return APP_INFO;
            case a.l /*3*/:
                return DEVICE_INFO;
            case a.aQ /*4*/:
                return MISC_INFO;
            case a.X /*5*/:
                return ACTIVATE_MSG;
            case a.bt /*6*/:
                return INSTANT_MSGS;
            case a.bc /*7*/:
                return SESSIONS;
            case a.ba /*8*/:
                return IMPRINT;
            case a.bo /*9*/:
                return ID_TRACKING;
            default:
                return null;
        }
    }

    public static bJ a(String str) {
        return (bJ) j.get(str);
    }

    public static bJ b(int i) {
        bJ a = a(i);
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
