package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Discount implements Parcelable {
    public static final Creator<Discount> CREATOR = new c();
    private String a;
    private String b;
    private Date c;
    private Date d;
    private int e;
    private List<Photo> f = new ArrayList();
    private String g;
    private String h;

    public Discount(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = e.e(parcel.readString());
        this.d = e.e(parcel.readString());
        this.e = parcel.readInt();
        this.f = parcel.createTypedArrayList(Photo.CREATOR);
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public void addPhotos(Photo photo) {
        this.f.add(photo);
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
        Discount discount = (Discount) obj;
        if (this.b == null) {
            if (discount.b != null) {
                return false;
            }
        } else if (!this.b.equals(discount.b)) {
            return false;
        }
        if (this.d == null) {
            if (discount.d != null) {
                return false;
            }
        } else if (!this.d.equals(discount.d)) {
            return false;
        }
        if (this.f == null) {
            if (discount.f != null) {
                return false;
            }
        } else if (!this.f.equals(discount.f)) {
            return false;
        }
        if (this.h == null) {
            if (discount.h != null) {
                return false;
            }
        } else if (!this.h.equals(discount.h)) {
            return false;
        }
        if (this.e != discount.e) {
            return false;
        }
        if (this.c == null) {
            if (discount.c != null) {
                return false;
            }
        } else if (!this.c.equals(discount.c)) {
            return false;
        }
        if (this.a == null) {
            if (discount.a != null) {
                return false;
            }
        } else if (!this.a.equals(discount.a)) {
            return false;
        }
        return this.g == null ? discount.g == null : this.g.equals(discount.g);
    }

    public String getDetail() {
        return this.b;
    }

    public Date getEndTime() {
        return this.d == null ? null : (Date) this.d.clone();
    }

    public List<Photo> getPhotos() {
        return this.f;
    }

    public String getProvider() {
        return this.h;
    }

    public int getSoldCount() {
        return this.e;
    }

    public Date getStartTime() {
        return this.c == null ? null : (Date) this.c.clone();
    }

    public String getTitle() {
        return this.a;
    }

    public String getUrl() {
        return this.g;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.a == null ? 0 : this.a.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((((this.h == null ? 0 : this.h.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + this.e) * 31)) * 31)) * 31;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode + i;
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.f.clear();
            for (Photo add : list) {
                this.f.add(add);
            }
        }
    }

    public void setDetail(String str) {
        this.b = str;
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.d = null;
        } else {
            this.d = (Date) date.clone();
        }
    }

    public void setProvider(String str) {
        this.h = str;
    }

    public void setSoldCount(int i) {
        this.e = i;
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.c = null;
        } else {
            this.c = (Date) date.clone();
        }
    }

    public void setTitle(String str) {
        this.a = str;
    }

    public void setUrl(String str) {
        this.g = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(e.a(this.c));
        parcel.writeString(e.a(this.d));
        parcel.writeInt(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
