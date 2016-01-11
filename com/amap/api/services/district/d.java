package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d implements Creator<DistrictSearchQuery> {
    d() {
    }

    public DistrictSearchQuery a(Parcel parcel) {
        boolean z = true;
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(parcel.readString());
        districtSearchQuery.setKeywordsLevel(parcel.readString());
        districtSearchQuery.setPageNum(parcel.readInt());
        districtSearchQuery.setPageSize(parcel.readInt());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        districtSearchQuery.setShowChild(z);
        return districtSearchQuery;
    }

    public DistrictSearchQuery[] a(int i) {
        return new DistrictSearchQuery[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return a(i);
    }
}
