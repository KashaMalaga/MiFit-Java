package com.amap.api.services.geocoder;

public class GeocodeQuery {
    private String a;
    private String b;

    public GeocodeQuery(String str, String str2) {
        this.a = str;
        this.b = str2;
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
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        if (this.b == null) {
            if (geocodeQuery.b != null) {
                return false;
            }
        } else if (!this.b.equals(geocodeQuery.b)) {
            return false;
        }
        return this.a == null ? geocodeQuery.a == null : this.a.equals(geocodeQuery.a);
    }

    public String getCity() {
        return this.b;
    }

    public String getLocationName() {
        return this.a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + 31) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setLocationName(String str) {
        this.a = str;
    }
}
