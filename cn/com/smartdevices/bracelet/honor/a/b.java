package cn.com.smartdevices.bracelet.honor.a;

import java.io.Serializable;

public class b implements Serializable {
    public static final transient int a = 1;
    public static final transient int b = 2;
    private static final long serialVersionUID = -2596943824379920159L;
    @com.c.a.a.b(a = "type")
    public int c;
    @com.c.a.a.b(a = "id")
    public int d;
    @com.c.a.a.b(a = "value")
    public String e;
    @com.c.a.a.b(a = "title")
    public String f;
    @com.c.a.a.b(a = "tips")
    public String g;
    @com.c.a.a.b(a = "desc")
    public String h;
    @com.c.a.a.b(a = "icon")
    public String i;
    @com.c.a.a.b(a = "value_to_text")
    public String j;

    public b(int i, int i2, String str) {
        this.c = i;
        this.d = i2;
        this.e = str;
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
        b bVar = (b) obj;
        return this.d != bVar.d ? false : this.c != bVar.c ? false : this.e == null ? bVar.e == null : this.e.equals(bVar.e);
    }

    public int hashCode() {
        return (this.e == null ? 0 : this.e.hashCode()) + (((((this.d ^ (this.d >>> 32)) + 31) * 31) + this.c) * 31);
    }

    public String toString() {
        return "MedalConfig [type=" + this.c + ", id=" + this.d + ", value=" + this.e + ", title=" + this.f + ", tips=" + this.g + ", desc=" + this.h + ", icon=" + this.i + ", value2Text=" + this.j + "]";
    }
}
