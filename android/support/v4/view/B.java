package android.support.v4.view;

import android.support.v4.view.a.C0113o;
import android.view.KeyEvent;
import android.view.KeyEvent.Callback;
import android.view.View;

class B implements E {
    private static final int a = 247;
    private static final int b = 247;

    B() {
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        Object obj = 1;
        Object obj2 = (i2 & i3) != 0 ? 1 : null;
        int i6 = i4 | i5;
        if ((i2 & i6) == 0) {
            obj = null;
        }
        if (obj2 == null) {
            return obj != null ? i & (i3 ^ -1) : i;
        } else {
            if (obj == null) {
                return i & (i6 ^ -1);
            }
            throw new IllegalArgumentException("bad arguments");
        }
    }

    public int a(int i) {
        int i2 = (i & 192) != 0 ? i | 1 : i;
        if ((i2 & 48) != 0) {
            i2 |= 2;
        }
        return i2 & b;
    }

    public Object a(View view) {
        return null;
    }

    public void a(KeyEvent keyEvent) {
    }

    public boolean a(int i, int i2) {
        return a(a(a(i) & b, i2, 1, 64, C0113o.h), i2, 2, 16, 32) == i2;
    }

    public boolean a(KeyEvent keyEvent, Callback callback, Object obj, Object obj2) {
        return keyEvent.dispatch(callback);
    }

    public boolean b(int i) {
        return (a(i) & b) == 0;
    }

    public boolean b(KeyEvent keyEvent) {
        return false;
    }
}
