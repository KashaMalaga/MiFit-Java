package com.amap.api.location;

public class g {
    long a;
    public AMapLocationListener b;
    Boolean c;

    public g(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.a = j;
        this.b = aMapLocationListener;
        this.c = Boolean.valueOf(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.b == null ? gVar.b == null : this.b.equals(gVar.b);
    }

    public int hashCode() {
        return (this.b == null ? 0 : this.b.hashCode()) + 31;
    }
}
