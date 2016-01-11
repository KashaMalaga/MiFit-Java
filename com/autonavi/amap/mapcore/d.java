package com.autonavi.amap.mapcore;

import java.util.Hashtable;

class d {
    private Hashtable a = new Hashtable();

    public void a(String str) {
        this.a.remove(str);
    }

    public boolean b(String str) {
        return this.a.get(str) != null;
    }

    public void c(String str) {
        this.a.put(str, new b(str, 0));
    }
}
