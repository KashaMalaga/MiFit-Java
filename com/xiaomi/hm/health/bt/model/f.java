package com.xiaomi.hm.health.bt.model;

import android.support.v4.view.a.C0113o;
import java.text.DateFormat;
import java.util.Calendar;

public final class f {
    public int a;
    public final Calendar b;
    public int c;
    public int d;

    public f(int i, Calendar calendar, int i2, int i3) {
        this.a = i;
        this.b = calendar;
        this.c = i2;
        this.d = i3;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.a = i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n       level: " + this.a + "%");
        stringBuilder.append("\n  lastCharge: " + DateFormat.getDateTimeInstance().format(this.b.getTime()));
        stringBuilder.append("\n     charges: " + this.c);
        stringBuilder.append("\n      status: " + Integer.toHexString(this.d));
        return stringBuilder.toString();
    }
}
