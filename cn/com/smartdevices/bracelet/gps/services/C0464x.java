package cn.com.smartdevices.bracelet.gps.services;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import cn.com.smartdevices.bracelet.gps.services.a.a;
import cn.com.smartdevices.bracelet.gps.services.a.b;
import java.util.LinkedList;
import java.util.List;

class C0464x {
    private static final String c = "GPSSportObserverCenter";
    private List<b> a;
    private List<a> b;

    public C0464x() {
        this.a = null;
        this.b = null;
        this.a = new LinkedList();
        this.b = new LinkedList();
    }

    public int a() {
        return this.b.size();
    }

    void a(int i) {
        C0596r.d(c, "onGPSSignalChanged|level:" + i);
        for (b a : this.a) {
            a.a(i);
        }
    }

    void a(int i, int i2) {
        for (a b : this.b) {
            b.b(i, i2);
        }
    }

    void a(int i, boolean z) {
        C0596r.d(c, "onGPSSportStateChanged|state:" + i);
        for (a a : this.b) {
            a.a(i, z);
        }
    }

    void a(long j) {
        for (a a : this.b) {
            a.a(j);
        }
    }

    void a(c cVar) {
        for (b a : this.a) {
            a.a(cVar);
        }
    }

    void a(c cVar, c cVar2, g gVar) {
        for (b a : this.a) {
            a.a(cVar, cVar2, gVar);
        }
    }

    public void a(a aVar) {
        C0596r.d(c, "registerGPSSportObserver");
        if (aVar == null) {
            throw new IllegalArgumentException("Argument shouldnt be null");
        } else if (!this.b.contains(aVar)) {
            this.b.add(aVar);
        }
    }

    public void a(b bVar) {
        C0596r.d(c, "registerGPSStateObserver");
        if (bVar == null) {
            throw new IllegalArgumentException("Argument shouldnt be null");
        } else if (!this.a.contains(bVar)) {
            this.a.add(bVar);
        }
    }

    void a(az azVar) {
        for (a a : this.b) {
            a.a(azVar);
        }
    }

    void a(List<c> list, g gVar) {
        for (b a : this.a) {
            a.a(list, gVar);
        }
    }

    void b() {
        this.a.clear();
        this.b.clear();
    }

    void b(int i) {
        C0596r.d(c, "onGPSStateChanged|state:" + i);
        for (b b : this.a) {
            b.b(i);
        }
    }

    public void b(a aVar) {
        C0596r.d(c, "unregisterGPSSportObserver");
        if (aVar == null) {
            throw new IllegalArgumentException("Argument shouldnt be null");
        } else if (this.b.contains(aVar)) {
            this.b.remove(aVar);
        }
    }

    public void b(b bVar) {
        C0596r.d(c, "unregisterGPSStateObserver");
        if (bVar == null) {
            throw new IllegalArgumentException("Argument shouldnt be null");
        } else if (this.a.contains(bVar)) {
            this.a.remove(bVar);
        }
    }
}
