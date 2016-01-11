package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum Z implements cw {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    private final int d;

    private Z(int i) {
        this.d = i;
    }

    public static Z a(int i) {
        switch (i) {
            case a.i /*0*/:
                return MALE;
            case l.a /*1*/:
                return FEMALE;
            case a.k /*2*/:
                return UNKNOWN;
            default:
                return null;
        }
    }

    public int a() {
        return this.d;
    }
}
