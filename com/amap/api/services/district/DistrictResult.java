package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
    public Creator<DistrictResult> CREATOR = new b(this);
    private DistrictSearchQuery a;
    private ArrayList<DistrictItem> b;
    private int c;
    private AMapException d;

    protected DistrictResult(Parcel parcel) {
        this.a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.a = districtSearchQuery;
        this.b = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        if (this.a == null) {
            if (districtResult.a != null) {
                return false;
            }
        } else if (!this.a.equals(districtResult.a)) {
            return false;
        }
        return this.b == null ? districtResult.b == null : this.b.equals(districtResult.b);
    }

    public AMapException getAMapException() {
        return this.d;
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public int getPageCount() {
        return this.c;
    }

    public DistrictSearchQuery getQuery() {
        return this.a;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.a == null ? 0 : this.a.hashCode()) + 31) * 31;
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }

    public void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public void setPageCount(int i) {
        this.c = i;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.a = districtSearchQuery;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.a + ", mDistricts=" + this.b + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }
}
