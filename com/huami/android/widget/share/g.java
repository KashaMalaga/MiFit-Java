package com.huami.android.widget.share;

import com.c.a.a.b;
import java.io.Serializable;

public class g implements Serializable {
    private static final long serialVersionUID = 5020344097460101540L;
    @b(a = "type")
    public int a;
    @b(a = "times")
    public int b;

    public g(int i) {
        this.a = i;
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
        return this.a == ((g) obj).a;
    }

    public int hashCode() {
        return this.a + 31;
    }

    public String toString() {
        return "Shares [type=" + this.a + ", times=" + this.b + "]";
    }
}
