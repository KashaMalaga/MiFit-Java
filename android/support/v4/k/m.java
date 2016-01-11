package android.support.v4.k;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

class m implements o {
    public static final m a = new m(true);
    public static final m b = new m(false);
    private final boolean c;

    private m(boolean z) {
        this.c = z;
    }

    public int a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            switch (k.c(Character.getDirectionality(charSequence.charAt(i)))) {
                case a.i /*0*/:
                    if (!this.c) {
                        i4 = 1;
                        break;
                    }
                    return 0;
                case l.a /*1*/:
                    if (this.c) {
                        i4 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
            i++;
        }
        return i4 != 0 ? !this.c ? 0 : 1 : 2;
    }
}
