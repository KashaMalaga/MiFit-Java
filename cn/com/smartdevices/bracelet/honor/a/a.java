package cn.com.smartdevices.bracelet.honor.a;

import com.c.a.a.b;
import java.io.Serializable;

public class a implements Serializable {
    private static final long serialVersionUID = -1796985850800580242L;
    @b(a = "config")
    public b a;
    @b(a = "my_medal")
    public c b;

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
        a aVar = (a) obj;
        return this.b == null ? aVar.b == null : this.b.equals(aVar.b);
    }

    public int hashCode() {
        return (this.b == null ? 0 : this.b.hashCode()) + 31;
    }

    public String toString() {
        return "Medal [config=" + this.a + ", myDedal=" + this.b + "]";
    }
}
