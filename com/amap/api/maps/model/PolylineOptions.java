package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.C0151az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = C0151az.s;
    private float e = 0.0f;
    private boolean f = true;
    private BitmapDescriptor g;
    private boolean h = true;
    private boolean i = false;
    private boolean j = false;

    public PolylineOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.b.add(add);
        }
        return this;
    }

    public PolylineOptions color(int i) {
        this.d = i;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean z) {
        this.i = z;
        return this;
    }

    public int getColor() {
        return this.d;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.g;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public float getWidth() {
        return this.c;
    }

    public float getZIndex() {
        return this.e;
    }

    public boolean isDottedLine() {
        return this.j;
    }

    public boolean isGeodesic() {
        return this.i;
    }

    public boolean isUseTexture() {
        return this.h;
    }

    public boolean isVisible() {
        return this.f;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        return this;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.j = z;
        return this;
    }

    public PolylineOptions setUseTexture(boolean z) {
        this.h = z;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeFloat(this.e);
        parcel.writeString(this.a);
        parcel.writeBooleanArray(new boolean[]{this.f, this.j, this.i});
        if (this.g != null) {
            parcel.writeParcelable(this.g, i);
        }
    }

    public PolylineOptions zIndex(float f) {
        this.e = f;
        return this;
    }
}
