package android.support.v4.view.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.List;

public class L {
    private static final M a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 19) {
            a = new P();
        } else if (VERSION.SDK_INT >= 16) {
            a = new N();
        } else {
            a = new R();
        }
    }

    public L() {
        this.b = a.a(this);
    }

    public L(Object obj) {
        this.b = obj;
    }

    public C0113o a(int i) {
        return null;
    }

    public Object a() {
        return this.b;
    }

    public List<C0113o> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0113o b(int i) {
        return null;
    }
}
