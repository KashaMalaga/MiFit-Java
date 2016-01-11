package com.xiaomi.hm.health.bt.model;

import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;

public final class s {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public s(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n     wake: " + this.a + "ms");
        stringBuilder.append("\n  vibrate: " + this.b + "ms");
        stringBuilder.append("\n    light: " + this.c + "ms");
        stringBuilder.append("\n     conn: " + this.d + GroupItemBaseInfo.KEY_START_TIME);
        stringBuilder.append("\n      adv: " + this.e + GroupItemBaseInfo.KEY_START_TIME);
        return stringBuilder.toString();
    }
}
