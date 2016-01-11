package com.amap.api.location;

import android.location.Location;
import com.amap.api.location.core.AMapLocException;

public class AMapLocation extends Location {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private AMapLocException m = new AMapLocException();

    public AMapLocation(Location location) {
        super(location);
    }

    public AMapLocation(String str) {
        super(str);
    }

    void a(String str) {
        this.h = str;
    }

    void b(String str) {
        this.i = str;
    }

    public AMapLocException getAMapException() {
        return this.m;
    }

    public String getAdCode() {
        return this.e;
    }

    public String getAddress() {
        return this.i;
    }

    public String getCity() {
        return this.b;
    }

    public String getCityCode() {
        return this.d;
    }

    public String getCountry() {
        return this.j;
    }

    public String getDistrict() {
        return this.c;
    }

    public String getFloor() {
        return this.g;
    }

    public String getPoiId() {
        return this.f;
    }

    public String getPoiName() {
        return this.l;
    }

    public String getProvince() {
        return this.a;
    }

    public String getRoad() {
        return this.k;
    }

    public String getStreet() {
        return this.h;
    }

    public void setAMapException(AMapLocException aMapLocException) {
        this.m = aMapLocException;
    }

    public void setAdCode(String str) {
        this.e = str;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setCountry(String str) {
        this.j = str;
    }

    public void setDistrict(String str) {
        this.c = str;
    }

    public void setFloor(String str) {
        this.g = str;
    }

    public void setPoiId(String str) {
        this.f = str;
    }

    public void setPoiName(String str) {
        this.l = str;
    }

    public void setProvince(String str) {
        this.a = str;
    }

    public void setRoad(String str) {
        this.k = str;
    }
}
