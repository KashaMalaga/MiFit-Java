package android.support.v4.k;

import java.nio.CharBuffer;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

abstract class p implements j {
    private final o a;

    public p(o oVar) {
        this.a = oVar;
    }

    private boolean b(CharSequence charSequence, int i, int i2) {
        switch (this.a.a(charSequence, i, i2)) {
            case a.i /*0*/:
                return true;
            case l.a /*1*/:
                return false;
            default:
                return a();
        }
    }

    protected abstract boolean a();

    public boolean a(CharSequence charSequence, int i, int i2) {
        if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
            return this.a == null ? a() : b(charSequence, i, i2);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean a(char[] cArr, int i, int i2) {
        return a(CharBuffer.wrap(cArr), i, i2);
    }
}
