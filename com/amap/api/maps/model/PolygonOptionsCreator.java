package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    public PolygonOptions createFromParcel(Parcel parcel) {
        int i = 0;
        PolygonOptions polygonOptions = new PolygonOptions();
        List arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float readFloat = parcel.readFloat();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        float readFloat2 = parcel.readFloat();
        boolean z = parcel.readByte() == (byte) 1;
        LatLng[] latLngArr = new LatLng[arrayList.size()];
        while (i < arrayList.size()) {
            latLngArr[i] = (LatLng) arrayList.get(i);
            i++;
        }
        polygonOptions.add(latLngArr);
        polygonOptions.strokeWidth(readFloat);
        polygonOptions.strokeColor(readInt);
        polygonOptions.fillColor(readInt2);
        polygonOptions.zIndex(readFloat2);
        polygonOptions.visible(z);
        polygonOptions.a = parcel.readString();
        return polygonOptions;
    }

    public PolygonOptions[] newArray(int i) {
        return new PolygonOptions[i];
    }
}
