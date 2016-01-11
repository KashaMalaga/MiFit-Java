package cn.com.smartdevices.bracelet.gps.sync;

import java.util.ArrayList;
import java.util.List;

class C0474g {
    List<Long> a = null;
    List<Long> b = null;

    public C0474g(int i) {
        if (i == -1) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            return;
        }
        this.a = new ArrayList(i);
        this.b = new ArrayList(i);
    }

    public static C0474g a(List<Long> list, List<Long> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException();
        }
        C0474g c0474g = new C0474g(-1);
        int size = list.size();
        int size2 = list2.size();
        int max = Math.max(size, size2);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= max && i >= max) {
                return c0474g;
            }
            long longValue = i2 < size ? ((Long) list.get(i2)).longValue() : -1;
            long longValue2 = i < size2 ? ((Long) list2.get(i)).longValue() : -1;
            if (longValue > longValue2) {
                c0474g.a.add(Long.valueOf(longValue));
                i2++;
            } else if (longValue < longValue2) {
                c0474g.b.add(Long.valueOf(longValue2));
                i++;
            } else {
                i++;
                i2++;
            }
        }
    }
}
