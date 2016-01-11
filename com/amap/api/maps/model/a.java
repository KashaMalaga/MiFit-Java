package com.amap.api.maps.model;

import com.amap.api.mapcore.util.h;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class a {
    private final h a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    private a(double d, double d2, double d3, double d4, int i) {
        this(new h(d, d2, d3, d4), i);
    }

    protected a(h hVar) {
        this(hVar, 0);
    }

    private a(h hVar, int i) {
        this.d = null;
        this.a = hVar;
        this.b = i;
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new a(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new a(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new a(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
        List<WeightedLatLng> list = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.d == null) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(weightedLatLng);
            if (this.c.size() > 50 && this.b < 40) {
                a();
            }
        } else if (d2 < this.a.f) {
            if (d < this.a.e) {
                ((a) this.d.get(0)).a(d, d2, weightedLatLng);
            } else {
                ((a) this.d.get(1)).a(d, d2, weightedLatLng);
            }
        } else if (d < this.a.e) {
            ((a) this.d.get(2)).a(d, d2, weightedLatLng);
        } else {
            ((a) this.d.get(3)).a(d, d2, weightedLatLng);
        }
    }

    private void a(h hVar, Collection<WeightedLatLng> collection) {
        if (!this.a.a(hVar)) {
            return;
        }
        if (this.d != null) {
            for (a a : this.d) {
                a.a(hVar, collection);
            }
        } else if (this.c == null) {
        } else {
            if (hVar.b(this.a)) {
                collection.addAll(this.c);
                return;
            }
            for (WeightedLatLng weightedLatLng : this.c) {
                if (hVar.a(weightedLatLng.getPoint())) {
                    collection.add(weightedLatLng);
                }
            }
        }
    }

    protected Collection<WeightedLatLng> a(h hVar) {
        Collection<WeightedLatLng> arrayList = new ArrayList();
        a(hVar, arrayList);
        return arrayList;
    }

    protected void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }
}
