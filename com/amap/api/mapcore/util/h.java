package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

public class h {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public h(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(h hVar) {
        return a(hVar.a, hVar.c, hVar.b, hVar.d);
    }

    public boolean a(DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    public boolean b(h hVar) {
        return hVar.a >= this.a && hVar.c <= this.c && hVar.b >= this.b && hVar.d <= this.d;
    }
}
