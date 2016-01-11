package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum S implements cw {
    LEGIT(1),
    ALIEN(2);
    
    private final int c;

    private S(int i) {
        this.c = i;
    }

    public static S a(int i) {
        switch (i) {
            case l.a /*1*/:
                return LEGIT;
            case a.k /*2*/:
                return ALIEN;
            default:
                return null;
        }
    }

    public int a() {
        return this.c;
    }
}
