package b.a;

import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C0326br implements cw {
    ANDROID(0),
    IOS(1),
    WINDOWS_PHONE(2),
    WINDOWS_RT(3);
    
    private final int e;

    private C0326br(int i) {
        this.e = i;
    }

    public static C0326br a(int i) {
        switch (i) {
            case a.i /*0*/:
                return ANDROID;
            case l.a /*1*/:
                return IOS;
            case a.k /*2*/:
                return WINDOWS_PHONE;
            case a.l /*3*/:
                return WINDOWS_RT;
            default:
                return null;
        }
    }

    public int a() {
        return this.e;
    }
}
