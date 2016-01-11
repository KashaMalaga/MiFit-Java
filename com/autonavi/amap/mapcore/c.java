package com.autonavi.amap.mapcore;

import java.util.Vector;

class c extends Vector {
    protected int a = -1;

    c() {
    }

    public synchronized Object a() {
        Object obj;
        if (b()) {
            obj = null;
        } else {
            obj = super.elementAt(0);
            super.removeElementAt(0);
        }
        return obj;
    }

    public synchronized void a(Object obj) {
        if (this.a > 0 && size() > this.a) {
            a();
        }
        super.addElement(obj);
    }

    public boolean b() {
        return super.isEmpty();
    }

    public synchronized void clear() {
        super.removeAllElements();
    }

    public synchronized boolean equals(Object obj) {
        return super.equals(obj);
    }

    public synchronized int hashCode() {
        return super.hashCode();
    }
}
