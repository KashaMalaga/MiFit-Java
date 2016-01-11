package com.amap.api.maps.model;

public class MyTrafficStyle {
    private int a = -16735735;
    private int b = -35576;
    private int c = -1441006;
    private int d = -7208950;

    public int getCongestedColor() {
        return this.c;
    }

    public int getSeriousCongestedColor() {
        return this.d;
    }

    public int getSlowColor() {
        return this.b;
    }

    public int getSmoothColor() {
        return this.a;
    }

    public void setCongestedColor(int i) {
        this.c = i;
    }

    public void setSeriousCongestedColor(int i) {
        this.d = i;
    }

    public void setSlowColor(int i) {
        this.b = i;
    }

    public void setSmoothColor(int i) {
        this.a = i;
    }
}
