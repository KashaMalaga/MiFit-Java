package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Groupbuy implements Parcelable {
    public static final Creator<Groupbuy> CREATOR = new d();
    private String a;
    private String b;
    private String c;
    private Date d;
    private Date e;
    private int f;
    private int g;
    private float h;
    private float i;
    private float j;
    private String k;
    private String l;
    private List<Photo> m = new ArrayList();
    private String n;
    private String o;

    public Groupbuy(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = e.e(parcel.readString());
        this.e = e.e(parcel.readString());
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readFloat();
        this.i = parcel.readFloat();
        this.j = parcel.readFloat();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.createTypedArrayList(Photo.CREATOR);
        this.n = parcel.readString();
        this.o = parcel.readString();
    }

    public void addPhotos(Photo photo) {
        this.m.add(photo);
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
        Groupbuy groupbuy = (Groupbuy) obj;
        if (this.f != groupbuy.f) {
            return false;
        }
        if (this.c == null) {
            if (groupbuy.c != null) {
                return false;
            }
        } else if (!this.c.equals(groupbuy.c)) {
            return false;
        }
        if (Float.floatToIntBits(this.j) != Float.floatToIntBits(groupbuy.j)) {
            return false;
        }
        if (this.e == null) {
            if (groupbuy.e != null) {
                return false;
            }
        } else if (!this.e.equals(groupbuy.e)) {
            return false;
        }
        if (Float.floatToIntBits(this.i) != Float.floatToIntBits(groupbuy.i)) {
            return false;
        }
        if (Float.floatToIntBits(this.h) != Float.floatToIntBits(groupbuy.h)) {
            return false;
        }
        if (this.m == null) {
            if (groupbuy.m != null) {
                return false;
            }
        } else if (!this.m.equals(groupbuy.m)) {
            return false;
        }
        if (this.o == null) {
            if (groupbuy.o != null) {
                return false;
            }
        } else if (!this.o.equals(groupbuy.o)) {
            return false;
        }
        if (this.g != groupbuy.g) {
            return false;
        }
        if (this.d == null) {
            if (groupbuy.d != null) {
                return false;
            }
        } else if (!this.d.equals(groupbuy.d)) {
            return false;
        }
        if (this.k == null) {
            if (groupbuy.k != null) {
                return false;
            }
        } else if (!this.k.equals(groupbuy.k)) {
            return false;
        }
        if (this.l == null) {
            if (groupbuy.l != null) {
                return false;
            }
        } else if (!this.l.equals(groupbuy.l)) {
            return false;
        }
        if (this.a == null) {
            if (groupbuy.a != null) {
                return false;
            }
        } else if (!this.a.equals(groupbuy.a)) {
            return false;
        }
        if (this.b == null) {
            if (groupbuy.b != null) {
                return false;
            }
        } else if (!this.b.equals(groupbuy.b)) {
            return false;
        }
        return this.n == null ? groupbuy.n == null : this.n.equals(groupbuy.n);
    }

    public int getCount() {
        return this.f;
    }

    public String getDetail() {
        return this.c;
    }

    public float getDiscount() {
        return this.j;
    }

    public Date getEndTime() {
        return this.e == null ? null : (Date) this.e.clone();
    }

    public float getGroupbuyPrice() {
        return this.i;
    }

    public float getOriginalPrice() {
        return this.h;
    }

    public List<Photo> getPhotos() {
        return this.m;
    }

    public String getProvider() {
        return this.o;
    }

    public int getSoldCount() {
        return this.g;
    }

    public Date getStartTime() {
        return this.d == null ? null : (Date) this.d.clone();
    }

    public String getTicketAddress() {
        return this.k;
    }

    public String getTicketTel() {
        return this.l;
    }

    public String getTypeCode() {
        return this.a;
    }

    public String getTypeDes() {
        return this.b;
    }

    public String getUrl() {
        return this.n;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((((this.o == null ? 0 : this.o.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((((((this.e == null ? 0 : this.e.hashCode()) + (((((this.c == null ? 0 : this.c.hashCode()) + ((this.f + 31) * 31)) * 31) + Float.floatToIntBits(this.j)) * 31)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.h)) * 31)) * 31)) * 31) + this.g) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.n != null) {
            i = this.n.hashCode();
        }
        return hashCode + i;
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.m.clear();
            for (Photo add : list) {
                this.m.add(add);
            }
        }
    }

    public void setCount(int i) {
        this.f = i;
    }

    public void setDetail(String str) {
        this.c = str;
    }

    public void setDiscount(float f) {
        this.j = f;
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.e = null;
        } else {
            this.e = (Date) date.clone();
        }
    }

    public void setGroupbuyPrice(float f) {
        this.i = f;
    }

    public void setOriginalPrice(float f) {
        this.h = f;
    }

    public void setProvider(String str) {
        this.o = str;
    }

    public void setSoldCount(int i) {
        this.g = i;
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.d = null;
        } else {
            this.d = (Date) date.clone();
        }
    }

    public void setTicketAddress(String str) {
        this.k = str;
    }

    public void setTicketTel(String str) {
        this.l = str;
    }

    public void setTypeCode(String str) {
        this.a = str;
    }

    public void setTypeDes(String str) {
        this.b = str;
    }

    public void setUrl(String str) {
        this.n = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(e.a(this.d));
        parcel.writeString(e.a(this.e));
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.i);
        parcel.writeFloat(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeTypedList(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
    }
}
