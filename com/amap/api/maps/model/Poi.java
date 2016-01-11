package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();
    private final String a;
    private final LatLng b;

    public Poi(String str, LatLng latLng) {
        this.a = str;
        this.b = latLng;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Poi)) {
            return false;
        }
        Poi poi = (Poi) obj;
        return poi.getName().equals(this.a) && poi.getCoordinate().equals(this.b);
    }

    public LatLng getCoordinate() {
        return this.b;
    }

    public String getName() {
        return this.a;
    }

    public String toString() {
        return "name:" + this.a + "  coordinate:" + this.b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
    }
}
