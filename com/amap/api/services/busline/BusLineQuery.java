package com.amap.api.services.busline;

import com.amap.api.services.core.e;

public class BusLineQuery {
    private String a;
    private String b;
    private int c = 10;
    private int d = 0;
    private SearchType e;

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.a = str;
        this.e = searchType;
        this.b = str2;
        if (!a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    private boolean a() {
        return !e.a(this.a);
    }

    protected BusLineQuery clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        return busLineQuery;
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
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.e != busLineQuery.e) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.b != null) {
                return false;
            }
        } else if (!this.b.equals(busLineQuery.b)) {
            return false;
        }
        return this.d != busLineQuery.d ? false : this.c != busLineQuery.c ? false : this.a == null ? busLineQuery.a == null : this.a.equals(busLineQuery.a);
    }

    public SearchType getCategory() {
        return this.e;
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
        int hashCode = ((((((this.b == null ? 0 : this.b.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + 31) * 31)) * 31) + this.d) * 31) + this.c) * 31;
        if (this.a != null) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setPageNumber(int i) {
        this.d = i;
    }

    public void setPageSize(int i) {
        this.c = i;
    }

    public void setQueryString(String str) {
        this.a = str;
    }

    protected boolean weakEquals(BusLineQuery busLineQuery) {
        return busLineQuery.getQueryString().equals(this.a) && busLineQuery.getCity().equals(this.b) && busLineQuery.getPageSize() == this.c && busLineQuery.getCategory().compareTo(this.e) == 0;
    }
}
