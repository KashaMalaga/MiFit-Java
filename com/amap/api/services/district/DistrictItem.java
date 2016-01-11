package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public final class DistrictItem implements Parcelable {
    public static final Creator<DistrictItem> CREATOR = new a();
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private String e;
    private List<DistrictItem> f;

    public DistrictItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.c = str;
        this.a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
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
        DistrictItem districtItem = (DistrictItem) obj;
        if (this.b == null) {
            if (districtItem.b != null) {
                return false;
            }
        } else if (!this.b.equals(districtItem.b)) {
            return false;
        }
        if (this.d == null) {
            if (districtItem.d != null) {
                return false;
            }
        } else if (!this.d.equals(districtItem.d)) {
            return false;
        }
        if (this.a == null) {
            if (districtItem.a != null) {
                return false;
            }
        } else if (!this.a.equals(districtItem.a)) {
            return false;
        }
        if (this.f == null) {
            if (districtItem.f != null) {
                return false;
            }
        } else if (!this.f.equals(districtItem.f)) {
            return false;
        }
        if (this.e == null) {
            if (districtItem.e != null) {
                return false;
            }
        } else if (!this.e.equals(districtItem.e)) {
            return false;
        }
        return this.c == null ? districtItem.c == null : this.c.equals(districtItem.c);
    }

    public String getAdcode() {
        return this.b;
    }

    public LatLonPoint getCenter() {
        return this.d;
    }

    public String getCitycode() {
        return this.a;
    }

    public String getLevel() {
        return this.e;
    }

    public String getName() {
        return this.c;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return hashCode + i;
    }

    public void setAdcode(String str) {
        this.b = str;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setCitycode(String str) {
        this.a = str;
    }

    public void setLevel(String str) {
        this.e = str;
    }

    public void setName(String str) {
        this.c = str;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
    }
}
