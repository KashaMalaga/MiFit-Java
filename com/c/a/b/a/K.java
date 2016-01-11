package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;
import java.util.BitSet;
import kankan.wheel.widget.l;

final class K extends N<BitSet> {
    K() {
    }

    public BitSet a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        BitSet bitSet = new BitSet();
        aVar.a();
        d f = aVar.f();
        int i = 0;
        while (f != d.END_ARRAY) {
            boolean z;
            switch (Z.a[f.ordinal()]) {
                case l.a /*1*/:
                    if (aVar.m() == 0) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case kankan.wheel.widget.a.k /*2*/:
                    z = aVar.i();
                    break;
                case kankan.wheel.widget.a.l /*3*/:
                    String h = aVar.h();
                    try {
                        if (Integer.parseInt(h) == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    } catch (NumberFormatException e) {
                        throw new G("Error: Expecting: bitset number value (1, 0), Found: " + h);
                    }
                default:
                    throw new G("Invalid bitset value type: " + f);
            }
            if (z) {
                bitSet.set(i);
            }
            i++;
            f = aVar.f();
        }
        aVar.b();
        return bitSet;
    }

    public void a(e eVar, BitSet bitSet) {
        if (bitSet == null) {
            eVar.f();
            return;
        }
        eVar.b();
        for (int i = 0; i < bitSet.length(); i++) {
            eVar.a((long) (bitSet.get(i) ? 1 : 0));
        }
        eVar.c();
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
