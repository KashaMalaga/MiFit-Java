package cn.com.smartdevices.bracelet.honor.a;

import com.c.a.a.b;
import java.io.Serializable;

public class c implements Serializable {
    public static final transient int a = 1;
    public static final transient int b = 2;
    public static final transient int c = 3;
    private static final long serialVersionUID = -706847041877812581L;
    @b(a = "type")
    public int d;
    @b(a = "id")
    public long e;
    @b(a = "value")
    public String f;
    @b(a = "state")
    public int g;
    @b(a = "get_time")
    public long h;
    @b(a = "sync_mark")
    public boolean i;

    public c(int i, long j, String str) {
        this.d = i;
        this.e = j;
        if (str != null) {
            this.f = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.e != cVar.e ? false : this.d != cVar.d ? false : this.f == null ? cVar.f == null : this.f.equals(cVar.f);
    }

    public int hashCode() {
        return (this.f == null ? 0 : this.f.hashCode()) + ((((((int) (this.e ^ (this.e >>> 32))) + 31) * 31) + this.d) * 31);
    }

    public String toString() {
        return "MyMedal [type=" + this.d + ", id=" + this.e + ", value=" + this.f + ", state=" + this.g + ", getTime=" + this.h + "]";
    }
}
