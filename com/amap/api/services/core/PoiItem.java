package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.xiaomi.e.a;

public class PoiItem implements Parcelable {
    public static final Creator<PoiItem> CREATOR = new p();
    private String a;
    private String b;
    private String c;
    private String d;
    private String e = a.f;
    private int f = -1;
    private LatLonPoint g;
    private LatLonPoint h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;
    private String n;
    private String o;
    private String p;
    private String q;
    private boolean r;
    private String s;

    protected PoiItem(Parcel parcel) {
        this.a = parcel.readString();
        this.c = parcel.readString();
        this.b = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.d = parcel.readString();
        this.g = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.h = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        boolean[] zArr = new boolean[3];
        parcel.readBooleanArray(zArr);
        this.l = zArr[0];
        this.m = zArr[1];
        this.r = zArr[2];
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.s = parcel.readString();
    }

    public PoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
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
        PoiItem poiItem = (PoiItem) obj;
        return this.a == null ? poiItem.a == null : this.a.equals(poiItem.a);
    }

    public String getAdCode() {
        return this.c;
    }

    public String getAdName() {
        return this.q;
    }

    public String getCityCode() {
        return this.d;
    }

    public String getCityName() {
        return this.p;
    }

    public String getDirection() {
        return this.n;
    }

    public int getDistance() {
        return this.f;
    }

    public String getEmail() {
        return this.k;
    }

    public LatLonPoint getEnter() {
        return this.g;
    }

    public LatLonPoint getExit() {
        return this.h;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getPoiId() {
        return this.a;
    }

    public String getPostcode() {
        return this.j;
    }

    public String getProvinceCode() {
        return this.s;
    }

    public String getProvinceName() {
        return this.o;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTel() {
        return this.b;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTypeDes() {
        return this.e;
    }

    public String getWebsite() {
        return this.i;
    }

    public int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) + 31;
    }

    public boolean isDiscountInfo() {
        return this.m;
    }

    public boolean isGroupbuyInfo() {
        return this.l;
    }

    public boolean isIndoorMap() {
        return this.r;
    }

    public void setAdCode(String str) {
        this.c = str;
    }

    public void setAdName(String str) {
        this.q = str;
    }

    public void setCityCode(String str) {
        this.d = str;
    }

    public void setCityName(String str) {
        this.p = str;
    }

    public void setDirection(String str) {
        this.n = str;
    }

    public void setDiscountInfo(boolean z) {
        this.m = z;
    }

    public void setDistance(int i) {
        this.f = i;
    }

    public void setEmail(String str) {
        this.k = str;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.g = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.h = latLonPoint;
    }

    public void setGroupbuyInfo(boolean z) {
        this.l = z;
    }

    public void setIndoorMap(boolean z) {
        this.r = z;
    }

    public void setPostcode(String str) {
        this.j = str;
    }

    public void setProvinceCode(String str) {
        this.s = str;
    }

    public void setProvinceName(String str) {
        this.o = str;
    }

    public void setTel(String str) {
        this.b = str;
    }

    public void setTypeDes(String str) {
        this.e = str;
    }

    public void setWebsite(String str) {
        this.i = str;
    }

    public String toString() {
        return this.mTitle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.c);
        parcel.writeString(this.b);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.d);
        parcel.writeValue(this.g);
        parcel.writeValue(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeBooleanArray(new boolean[]{this.l, this.m, this.r});
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.s);
    }
}
