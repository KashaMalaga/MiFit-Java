package com.c.b.h.a;

import com.c.b.h.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class b {
    private final Map<Integer, Integer> a = new HashMap();

    b() {
    }

    void a(int i) {
        Integer num = (Integer) this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    int[] a() {
        Collection arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.a.entrySet()) {
            int i2;
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
                i2 = i;
            } else {
                if (((Integer) entry.getValue()).intValue() == i) {
                    arrayList.add(entry.getKey());
                }
                i2 = i;
            }
            i = i2;
        }
        return a.a(arrayList);
    }

    public Integer b(int i) {
        return (Integer) this.a.get(Integer.valueOf(i));
    }
}
