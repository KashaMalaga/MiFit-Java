package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.C0151az;

public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    String a;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = C0151az.s;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;

    public CircleOptions center(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.b;
    }

    public int getFillColor() {
        return this.f;
    }

    public double getRadius() {
        return this.c;
    }

    public int getStrokeColor() {
        return this.e;
    }

    public float getStrokeWidth() {
        return this.d;
    }

    public float getZIndex() {
        return this.g;
    }

    public boolean isVisible() {
        return this.h;
    }

    public CircleOptions radius(double d) {
        this.c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.b != null) {
            bundle.putDouble("lat", this.b.latitude);
            bundle.putDouble("lng", this.b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.c);
        parcel.writeFloat(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
        parcel.writeByte((byte) (this.h ? 1 : 0));
        parcel.writeString(this.a);
    }

    public CircleOptions zIndex(float f) {
        this.g = f;
        return this;
    }
}
