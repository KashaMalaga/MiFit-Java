package com.xiaomi.c.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;

public final class R extends EventObject {
    private final boolean a;
    private final List<C1079j> b;
    private final Throwable c;

    private R(L l, boolean z, List<C1079j> list, Throwable th) {
        super(l);
        this.a = z;
        this.c = th;
        if (this.a) {
            if (th != null) {
                throw new IllegalStateException("Cannot be connected and have a cause");
            } else if (list != null && list.size() > 0) {
                throw new IllegalStateException("Cannot be connected and have outstanding requests");
            }
        }
        if (list == null) {
            this.b = Collections.emptyList();
        } else {
            this.b = Collections.unmodifiableList(new ArrayList(list));
        }
    }

    static R a(L l) {
        return new R(l, true, null, null);
    }

    static R a(L l, List<C1079j> list, Throwable th) {
        return new R(l, false, list, th);
    }

    static R b(L l) {
        return new R(l, false, null, null);
    }

    public boolean a() {
        return this.a;
    }

    public Throwable b() {
        return this.c;
    }
}
