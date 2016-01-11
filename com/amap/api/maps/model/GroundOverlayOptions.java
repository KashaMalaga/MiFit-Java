package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.e;

public final class GroundOverlayOptions implements Parcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final int a;
    private BitmapDescriptor b;
    private LatLng c;
    private float d;
    private float e;
    private LatLngBounds f;
    private float g;
    private float h;
    private boolean i;
    private float j;
    private float k;
    private float l;

    public GroundOverlayOptions() {
        this.h = 0.0f;
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.h = 0.0f;
        this.i = true;
        this.j = 0.0f;
        this.k = 0.5f;
        this.l = 0.5f;
        this.a = i;
        this.b = BitmapDescriptorFactory.fromBitmap(null);
        this.c = latLng;
        this.d = f;
        this.e = f2;
        this.f = latLngBounds;
        this.g = f3;
        this.h = f4;
        this.i = z;
        this.j = f5;
        this.k = f6;
        this.l = f7;
    }

    private GroundOverlayOptions a(LatLng latLng, float f, float f2) {
        this.c = latLng;
        this.d = f;
        this.e = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.k = f;
        this.l = f2;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.g = f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.k;
    }

    public float getAnchorV() {
        return this.l;
    }

    public float getBearing() {
        return this.g;
    }

    public LatLngBounds getBounds() {
        return this.f;
    }

    public float getHeight() {
        return this.e;
    }

    public BitmapDescriptor getImage() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public float getTransparency() {
        return this.j;
    }

    public float getWidth() {
        return this.d;
    }

    public float getZIndex() {
        return this.h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.b = bitmapDescriptor;
        return this;
    }

    public boolean isVisible() {
        return this.i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        e.a(this.f == null, (Object) "Position has already been set using positionFromBounds");
        e.b(latLng != null, "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        e.b(z, "Width must be non-negative");
        return a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        e.a(this.f == null, (Object) "Position has already been set using positionFromBounds");
        e.b(latLng != null, "Location must be specified");
        e.b(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        e.b(z, "Height must be non-negative");
        return a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        e.a(this.c == null, "Position has already been set using position: " + this.c);
        this.f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        e.b(z, "Transparency must be in the range [0..1]");
        this.j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeFloat(this.g);
        parcel.writeFloat(this.h);
        parcel.writeByte((byte) (this.i ? 1 : 0));
        parcel.writeFloat(this.j);
        parcel.writeFloat(this.k);
        parcel.writeFloat(this.l);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.h = f;
        return this;
    }
}
