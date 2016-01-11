package b.a;

import com.amap.api.services.district.DistrictSearchQuery;
import com.sina.weibo.sdk.constant.WBPageConstants.ParamKey;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum aV implements cz {
    TIME_ZONE((short) 1, "time_zone"),
    LANGUAGE((short) 2, "language"),
    COUNTRY((short) 3, DistrictSearchQuery.KEYWORDS_COUNTRY),
    LATITUDE((short) 4, ParamKey.LATITUDE),
    LONGITUDE((short) 5, ParamKey.LONGITUDE),
    CARRIER((short) 6, "carrier"),
    LATENCY((short) 7, "latency"),
    DISPLAY_NAME((short) 8, "display_name"),
    ACCESS_TYPE((short) 9, "access_type"),
    ACCESS_SUBTYPE((short) 10, "access_subtype"),
    USER_INFO((short) 11, "user_info");
    
    private static final Map<String, aV> l = null;
    private final short m;
    private final String n;

    static {
        l = new HashMap();
        Iterator it = EnumSet.allOf(aV.class).iterator();
        while (it.hasNext()) {
            aV aVVar = (aV) it.next();
            l.put(aVVar.b(), aVVar);
        }
    }

    private aV(short s, String str) {
        this.m = s;
        this.n = str;
    }

    public static aV a(int i) {
        switch (i) {
            case l.a /*1*/:
                return TIME_ZONE;
            case a.k /*2*/:
                return LANGUAGE;
            case a.l /*3*/:
                return COUNTRY;
            case a.aQ /*4*/:
                return LATITUDE;
            case a.X /*5*/:
                return LONGITUDE;
            case a.bt /*6*/:
                return CARRIER;
            case a.bc /*7*/:
                return LATENCY;
            case a.ba /*8*/:
                return DISPLAY_NAME;
            case a.bo /*9*/:
                return ACCESS_TYPE;
            case a.bd /*10*/:
                return ACCESS_SUBTYPE;
            case a.aW /*11*/:
                return USER_INFO;
            default:
                return null;
        }
    }

    public static aV a(String str) {
        return (aV) l.get(str);
    }

    public static aV b(int i) {
        aV a = a(i);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException("Field " + i + " doesn't exist!");
    }

    public short a() {
        return this.m;
    }

    public String b() {
        return this.n;
    }
}
