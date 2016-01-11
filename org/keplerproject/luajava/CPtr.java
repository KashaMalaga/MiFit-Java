package org.keplerproject.luajava;

public class CPtr {
    private long peer;

    CPtr() {
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (CPtr.class != obj.getClass()) {
            return false;
        }
        if (this.peer != ((CPtr) obj).peer) {
            z = false;
        }
        return z;
    }

    protected long getPeer() {
        return this.peer;
    }
}
