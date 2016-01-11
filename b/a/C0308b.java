package b.a;

import java.io.Serializable;
import java.util.Map;

public class C0308b implements Serializable {
    private static final long e = 1;
    public long a = System.currentTimeMillis();
    public String b;
    public String c;
    public Map<String, Object> d;

    public String a() {
        return this.b + this.c;
    }
}
