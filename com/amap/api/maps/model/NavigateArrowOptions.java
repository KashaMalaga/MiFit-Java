package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kankan.wheel.widget.a;

public final class NavigateArrowOptions implements Parcelable {
    public static final NavigateArrowOptionsCreator CREATOR = new NavigateArrowOptionsCreator();
    String a;
    private final List<LatLng> b = new ArrayList();
    private float c = 10.0f;
    private int d = Color.argb(HeartRateInfo.MAX_HR_VALUE, 87, 235, 204);
    private int e = Color.argb(a.aC, 0, 172, 146);
    private float f = 0.0f;
    private boolean g = true;

    public NavigateArrowOptions add(LatLng latLng) {
        this.b.add(latLng);
        return this;
    }

    public NavigateArrowOptions add(LatLng... latLngArr) {
        this.b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public NavigateArrowOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.b.add(add);
        }
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public int getSideColor() {
        return this.e;
    }

    public int getTopColor() {
        return this.d;
    }

    public float getWidth() {
        return this.c;
    }

    public float getZIndex() {
        return this.f;
    }

    public boolean isVisible() {
        return this.g;
    }

    public NavigateArrowOptions sideColor(int i) {
        this.e = i;
        return this;
    }

    public NavigateArrowOptions topColor(int i) {
        this.d = i;
        return this;
    }

    public NavigateArrowOptions visible(boolean z) {
        this.g = z;
        return this;
    }

    public NavigateArrowOptions width(float f) {
        this.c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f);
        parcel.writeByte((byte) (this.g ? 1 : 0));
        parcel.writeString(this.a);
    }

    public NavigateArrowOptions zIndex(float f) {
        this.f = f;
        return this;
    }
}
