package com.c.b.c.b;

import java.util.ArrayList;
import java.util.List;

public final class d {
    private final a a;
    private final List<b> b = new ArrayList();

    public d(a aVar) {
        this.a = aVar;
        this.b.add(new b(aVar, new int[]{1}));
    }

    private b a(int i) {
        if (i >= this.b.size()) {
            b bVar = (b) this.b.get(this.b.size() - 1);
            b bVar2 = bVar;
            for (int size = this.b.size(); size <= i; size++) {
                bVar2 = bVar2.b(new b(this.a, new int[]{1, this.a.a((size - 1) + this.a.d())}));
                this.b.add(bVar2);
            }
        }
        return (b) this.b.get(i);
    }

    public void a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a = a(i);
        Object obj = new int[length];
        System.arraycopy(iArr, 0, obj, 0, length);
        obj = new b(this.a, obj).a(i, 1).c(a)[1].a();
        int length2 = i - obj.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(obj, 0, iArr, length + length2, obj.length);
    }
}
