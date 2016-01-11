package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.List;

public class PoiItemDetail extends PoiItem implements Parcelable {
    public static final Creator<PoiItemDetail> CREATOR = new g();
    private List<Groupbuy> a;
    private List<Discount> b;
    private Dining c;
    private Hotel d;
    private Cinema e;
    private Scenic f;
    private DeepType g;

    public enum DeepType {
        UNKNOWN,
        DINING,
        HOTEL,
        CINEMA,
        SCENIC
    }

    private PoiItemDetail(Parcel parcel) {
        super(parcel);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.a = parcel.readArrayList(Groupbuy.class.getClassLoader());
        this.b = parcel.readArrayList(Discount.class.getClassLoader());
    }

    public PoiItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public void addDiscount(Discount discount) {
        this.b.add(discount);
    }

    public void addGroupbuy(Groupbuy groupbuy) {
        this.a.add(groupbuy);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PoiItemDetail poiItemDetail = (PoiItemDetail) obj;
        if (this.e == null) {
            if (poiItemDetail.e != null) {
                return false;
            }
        } else if (!this.e.equals(poiItemDetail.e)) {
            return false;
        }
        if (this.g != poiItemDetail.g) {
            return false;
        }
        if (this.c == null) {
            if (poiItemDetail.c != null) {
                return false;
            }
        } else if (!this.c.equals(poiItemDetail.c)) {
            return false;
        }
        if (this.b == null) {
            if (poiItemDetail.b != null) {
                return false;
            }
        } else if (!this.b.equals(poiItemDetail.b)) {
            return false;
        }
        if (this.a == null) {
            if (poiItemDetail.a != null) {
                return false;
            }
        } else if (!this.a.equals(poiItemDetail.a)) {
            return false;
        }
        if (this.d == null) {
            if (poiItemDetail.d != null) {
                return false;
            }
        } else if (!this.d.equals(poiItemDetail.d)) {
            return false;
        }
        return this.f == null ? poiItemDetail.f == null : this.f.equals(poiItemDetail.f);
    }

    public Cinema getCinema() {
        return this.e;
    }

    public DeepType getDeepType() {
        return this.g;
    }

    public Dining getDining() {
        return this.c;
    }

    public List<Discount> getDiscounts() {
        return this.b;
    }

    public List<Groupbuy> getGroupbuys() {
        return this.a;
    }

    public Hotel getHotel() {
        return this.d;
    }

    public Scenic getScenic() {
        return this.f;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.d == null ? 0 : this.d.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (super.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }

    public void initDiscounts(List<Discount> list) {
        if (list != null && list.size() != 0) {
            this.b.clear();
            for (Discount add : list) {
                this.b.add(add);
            }
        }
    }

    public void initGroupbuys(List<Groupbuy> list) {
        if (list != null && list.size() != 0) {
            for (Groupbuy add : list) {
                this.a.add(add);
            }
        }
    }

    public void setCinema(Cinema cinema) {
        this.e = cinema;
    }

    public void setDeepType(DeepType deepType) {
        this.g = deepType;
    }

    public void setDining(Dining dining) {
        this.c = dining;
    }

    public void setHotel(Hotel hotel) {
        this.d = hotel;
    }

    public void setScenic(Scenic scenic) {
        this.f = scenic;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.a);
        parcel.writeList(this.b);
    }
}
