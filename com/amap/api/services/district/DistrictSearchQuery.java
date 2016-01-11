package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Creator<DistrictSearchQuery> CREATOR = new d();
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";
    private int a;
    private int b;
    private String c;
    private String d;
    private boolean e;

    public DistrictSearchQuery() {
        this.a = 0;
        this.b = 20;
        this.e = true;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.a = 0;
        this.b = 20;
        this.e = true;
        this.c = str;
        this.d = str2;
        this.a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.e = z;
        this.b = i2;
    }

    public boolean checkKeyWords() {
        return (this.c == null || this.c.trim().equalsIgnoreCase(a.f)) ? false : true;
    }

    public boolean checkLevels() {
        return this.d == null ? false : this.d.trim().equals(KEYWORDS_COUNTRY) || this.d.trim().equals(KEYWORDS_PROVINCE) || this.d.trim().equals(KEYWORDS_CITY) || this.d.trim().equals(KEYWORDS_DISTRICT) || this.d.trim().equals(KEYWORDS_BUSINESS);
    }

    public DistrictSearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new DistrictSearchQuery(this.c, this.d, this.a, this.e, this.b);
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
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.c == null) {
            if (districtSearchQuery.c != null) {
                return false;
            }
        } else if (!this.c.equals(districtSearchQuery.c)) {
            return false;
        }
        if (this.d == null) {
            if (districtSearchQuery.d != null) {
                return false;
            }
        } else if (!this.d.equals(districtSearchQuery.d)) {
            return false;
        }
        return this.a != districtSearchQuery.a ? false : this.b != districtSearchQuery.b ? false : this.e == districtSearchQuery.e;
    }

    public String getKeywords() {
        return this.c;
    }

    public String getKeywordsLevel() {
        return this.d;
    }

    public int getPageNum() {
        return this.a;
    }

    public int getPageSize() {
        return this.b;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + 31) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return (this.e ? 1231 : 1237) + ((((((hashCode + i) * 31) + this.a) * 31) + this.b) * 31);
    }

    public boolean isShowChild() {
        return this.e;
    }

    public void setKeywords(String str) {
        this.c = str;
    }

    public void setKeywordsLevel(String str) {
        this.d = str;
    }

    public void setPageNum(int i) {
        this.a = i;
    }

    public void setPageSize(int i) {
        this.b = i;
    }

    public void setShowChild(boolean z) {
        this.e = z;
    }

    protected boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        if (this.c == null) {
            if (districtSearchQuery.c != null) {
                return false;
            }
        } else if (!this.c.equals(districtSearchQuery.c)) {
            return false;
        }
        if (this.d == null) {
            if (districtSearchQuery.d != null) {
                return false;
            }
        } else if (!this.d.equals(districtSearchQuery.d)) {
            return false;
        }
        return this.b != districtSearchQuery.b ? false : this.e == districtSearchQuery.e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeByte((byte) (this.e ? 1 : 0));
    }
}
