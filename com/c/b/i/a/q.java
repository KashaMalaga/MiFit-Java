package com.c.b.i.a;

import com.xiaomi.hm.health.t;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public enum q {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] k;
    private final int l;

    private q(int[] iArr, int i) {
        this.k = iArr;
        this.l = i;
    }

    public static q a(int i) {
        switch (i) {
            case a.i /*0*/:
                return TERMINATOR;
            case l.a /*1*/:
                return NUMERIC;
            case a.k /*2*/:
                return ALPHANUMERIC;
            case a.l /*3*/:
                return STRUCTURED_APPEND;
            case a.aQ /*4*/:
                return BYTE;
            case a.X /*5*/:
                return FNC1_FIRST_POSITION;
            case a.bc /*7*/:
                return ECI;
            case a.ba /*8*/:
                return KANJI;
            case a.bo /*9*/:
                return FNC1_SECOND_POSITION;
            case t.WeightView_wv_bmi_size /*13*/:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int a() {
        return this.l;
    }

    public int a(s sVar) {
        int a = sVar.a();
        a = a <= 9 ? 0 : a <= 26 ? 1 : 2;
        return this.k[a];
    }
}
