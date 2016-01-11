package com.c.a.b.a;

import com.c.a.G;
import com.c.a.N;
import com.c.a.d.a;
import com.c.a.d.d;
import com.c.a.d.e;

final class C extends N<Character> {
    C() {
    }

    public Character a(a aVar) {
        if (aVar.f() == d.NULL) {
            aVar.j();
            return null;
        }
        String h = aVar.h();
        if (h.length() == 1) {
            return Character.valueOf(h.charAt(0));
        }
        throw new G("Expecting character, got: " + h);
    }

    public void a(e eVar, Character ch) {
        eVar.b(ch == null ? null : String.valueOf(ch));
    }

    public /* synthetic */ Object b(a aVar) {
        return a(aVar);
    }
}
