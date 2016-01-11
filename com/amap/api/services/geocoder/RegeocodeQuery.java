package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
    private LatLonPoint a;
    private float b;
    private String c = GeocodeSearch.AMAP;

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.a = latLonPoint;
        this.b = f;
        setLatLonType(str);
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
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        if (this.c == null) {
            if (regeocodeQuery.c != null) {
                return false;
            }
        } else if (!this.c.equals(regeocodeQuery.c)) {
            return false;
        }
        if (this.a == null) {
            if (regeocodeQuery.a != null) {
                return false;
            }
        } else if (!this.a.equals(regeocodeQuery.a)) {
            return false;
        }
        return Float.floatToIntBits(this.b) == Float.floatToIntBits(regeocodeQuery.b);
    }

    public String getLatLonType() {
        return this.c;
    }

    public LatLonPoint getPoint() {
        return this.a;
    }

    public float getRadius() {
        return this.b;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + 31) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.b);
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
            this.c = str;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setRadius(float f) {
        this.b = f;
    }
}
