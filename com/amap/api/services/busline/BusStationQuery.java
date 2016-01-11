package com.amap.api.services.busline;

import com.amap.api.services.core.e;

public class BusStationQuery {
    private String a;
    private String b;
    private int c = 10;
    private int d = 0;

    public BusStationQuery(String str, String str2) {
        this.a = str;
        this.b = str2;
        if (!a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    private boolean a() {
        return !e.a(this.a);
    }

    protected BusStationQuery clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.a, this.b);
        busStationQuery.setPageNumber(this.d);
        busStationQuery.setPageSize(this.c);
        return busStationQuery;
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
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        if (this.b == null) {
            if (busStationQuery.b != null) {
                return false;
            }
        } else if (!this.b.equals(busStationQuery.b)) {
            return false;
        }
        return this.d != busStationQuery.d ? false : this.c != busStationQuery.c ? false : this.a == null ? busStationQuery.a == null : this.a.equals(busStationQuery.a);
    }

    public String getCity() {
        return this.b;
    }

    public int getPageNumber() {
        return this.d;
    }

    public int getPageSize() {
        return this.c;
    }

    public String getQueryString() {
        return this.a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.b == null ? 0 : this.b.hashCode()) + 31) * 31) + this.d) * 31) + this.c) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setPageNumber(int i) {
        this.d = i;
    }

    public void setPageSize(int i) {
        int i2 = 20;
        if (i <= 20) {
            i2 = i;
        }
        if (i2 <= 0) {
            i2 = 10;
        }
        this.c = i2;
    }

    public void setQueryString(String str) {
        this.a = str;
    }

    protected boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        if (this.b == null) {
            if (busStationQuery.b != null) {
                return false;
            }
        } else if (!this.b.equals(busStationQuery.b)) {
            return false;
        }
        return this.c != busStationQuery.c ? false : this.a == null ? busStationQuery.a == null : this.a.equals(busStationQuery.a);
    }
}
