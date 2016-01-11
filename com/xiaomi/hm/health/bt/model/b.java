package com.xiaomi.hm.health.bt.model;

import android.support.v4.view.a.C0113o;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b<T> {
    public final Calendar a;
    public final List<T> b;

    public b(Calendar calendar, int i) {
        this.a = calendar;
        this.b = new ArrayList(i);
    }

    public b(Calendar calendar, List<T> list) {
        this.a = calendar;
        this.b = list;
    }

    public void a(T t) {
        this.b.add(t);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(C0113o.h);
        stringBuilder.append("[[[ " + getClass().getSimpleName() + " ]]]");
        stringBuilder.append("\n    timestamp: " + DateFormat.getDateTimeInstance().format(this.a.getTime()));
        stringBuilder.append("\n  data.size(): " + this.b.size());
        return stringBuilder.toString();
    }
}
