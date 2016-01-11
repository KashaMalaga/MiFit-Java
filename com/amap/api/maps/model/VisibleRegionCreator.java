package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        BadParcelableException badParcelableException;
        BadParcelableException badParcelableException2;
        LatLngBounds latLngBounds = null;
        int readInt = parcel.readInt();
        try {
            LatLng latLng5 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e) {
                    latLng3 = null;
                    latLng4 = null;
                    badParcelableException = e;
                    latLng2 = latLng;
                    latLng = latLng5;
                    badParcelableException2 = badParcelableException;
                    badParcelableException2.printStackTrace();
                    return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
                }
                try {
                    latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                        latLng3 = latLng4;
                        latLng4 = latLng2;
                        latLng2 = latLng;
                        latLng = latLng5;
                    } catch (BadParcelableException e2) {
                        badParcelableException = e2;
                        latLng3 = latLng4;
                        latLng4 = latLng2;
                        latLng2 = latLng;
                        latLng = latLng5;
                        badParcelableException2 = badParcelableException;
                        badParcelableException2.printStackTrace();
                        return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
                    }
                } catch (BadParcelableException e3) {
                    latLng3 = null;
                    badParcelableException = e3;
                    latLng4 = latLng2;
                    latLng2 = latLng;
                    latLng = latLng5;
                    badParcelableException2 = badParcelableException;
                    badParcelableException2.printStackTrace();
                    return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
                }
            } catch (BadParcelableException e4) {
                latLng3 = null;
                latLng4 = null;
                latLng2 = null;
                badParcelableException = e4;
                latLng = latLng5;
                badParcelableException2 = badParcelableException;
                badParcelableException2.printStackTrace();
                return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
            }
        } catch (BadParcelableException e5) {
            badParcelableException2 = e5;
            latLng3 = null;
            latLng4 = null;
            latLng2 = null;
            latLng = null;
            badParcelableException2.printStackTrace();
            return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
        }
        return new VisibleRegion(readInt, latLng, latLng2, latLng4, latLng3, latLngBounds);
    }

    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
