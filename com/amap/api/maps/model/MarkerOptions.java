package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    String a;
    private LatLng b;
    private String c;
    private String d;
    private float e = 0.5f;
    private float f = 1.0f;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private ArrayList<BitmapDescriptor> l = new ArrayList();
    private int m = 20;
    private boolean n = false;
    private boolean o = false;

    private void a() {
        if (this.l == null) {
            this.l = new ArrayList();
        }
    }

    public MarkerOptions anchor(float f, float f2) {
        this.e = f;
        this.f = f2;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean z) {
        this.g = z;
        return this;
    }

    public float getAnchorU() {
        return this.e;
    }

    public float getAnchorV() {
        return this.f;
    }

    public BitmapDescriptor getIcon() {
        return (this.l == null || this.l.size() == 0) ? null : (BitmapDescriptor) this.l.get(0);
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.l;
    }

    public int getInfoWindowOffsetX() {
        return this.j;
    }

    public int getInfoWindowOffsetY() {
        return this.k;
    }

    public int getPeriod() {
        return this.m;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public String getSnippet() {
        return this.d;
    }

    public String getTitle() {
        return this.c;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        a();
        this.l.clear();
        this.l.add(bitmapDescriptor);
        return this;
    }

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.l = arrayList;
        return this;
    }

    public boolean isDraggable() {
        return this.g;
    }

    public boolean isFlat() {
        return this.o;
    }

    public boolean isGps() {
        return this.n;
    }

    public boolean isPerspective() {
        return this.i;
    }

    public boolean isVisible() {
        return this.h;
    }

    public MarkerOptions period(int i) {
        if (i <= 1) {
            this.m = 1;
        } else {
            this.m = i;
        }
        return this;
    }

    public MarkerOptions perspective(boolean z) {
        this.i = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public MarkerOptions setFlat(boolean z) {
        this.o = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.n = z;
        return this;
    }

    public MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.j = i;
        this.k = i2;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.c = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
        if (!(this.l == null || this.l.size() == 0)) {
            parcel.writeParcelable((Parcelable) this.l.get(0), i);
        }
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
        parcel.writeFloat(this.f);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeBooleanArray(new boolean[]{this.h, this.g, this.n, this.o});
        parcel.writeString(this.a);
        parcel.writeInt(this.m);
        parcel.writeList(this.l);
    }
}
