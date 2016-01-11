package com.amap.api.location;

import com.amap.api.location.core.AMapLocException;

public class AMapLocalWeatherLive {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private AMapLocException g;
    private String h;
    private String i;
    private String j;

    void a(AMapLocException aMapLocException) {
        this.g = aMapLocException;
    }

    void a(String str) {
        this.a = str;
    }

    void b(String str) {
        this.b = str;
    }

    void c(String str) {
        this.c = str;
    }

    void d(String str) {
        this.d = str;
    }

    void e(String str) {
        this.e = str;
    }

    void f(String str) {
        this.f = str;
    }

    public AMapLocException getAMapException() {
        return this.g;
    }

    public String getCity() {
        return this.h;
    }

    public String getCityCode() {
        return this.j;
    }

    public String getHumidity() {
        return this.e;
    }

    public String getProvince() {
        return this.i;
    }

    public String getReportTime() {
        return this.f;
    }

    public String getTemperature() {
        return this.b;
    }

    public String getWeather() {
        return this.a;
    }

    public String getWindDir() {
        return this.c;
    }

    public String getWindPower() {
        return this.d;
    }

    public void setCity(String str) {
        this.h = str;
    }

    public void setCityCode(String str) {
        this.j = str;
    }

    public void setProvince(String str) {
        this.i = str;
    }
}
