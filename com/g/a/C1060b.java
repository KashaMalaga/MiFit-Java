package com.g.a;

import b.a.Z;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum C1060b {
    Male(1),
    Female(2),
    Unknown(0);
    
    public int d;

    private C1060b(int i) {
        this.d = i;
    }

    public static Z a(C1060b c1060b) {
        switch (C1060b.b()[c1060b.ordinal()]) {
            case l.a /*1*/:
                return Z.MALE;
            case a.k /*2*/:
                return Z.FEMALE;
            default:
                return Z.UNKNOWN;
        }
    }

    public static C1060b a(int i) {
        switch (i) {
            case l.a /*1*/:
                return Male;
            case a.k /*2*/:
                return Female;
            default:
                return Unknown;
        }
    }

    public int a() {
        return this.d;
    }
}
